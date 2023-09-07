package com.andris.littlemodid.item.custom;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;

public class ThreeByThreeBreaker extends Item {

    public ThreeByThreeBreaker(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {

        if (!context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            World worldClicked = context.getWorld();
            PlayerEntity player = context.getPlayer();
            Direction blockHit = context.getSide();

            assert player != null;
            player.sendMessage(Text.literal("BLOCKHIT_DIRECTION: " + blockHit), true);

            switch(blockHit){
                case UP,DOWN -> {
                    worldClicked.breakBlock(positionClicked.add(0,0,1),true);
                    worldClicked.breakBlock(positionClicked.add(0,0,0),true);
                    worldClicked.breakBlock(positionClicked.add(0,0,-1),true);
                    //left row
                    worldClicked.breakBlock(positionClicked.add(1,0,1),true);
                    worldClicked.breakBlock(positionClicked.add(1,0,0),true);
                    worldClicked.breakBlock(positionClicked.add(1,0,-1),true);
                    //right row
                    worldClicked.breakBlock(positionClicked.add(-1,0,1),true);
                    worldClicked.breakBlock(positionClicked.add(-1,0,0),true);
                    worldClicked.breakBlock(positionClicked.add(-1,0,-1),true);
                }
                case NORTH,SOUTH -> {
                    worldClicked.breakBlock(positionClicked.add(0,1,0),true);
                    worldClicked.breakBlock(positionClicked.add(0,0,0),true);
                    worldClicked.breakBlock(positionClicked.add(0,-1,0),true);
                    //left row
                    worldClicked.breakBlock(positionClicked.add(1,1,0),true);
                    worldClicked.breakBlock(positionClicked.add(1,0,0),true);
                    worldClicked.breakBlock(positionClicked.add(1,-1,0),true);
                    //right row
                    worldClicked.breakBlock(positionClicked.add(-1,1,0),true);
                    worldClicked.breakBlock(positionClicked.add(-1,0,0),true);
                    worldClicked.breakBlock(positionClicked.add(-1,-1,0),true);
                }
                case EAST,WEST -> {
                    worldClicked.breakBlock(positionClicked.add(0,1,0),true);
                    worldClicked.breakBlock(positionClicked.add(0,0,0),true);
                    worldClicked.breakBlock(positionClicked.add(0,-1,0),true);
                    //left row
                    worldClicked.breakBlock(positionClicked.add(0,1,1),true);
                    worldClicked.breakBlock(positionClicked.add(0,0,1),true);
                    worldClicked.breakBlock(positionClicked.add(0,-1,1),true);
                    //right row
                    worldClicked.breakBlock(positionClicked.add(0,1,-1),true);
                    worldClicked.breakBlock(positionClicked.add(0,0,-1),true);
                    worldClicked.breakBlock(positionClicked.add(0,-1,-1),true);
                }
                default -> {
                }
            }
        }
        return ActionResult.SUCCESS;
    }
}
