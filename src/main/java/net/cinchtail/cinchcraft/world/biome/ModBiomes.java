package net.cinchtail.cinchcraft.world.biome;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes
{
    public static final ResourceKey<Biome> BIRCH_GROVE = register("birch_grove");

    private static ResourceKey<Biome> register(String name)
    {
        return ResourceKey.create(Registries.BIOME, new ResourceLocation(Cinchcraft.MOD_ID, name));
    }
}
