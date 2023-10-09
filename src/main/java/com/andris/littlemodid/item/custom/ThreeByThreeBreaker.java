package com.andris.littlemodid.item.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.*;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.function.Consumer;

public class ThreeByThreeBreaker extends PickaxeItem {

    public ThreeByThreeBreaker(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }
    @Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if (!world.isClient && state.getHardness(world, pos) != 0.0F) {
            stack.damage(1, (LivingEntity) miner, (Consumer<LivingEntity>) ((e) -> {
                miner.sendEquipmentBreakStatus(EquipmentSlot.MAINHAND);
            }));
        }
        float yaw = miner.getYaw();
        float pitch = miner.getYaw();

        if((pitch >= 45 && pitch <= 90) || (pitch <= -45 && pitch >= -90)){
            miner.sendMessage(Text.literal("Up or down" + pitch +"---"+ yaw));
            world.breakBlock(pos.add(0, 0, 1), true);
            world.breakBlock(pos.add(0, 0, 0), true);
            world.breakBlock(pos.add(0, 0, -1), true);
            //left row
            world.breakBlock(pos.add(1, 0, 1), true);
            world.breakBlock(pos.add(1, 0, 0), true);
            world.breakBlock(pos.add(1, 0, -1), true);
            //right row
            world.breakBlock(pos.add(-1, 0, 1), true);
            world.breakBlock(pos.add(-1, 0, 0), true);
            world.breakBlock(pos.add(-1, 0, -1), true);

        }else if(((yaw <= 135.1 && yaw < 180) || (yaw > -180 && yaw <= -135.1)) || (yaw >= -44.9 || yaw <= 45)){
            miner.sendMessage(Text.literal("north and south" + pitch +"---"+ yaw));
            world.breakBlock(pos.add(0, 1, 0), true);
            world.breakBlock(pos.add(0, 0, 0), true);
            world.breakBlock(pos.add(0, -1, 0), true);
            //left row
            world.breakBlock(pos.add(1, 1, 0), true);
            world.breakBlock(pos.add(1, 0, 0), true);
            world.breakBlock(pos.add(1, -1, 0), true);
            //right row
            world.breakBlock(pos.add(-1, 1, 0), true);
            world.breakBlock(pos.add(-1, 0, 0), true);
            world.breakBlock(pos.add(-1, -1, 0), true);

        }else if((yaw < -134.9 || yaw <= -45.1) || (yaw <= 49.1 || yaw > -135)) {
            miner.sendMessage(Text.literal("east and west"+ pitch +"---"+ yaw));
            world.breakBlock(pos.add(0, 1, 0), true);
            world.breakBlock(pos.add(0, 0, 0), true);
            world.breakBlock(pos.add(0, -1, 0), true);
            //left row
            world.breakBlock(pos.add(0, 1, 1), true);
            world.breakBlock(pos.add(0, 0, 1), true);
            world.breakBlock(pos.add(0, -1, 1), true);
            //right row
            world.breakBlock(pos.add(0, 1, -1), true);
            world.breakBlock(pos.add(0, 0, -1), true);
            world.breakBlock(pos.add(0, -1, -1), true);
        }
        return true;
    }
/*
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
    */

}
