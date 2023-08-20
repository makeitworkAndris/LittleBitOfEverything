package com.andris.littlemodid;

import com.andris.littlemodid.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LittleModMain implements ModInitializer {
	public static final String MOD_ID = "littlemodid";
    public static final Logger LOGGER = LoggerFactory.getLogger("littlemodid");

	@Override
	public void onInitialize() {
		LOGGER.info("LittleBitOfEverything s running!");
		LOGGER.info("This is the itemsFeature branch!");
		LOGGER.info("This is still the itemsFeature branch!");

		ModItems.registerModItems();

	}
}