package org.teamvoided.astral_armory.items.upgrades

import org.teamvoided.voidlib.core.ARGB


enum class UpgradeRarity(val color: ARGB) {
    COMMON(ARGB(256, 100, 100, 100)),
    RARE(ARGB(256, 230, 100, 100)),
    LEGENDARY(ARGB(256, 200, 200, 100))
}