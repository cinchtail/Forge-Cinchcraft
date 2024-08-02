package net.cinchtail.cinchcraft.util;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public class ModBlockTags {

    public static final TagKey<Block> REEDS_PLACEABLE = create("reeds_placeable");
    public static final TagKey<Block> FIRE_FERN_PLACEABLE = create("fire_fern_placeable");
    public static final TagKey<Block> SUNFLOWER_CROP_PLACEABLE = create("sunflower_crop_placeable");
    public static final TagKey<Block> CATTAILS_PLACEABLE = create("cattails_placeable");

    private static TagKey<Block> create(String s) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.withDefaultNamespace(s));
    }
}
