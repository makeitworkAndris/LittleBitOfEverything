package com.andris.littlemodid.item;

import com.andris.littlemodid.LittleModMain;
import com.andris.littlemodid.block.ModBlocks;
import com.andris.littlemodid.item.custom.*;
import com.andris.littlemodid.sound.ModSounds;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.MusicDiscItem;
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
    public static final Item COMPRESSED_COAL = registerItem("compressed_coal", new Item(new FabricItemSettings()));
    public static final Item DENSE_DIAWRONITE_ALLOY_INGOT = registerItem("dense_diawronite_alloy_ingot", new Item(new FabricItemSettings()));

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
    public static final Item MUSIC_DISC_ACID_BALADE = registerItem("music_disc_acid_balade",
            new MusicDiscItem(6, ModSounds.MUSIC_DISC_ACID_BALADE, new FabricItemSettings().maxCount(1), 301));


    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(IRON_DUST);
        entries.add(WROUGHT_IRON_DUST);
        entries.add(GOLD_DUST);
        entries.add(DIAMOND_DUST);
        entries.add(NETHERITE_DUST);
        entries.add(DIAWRONITE_ALLOY_DUST);
        entries.add(URANIUM_DUST);
        entries.add(RAINBOW_DYE);

        entries.add(DIAWRONITE_ALLOY_INGOT);
        entries.add(DENSE_DIAWRONITE_ALLOY_INGOT);
        entries.add(COMPRESSED_COAL);

        entries.add(ModBlocks.DIAWRONITE_BLOCK);
        entries.add(ModBlocks.SPECIAL_DIRT);

        entries.add(DIAWRONITE_SWORD);
        entries.add(DIAWRONITE_AXE);
        entries.add(DIAWRONITE_PICKAXE);
        entries.add(DIAWRONITE_SHOVEL);
        entries.add(DIAWRONITE_HOE);
        entries.add(MORTAR);

        entries.add(MUSIC_DISC_ACID_BALADE);


    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LittleModMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LittleModMain.LOGGER.info("Registering Mod Items for " + LittleModMain.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
