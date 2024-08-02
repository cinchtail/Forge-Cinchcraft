package net.cinchtail.cinchcraft.mixins;

import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = WalkNodeEvaluator.class, priority = 1002)
public class MixinWalkNodeEvaluator {
    @Inject(method = "getPathTypeFromState", at = @At("RETURN"), cancellable = true)
    private static void getPathTypeFromState(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<PathType> cir) {
        if (cir.getReturnValue() == PathType.OPEN) {
            BlockState blockState = blockGetter.getBlockState(blockPos);
            if (blockState.is(ModBlocks.STAR_CACTUS.get())) {
                cir.setReturnValue(PathType.DAMAGE_OTHER);
            } else if (blockState.is(ModBlocks.ICICLE.get())) {
                cir.setReturnValue(PathType.DAMAGE_CAUTIOUS);
            } else if (blockState.is(ModBlocks.FIRE_FERN.get())) {
                    cir.setReturnValue(PathType.DAMAGE_FIRE);
            }
        }
    }
}
