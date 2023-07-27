package net.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class ModFlammableBlock extends Block {
    private static boolean isFlammable;
    private static int flammability;
    private static int fireSpreadSpeed;

    public ModFlammableBlock(Properties properties,
                                 boolean isFlammable, int flammability, int fireSpreadSpeed) {
        super(properties);

        ModFlammableBlock.isFlammable = isFlammable;
        ModFlammableBlock.flammability = flammability;
        ModFlammableBlock.fireSpreadSpeed = fireSpreadSpeed;
    }
    @Override
    public boolean isFlammable(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return  isFlammable; // return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return flammability; // return 20;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
        return fireSpreadSpeed; //return 5;
    }
}
