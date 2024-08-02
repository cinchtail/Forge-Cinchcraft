package net.cinchtail.cinchcraft.item;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public enum ModToolTiers implements Tier {
    BLACKSTONE(Tiers.STONE.getIncorrectBlocksForDrops(), 131, 4.0f, 1.0f, 5, Ingredient.of(Blocks.BLACKSTONE)),
    DEEPSLATE(Tiers.STONE.getIncorrectBlocksForDrops(), 231, 4.0f, 1.0f, 5, Ingredient.of(Blocks.COBBLED_DEEPSLATE)),
    RUBY(Tiers.IRON.getIncorrectBlocksForDrops(), 850, 7F, 2.5F, 15, Ingredient.of(ModItems.RUBY.get()));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float attackDamageBonus;
    private final int enchantmentValue;
    private final Ingredient repairIngredient;

    ModToolTiers(TagKey<Block> incorrectBlocksForDrops, int uses, float speed, float attackDamageBonus, int enchantmentValue, Ingredient repairIngredient) {
        this.incorrectBlocksForDrops = incorrectBlocksForDrops;
        this.uses = uses;
        this.speed = speed;
        this.attackDamageBonus = attackDamageBonus;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = repairIngredient;
    }

    @Override
    public float getAttackDamageBonus() {
        return attackDamageBonus;
    }

    @Override
    public int getEnchantmentValue() {
        return enchantmentValue;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return incorrectBlocksForDrops;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return repairIngredient;
    }

    @Override
    public float getSpeed() {
        return speed;
    }

    @Override
    public int getUses() {
        return uses;
    }
}
    //public static final ForgeTier RUBY = new ForgeTier(2,850,4,2f,10,
            //BlockTags.NEEDS_IRON_TOOL,
            //() -> Ingredient.of(ModItems.RUBY.get()));

