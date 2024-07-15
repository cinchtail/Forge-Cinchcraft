package net.cinchtail.cinchcraft.mixins;

import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.level.pathfinder.WalkNodeEvaluator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = WalkNodeEvaluator.class, priority = 1002)
public class MixinWalkNodeEvaluator {
    @Inject(method = "checkNeighbourBlocks", at = @At("RETURN"), cancellable = true)
    private static void cinchcraft$checkNeighbourBlocks(BlockGetter p_77608_, BlockPos.MutableBlockPos p_77609_, BlockPathTypes p_77610_, CallbackInfoReturnable<BlockPathTypes> cir) {
        int i = p_77609_.getX();
        int j = p_77609_.getY();
        int k = p_77609_.getZ();

        for(int l = -1; l <= 1; ++l) {
            for(int i1 = -1; i1 <= 1; ++i1) {
                for(int j1 = -1; j1 <= 1; ++j1) {
                    if (l != 0 || j1 != 0) {
                        p_77609_.set(i + l, j + i1, k + j1);
                        BlockState blockstate = p_77608_.getBlockState(p_77609_);
                        if (blockstate.is(ModBlocks.STAR_CACTUS.get())) {
                            cir.setReturnValue(BlockPathTypes.DANGER_OTHER);
                        }

                        if (blockstate.is(ModBlocks.ICICLE.get())) {
                            cir.setReturnValue(BlockPathTypes.DAMAGE_CAUTIOUS);
                        }

                        if (blockstate.is(ModBlocks.FIRE_FERN.get())) {
                            cir.setReturnValue(BlockPathTypes.DAMAGE_FIRE);
                        }
                    }
                }
            }
        }
    }

    @Inject(method = "getBlockPathTypeRaw", at = @At("RETURN"), cancellable = true)
    private static void getBlockPathTypeRaw(BlockGetter blockGetter, BlockPos blockPos, CallbackInfoReturnable<BlockPathTypes> cir) {
        BlockState blockState = blockGetter.getBlockState(blockPos);

        if (blockState.is(ModBlocks.STAR_CACTUS.get())) {
            cir.setReturnValue(BlockPathTypes.DAMAGE_OTHER);
        } else if (blockState.is(ModBlocks.ICICLE.get())) {
            cir.setReturnValue(BlockPathTypes.DAMAGE_CAUTIOUS);
        }
        else if (blockState.is(ModBlocks.FIRE_FERN.get())) {
            cir.setReturnValue(BlockPathTypes.DAMAGE_FIRE);
        }
    }
}
