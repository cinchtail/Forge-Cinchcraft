package net.cinchtail.cinchcraft.block.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffect;
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

public class AlyssumFlowerBlock extends BushBlock implements SuspiciousEffectHolder {
    protected static final VoxelShape SHAPE = Block.box(2.0D, 0.0D, 2.0D, 14.0D, 3.0D, 14.0D);

    private final List<EffectEntry> f_290810_;

    public AlyssumFlowerBlock(MobEffect pSuspiciousStewEffect, int pEffectDuration, BlockBehaviour.Properties pProperties) {
        super(pProperties);
        int i;
        if (pSuspiciousStewEffect.isInstantenous()) {
            i = pEffectDuration;
        } else {
            i = pEffectDuration * 20;
        }

        this.f_290810_ = List.of(new SuspiciousEffectHolder.EffectEntry(pSuspiciousStewEffect, i));
    }

    public VoxelShape getShape(BlockState pState, BlockGetter pLevel, BlockPos pPos, CollisionContext pContext) {
        Vec3 vec3 = pState.getOffset(pLevel, pPos);
        return SHAPE.move(vec3.x, vec3.y, vec3.z);
    }

    public List<SuspiciousEffectHolder.EffectEntry> m_294088_() {
        return this.f_290810_;
    }
}