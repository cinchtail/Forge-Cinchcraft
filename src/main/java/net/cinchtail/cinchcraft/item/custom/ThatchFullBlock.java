package net.cinchtail.cinchcraft.item.custom;

import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

public class ThatchFullBlock extends ItemNameBlockItem {
    public ThatchFullBlock(Block block, Properties properties) {
        super(block, properties);
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 4000;
    }
}
