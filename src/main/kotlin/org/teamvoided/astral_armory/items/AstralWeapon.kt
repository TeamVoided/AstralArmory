package org.teamvoided.astral_armory.items

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.client.item.TooltipContext
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.text.Text
import net.minecraft.util.Rarity
import net.minecraft.world.World
import org.teamvoided.astral_armory.api.UpgradableItem
import org.teamvoided.astral_armory.api.Upgrade


class AstralWeapon(private val attackDamage: Float, private val attackSpeed: Float) : SwordItem(
    AstralToolMaterials.ASTRAL,
    0,
    attackSpeed,
    FabricItemSettings().fireproof().rarity(Rarity.EPIC)
) {
    override fun getAttackDamage(): Float {
        return this.attackDamage
    }

    val UPGRADES_TAG = "Upgrades"

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?,
    ) {
        var times = 3;
        tooltip?.add(Text.of("Upgrades:"))
        for (i in 0 until times) tooltip?.add(Text.of("*"))

        super.appendTooltip(stack, world, tooltip, context)
    }

    class UpgradableItemImpl(val stack: ItemStack?) : UpgradableItem {
        override fun addUpgrade(upgrade: Upgrade): Boolean {


          return false
        }

    }

}
