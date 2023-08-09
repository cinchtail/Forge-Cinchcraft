package net.cinchtail.cinchcraft.item.custom;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SignItem;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class ModSignItem extends SignItem {
    public ModSignItem(Properties properties, Block block, Block block1) {
        super(properties, block, block1);
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @org.jetbrains.annotations.Nullable RecipeType<?> recipeType) {
        return 200;
    }
}
