package org.teamvoided.astral_armory.items


import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.astral_armory.id
import java.util.LinkedList


object AstralArmoryItems {
    val ITEM_LIST = LinkedList<ItemStack>()


    val TEST: Item = Item(FabricItemSettings().maxCount(2))

    fun register() {
        registerItem(TEST, "test")
    }

    fun registerItem(item: Item, id: String) {
        Registry.register(Registries.ITEM, id(id), item)
        ITEM_LIST.add(item.defaultStack)
    }

}