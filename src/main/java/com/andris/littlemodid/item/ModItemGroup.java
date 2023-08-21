package com.andris.littlemodid.item;


import com.andris.littlemodid.LittleModMain;
import com.andris.littlemodid.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;


public class ModItemGroup {
    private static final RegistryKey<ItemGroup> LITTLEMOD = RegistryKey.of(RegistryKeys.ITEM_GROUP, new Identifier(LittleModMain.MOD_ID, "ittlemod"));

    public static void regiterModItemGroup()
    {
        Registry.register(Registries.ITEM_GROUP, LITTLEMOD, FabricItemGroup.builder()
                .displayName(Text.translatable("Littlemod"))
                .icon(() -> new ItemStack(ModItems.URANIUM_DUST))
                .entries((context, entries) -> {
                    entries.add(ModItems.IRON_DUST);
                    entries.add(ModItems.WROUGHT_IRON_DUST);
                    entries.add(ModItems.GOLD_DUST);
                    entries.add(ModItems.DIAMOND_DUST);
                    entries.add(ModItems.NETHERITE_DUST);
                    entries.add(ModItems.DIAWRONITE_ALLOY_DUST);
                    entries.add(ModItems.URANIUM_DUST);
                    entries.add(ModItems.RAINBOW_DYE);

                    entries.add(ModItems.DIAWRONITE_ALLOY_INGOT);
                    entries.add(ModItems.DENSE_DIAWRONITE_ALLOY_INGOT);
                    entries.add(ModItems.COMPRESSED_COAL);

                    entries.add(ModBlocks.DIAWRONITE_BLOCK);
                    entries.add(ModBlocks.SPECIAL_DIRT);

                    entries.add(ModItems.DIAWRONITE_SWORD);
                    entries.add(ModItems.DIAWRONITE_AXE);
                    entries.add(ModItems.DIAWRONITE_PICKAXE);
                    entries.add(ModItems.DIAWRONITE_SHOVEL);
                    entries.add(ModItems.DIAWRONITE_HOE);
                    entries.add(ModItems.MORTAR);

                    entries.add(ModItems.MUSIC_DISC_ACID_BALADE);
                })
                .build()
        );

    }
}
