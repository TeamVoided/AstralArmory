package org.teamvoided.astral_armory.mixin

import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.item.Items
import org.spongepowered.asm.mixin.Mixin
import org.spongepowered.asm.mixin.Shadow

@Mixin(ItemStack::class)
class ItemStackMixin {
    @Shadow
    fun getItem(): Item {
        return Items.AIR
    }


}