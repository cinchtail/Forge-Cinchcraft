package net.cinchtail.cinchcraft.block.custom;

import com.google.common.annotations.VisibleForTesting;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntitySelector;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ThrownTrident;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.*;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.*;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;
import java.util.Optional;
import java.util.function.BiPredicate;
import java.util.function.Predicate;
//TODO dont drop item when broken by water falling or that things
//TODO make icicle transparent without bug
public class IcicleBlock extends Block implements Fallable, SimpleWaterloggedBlock {
    public static final DirectionProperty TIP_DIRECTION = BlockStateProperties.VERTICAL_DIRECTION;
    public static final EnumProperty<DripstoneThickness> THICKNESS = BlockStateProperties.DRIPSTONE_THICKNESS;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final int MAX_SEARCH_LENGTH_WHEN_CHECKING_DRIP_TYPE = 11;
    private static final int DELAY_BEFORE_FALLING = 2;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK = 0.02F;
    private static final float DRIP_PROBABILITY_PER_ANIMATE_TICK_IF_UNDER_LIQUID_SOURCE = 0.12F;
    private static final int MAX_SEARCH_LENGTH_BETWEEN_STALACTITE_TIP_AND_CAULDRON = 11;
    private static final float WATER_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.17578125F;
    private static final float LAVA_TRANSFER_PROBABILITY_PER_RANDOM_TICK = 0.05859375F;
    private static final double MIN_TRIDENT_VELOCITY_TO_BREAK_DRIPSTONE = 0.6D;
    private static final float STALACTITE_DAMAGE_PER_FALL_DISTANCE_AND_SIZE = 1.0F;
    private static final int STALACTITE_MAX_DAMAGE = 40;
    private static final int MAX_STALACTITE_HEIGHT_FOR_DAMAGE_CALCULATION = 6;
    private static final float STALAGMITE_FALL_DISTANCE_OFFSET = 2.0F;
    private static final int STALAGMITE_FALL_DAMAGE_MODIFIER = 2;
    private static final float AVERAGE_DAYS_PER_GROWTH = 5.0F;
    private static final float GROWTH_PROBABILITY_PER_RANDOM_TICK = 0.011377778F;
    private static final int MAX_GROWTH_LENGTH = 7;
    private static final int MAX_STALAGMITE_SEARCH_RANGE_WHEN_GROWING = 10;
    private static final float STALACTITE_DRIP_START_PIXEL = 0.6875F;
    private static final VoxelShape TIP_MERGE_SHAPE = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_UP = Block.box(5.0D, 0.0D, 5.0D, 11.0D, 11.0D, 11.0D);
    private static final VoxelShape TIP_SHAPE_DOWN = Block.box(5.0D, 5.0D, 5.0D, 11.0D, 16.0D, 11.0D);
    private static final VoxelShape FRUSTUM_SHAPE = Block.box(4.0D, 0.0D, 4.0D, 12.0D, 16.0D, 12.0D);
    private static final VoxelShape MIDDLE_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape BASE_SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 16.0D, 14.0D);
    private static final float MAX_HORIZONTAL_OFFSET = 0.125F;
    private static final VoxelShape REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK = Block.box(6.0D, 0.0D, 6.0D, 10.0D, 16.0D, 10.0D);

    public IcicleBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(TIP_DIRECTION, Direction.UP)
                .setValue(THICKNESS, DripstoneThickness.TIP).setValue(WATERLOGGED, Boolean.FALSE));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> pBuilder) {
        pBuilder.add(TIP_DIRECTION, THICKNESS, WATERLOGGED);
    }

    public boolean canSurvive(BlockState pState, LevelReader pLevel, BlockPos pPos) {
        return isValidIciclePlacement(pLevel, pPos, pState.getValue(TIP_DIRECTION));
    }

    public BlockState updateShape(BlockState pState, Direction pDirection, BlockState pNeighborState, LevelAccessor pLevel, BlockPos pCurrentPos, BlockPos pNeighborPos) {
        if (pState.getValue(WATERLOGGED)) {
            pLevel.scheduleTick(pCurrentPos, Fluids.WATER, Fluids.WATER.getTickDelay(pLevel));
        }

        if (pDirection != Direction.UP && pDirection != Direction.DOWN) {
            return pState;
        } else {
            Direction direction = pState.getValue(TIP_DIRECTION);
            if (direction == Direction.DOWN && pLevel.getBlockTicks().hasScheduledTick(pCurrentPos, this)) {
                return pState;
            } else if (pDirection == direction.getOpposite() && !this.canSurvive(pState, pLevel, pCurrentPos)) {
                if (direction == Direction.DOWN) {
                    pLevel.scheduleTick(pCurrentPos, this, 2);
                } else {
                    pLevel.scheduleTick(pCurrentPos, this, 1);
                }

                return pState;
            } else {
                boolean flag = pState.getValue(THICKNESS) == DripstoneThickness.TIP_MERGE;
                DripstoneThickness dripstonethickness = calculateDripstoneThickness(pLevel, pCurrentPos, direction, flag);
                return pState.setValue(THICKNESS, dripstonethickness);
            }
        }
    }

    public void onProjectileHit(Level pLevel, BlockState pState, BlockHitResult pHit, Projectile pProjectile) {
        BlockPos blockpos = pHit.getBlockPos();
        if (!pLevel.isClientSide && pProjectile.mayInteract(pLevel, blockpos) && pProjectile instanceof ThrownTrident && pProjectile.getDeltaMovement().length() > 0.6D) {
            pLevel.destroyBlock(blockpos, true);
        }

    }

    public void fallOn(Level customLevel, BlockState blockState, BlockPos pos, Entity entity, float f) {
        if (blockState.getValue(TIP_DIRECTION) == Direction.UP && blockState.getValue(THICKNESS) == DripstoneThickness.TIP) {
            entity.causeFallDamage(f + 2.0F, 2.0F, customLevel.damageSources().stalagmite());
        } else {
            //super.fallOn(level, blockState, pos, entity, p_154051_);
            entity.causeFallDamage(f, 1.0F, customLevel.damageSources().fall());
        }
    }

    public void animateTick(BlockState pState, Level pLevel, BlockPos pPos, RandomSource pRandom) {
        if (canDrip(pState)) {
            float f = pRandom.nextFloat();
            if (!(f > 0.12F)) {
                getFluidAboveStalactite(pLevel, pPos, pState).filter((p_221848_) -> f < 0.02F || canFillCauldron(p_221848_.fluid)).ifPresent((p_221881_) -> {
                    spawnDripParticle(pLevel, pPos, pState, p_221881_.fluid);
                });
            }
        }
    }

    public void tick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (isStalagmite(pState) && !this.canSurvive(pState, pLevel, pPos)) {
            pLevel.destroyBlock(pPos, true);
        } else {
            spawnFallingStalactite(pState, pLevel, pPos);
        }

    }

    public void randomTick(BlockState pState, ServerLevel pLevel, BlockPos pPos, RandomSource pRandom) {
        if (pLevel.getBrightness(LightLayer.BLOCK, pPos) > 11 - pState.getLightBlock(pLevel, pPos)) {
            this.melt(pLevel, pPos);
        }
        if (pRandom.nextFloat() < 0.011377778F && isStalactiteStartPos(pState, pLevel, pPos)) {
            growStalactiteOrStalagmiteIfPossible(pState, pLevel, pPos, pRandom);
        }
//        maybeTransferFluid(state, level, pos, source.nextFloat());
//        if (source.nextFloat() < 0.011377778F && isStalactiteStartPos(state, level, pos)) {
//            growStalactiteOrStalagmiteIfPossible(state, level, pos, source);
//        }
    }
    @VisibleForTesting
//    public static void maybeTransferFluid(BlockState state, ServerLevel level, BlockPos pos, float randomSource) {
//        if (!(randomSource > 0.17578125F) || !(randomSource > 0.05859375F)) {
//            if (isStalactiteStartPos(state, level, pos)) {
//                Optional<IcicleBlock.FluidInfo> optional = getFluidAboveStalactite(level, pos, state);
//                if (!optional.isEmpty()) {
//                    Fluid fluid = (optional.get()).fluid;
//                    float f;
//                    if (fluid == Fluids.WATER) {
//                        f = 0.17578125F;
//                    } else {
//                        if (fluid != Fluids.LAVA) {
//                            return;
//                        }
//
//                        f = 0.05859375F;
//                    }
//
//                    if (!(randomSource >= f)) {
//                        BlockPos blockpos = findTip(state, level, pos, 11, false);
//                        if (blockpos != null) {
//                            if ((optional.get()).sourceState.is(Blocks.MUD) && fluid == Fluids.WATER) {
//                                BlockState blockstate1 = Blocks.CLAY.defaultBlockState();
//                                level.setBlockAndUpdate((optional.get()).pos, blockstate1);
//                                Block.pushEntitiesUp((optional.get()).sourceState, blockstate1, level, (optional.get()).pos);
//                                level.gameEvent(GameEvent.BLOCK_CHANGE, (optional.get()).pos, GameEvent.Context.of(blockstate1));
//                                level.levelEvent(1504, blockpos, 0);
//                            } else {
//                                BlockPos blockpos1 = findFillableCauldronBelowStalactiteTip(level, blockpos, fluid);
//                                if (blockpos1 != null) {
//                                    level.levelEvent(1504, blockpos, 0);
//                                    int i = blockpos.getY() - blockpos1.getY();
//                                    int j = 50 + i;
//                                    BlockState blockstate = level.getBlockState(blockpos1);
//                                    level.scheduleTick(blockpos1, blockstate.getBlock(), j);
//                                }
//                            }
//                        }
//                    }
//                }
//            }
//        }
//    }

    public PushReaction getPistonPushReaction(BlockState blockState) {
        return PushReaction.DESTROY;
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext pContext) {
        LevelAccessor levelaccessor = pContext.getLevel();
        BlockPos blockpos = pContext.getClickedPos();
        Direction direction = pContext.getNearestLookingVerticalDirection().getOpposite();
        Direction direction1 = calculateTipDirection(levelaccessor, blockpos, direction);
        if (direction1 == null) {
            return null;
        } else {
            boolean flag = !pContext.isSecondaryUseActive();
            DripstoneThickness dripstonethickness = calculateDripstoneThickness(levelaccessor, blockpos, direction1, flag);
            return dripstonethickness == null ? null : this.defaultBlockState().setValue(TIP_DIRECTION, direction1).setValue(THICKNESS, dripstonethickness).setValue(WATERLOGGED, Boolean.valueOf(levelaccessor.getFluidState(blockpos).getType() == Fluids.WATER));
        }
    }

    public FluidState getFluidState(BlockState pState) {
        return pState.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(pState);
    }

    public VoxelShape getOcclusionShape(BlockState pState, BlockGetter pLevel, BlockPos pos) {
        return Shapes.empty();
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        DripstoneThickness dripstonethickness = pState.getValue(THICKNESS);
        VoxelShape voxelshape;
        if (dripstonethickness == DripstoneThickness.TIP_MERGE) {
            voxelshape = TIP_MERGE_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.TIP) {
            if (pState.getValue(TIP_DIRECTION) == Direction.DOWN) {
                voxelshape = TIP_SHAPE_DOWN;
            } else {
                voxelshape = TIP_SHAPE_UP;
            }
        } else if (dripstonethickness == DripstoneThickness.FRUSTUM) {
            voxelshape = FRUSTUM_SHAPE;
        } else if (dripstonethickness == DripstoneThickness.MIDDLE) {
            voxelshape = MIDDLE_SHAPE;
        } else {
            voxelshape = BASE_SHAPE;
        }

        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        return voxelshape.move(vec3.x, 0.0D, vec3.z);
    }

    public boolean isCollisionShapeFullBlock(BlockState pState, BlockGetter pLevel, BlockPos pPos) {
        return false;
    }

    public float getMaxHorizontalOffset() {
        return 0.125F;
    }

    public void onBrokenAfterFall(Level pLevel, BlockPos pPos, FallingBlockEntity pFallingBlock) {
        if (!pFallingBlock.isSilent()) {
            pLevel.levelEvent(1045, pPos, 0);
        }
    }

    public DamageSource getFallDamageSource(Entity entity) {
        return entity.damageSources().fallingStalactite(entity);
    }

    public Predicate<Entity> getHurtsEntitySelector() {
        return EntitySelector.NO_CREATIVE_OR_SPECTATOR.and(EntitySelector.LIVING_ENTITY_STILL_ALIVE);
    }

    private static void spawnFallingStalactite(BlockState blockState, ServerLevel serverLevel, BlockPos pos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(BlockState blockstate = blockState; isStalactite(blockstate); blockstate = serverLevel.getBlockState(blockpos$mutableblockpos)) {
            FallingBlockEntity fallingblockentity = FallingBlockEntity.fall(serverLevel, blockpos$mutableblockpos, blockstate);
            if (isTip(blockstate, true)) {
                int i = Math.max(1 + pos.getY() - blockpos$mutableblockpos.getY(), 6);
                float f = (float) i;
                fallingblockentity.setHurtsEntities(f, 40);
                break;
            }

            blockpos$mutableblockpos.move(Direction.DOWN);
        }

    }

    @VisibleForTesting
    public static void growStalactiteOrStalagmiteIfPossible(BlockState blockState, ServerLevel level, BlockPos pos, RandomSource randomSource) {
        BlockState blockstate = level.getBlockState(pos.above(1));
        BlockState blockstate1 = level.getBlockState(pos.above(2));
        if (canGrow(blockstate, blockstate1, level, pos)) {
            BlockPos blockpos = findTip(blockState, level, pos, 7, false);
            if (blockpos != null) {
                BlockState blockstate2 = level.getBlockState(blockpos);
                if (canDrip(blockstate2) && canTipGrow(blockstate2, level, blockpos)) {
                    if (randomSource.nextBoolean()) {
                        grow(level, blockpos, Direction.DOWN);
                    } else {
                        growStalagmiteBelow(level, blockpos);
                    }

                }
            }
        }
    }

    private static void growStalagmiteBelow(ServerLevel serverLevel, BlockPos pos) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(int i = 0; i < 10; ++i) {
            blockpos$mutableblockpos.move(Direction.DOWN);
            BlockState blockstate = serverLevel.getBlockState(blockpos$mutableblockpos);
            if (!blockstate.getFluidState().isEmpty()) {
                return;
            }

            if (isUnmergedTipWithDirection(blockstate, Direction.UP) && canTipGrow(blockstate, serverLevel, blockpos$mutableblockpos)) {
                grow(serverLevel, blockpos$mutableblockpos, Direction.UP);
                return;
            }

            if (isValidIciclePlacement(serverLevel, blockpos$mutableblockpos, Direction.UP) && !serverLevel.isWaterAt(blockpos$mutableblockpos.below())) {
                grow(serverLevel, blockpos$mutableblockpos.below(), Direction.UP);
                return;
            }

            if (!canDripThrough(serverLevel, blockpos$mutableblockpos, blockstate)) {
                return;
            }
        }

    }

    private static void grow(ServerLevel serverLevel, BlockPos pos, Direction direction) {
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = serverLevel.getBlockState(blockpos);
        if (isUnmergedTipWithDirection(blockstate, direction.getOpposite())) {
            createMergedTips(blockstate, serverLevel, blockpos);
        } else if (blockstate.isAir() || blockstate.is(Blocks.WATER)) {
            createIcicle(serverLevel, blockpos, direction, DripstoneThickness.TIP);
        }

    }

    private static void createIcicle(LevelAccessor levelAccessor, BlockPos pos, Direction direction, DripstoneThickness dripstoneThickness) {
        BlockState blockstate = ModBlocks.ICICLE.get().defaultBlockState().setValue(TIP_DIRECTION, direction).setValue(THICKNESS,
                dripstoneThickness).setValue(WATERLOGGED, levelAccessor.getFluidState(pos).getType() == Fluids.WATER);
        levelAccessor.setBlock(pos, blockstate, 3);
    }

    private static void createMergedTips(BlockState blockState, LevelAccessor levelAccessor, BlockPos pos) {
        BlockPos blockpos;
        BlockPos blockpos1;
        if (blockState.getValue(TIP_DIRECTION) == Direction.UP) {
            blockpos1 = pos;
            blockpos = pos.above();
        } else {
            blockpos = pos;
            blockpos1 = pos.below();
        }

        createIcicle(levelAccessor, blockpos, Direction.DOWN, DripstoneThickness.TIP_MERGE);
        createIcicle(levelAccessor, blockpos1, Direction.UP, DripstoneThickness.TIP_MERGE);
    }

    public static void spawnDripParticle(Level level, BlockPos pos, BlockState blockState) {
        getFluidAboveStalactite(level, pos, blockState).ifPresent((p_221856_) -> {
            spawnDripParticle(level, pos, blockState, p_221856_.fluid);
        });
    }

    private static void spawnDripParticle(Level level, BlockPos pos, BlockState blockState, Fluid fluid1) {
        Vec3 vec3 = blockState.getOffset(level, pos);
        double d0 = 0.0625D;
        double d1 = (double)pos.getX() + 0.5D + vec3.x;
        double d2 = (double)((float)(pos.getY() + 1) - 0.6875F) - 0.0625D;
        double d3 = (double)pos.getZ() + 0.5D + vec3.z;
        Fluid fluid = getDripFluid(level, fluid1);
        ParticleOptions particleoptions = fluid.is(FluidTags.LAVA) ? ParticleTypes.DRIPPING_DRIPSTONE_LAVA : ParticleTypes.DRIPPING_DRIPSTONE_WATER;
        level.addParticle(particleoptions, d1, d2, d3, 0.0D, 0.0D, 0.0D);
    }

    @Nullable
    private static BlockPos findTip(BlockState blockState, LevelAccessor levelAccessor, BlockPos pos, int i, boolean b) {
        if (isTip(blockState, b)) {
            return pos;
        } else {
            Direction direction = blockState.getValue(TIP_DIRECTION);
            BiPredicate<BlockPos, BlockState> bipredicate = (pos1, blockState1) -> blockState1.is(ModBlocks.ICICLE.get()) && blockState1.getValue(TIP_DIRECTION) == direction;
            return findBlockVertical(levelAccessor, pos, direction.getAxisDirection(), bipredicate, (p_154168_) -> isTip(p_154168_, b), i).orElse(null);
        }
    }

    @Nullable
    private static Direction calculateTipDirection(LevelReader levelReader, BlockPos pos, Direction direction1) {
        Direction direction;
        if (isValidIciclePlacement(levelReader, pos, direction1)) {
            direction = direction1;
        } else {
            if (!isValidIciclePlacement(levelReader, pos, direction1.getOpposite())) {
                return null;
            }

            direction = direction1.getOpposite();
        }

        return direction;
    }

    private static DripstoneThickness calculateDripstoneThickness(LevelReader levelReader, BlockPos pos, Direction direction1, boolean b) {
        Direction direction = direction1.getOpposite();
        BlockState blockstate = levelReader.getBlockState(pos.relative(direction1));
        if (isIcicleWithDirection(blockstate, direction)) {
            return !b && blockstate.getValue(THICKNESS) != DripstoneThickness.TIP_MERGE ? DripstoneThickness.TIP : DripstoneThickness.TIP_MERGE;
        } else if (!isIcicleWithDirection(blockstate, direction1)) {
            return DripstoneThickness.TIP;
        } else {
            DripstoneThickness dripstonethickness = blockstate.getValue(THICKNESS);
            if (dripstonethickness != DripstoneThickness.TIP && dripstonethickness != DripstoneThickness.TIP_MERGE) {
                BlockState blockstate1 = levelReader.getBlockState(pos.relative(direction));
                return !isIcicleWithDirection(blockstate1, direction1) ? DripstoneThickness.BASE : DripstoneThickness.MIDDLE;
            } else {
                return DripstoneThickness.FRUSTUM;
            }
        }
    }

    public static boolean canDrip(BlockState blockState) {
        return blockState.getValue(THICKNESS) == DripstoneThickness.TIP && !blockState.getValue(WATERLOGGED);
    }

    private static boolean canTipGrow(BlockState blockState, ServerLevel serverLevel, BlockPos pos) {
        Direction direction = blockState.getValue(TIP_DIRECTION);
        BlockPos blockpos = pos.relative(direction);
        BlockState blockstate = serverLevel.getBlockState(blockpos);
        if (!blockstate.getFluidState().isEmpty()) {
            return false;
        } else {
            return blockstate.isAir() || isUnmergedTipWithDirection(blockstate, direction.getOpposite());
        }
    }

    private static Optional<BlockPos> findRootBlock(Level level, BlockPos pos, BlockState blockState, int i) {
        Direction direction = blockState.getValue(TIP_DIRECTION);
        BiPredicate<BlockPos, BlockState> bipredicate = (p_202015_, p_202016_) -> {
            return p_202016_.is(ModBlocks.ICICLE.get()) && p_202016_.getValue(TIP_DIRECTION) == direction;
        };
        return findBlockVertical(level, pos, direction.getOpposite().getAxisDirection(), bipredicate, (p_154245_) -> {
            return !p_154245_.is(ModBlocks.ICICLE.get());
        }, i);
    }

    private static boolean isValidIciclePlacement(LevelReader levelReader, BlockPos pos, Direction direction) {
        BlockPos blockpos = pos.relative(direction.getOpposite());
        BlockState blockstate = levelReader.getBlockState(blockpos);
        return blockstate.isFaceSturdy(levelReader, blockpos, direction) || isIcicleWithDirection(blockstate, direction);
    }

    private static boolean isTip(BlockState blockState, boolean b) {
        if (!blockState.is(ModBlocks.ICICLE.get())) {
            return false;
        } else {
            DripstoneThickness dripstonethickness = blockState.getValue(THICKNESS);
            return dripstonethickness == DripstoneThickness.TIP || b && dripstonethickness == DripstoneThickness.TIP_MERGE;
        }
    }

    private static boolean isUnmergedTipWithDirection(BlockState blockState, Direction direction) {
        return isTip(blockState, false) && blockState.getValue(TIP_DIRECTION) == direction;
    }

    private static boolean isStalactite(BlockState blockState) {
        return isIcicleWithDirection(blockState, Direction.DOWN);
    }

    private static boolean isStalagmite(BlockState blockState) {
        return isIcicleWithDirection(blockState, Direction.UP);
    }

    private static boolean isStalactiteStartPos(BlockState blockState, LevelReader levelReader, BlockPos pos) {
        return isStalactite(blockState) && !levelReader.getBlockState(pos.above()).is(ModBlocks.ICICLE.get());
    }

    public boolean isPathfindable(BlockState pState, BlockGetter pLevel, BlockPos pPos, PathComputationType pType) {
        return false;
    }

    private static boolean isIcicleWithDirection(BlockState blockState, Direction direction) {
        return blockState.is(ModBlocks.ICICLE.get()) && blockState.getValue(TIP_DIRECTION) == direction;
    }


//    @Nullable
//    private static BlockPos findFillableCauldronBelowStalactiteTip(Level p_154077_, BlockPos p_154078_, Fluid p_154079_) {
//        Predicate<BlockState> predicate = (p_154162_) -> {
//            return p_154162_.getBlock() instanceof AbstractCauldronBlock && true;//((AbstractCauldronBlock)p_154162_.getBlock()).canReceiveStalactiteDrip();
//        };
//        BiPredicate<BlockPos, BlockState> bipredicate = (p_202034_, p_202035_) -> {
//            return canDripThrough(p_154077_, p_202034_, p_202035_);
//        };
//        return findBlockVertical(p_154077_, p_154078_, Direction.DOWN.getAxisDirection(), bipredicate, predicate, 11).orElse((BlockPos)null);
//    }

    @Nullable
    public static BlockPos findStalactiteTipAboveCauldron(Level level, BlockPos pos) {
        BiPredicate<BlockPos, BlockState> bipredicate = (p_202030_, p_202031_) -> canDripThrough(level, p_202030_, p_202031_);
        return findBlockVertical(level, pos, Direction.UP.getAxisDirection(), bipredicate, IcicleBlock::canDrip, 11).orElse(null);
    }

    public static Fluid getCauldronFillFluidType(ServerLevel serverLevel, BlockPos pos) {
        return getFluidAboveStalactite(serverLevel, pos, serverLevel.getBlockState(pos)).map((p_221858_) -> p_221858_.fluid)
                .filter(IcicleBlock::canFillCauldron).orElse(Fluids.EMPTY);
    }

    private static Optional<IcicleBlock.FluidInfo> getFluidAboveStalactite(Level level, BlockPos pos, BlockState blockState) {
        return !isStalactite(blockState) ? Optional.empty() : findRootBlock(level, pos, blockState, 11).map((p_221876_) -> {
            BlockPos blockpos = p_221876_.above();
            BlockState blockstate = level.getBlockState(blockpos);
            Fluid fluid;
            if (blockstate.is(Blocks.MUD) && !level.dimensionType().ultraWarm()) {
                fluid = Fluids.WATER;
            } else {
                fluid = level.getFluidState(blockpos).getType();
            }

            return new IcicleBlock.FluidInfo(blockpos, fluid, blockstate);
        });
    }

    private static boolean canFillCauldron(Fluid fluid) {
        return fluid == Fluids.WATER;
    }

    private static boolean canGrow(BlockState state1, BlockState state2, Level level, BlockPos pos) {
        return state1.is(ModBlocks.ICICLE.get()) && state2.is(Blocks.WATER) && state2.getFluidState().isSource()
                && !level.dimensionType().ultraWarm() && level.getBrightness(LightLayer.BLOCK, pos) > 11 - state2.getLightBlock(level, pos);
    }

    private static Fluid getDripFluid(Level level, Fluid fluid) {
        if (fluid.isSame(Fluids.EMPTY)) {
            return level.dimensionType().ultraWarm() ? Fluids.LAVA : Fluids.WATER;
        } else {
            return fluid;
        }
    }

    private static Optional<BlockPos> findBlockVertical(LevelAccessor levelAccessor, BlockPos pos, Direction.AxisDirection axisDirection, BiPredicate<BlockPos, BlockState> blockPosBlockStateBiPredicate, Predicate<BlockState> blockStatePredicate, int i1) {
        Direction direction = Direction.get(axisDirection, Direction.Axis.Y);
        BlockPos.MutableBlockPos blockpos$mutableblockpos = pos.mutable();

        for(int i = 1; i < i1; ++i) {
            blockpos$mutableblockpos.move(direction);
            BlockState blockstate = levelAccessor.getBlockState(blockpos$mutableblockpos);
            if (blockStatePredicate.test(blockstate)) {
                return Optional.of(blockpos$mutableblockpos.immutable());
            }

            if (levelAccessor.isOutsideBuildHeight(blockpos$mutableblockpos.getY()) || !blockPosBlockStateBiPredicate.test(blockpos$mutableblockpos, blockstate)) {
                return Optional.empty();
            }
        }

        return Optional.empty();
    }

    private static boolean canDripThrough(BlockGetter blockGetter, BlockPos pos, BlockState blockState) {
        if (blockState.isAir()) {
            return true;
        } else if (blockState.isSolidRender(blockGetter, pos)) {
            return false;
        } else if (!blockState.getFluidState().isEmpty()) {
            return false;
        } else {
            VoxelShape voxelshape = blockState.getCollisionShape(blockGetter, pos);
            return !Shapes.joinIsNotEmpty(REQUIRED_SPACE_TO_DRIP_THROUGH_NON_SOLID_BLOCK, voxelshape, BooleanOp.AND);
        }
    }

    record FluidInfo(BlockPos pos, Fluid fluid, BlockState sourceState) {
    }

    protected void melt(Level level, BlockPos pos) {
        level.removeBlock(pos, false);
    }
}


