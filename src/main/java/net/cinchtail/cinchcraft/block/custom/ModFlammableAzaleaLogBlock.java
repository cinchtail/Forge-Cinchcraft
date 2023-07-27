package net.cinchtail.cinchcraft.block.custom;

import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;

public class ModFlammableAzaleaLogBlock extends RotatedPillarBlock {
    private static boolean isFlammable;
    private static int flammability;
    private static int fireSpreadSpeed;

    public ModFlammableAzaleaLogBlock(Properties properties,
                                 boolean isFlammable, int flammability, int fireSpreadSpeed) {
        super(properties);

        ModFlammableAzaleaLogBlock.isFlammable = isFlammable;
        ModFlammableAzaleaLogBlock.flammability = flammability;
        ModFlammableAzaleaLogBlock.fireSpreadSpeed = fireSpreadSpeed;
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

    @Nullable
    @Override
    public BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        if (context.getItemInHand().getItem() instanceof AxeItem) {
            if (state.is(ModBlocks.AZALEA_LOG.get())) {
                return ModBlocks.STRIPPED_AZALEA_LOG.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            if (state.is(ModBlocks.AZALEA_WOOD.get())) {
                return ModBlocks.STRIPPED_AZALEA_WOOD.get().defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
        }

        return super.getToolModifiedState(state, context, toolAction, simulate);
    }
}
