package org.teamvoided.astral_armory.items

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.nbt.NbtList
import net.minecraft.nbt.NbtString
import net.minecraft.text.Text
import net.minecraft.util.Rarity
import net.minecraft.world.World
import org.teamvoided.astral_armory.api.UpgradableItem
import org.teamvoided.astral_armory.api.Upgrade
import org.teamvoided.astral_armory.util.NBTHelper


class AstralWeapon(private val attackDamage: Float, attackSpeed: Float) : SwordItem(
    AstralToolMaterials.ASTRAL,
    0,
    attackSpeed,
    FabricItemSettings().fireproof().rarity(Rarity.EPIC)
) {
    override fun getAttackDamage(): Float {
        return this.attackDamage
    }


    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?,
    ) {
        tooltip?.add(Text.of("Upgrades:"))
        val upgrades = getList(stack!!)
        if (upgrades != null) {
            for (up in upgrades) tooltip?.add(Text.of(up.toString()))
        }
        val slots = getSlots(stack)
        if (slots != null) {
            for (i in 0 until slots) tooltip?.add(Text.of("*"))
        }

        super.appendTooltip(stack, world, tooltip, context)
    }

    companion object {
        private const val UPGRADE_LIST = "Upgrades"
        private const val UPGRADE_SLOTS = "UpgradeSlots"

        fun setSlots(stack: ItemStack, int: Int) = NBTHelper.setInt(stack, UPGRADE_SLOTS, int)
        fun getSlots(stack: ItemStack) = NBTHelper.getInt(stack, UPGRADE_SLOTS)

        fun setList(stack: ItemStack, list: NbtList) = NBTHelper.setList(stack, UPGRADE_LIST, list)
        fun getList(stack: ItemStack) = NBTHelper.getList(stack, UPGRADE_LIST, 8, false)

        fun setDefaults(stack: ItemStack): ItemStack {
            setSlots(stack, 3)
            setList(stack, NbtList())
            return stack
        }

    }

    class UpgradableItemImpl(val stack: ItemStack) : UpgradableItem {
        override fun addUpgrade(upgrade: Upgrade): Boolean {
            val name = "${upgrade.getType().name}.${upgrade.getRarity().name}"
            val slots = getSlots(stack)
            if (slots != null && slots > 0) {
                setSlots(stack, slots - 1)
                val list = getList(stack)
                if (list != null) {
                    list.add(NbtString.of(name))
                    setList(stack, list)
                    return true
                }
            }
            return false
        }

    }

}
