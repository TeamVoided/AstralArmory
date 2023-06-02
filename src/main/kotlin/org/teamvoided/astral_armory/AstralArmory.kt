package org.teamvoided.astral_armory


import net.minecraft.util.Identifier
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.teamvoided.astral_armory.blocks.AstralArmoryBlocks
import org.teamvoided.astral_armory.items.AstralArmoryItems
import org.teamvoided.astral_armory.items.AstralArmoryTabs


const val MODID = "astral_armory"

@JvmField
val LOGGER: Logger = LoggerFactory.getLogger(MODID)

@Suppress("unused")
fun id(path: String): Identifier = Identifier(MODID, path)


@Suppress("unused")
fun onInitialize() {
    LOGGER.info("We shall be among the Stars!")

    AstralArmoryTabs.register()
    AstralArmoryItems.register()
    AstralArmoryBlocks.register()

}