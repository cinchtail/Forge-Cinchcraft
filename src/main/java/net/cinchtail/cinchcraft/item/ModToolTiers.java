package net.cinchtail.cinchcraft.item;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ForgeTier;

public class ModToolTiers {
    public static final Tier BLACKSTONE = new ForgeTier(131, 4.0f, 1.0f, 5,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Blocks.BLACKSTONE), BlockTags.NEEDS_STONE_TOOL);
    public static final Tier DEEPSLATE = new ForgeTier(231, 4.0f, 1.0f, 5,
            BlockTags.NEEDS_STONE_TOOL, () -> Ingredient.of(Blocks.COBBLED_DEEPSLATE), BlockTags.NEEDS_STONE_TOOL);
    public static final Tier RUBY = new ForgeTier(850, 7F, 2.5F, 15,
            BlockTags.NEEDS_IRON_TOOL, () -> Ingredient.of(ModItems.RUBY.get()), BlockTags.NEEDS_IRON_TOOL);

}