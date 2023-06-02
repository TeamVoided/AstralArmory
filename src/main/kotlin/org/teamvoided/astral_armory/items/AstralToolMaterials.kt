package org.teamvoided.astral_armory.items

import net.minecraft.item.ItemConvertible
import net.minecraft.item.ToolMaterial
import net.minecraft.recipe.Ingredient
import net.minecraft.util.Lazy
import java.util.function.Supplier


enum class AstralToolMaterials(
    private val miningLevel: Int,
    private val itemDurability: Int,
    private val miningSpeed: Float,
    private val attackDamage: Float,
    private val enchantability: Int,
    repairIngredient: Supplier<Ingredient>
) : ToolMaterial {
    ASTRAL(
        0,
        5003,
        0f,
        0f,
        0,
        Supplier { Ingredient.ofItems(*arrayOf<ItemConvertible>(AstralArmoryItems.TEST)) });

    private val repairIngredient: Lazy<Ingredient>

    init {
        this.repairIngredient = Lazy(repairIngredient)
    }


    override fun getDurability(): Int {
        return itemDurability
    }

    override fun getMiningSpeedMultiplier(): Float {
        return miningSpeed
    }

    override fun getAttackDamage(): Float {
        return attackDamage
    }

    override fun getMiningLevel(): Int {
        return miningLevel
    }

    override fun getEnchantability(): Int {
        return enchantability
    }

    override fun getRepairIngredient(): Ingredient {
        return repairIngredient.get() as Ingredient
    }
}
