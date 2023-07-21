package net.cinchtail.cinchcraft.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.resources.ResourceLocation;


@JeiPlugin
public class JEICinchcraftPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Cinchcraft.MOD_ID, "jei_plugin");
    }
}
