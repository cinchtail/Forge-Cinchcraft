package net.cinchtail.cinchcraft.entity.layers;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.ResourceLocation;

public class ModModelLayers {

    public static final ModelLayerLocation AZALEA_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "boat/azalea"), "main");
    public static final ModelLayerLocation AZALEA_CHEST_BOAT_LAYER = new ModelLayerLocation(
            ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "chest_boat/azalea"), "main");

}
