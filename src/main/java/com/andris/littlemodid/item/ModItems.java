package com.andris.littlemodid.item;

import com.andris.littlemodid.LittleModMain;
import com.andris.littlemodid.block.ModBlocks;
import com.andris.littlemodid.item.custom.*;
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

    //Attack damage and speeds need to be corrected.
    public static final Item DIAWRONITE_AXE = registerItem("diawronite_axe",
            new ModAxeItem(ModToolMaterials.DIAWRONITE,1,2f, new FabricItemSettings()));
    public static final Item DIAWRONITE_PICKAXE = registerItem("diawronite_pickaxe",
            new ModPickaxeItem(ModToolMaterials.DIAWRONITE,1,2f, new FabricItemSettings()));
    public static final Item DIAWRONITE_HOE = registerItem("diawronite_hoe",
            new ModHoeItem(ModToolMaterials.DIAWRONITE,1,2f, new FabricItemSettings()));
    public static final Item DIAWRONITE_SHOVEL = registerItem("diawronite_shovel",
            new ModShovelItem(ModToolMaterials.DIAWRONITE,1,2f, new FabricItemSettings()));
    public static final Item DIAWRONITE_SWORD = registerItem("diawronite_sword",
            new ModSwordItem(ModToolMaterials.DIAWRONITE,1,2f, new FabricItemSettings()));


    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(DIAWRONITE_ALLOY_INGOT);
        entries.add(ModBlocks.DIAWRONITE_BLOCK);

        entries.add(DIAWRONITE_AXE);
        entries.add(DIAWRONITE_HOE);
        entries.add(DIAWRONITE_PICKAXE);
        entries.add(DIAWRONITE_SHOVEL);
        entries.add(DIAWRONITE_SWORD);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LittleModMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LittleModMain.LOGGER.info("Registering Mod Items for " + LittleModMain.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
