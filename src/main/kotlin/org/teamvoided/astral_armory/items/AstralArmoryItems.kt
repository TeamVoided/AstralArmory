package org.teamvoided.astral_armory.items


import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.SwordItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.astral_armory.id
import java.util.*


object AstralArmoryItems {
    val ITEM_LIST = LinkedList<ItemStack>()


    val TEST: Item = Item(FabricItemSettings().maxCount(2))
    val ASTRAL_NUGGET: Item = Item(FabricItemSettings())


    val SWORD_ITEM: Item = SwordItem(AstralToolMaterials.ASTRAL, 9, -2.4f, FabricItemSettings().fireproof())

    fun register() {
        registerItem(TEST, "test")
        registerItem(ASTRAL_NUGGET, "astral_nugget")
        registerItem(SWORD_ITEM, "sword")
    }

    fun registerItem(item: Item, id: String) {
        Registry.register(Registries.ITEM, id(id), item)
        ITEM_LIST.add(item.defaultStack)
    }

}