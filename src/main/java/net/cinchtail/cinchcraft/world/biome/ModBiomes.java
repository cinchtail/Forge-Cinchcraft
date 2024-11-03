package net.cinchtail.cinchcraft.world.biome;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes
{
    public static final ResourceKey<Biome> BIRCH_GROVE = register("birch_grove");
    public static final ResourceKey<Biome> ROCKY_MEADOW = register("rocky_meadow");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, name));
    }
}
