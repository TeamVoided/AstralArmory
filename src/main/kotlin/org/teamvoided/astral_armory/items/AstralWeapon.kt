package org.teamvoided.astral_armory.items

import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.SwordItem
import net.minecraft.util.Rarity

class AstralWeapon(val attackDamage: Int, val attackSpeed: Float) : SwordItem(
    AstralToolMaterials.ASTRAL,
    attackDamage,
    attackSpeed,
    FabricItemSettings().fireproof().rarity(Rarity.EPIC)
)
