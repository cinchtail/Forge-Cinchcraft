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

    private static TagKey<Block> create(String s) {
        return TagKey.create(Registries.BLOCK, new ResourceLocation(s));
    }
}
