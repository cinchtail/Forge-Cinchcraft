package net.cinchtail.cinchcraft.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.FenceBlock;
import net.minecraft.world.level.block.state.BlockState;

public class ModFlammableFenceBlock extends FenceBlock {
    private static boolean isFlammable;
    private static int flammability;
    private static int fireSpreadSpeed;

    public ModFlammableFenceBlock(Properties properties,
                                 boolean isFlammable, int flammability, int fireSpreadSpeed) {
        super(properties);

        ModFlammableFenceBlock.isFlammable = isFlammable;
        ModFlammableFenceBlock.flammability = flammability;
        ModFlammableFenceBlock.fireSpreadSpeed = fireSpreadSpeed;
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
