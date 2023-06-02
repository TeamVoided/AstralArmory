package org.teamvoided.astral_armory.blocks

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.fabricmc.fabric.api.`object`.builder.v1.block.FabricBlockSettings
import net.minecraft.block.Block
import net.minecraft.block.Material
import net.minecraft.item.BlockItem
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import net.minecraft.sound.BlockSoundGroup
import org.teamvoided.astral_armory.id
import java.util.LinkedList

object AstralArmoryBlocks {
    val BLOCK_ITEMS = LinkedList<ItemStack>()

    val TEST_BLOCK: Block = Block(FabricBlockSettings.of(Material.AIR))
    val ASTRAL_BLOCK: Block = Block(FabricBlockSettings.of(Material.METAL).luminance(3).sounds(BlockSoundGroup.NETHERITE).hardness(55f))


    fun register() {
        registerBlock(TEST_BLOCK, "test_block")
        registerBlock(ASTRAL_BLOCK, "astral_block")
    }

    fun registerBlock(block: Block, id: String) {
        Registry.register(Registries.BLOCK, id(id), block)
        BLOCK_ITEMS.add(Registry.register(Registries.ITEM, id(id), BlockItem(block, FabricItemSettings())).defaultStack)
    }
}