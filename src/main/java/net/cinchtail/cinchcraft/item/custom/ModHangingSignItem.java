package net.cinchtail.cinchcraft.item.custom;

import net.minecraft.world.item.HangingSignItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;

public class ModHangingSignItem extends HangingSignItem {
    public ModHangingSignItem(Block block, Block block1, Properties properties) {
        super(block, block1, properties);
    }
    @Override
    public int getBurnTime(ItemStack itemStack, @org.jetbrains.annotations.Nullable RecipeType<?> recipeType) {
        return 800;
    }
}
