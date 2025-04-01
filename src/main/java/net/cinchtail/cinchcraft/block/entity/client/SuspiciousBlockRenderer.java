package net.cinchtail.cinchcraft.block.entity.client;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.cinchtail.cinchcraft.block.entity.SuspiciousBlockEntity;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SuspiciousBlockRenderer implements BlockEntityRenderer<SuspiciousBlockEntity> {
    private final ItemRenderer itemRenderer;

    public SuspiciousBlockRenderer(BlockEntityRendererProvider.Context context) {
        this.itemRenderer = context.getItemRenderer();
    }

    public void render(SuspiciousBlockEntity suspiciousBlockEntity, float v, PoseStack poseStack, MultiBufferSource multiBufferSource, int i, int i1) {
        if (suspiciousBlockEntity.getLevel() != null) {
            int $$6 = (Integer)suspiciousBlockEntity.getBlockState().getValue(BlockStateProperties.DUSTED);
            if ($$6 > 0) {
                Direction $$7 = suspiciousBlockEntity.getHitDirection();
                if ($$7 != null) {
                    ItemStack $$8 = suspiciousBlockEntity.getItem();
                    if (!$$8.isEmpty()) {
                        poseStack.pushPose();
                        poseStack.translate(0.0F, 0.5F, 0.0F);
                        float[] $$9 = this.translations($$7, $$6);
                        poseStack.translate($$9[0], $$9[1], $$9[2]);
                        poseStack.mulPose(Axis.YP.rotationDegrees(75.0F));
                        boolean $$10 = $$7 == Direction.EAST || $$7 == Direction.WEST;
                        poseStack.mulPose(Axis.YP.rotationDegrees((float)(($$10 ? 90 : 0) + 11)));
                        poseStack.scale(0.5F, 0.5F, 0.5F);
                        int $$11 = LevelRenderer.getLightColor(suspiciousBlockEntity.getLevel(), suspiciousBlockEntity.getBlockState(), suspiciousBlockEntity.getBlockPos().relative($$7));
                        this.itemRenderer.renderStatic($$8, ItemDisplayContext.FIXED, $$11, OverlayTexture.NO_OVERLAY, poseStack, multiBufferSource, suspiciousBlockEntity.getLevel(), 0);
                        poseStack.popPose();
                    }
                }
            }
        }
    }

    private float[] translations(Direction direction, int i) {
        float[] $$2 = new float[]{0.5F, 0.0F, 0.5F};
        float $$3 = (float)i / 10.0F * 0.75F;
        switch (direction) {
            case EAST -> $$2[0] = 0.73F + $$3;
            case WEST -> $$2[0] = 0.25F - $$3;
            case UP -> $$2[1] = 0.25F + $$3;
            case DOWN -> $$2[1] = -0.23F - $$3;
            case NORTH -> $$2[2] = 0.25F - $$3;
            case SOUTH -> $$2[2] = 0.73F + $$3;
        }

        return $$2;
    }
}
