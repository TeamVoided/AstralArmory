package org.teamvoided.astral_armory.api

import org.teamvoided.astral_armory.items.upgrades.UpgradeRarity
import org.teamvoided.astral_armory.items.upgrades.UpgradeType

interface Upgrade {
    fun  getType(): UpgradeType
    fun  getRarity(): UpgradeRarity
}