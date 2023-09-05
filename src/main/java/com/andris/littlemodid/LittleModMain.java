package com.andris.littlemodid;

import com.andris.littlemodid.block.ModBlocks;
import com.andris.littlemodid.item.ModItems;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LittleModMain implements ModInitializer {
	public static final String MOD_ID = "littlemodid";
    public static final Logger LOGGER = LoggerFactory.getLogger("littlemodid");
    public static final Logger LOGGER = LoggerFactory.getLogger("Edited in School :O");

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		LOGGER.info("LittleBitOfEverything s running!");
		LOGGER.info("This is the toolsFeature branch!");
		LOGGER.info("This is still the toolsFeature branch!");

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		FuelRegistry.INSTANCE.add(ModItems.URANIUM_DUST, 16000);

	}
}
