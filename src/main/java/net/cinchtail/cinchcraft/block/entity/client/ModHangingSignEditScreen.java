package net.cinchtail.cinchcraft.block.entity.client;

import net.cinchtail.cinchcraft.block.entity.ModHangingSignBlockEntity;
import net.cinchtail.cinchcraft.block.entity.ModSignBlockEntity;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractSignEditScreen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.joml.Vector3f;

@OnlyIn(Dist.CLIENT)
public class ModHangingSignEditScreen extends AbstractSignEditScreen {
    public static final float MAGIC_BACKGROUND_SCALE = 4.5F;
    private static final Vector3f TEXT_SCALE = new Vector3f(1.0F, 1.0F, 1.0F);
    private static final int TEXTURE_WIDTH = 16;
    private static final int TEXTURE_HEIGHT = 16;
    private final ResourceLocation texture;

    public ModHangingSignEditScreen(ModHangingSignBlockEntity modHangingSignBlockEntity, boolean b, boolean b1) {
        super(modHangingSignBlockEntity, b, b1, Component.translatable("hanging_sign.edit"));
        this.texture = ResourceLocation.parse(this.woodType.name() + ".png").withPrefix("textures/gui/hanging_signs/");
    }
    protected void offsetSign(GuiGraphics guiGraphics, BlockState blockState) {
        guiGraphics.pose().translate((float)this.width / 2.0F, 125.0F, 50.0F);
    }
    protected void renderSignBackground(GuiGraphics guiGraphics, BlockState blockState) {
        guiGraphics.pose().translate(0.0F, -13.0F, 0.0F);
        guiGraphics.pose().scale(4.5F, 4.5F, 1.0F);
        guiGraphics.blit(this.texture, -8, -8, 0.0F, 0.0F, 16, 16, 16, 16);
    }
    protected Vector3f getSignTextScale() {
        return TEXT_SCALE;
    }
}