package com.andris.littlemodid.block;

import com.andris.littlemodid.LittleModMain;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.MapColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    public static final Block DIAWRONITE_BLOCK = registerBlock("diawronite_block",
            new Block(AbstractBlock.Settings.create().mapColor(MapColor.BLACK).requiresTool().strength(5.0F, 6.0F).sounds(BlockSoundGroup.NETHERITE)));
    public static final Block SPECIAL_DIRT = registerBlock("special_dirt",
            new Block(FabricBlockSettings.copyOf(Blocks.DIRT)));

    public static void registerModBlocks(){
        LittleModMain.LOGGER.info("Registering Modblocks for " + LittleModMain.MOD_ID);
    }

    public static Block registerBlock(String name, Block block){
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(LittleModMain.MOD_ID, name), block);
    }

    private static Item registerBlockItem(String name, Block block) {
        return Registry.register(Registries.ITEM, new Identifier(LittleModMain.MOD_ID, name), new BlockItem(block, new FabricItemSettings()));
    }
}
