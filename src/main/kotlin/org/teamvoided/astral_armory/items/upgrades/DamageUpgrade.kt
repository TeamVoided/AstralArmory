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

open class DamageUpgrade(settings: Settings?, val rarity: UpgradeRarity) : Item(settings) {
    companion object {
        val upgradeName: Text = Text.of("Damage")
    }

    override fun appendTooltip(
        stack: ItemStack?,
        world: World?,
        tooltip: MutableList<Text>?,
        context: TooltipContext?,
    ) {
        tooltip?.add(upgradeName)
        super.appendTooltip(stack, world, tooltip, context)
    }


    override fun use(world: World?, user: PlayerEntity?, hand: Hand?): TypedActionResult<ItemStack> {
        val itemStack = user?.getStackInHand(hand)
        val upgrade: Upgrade? = findUpgrade(itemStack)
        val item: UpgradableItem? = findUpgradableItem(user?.getStackInHand(Hand.MAIN_HAND))
        if (item != null && upgrade != null) {
            if (item.addUpgrade(upgrade)) {
                user?.sendMessage(upgradeName)
            } else {
                user?.sendMessage(Text.of("Failed to Upgrade"))
            }
        }
        return TypedActionResult.pass(itemStack)
    }

    class UpgradeIml(stack: ItemStack) : Upgrade {
        override fun getUpgradeName(): Text = upgradeName
        override fun getRarity(): UpgradeRarity = UpgradeRarity.COMMON

    }

}