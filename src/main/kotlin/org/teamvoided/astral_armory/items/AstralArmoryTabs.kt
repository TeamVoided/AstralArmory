package org.teamvoided.astral_armory.items

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents
import org.teamvoided.astral_armory.blocks.AstralArmoryBlocks
import org.teamvoided.astral_armory.id

object AstralArmoryTabs {

    val ASTRAL_ARMORY_TAB =
        FabricItemGroup.builder(id("astral_armory_tab")).icon { AstralArmoryItems.TEST.defaultStack }.build()

    fun register() {
        ItemGroupEvents.modifyEntriesEvent(ASTRAL_ARMORY_TAB).register(ItemGroupEvents.ModifyEntries { content ->
            content.addAll(AstralArmoryItems.ITEM_LIST)
            content.addAll(AstralArmoryBlocks.BLOCK_ITEMS)
        })
    }
}