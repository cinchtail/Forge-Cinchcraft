package net.cinchtail.cinchcraft.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.SuspiciousEffectHolder;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.List;

public class CrocusFlowerBlock extends BushBlock implements SuspiciousEffectHolder {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 13.0D, 14.0D);
    private final List<EffectEntry> f_290810_;

    public CrocusFlowerBlock(BlockBehaviour.Properties pProperties) {
        super(pProperties);
        int i;
        if (MobEffects.INVISIBILITY.isInstantenous()) {
            i = 5;
        } else {
            i = 5 * 20;
        }

        this.f_290810_ = List.of(new SuspiciousEffectHolder.EffectEntry(MobEffects.INVISIBILITY, i));
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    @Override
    public List<EffectEntry> getSuspiciousEffects() {
        return this.f_290810_;
    }

    @Override
    protected MapCodec<? extends BushBlock> codec() {
        return simpleCodec(CrocusFlowerBlock::new);
    }
}