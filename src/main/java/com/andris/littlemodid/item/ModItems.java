package com.andris.littlemodid.item;

import com.andris.littlemodid.LittleModMain;
import com.andris.littlemodid.item.custom.RemoverItem;
import com.andris.littlemodid.item.custom.ThreeByThreeBreaker;
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
    public static final Item REMOVERITEM = registerItem("removeritem", new RemoverItem(new FabricItemSettings()));
    public static final Item THREEBYTHREEBREAKER = registerItem("threebythreebreaker", new ThreeByThreeBreaker(new FabricItemSettings()));

    private static void addItemsToIngredientsItemGroup(FabricItemGroupEntries entries) {
        entries.add(DIAWRONITE_ALLOY_INGOT);
        entries.add(REMOVERITEM);
        entries.add(THREEBYTHREEBREAKER);
    }

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(LittleModMain.MOD_ID, name), item);
    }

    public static void registerModItems() {
        LittleModMain.LOGGER.info("Registering Mod Items for " + LittleModMain.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientsItemGroup);
    }
}
