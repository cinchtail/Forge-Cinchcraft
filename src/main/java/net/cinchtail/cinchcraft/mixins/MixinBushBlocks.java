package net.cinchtail.cinchcraft.mixins;

import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.block.custom.BlueBerryBushBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.entity.animal.Bee;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SweetBerryBushBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(Bee.BeeGrowCropGoal.class)
public class MixinBushBlocks {
    @Inject(method = "tick", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/level/block/state/BlockState;is(Lnet/minecraft/tags/TagKey;)Z"), locals = LocalCapture.CAPTURE_FAILHARD)
    private void cinchcraft$makeBushesModifiable(CallbackInfo ci, int i, BlockPos blockpos, BlockState blockState, Block block, BlockState state) {
        int j;
        if (blockState.is(BlockTags.BEE_GROWABLES)) {
            if (blockState.is(ModBlocks.BLUEBERRY_BUSH.get())) {
                j = blockState.getValue(BlueBerryBushBlock.AGE);
                if (j < 3) {
                    blockState = (BlockState)blockState.setValue(SweetBerryBushBlock.AGE, j + 1);
                }
            }
        }
    }
}
