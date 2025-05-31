package net.cinchtail.cinchcraft.block.custom;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.cinchtail.cinchcraft.block.entity.SuspiciousBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;

import javax.annotation.Nullable;

public class SuspiciousBlock { /* extends BaseEntityBlock implements Fallable {
    public static final MapCodec<BrushableBlock> CODEC = RecordCodecBuilder.mapCodec((brushableBlockInstance) -> brushableBlockInstance.group(BuiltInRegistries.BLOCK.byNameCodec().fieldOf("turns_into").forGetter(BrushableBlock::getTurnsInto),
            BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("brush_sound").forGetter(BrushableBlock::getBrushSound),
            BuiltInRegistries.SOUND_EVENT.byNameCodec().fieldOf("brush_comleted_sound").forGetter(BrushableBlock::getBrushCompletedSound),
            propertiesCodec()).apply(brushableBlockInstance, BrushableBlock::new));
    
    private static final IntegerProperty DUSTED;
    public static final int TICK_DELAY = 2;
    private final Block turnsInto;
    private final SoundEvent brushSound;
    private final SoundEvent brushCompletedSound;

    public MapCodec<BrushableBlock> codec() {
        return CODEC;
    }

    public SuspiciousBlock(Block block, SoundEvent soundEvent, SoundEvent soundEvent1, BlockBehaviour.Properties properties) {
        super(properties);
        this.turnsInto = block;
        this.brushSound = soundEvent;
        this.brushCompletedSound = soundEvent1;
        this.registerDefaultState(this.stateDefinition.any().setValue(DUSTED, 0));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> blockBlockStateBuilder) {
        blockBlockStateBuilder.add(DUSTED);
    }

    public RenderShape getRenderShape(BlockState blockState) {
        return RenderShape.MODEL;
    }

    public void onPlace(BlockState blockState, Level level, BlockPos blockPos, BlockState blockState1, boolean b) {
        level.scheduleTick(blockPos, this, 2);
    }

    public BlockState updateShape(BlockState blockState, Direction direction, BlockState blockState1, LevelAccessor levelAccessor, BlockPos blockPos, BlockPos blockPos1) {
        levelAccessor.scheduleTick(blockPos, this, 2);
        return super.updateShape(blockState, direction, blockState1, levelAccessor, blockPos, blockPos1);
    }

    public void tick(BlockState blockState, ServerLevel serverLevel, BlockPos blockPos, RandomSource randomSource) {
        BlockEntity var6 = serverLevel.getBlockEntity(blockPos);
        if (var6 instanceof SuspiciousBlockEntity $$4) {
            $$4.checkReset();
        }

        if (FallingBlock.isFree(serverLevel.getBlockState(blockPos.below())) && blockPos.getY() >= serverLevel.getMinBuildHeight()) {
            FallingBlockEntity $$5 = FallingBlockEntity.fall(serverLevel, blockPos, blockState);
            $$5.disableDrop();
        }
    }

    public void onBrokenAfterFall(Level level, BlockPos blockPos, FallingBlockEntity fallingBlockEntity) {
        Vec3 $$3 = fallingBlockEntity.getBoundingBox().getCenter();
        level.levelEvent(2001, BlockPos.containing($$3), Block.getId(fallingBlockEntity.getBlockState()));
        level.gameEvent(fallingBlockEntity, GameEvent.BLOCK_DESTROY, $$3);
    }

    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        if (randomSource.nextInt(16) == 0) {
            BlockPos $$4 = blockPos.below();
            if (FallingBlock.isFree(level.getBlockState($$4))) {
                double $$5 = (double)blockPos.getX() + randomSource.nextDouble();
                double $$6 = (double)blockPos.getY() - 0.05;
                double $$7 = (double)blockPos.getZ() + randomSource.nextDouble();
                level.addParticle(new BlockParticleOption(ParticleTypes.FALLING_DUST, blockState), $$5, $$6, $$7, 0.0, 0.0, 0.0);
            }
        }

    }

    @Nullable
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new SuspiciousBlockEntity(blockPos, blockState);
    }

    public Block getTurnsInto() {
        return this.turnsInto;
    }

    public SoundEvent getBrushSound() {
        return this.brushSound;
    }

    public SoundEvent getBrushCompletedSound() {
        return this.brushCompletedSound;
    }

    static {
        DUSTED = BlockStateProperties.DUSTED;
    }*/
}