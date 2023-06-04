package org.teamvoided.astral_armory.items

import net.fabricmc.fabric.api.lookup.v1.item.ItemApiLookup
import net.minecraft.item.ItemStack
import org.teamvoided.astral_armory.api.UpgradableItem
import org.teamvoided.astral_armory.api.Upgrade
import org.teamvoided.astral_armory.id


object ApiUtil {

    val UPGRADABLE_ITEM: ItemApiLookup<UpgradableItem, Unit> =
        ItemApiLookup.get(id("upgradable_item"), UpgradableItem::class.java, Unit::class.java)
    val UPGRADE: ItemApiLookup<Upgrade, Unit> =
        ItemApiLookup.get(id("upgrade"), Upgrade::class.java, Unit::class.java)

    fun findUpgradableItem(stack: ItemStack?): UpgradableItem? {
        return UPGRADABLE_ITEM.find(stack, Unit)
    }

    fun findUpgrade(stack: ItemStack?): Upgrade? {
        return UPGRADE.find(stack, Unit)
    }
}