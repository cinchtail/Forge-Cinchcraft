package net.cinchtail.cinchcraft.block.custom;

import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ModSunflowerCropBlock extends DoublePlantBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static final int MAX_AGE = 4;
    private static final int DOUBLE_PLANT_AGE_INTERSECTION = 3;
    private static final int BONEMEAL_INCREASE = 1;

    private static final VoxelShape FULL_UPPER_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D);
    private static final VoxelShape FULL_LOWER_SHAPE = Block.box(3.0D, -1.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape[] UPPER_SHAPE_BY_AGE = new VoxelShape[]{Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D), FULL_UPPER_SHAPE};
    private static final VoxelShape[] LOWER_SHAPE_BY_AGE = new VoxelShape[]{Block.box(5.0D, 0.0D, 5.0D, 11.0D, 10.0D, 11.0D), FULL_LOWER_SHAPE, FULL_LOWER_SHAPE, FULL_LOWER_SHAPE};
    public ModSunflowerCropBlock(Properties properties) {
        super(properties);
    }
    private boolean isMaxAge(BlockState blockState) {
        return blockState.getValue(AGE) >= 4;
    }

    public boolean isRandomlyTicking(BlockState blockState) {
        return blockState.getValue(HALF) == DoubleBlockHalf.LOWER && !this.isMaxAge(blockState);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        return this.defaultBlockState();
    }
    protected boolean mayPlaceOn(BlockState blockState, BlockGetter blockGetter, BlockPos pos) {
        return blockState.is(BlockTags.DIRT);
    }
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(AGE);
        super.createBlockStateDefinition(blockBlockStateBuilder);
    }
    public VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos pos, CollisionContext collisionContext) {
        return blockState.getValue(HALF) == DoubleBlockHalf.UPPER ? UPPER_SHAPE_BY_AGE[Math.min(Math.abs(4 - (blockState.getValue(AGE) + 1)), UPPER_SHAPE_BY_AGE.length - 1)] : LOWER_SHAPE_BY_AGE[blockState.getValue(AGE)];
    }
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        return !blockState.canSurvive(levelAccessor, pos) ? Blocks.AIR.defaultBlockState() : blockState;
    }
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos pos) {
        if (!isLower(blockState)) {
            return super.canSurvive(blockState, levelReader, pos);
        } else {
            return this.mayPlaceOn(levelReader.getBlockState(pos.below()), levelReader, pos.below()) && sufficientLight(levelReader, pos) && (blockState.getValue(AGE) < 3 || isUpper(levelReader.getBlockState(pos.above())));
        }
    }
    public boolean canBeReplaced(BlockState blockState, BlockPlaceContext placeContext) {
        return false;
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
    }

    public void randomTick(BlockState blockState, ServerLevel serverLevel, BlockPos pos, RandomSource randomSource) {
        float f = ModSunflowerCropBlock.modGetGrowthSpeed(this, serverLevel, pos);
        boolean flag = randomSource.nextInt((int)(25.0F / f) + 1) == 0;
        if (flag) {
            this.grow(serverLevel, blockState, pos, 1);
        }

    }
    protected static float modGetGrowthSpeed(Block block, BlockGetter blockGetter, BlockPos pos) {
        float f = 1.0F;
        BlockPos blockpos = pos.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = blockGetter.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(blockGetter, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP, (net.minecraftforge.common.IPlantable) block)) {
                    f1 = 3.0F;
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = pos.north();
        BlockPos blockpos2 = pos.south();
        BlockPos blockpos3 = pos.west();
        BlockPos blockpos4 = pos.east();
        boolean flag = blockGetter.getBlockState(blockpos3).is(block) || blockGetter.getBlockState(blockpos4).is(block);
        boolean flag1 = blockGetter.getBlockState(blockpos1).is(block) || blockGetter.getBlockState(blockpos2).is(block);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = blockGetter.getBlockState(blockpos3.north()).is(block) || blockGetter.getBlockState(blockpos4.north()).is(block) || blockGetter.getBlockState(blockpos4.south()).is(block) || blockGetter.getBlockState(blockpos3.south()).is(block);
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }
    private void grow(ServerLevel serverLevel, BlockState blockState, BlockPos pos, int i1) {
        int i = Math.min(blockState.getValue(AGE) + i1, 4);
        if (this.canGrow(serverLevel, pos, blockState, i)) {
            serverLevel.setBlock(pos, blockState.setValue(AGE, i), 2);
            if (i >= 3) {
                BlockPos blockpos = pos.above();
                serverLevel.setBlock(blockpos, copyWaterloggedFrom(serverLevel, pos, this.defaultBlockState().setValue(AGE, i).setValue(HALF, DoubleBlockHalf.UPPER)), 3);
            }

        }
    }
    private static boolean canGrowInto(LevelReader levelReader, BlockPos pos) {
        BlockState blockstate = levelReader.getBlockState(pos);
        return blockstate.isAir() || blockstate.is(ModBlocks.SUNFLOWER_CROP.get());
    }
    private static boolean sufficientLight(LevelReader levelReader, BlockPos pos) {
        return levelReader.getRawBrightness(pos, 0) >= 8 || levelReader.canSeeSky(pos);
    }

    private static boolean isLower(BlockState blockState) {
        return blockState.is(ModBlocks.SUNFLOWER_CROP.get()) && blockState.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    private static boolean isUpper(BlockState blockState) {
        return blockState.is(ModBlocks.SUNFLOWER_CROP.get()) && blockState.getValue(HALF) == DoubleBlockHalf.UPPER;
    }

    private boolean canGrow(LevelReader levelReader, BlockPos pos, BlockState blockState, int i) {
        return !this.isMaxAge(blockState) && sufficientLight(levelReader, pos) && (i < 3 || canGrowInto(levelReader, pos.above()));
    }
    @Nullable
    private ModSunflowerCropBlock.PosAndState getLowerHalf(LevelReader levelReader, BlockPos pos, BlockState blockState) {
        if (isLower(blockState)) {
            return new ModSunflowerCropBlock.PosAndState(pos, blockState);
        } else {
            BlockPos blockpos = pos.below();
            BlockState blockstate = levelReader.getBlockState(blockpos);
            return isLower(blockstate) ? new ModSunflowerCropBlock.PosAndState(blockpos, blockstate) : null;
        }
    }
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState blockState, boolean p_277487_) {
        ModSunflowerCropBlock.PosAndState modsunflowercropblock$posandstate = this.getLowerHalf(levelReader, pos, blockState);
        return modsunflowercropblock$posandstate != null && this.canGrow(levelReader, modsunflowercropblock$posandstate.pos, modsunflowercropblock$posandstate.state, modsunflowercropblock$posandstate.state.getValue(AGE) + 1);
    }

    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        return true;
    }

    public void performBonemeal(ServerLevel serverLevel, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        ModSunflowerCropBlock.PosAndState modsunflowercropblock$posandstate = this.getLowerHalf(serverLevel, pos, blockState);
        if (modsunflowercropblock$posandstate != null) {
            this.grow(serverLevel, modsunflowercropblock$posandstate.state, modsunflowercropblock$posandstate.pos, 1);
        }
    }
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        return new ItemStack(ModItems.SUNFLOWER_SEEDS.get());
    }
    record PosAndState(BlockPos pos, BlockState state) {
    }
}
