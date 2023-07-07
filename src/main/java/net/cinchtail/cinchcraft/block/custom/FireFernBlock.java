package net.cinchtail.cinchcraft.block.custom;

import net.cinchtail.cinchcraft.util.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.PlantType;

import javax.annotation.Nullable;

public class FireFernBlock extends BushBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public FireFernBlock(BlockBehaviour.Properties p_52861_) {
        super(p_52861_);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }
    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return null;
    }
    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos pos, BlockPos pos1) {
        DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
        if (direction.getAxis() != Direction.Axis.Y || doubleblockhalf == DoubleBlockHalf.LOWER != (direction == Direction.UP) || blockState1.is(this) && blockState1.getValue(HALF) != doubleblockhalf) {
            return doubleblockhalf == DoubleBlockHalf.LOWER && direction == Direction.DOWN && !blockState.canSurvive(levelAccessor, pos) ? Blocks.AIR.defaultBlockState() : super.updateShape(blockState, direction, blockState1, levelAccessor, pos, pos1);
        } else {
            return Blocks.AIR.defaultBlockState();
        }
    }
    public void animateTick(BlockState blockState, Level level, BlockPos pos, RandomSource randomSource) {
        VoxelShape voxelshape = this.getShape(blockState, level, pos, CollisionContext.empty());
        Vec3 vec3 = voxelshape.bounds().getCenter();
        double d0 = (double)pos.getX() + vec3.x;
        double d1 = (double)pos.getZ() + vec3.z;

        for(int i = 0; i < 3; ++i) {
            if (randomSource.nextBoolean()) {
                level.addParticle(ParticleTypes.FLAME, d0 + randomSource.nextDouble() / 5.0D, (double)pos.getY() + (0.5D - randomSource.nextDouble()),
                        d1 + randomSource.nextDouble() / 5.0D, 0.0D, 0.0D, 0.0D);
            }
        }

    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            entity.setSecondsOnFire(4);
        }
        super.stepOn(level, pos, state, entity);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext placeContext) {
        BlockPos blockpos = placeContext.getClickedPos();
        Level level = placeContext.getLevel();
        return blockpos.getY() < level.getMaxBuildHeight() - 1 && level.getBlockState(blockpos.above()).canBeReplaced(placeContext) ? super.getStateForPlacement(placeContext) : null;
    }

    public void setPlacedBy(Level level, BlockPos pos, BlockState blockState, LivingEntity livingEntity, ItemStack itemStack) {
        BlockPos blockpos = pos.above();
        level.setBlock(blockpos, copyWaterloggedFrom(level, blockpos, this.defaultBlockState().setValue(HALF, DoubleBlockHalf.UPPER)), 3);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos pos)
    {
        if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER)
        {
            BlockState blockstate = levelReader.getBlockState(pos.below());
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }
        if (blockState.getBlock() != this)
            return super.canSurvive(blockState, levelReader, pos);

        else if(blockState.getValue(HALF) == DoubleBlockHalf.LOWER)
        {
            return levelReader.getBlockState(pos.below()).is(ModBlockTags.FIRE_FERN_PLACEABLE);
        }
        else
        {
            return false;
        }
    }


    public static BlockState copyWaterloggedFrom(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return blockState.hasProperty(BlockStateProperties.WATERLOGGED) ? blockState.setValue(BlockStateProperties.WATERLOGGED, levelReader.isWaterAt(blockPos)) : blockState;
    }

    public void playerWillDestroy(Level level, BlockPos pos, BlockState blockState, Player player) {
        if (!level.isClientSide) {
            if (player.isCreative()) {
                preventCreativeDropFromBottomPart(level, pos, blockState, player);
            } else {
                dropResources(blockState, level, pos, null, player, player.getMainHandItem());
            }
        }

        super.playerWillDestroy(level, pos, blockState, player);
    }

    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState blockState, @Nullable BlockEntity blockEntity, ItemStack itemStack) {
        super.playerDestroy(level, player, pos, Blocks.AIR.defaultBlockState(), blockEntity, itemStack);
    }

    protected static void preventCreativeDropFromBottomPart(Level level, BlockPos pos, BlockState blockState, Player player) {
        DoubleBlockHalf doubleblockhalf = blockState.getValue(HALF);
        if (doubleblockhalf == DoubleBlockHalf.UPPER) {
            BlockPos blockpos = pos.below();
            BlockState blockstate = level.getBlockState(blockpos);
            if (blockstate.is(blockState.getBlock()) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER) {
                BlockState blockstate1 = blockstate.getFluidState().is(Fluids.WATER) ? Blocks.WATER.defaultBlockState() : Blocks.AIR.defaultBlockState();
                level.setBlock(blockpos, blockstate1, 35);
                level.levelEvent(player, 2001, blockpos, Block.getId(blockstate));
            }
        }

    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(HALF);
    }

    public long getSeed(BlockState blockState, BlockPos pos) {
        return Mth.getSeed(pos.getX(), pos.below(blockState.getValue(HALF) == DoubleBlockHalf.LOWER ? 0 : 1).getY(), pos.getZ());
    }
}
