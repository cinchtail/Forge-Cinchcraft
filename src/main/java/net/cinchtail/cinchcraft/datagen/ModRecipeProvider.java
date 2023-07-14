package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.checkerframework.checker.units.qual.C;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Consumer;
public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    private static final List<ItemLike> RUBY_SMELTABLES = List.of(ModBlocks.RUBY_ORE.get(), ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModBlocks.NETHER_RUBY_ORE.get());
    private static final List<ItemLike> NETHER_COAL = List.of(ModBlocks.NETHER_COAL_ORE.get());
    private static final List<ItemLike> NETHER_IRON = List.of(ModBlocks.NETHER_IRON_ORE.get());
    private static final List<ItemLike> NETHER_COPPER = List.of(ModBlocks.NETHER_COPPER_ORE.get());
    private static final List<ItemLike> NETHER_REDSTONE = List.of(ModBlocks.NETHER_REDSTONE_ORE.get());
    private static final List<ItemLike> NETHER_LAPIS = List.of(ModBlocks.NETHER_LAPIS_LAZULI_ORE.get());
    private static final List<ItemLike> NETHER_EMERALD = List.of(ModBlocks.NETHER_EMERALD_ORE.get());
    private static final List<ItemLike> NETHER_DIAMOND = List.of(ModBlocks.NETHER_DIAMOND_ORE.get());

    public ModRecipeProvider(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> pWriter) {

        //Ruby Recipes
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

        oreSmelting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.8f, 200, "ruby");
        oreBlasting(pWriter, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.8f, 100, "ruby");

        //Nether ore Recipes
        oreSmelting(pWriter, NETHER_COAL, RecipeCategory.MISC, Items.COAL, 0.1f, 200, "coal");
        oreBlasting(pWriter, NETHER_COAL, RecipeCategory.MISC, Items.COAL, 0.1f, 100, "coal");

        oreSmelting(pWriter, NETHER_IRON, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(pWriter, NETHER_IRON, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");

        oreSmelting(pWriter, NETHER_COPPER, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(pWriter, NETHER_COPPER, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");

        oreSmelting(pWriter, NETHER_REDSTONE, RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(pWriter, NETHER_REDSTONE, RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");

        oreSmelting(pWriter, NETHER_LAPIS, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 200, "lapis_lazuli");
        oreBlasting(pWriter, NETHER_LAPIS, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 100, "lapis_lazuli");

        oreSmelting(pWriter, NETHER_EMERALD, RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(pWriter, NETHER_EMERALD, RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");

        oreSmelting(pWriter, NETHER_DIAMOND, RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(pWriter, NETHER_DIAMOND, RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");

        //Blackstone Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACKSTONE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BLACKSTONE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BLACKSTONE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_AXE.get())
                .pattern("AA ")
                .pattern("AI ")
                .pattern(" I ")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BLACKSTONE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_SHOVEL.get())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BLACKSTONE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_HOE.get())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BLACKSTONE).build()))
                .save(pWriter);

        //Deepslate Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DEEPSLATE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COBBLED_DEEPSLATE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COBBLED_DEEPSLATE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_AXE.get())
                .pattern("AA ")
                .pattern("AI ")
                .pattern(" I ")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COBBLED_DEEPSLATE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_SHOVEL.get())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COBBLED_DEEPSLATE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_HOE.get())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COBBLED_DEEPSLATE).build()))
                .save(pWriter);

        //Copper Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COPPER_INGOT)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.COPPER_NUGGET.get())
                .unlockedBy("has_copper_nugget", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.COPPER_NUGGET.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.COPPER_INGOT).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 2)
                .requires(Items.CUT_COPPER)
                .group("copper_ingot")
                .unlockedBy("has_cut_copper", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CUT_COPPER).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "copper_ingot_from_cut_copper"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 2)
                .requires(Items.CUT_COPPER_STAIRS)
                .group("copper_ingot")
                .unlockedBy("has_cut_copper_stairs", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CUT_COPPER_STAIRS).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "copper_ingot_from_cut_copper_stairs"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 1)
                .requires(Items.CUT_COPPER_SLAB)
                .group("copper_ingot")
                .unlockedBy("has_cut_copper_slab", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CUT_COPPER_SLAB).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "copper_ingot_from_cut_copper_slab"));

        //Chainmail recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHAINMAIL.get(), 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', Items.CHAIN)
                .unlockedBy("has_chain", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CHAIN).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CHAINMAIL.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CHAINMAIL.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CHAINMAIL.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CHAINMAIL.get()).build()))
                .save(pWriter);

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
}
