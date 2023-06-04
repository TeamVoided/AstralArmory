package org.teamvoided.astral_armory.util

import net.minecraft.item.ItemStack
import net.minecraft.nbt.NbtCompound
import net.minecraft.nbt.NbtElement
import net.minecraft.nbt.NbtList
import org.jetbrains.annotations.Contract


@Suppress("unused")
object NBTHelper {

    //Setters

    operator fun set(stack: ItemStack, tag: String, nbt: NbtElement) =
        stack.orCreateNbt.put(tag, nbt)

    fun setInt(stack: ItemStack, tag: String, int: Int) =
        stack.orCreateNbt.putInt(tag, int)

    fun setString(stack: ItemStack, tag: String, string: String) =
        stack.orCreateNbt.putString(tag, string)

    fun setCompound(stack: ItemStack, tag: String, cmp: NbtCompound) =
        stack.orCreateNbt.put(tag, cmp)

    fun setList(stack: ItemStack, tag: String, list: NbtList) =
        stack.orCreateNbt.put(tag, list)


    // Getters
    private fun exists(stack: ItemStack, tag: String): Boolean =
        !stack.isEmpty && stack.hasNbt() && stack.orCreateNbt.contains(tag)


    operator fun get(stack: ItemStack, tag: String): NbtElement? =
        if (exists(stack, tag)) stack.orCreateNbt.get(tag) else null

    fun getInt(stack: ItemStack, tag: String) =
        if (exists(stack, tag)) stack.orCreateNbt.getInt(tag) else null

    fun getString(stack: ItemStack, tag: String) =
        if (exists(stack, tag)) stack.orCreateNbt.getString(tag) else null

    @Contract("_, _, _, false -> !null")
    fun getCompound(stack: ItemStack, tag: String, nullifyOnFail: Boolean): NbtCompound? =
        if (exists(stack, tag)) stack.orCreateNbt.getCompound(tag) else if (nullifyOnFail) null else NbtCompound()


    @Contract("_, _, _, false -> !null")
    fun getList(stack: ItemStack, tag: String, listType: Int, nullifyOnFail: Boolean): NbtList? =
        if (exists(stack, tag)) stack.orCreateNbt.getList(tag, listType) else if (nullifyOnFail) null else NbtList()

}