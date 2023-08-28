package com.andris.littlemodid.item.custom;

import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class RemoverItem extends Item {

    public RemoverItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if(!context.getWorld().isClient()){
            BlockPos positionClicked = context.getBlockPos();
            World worldClicked = context.getWorld();
            worldClicked.breakBlock(positionClicked.add(0,0,0),true);

        }

        return ActionResult.SUCCESS;
    }
}
