package org.teamvoided.astral_armory.items.upgrades

import net.minecraft.client.item.TooltipContext
import net.minecraft.entity.player.PlayerEntity
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.text.Text
import net.minecraft.util.Hand
import net.minecraft.util.TypedActionResult
import net.minecraft.world.World
import org.teamvoided.astral_armory.api.UpgradableItem
import org.teamvoided.astral_armory.api.Upgrade
import org.teamvoided.astral_armory.items.ApiUtil.findUpgradableItem
import org.teamvoided.astral_armory.items.ApiUtil.findUpgrade
import org.teamvoided.astral_armory.util.NBTHelper

open class UpgradeItem(settings: Settings?, val rarity: UpgradeRarity, val upgradeType: UpgradeType) : Item(settings) {
    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?,
    ) {
        tooltip?.add(Text.of("$rarity.$upgradeType"))
        super.appendTooltip(stack, world, tooltip, context)
    }


    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        val itemStack = user?.getStackInHand(hand)
        if (hand == Hand.OFF_HAND) {
            val upgrade: Upgrade? = findUpgrade(itemStack)
            val item: UpgradableItem? = findUpgradableItem(user?.getStackInHand(Hand.MAIN_HAND))
            if (item != null && upgrade != null) {
                if (item.addUpgrade(upgrade)) return TypedActionResult.consume(itemStack)
                user?.sendMessage(Text.of("Failed to Upgrade"))
            }
        }
        return TypedActionResult.pass(itemStack)
    }

    companion object {

        val RARITY_TAG = "Rarity"
        val TYPE_TAG = "Type"
        fun getRarity(stack: ItemStack) = NBTHelper.getString(stack, RARITY_TAG)
        fun setRarity(stack: ItemStack, string: String) = NBTHelper.setString(stack, RARITY_TAG, string)
        fun getType(stack: ItemStack) = NBTHelper.getString(stack, TYPE_TAG)
        fun setType(stack: ItemStack, string: String) = NBTHelper.setString(stack, TYPE_TAG, string)
        fun setDefault(stack: ItemStack): ItemStack {
            setRarity(stack, UpgradeRarity.COMMON.name)
            setType(stack, UpgradeType.DAMAGE.name)
            return stack
        }
    }

    class UpgradeIml(val stack: ItemStack) : Upgrade {
        override fun getRarity(): UpgradeRarity {
            val rarity = getRarity(stack)
            if (rarity != null) return UpgradeRarity.valueOf(rarity)
            return UpgradeRarity.COMMON
        }

        override fun getType(): UpgradeType {
            val rarity = getType(stack)
            if (rarity != null) return UpgradeType.valueOf(rarity)
            return UpgradeType.DAMAGE
        }

    }

}