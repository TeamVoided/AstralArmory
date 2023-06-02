package org.teamvoided.astral_armory.blocks

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.astral_armory.id

object AstralArmoryBlocks {
    val TEST_BLOCK: Block = Block(FabricBlockSettings.of(Material.AIR))

    fun register(){
        Registry.register(Registries.BLOCK, id("test_block"), TEST_BLOCK)
        Registry.register(Registries.ITEM, id("test_block"), BlockItem(TEST_BLOCK, FabricItemSettings()))
    }
}