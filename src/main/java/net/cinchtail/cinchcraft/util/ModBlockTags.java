package net.cinchtail.cinchcraft.util;
import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> REEDS_PLACEABLE = create("reeds_placeable");
    public static final TagKey<Block> FIRE_FERN_PLACEABLE = create("fire_fern_placeable");

    private ModBlockTags() {
    }
    public static final TagKey<Biome> HAS_FIRE_FERN
            = biomeTag("has_fire_fern");
    private static TagKey<Biome> biomeTag(String name) {
        return TagKey.create(Registries.BIOME, new ResourceLocation(Cinchcraft.MOD_ID, name));
    }

    private static TagKey<Block> create(String s) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(s));
    }
}
