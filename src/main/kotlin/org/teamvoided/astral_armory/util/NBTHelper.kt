package org.teamvoided.astral_armory.util

import blue.endless.jankson.annotation.Nullable
import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.nbt.NbtList
import org.jetbrains.annotations.Contract


@Suppress("unused")
object NBTHelper {

    //Setters

    operator fun set(stack: ItemStack, tag: String, nbt: NbtElement) {
        stack.orCreateNbt.put(tag, nbt)
    }
    fun setCompound(stack: ItemStack, tag: String, cmp: NbtCompound) {
        stack.orCreateNbt.put(tag, cmp)
    }

    fun setList(stack: ItemStack, tag: String, list: NbtList) {
        stack.orCreateNbt.put(tag, list)
    }



    // Getters
    private fun exists(stack: ItemStack, tag: String): Boolean {
        return !stack.isEmpty && stack.hasNbt() && stack.orCreateNbt.contains(tag)
    }

    @Nullable
    operator fun get(stack: ItemStack, tag: String): NbtElement? {
        return if (exists(stack, tag)) stack.orCreateNbt.get(tag) else null
    }


    @Nullable
    @Contract("_, _, _, false -> !null")
    fun getCompound(stack: ItemStack, tag: String, nullifyOnFail: Boolean): NbtCompound? {
        return if (exists(stack, tag)) stack.orCreateNbt
            .getCompound(tag) else if (nullifyOnFail) null else NbtCompound()
    }

    @Nullable
    @Contract("_, _, _, false -> !null")
    fun getList(stack: ItemStack, tag: String, listType: Int, nullifyOnFail: Boolean): NbtList? {
        return if (exists(stack, tag)) stack.orCreateNbt
            .getList(tag, listType) else if (nullifyOnFail) null else NbtList()
    }
}