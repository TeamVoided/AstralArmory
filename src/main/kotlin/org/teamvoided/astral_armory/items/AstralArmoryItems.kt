package org.teamvoided.astral_armory.items


import net.fabricmc.fabric.api.item.v1.FabricItemSettings
import net.minecraft.item.Item
import net.minecraft.item.ItemStack
import net.minecraft.registry.Registries
import net.minecraft.registry.Registry
import org.teamvoided.astral_armory.id
import org.teamvoided.astral_armory.items.upgrades.UpgradeItem
import org.teamvoided.astral_armory.items.upgrades.UpgradeRarity
import org.teamvoided.astral_armory.items.upgrades.UpgradeType
import java.util.*


object AstralArmoryItems {
    val ITEM_LIST = LinkedList<ItemStack>()


    val TEST: Item = Item(FabricItemSettings().maxCount(2))
    val ASTRAL_NUGGET: Item = Item(FabricItemSettings())
    val ASTRAL_INGOT: Item = Item(FabricItemSettings())


    val ASTRAL_SWORD: Item = AstralWeapon(9f, -2.4f)

    val ASTRAL_LONGSWORD: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_TWINBLADE: Item = AstralWeapon(8f, -2.4f)
    val ASTRAL_RAPIER: Item = AstralWeapon(7f, -2.4f)
    val ASTRAL_KATANA: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_SAI: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_SPEAR: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_GLAIVE: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_WARGLAIVE: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_CUTLASS: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_GREATSWORD:  Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_GREATHAMMER:  Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_GREATAXE: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_CHAKRAM: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_SCYTHE: Item = AstralWeapon(9f, -2.4f)
    val ASTRAL_HALBERD: Item = AstralWeapon(9f, -2.4f)

    val COMMON_UPGRADE: Item = UpgradeItem(FabricItemSettings().maxCount(16), UpgradeRarity.COMMON, UpgradeType.DAMAGE)
    fun register() {

        registerItem(TEST, "test")
        registerItem(ASTRAL_NUGGET, "astral_nugget")
        registerItem(ASTRAL_INGOT, "astral_ingot")

        registerItem(ASTRAL_SWORD, "astral_sword")
        registerItem(ASTRAL_CHAKRAM, "astral_chakram")
        registerItem(ASTRAL_CUTLASS, "astral_cutlass")
        registerItem(ASTRAL_GLAIVE, "astral_glaive")
        registerItem(ASTRAL_GREATAXE, "astral_greataxe")
        registerItem(ASTRAL_GREATHAMMER, "astral_greathammer")
        registerItem(ASTRAL_GREATSWORD, "astral_greatsword")
        registerItem(ASTRAL_HALBERD, "astral_halberd")
        registerItem(ASTRAL_KATANA, "astral_katana")
        registerItem(ASTRAL_LONGSWORD, "astral_longsword")
        registerItem(ASTRAL_RAPIER, "astral_rapier")
        registerItem(ASTRAL_SAI, "astral_sai")
        registerItem(ASTRAL_SCYTHE, "astral_scythe")
        registerItem(ASTRAL_SPEAR, "astral_spear")
        registerItem(ASTRAL_TWINBLADE, "astral_twinblade")
        registerItem(ASTRAL_WARGLAIVE, "astral_warglaive")

        registerItem(COMMON_UPGRADE, "common_upgrade")





    }

    fun registerItem(item: Item, id: String) {
        Registry.register(Registries.ITEM, id(id), item)
        ITEM_LIST.add(item.defaultStack)
    }

}