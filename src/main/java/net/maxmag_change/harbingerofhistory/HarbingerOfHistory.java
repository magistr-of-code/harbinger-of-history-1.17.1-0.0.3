package net.maxmag_change.harbingerofhistory;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.maxmag_change.harbingerofhistory.block.ModBlocks;
import net.maxmag_change.harbingerofhistory.item.ModItemGroup;
import net.maxmag_change.harbingerofhistory.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.client.render.RenderLayer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class HarbingerOfHistory implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final String MOD_ID = "harbingerofhistory";
	public static final Logger LOGGER = LogManager.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.GOLD_FENCE, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.PIANO, RenderLayer.getCutout());
		BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LANTERN_STAND, RenderLayer.getCutout());
		LOGGER.info("Hello Fabric world!");
	}
}
