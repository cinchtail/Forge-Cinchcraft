package net.cinchtail.cinchcraft.block.custom;


import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.component.SuspiciousStewEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class AlyssumFlowerBlock extends BushBlock implements SuspiciousEffectHolder {
    protected static final MapCodec<SuspiciousStewEffects> EFFECTS_FIELD;
    public static final MapCodec<FlowerBlock> CODEC;
    protected static final float AABB_OFFSET = 3.0F;
    protected static final VoxelShape SHAPE;
    private final SuspiciousStewEffects suspiciousStewEffects;

    public MapCodec<? extends FlowerBlock> codec() {
        return CODEC;
    }

    public AlyssumFlowerBlock(Holder<MobEffect> mobEffectHolder, float v, BlockBehaviour.Properties properties) {
        this(makeEffectList(mobEffectHolder, v), properties);
    }

    public AlyssumFlowerBlock(SuspiciousStewEffects suspiciousStewEffects, BlockBehaviour.Properties properties) {
        super(properties);
        this.suspiciousStewEffects = suspiciousStewEffects;
    }

    protected static SuspiciousStewEffects makeEffectList(Holder<MobEffect> mobEffectHolder, float v) {
        return new SuspiciousStewEffects(List.of(new SuspiciousStewEffects.Entry(mobEffectHolder, Mth.floor(v * 20.0F))));
    }

    protected VoxelShape getShape(BlockState blockState, BlockGetter blockGetter, BlockPos blockPos, CollisionContext collisionContext) {
        Vec3 $$4 = blockState.getOffset(blockGetter, blockPos);
        return SHAPE.move($$4.x, $$4.y, $$4.z);
    }

    public SuspiciousStewEffects getSuspiciousEffects() {
        return this.suspiciousStewEffects;
    }

    static {
        EFFECTS_FIELD = SuspiciousStewEffects.CODEC.fieldOf("suspicious_stew_effects");
        CODEC = RecordCodecBuilder.mapCodec((flowerBlockInstance) -> {
            return flowerBlockInstance.group(EFFECTS_FIELD.forGetter(FlowerBlock::getSuspiciousEffects), propertiesCodec()).apply(flowerBlockInstance, FlowerBlock::new);
        });
        SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);
    }
}