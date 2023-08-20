package com.andris.littlemodid.item;

import com.andris.littlemodid.LittleModMain;
import com.andris.littlemodid.block.ModBlocks;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item DIAWRONITE_ALLOY_INGOT = registerItem("diawronite_alloy_ingot", new Item(new FabricItemSettings()));
    public static final Item GOLD_DUST = registerItem("gold_dust", new Item(new FabricItemSettings()));
    public static final Item DIAMOND_DUST = registerItem("diamond_dust", new Item(new FabricItemSettings()));
    public static final Item NETHERITE_DUST = registerItem("netherite_dust", new Item(new FabricItemSettings()));
    public static final Item IRON_DUST = registerItem("iron_dust", new Item(new FabricItemSettings()));
    public static final Item WROUGHT_IRON_DUST = registerItem("wrought_iron_dust", new Item(new FabricItemSettings()));
    public static final Item DIAWRONITE_ALLOY_DUST = registerItem("diawronite_alloy_dust", new Item(new FabricItemSettings()));
    public static final Item MORTAR = registerItem("mortar", new Item(new FabricItemSettings()));
    public static final Item URANIUM_DUST = registerItem("uranium_dust", new Item(new FabricItemSettings()));
    public static final Item RAINBOW_DYE = registerItem("rainbow_dye", new Item(new FabricItemSettings()));
    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(DIAWRONITE_ALLOY_INGOT);
        entries.add(ModBlocks.DIAWRONITE_BLOCK);
        entries.add(GOLD_DUST);
        entries.add(DIAMOND_DUST);
        entries.add(NETHERITE_DUST);
        entries.add(IRON_DUST);
        entries.add(WROUGHT_IRON_DUST);
        entries.add(MORTAR);
        entries.add(URANIUM_DUST);
        entries.add(DIAWRONITE_ALLOY_DUST);
        entries.add(RAINBOW_DYE);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LittleModMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LittleModMain.LOGGER.info("Registering Mod Items for " + LittleModMain.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
