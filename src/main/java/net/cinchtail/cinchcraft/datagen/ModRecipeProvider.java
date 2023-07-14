package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModBlocks.NETHER_RUBY_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //ruby recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_RUBY.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.BLOCK_OF_RUBY.get())
                .unlockedBy("has_block_of_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.BLOCK_OF_RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE.get())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_AXE.get())
                .pattern("AA ")
                .pattern("AI ")
                .pattern(" I ")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL.get())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HOE.get())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.RUBY.get()).build()))
                .save(pWriter);

        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 200, "ruby");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.25f, 100, "ruby");

        //nether ore recipes
    }

    protected static void oreSmelting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.SMELTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(Consumer<FinishedRecipe> pFinishedRecipeConsumer, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(pFinishedRecipeConsumer, RecipeSerializer.BLASTING_RECIPE, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static void oreCooking(Consumer<FinishedRecipe> pFinishedRecipeConsumer, RecipeSerializer<? extends AbstractCookingRecipe> pCookingSerializer,
                                     List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime,
                            pCookingSerializer).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(pFinishedRecipeConsumer, Cinchcraft.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
    protected static void oneToOneConversionRecipe(Consumer<FinishedRecipe> finishedRecipeConsumer, ItemLike itemLike, ItemLike itemLike1, @Nullable String s) {
        oneToOneConversionRecipe(finishedRecipeConsumer, itemLike, itemLike1, s, 1);
    }
    protected static void netheriteSmithing(Consumer<FinishedRecipe> finishedRecipeConsumer, Item item, RecipeCategory recipeCategory, Item item1) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(item), Ingredient.of(Items.NETHERITE_INGOT), recipeCategory, item1).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(finishedRecipeConsumer, getItemName(item1) + "_smithing");
    }

}
