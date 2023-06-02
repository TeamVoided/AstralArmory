package org.teamvoided.astral_armory.items

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.registry.Registry
import net.minecraft.registry.Registries
import org.teamvoided.astral_armory.id

object AstralArmoryItems {
    val TEST: Item = Item(FabricItemSettings().maxCount(2))

    fun register(){
        Registry.register(Registries.ITEM, id("test"), TEST)
    }
}