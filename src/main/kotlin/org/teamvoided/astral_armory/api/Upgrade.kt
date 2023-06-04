package org.teamvoided.astral_armory.api

import net.minecraft.text.Text
import org.teamvoided.astral_armory.items.upgrades.UpgradeRarity

interface Upgrade {
    fun  getUpgradeName(): Text
    fun  getRarity(): UpgradeRarity
}