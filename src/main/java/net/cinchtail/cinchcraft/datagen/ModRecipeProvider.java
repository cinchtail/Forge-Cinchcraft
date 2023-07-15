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
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

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
    private static final List<ItemLike> CRACKED_MUD_BRICKS = List.of(ModBlocks.CRACKED_MUD_BRICKS.get());

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

        //Cracked Block Recipes


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

        //Food Recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BLUEBERRY_PIE.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .unlockedBy("has_blueberry", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BLUEBERRIES.get()).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.ANCIENT_SLIME_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.BEETROOT)
                .requires(Items.TORCHFLOWER_SEEDS)
                .requires(Items.SLIME_BALL)
                .requires(Items.SLIME_BALL)
                .unlockedBy("has_torchflower_seeds", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.TORCHFLOWER_SEEDS).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.MELON_SLICE,9)
                .requires(Items.MELON)
                .group("melon_slices")
                .unlockedBy("has_melon", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.MELON).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "melon_slices"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.MELON_SLICE,6)
                .requires(ModItems.CARVED_MELON.get())
                .group("melon_slices")
                .unlockedBy("has_carved_melon", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CARVED_MELON.get()).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "melon_slices_from_carved_melon"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.NETHER_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.WARPED_FUNGUS)
                .requires(Items.CRIMSON_FUNGUS)
                .requires(Items.NETHER_WART)
                .requires(Items.MAGMA_CREAM)
                .unlockedBy("has_nether_wart", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.NETHER_WART).build()))
                .save(pWriter);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.VEGETABLE_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.POTATO)
                .requires(Items.BEETROOT)
                .requires(Items.CARROT)
                .requires(Items.BROWN_MUSHROOM)
                .group("vegetable_stew")
                .unlockedBy("has_vegetable_stew_ingredient", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BEETROOT, Items.POTATO, Items.CARROT, Items.BROWN_MUSHROOM).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "vegetable_stew_from_brown_mushroom"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.VEGETABLE_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.POTATO)
                .requires(Items.BEETROOT)
                .requires(Items.CARROT)
                .requires(Items.RED_MUSHROOM)
                .group("vegetable_stew")
                .unlockedBy("has_vegetable_stew_ingredient", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.BEETROOT, Items.POTATO, Items.CARROT, Items.RED_MUSHROOM).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "vegetable_stew_from_red_mushroom"));

        //Dye Recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
                .requires(ModItems.LUPINE.get())
                .unlockedBy("has_lupine", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.LUPINE.get()).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "cyan_dye_from_lupine"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.MAGENTA_DYE)
                .requires(ModItems.CROCUS.get())
                .unlockedBy("has_crocus", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.CROCUS.get()).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "magenta_dye_from_crocus"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE)
                .requires(ModBlocks.BUBBLE_FLOWER.get())
                .unlockedBy("has_bubble_flower", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.BUBBLE_FLOWER.get()).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "purple_dye_from_bubble_flower"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE)
                .requires(ModItems.SMALL_ROSE.get())
                .unlockedBy("has_small_rose", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.SMALL_ROSE.get()).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "red_dye_from_small_rose"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE)
                .requires(ModItems.ALYSSUM.get())
                .unlockedBy("has_alyssum", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.ALYSSUM.get()).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "white_dye_from_alyssum"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.YELLOW_DYE)
                .requires(ModItems.BUTTER_CUP.get())
                .unlockedBy("has_butter_cup", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.BUTTER_CUP.get()).build()))
                .save(pWriter, new ResourceLocation(Cinchcraft.MOD_ID, "yellow_dye_from_butter_cup"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SUNFLOWER_SEEDS.get(), 4)
                .requires(ModItems.SUNFLOWER_HEAD.get())
                .unlockedBy("has_sunflower_head", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModItems.SUNFLOWER_HEAD.get()).build()))
                .save(pWriter);

        //Miscellaneous
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.SMALL_ROSE.get(), 4)
                .requires(Items.ROSE_BUSH)
                .unlockedBy("has_rose_bush", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.ROSE_BUSH).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLOWSTONE_TORCH.get())
                .pattern("A")
                .pattern("T")
                .define('A', Items.GLOWSTONE_DUST)
                .define('T', Items.STICK)
                .unlockedBy("has_glowstone_dust", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.GLOWSTONE_DUST).build()))
                .save(pWriter);

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_HORSE_ARMOR), Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TRANSPORTATION, ModItems.NETHERITE_HORSE_ARMOR.get()).unlocks("has_netherite_ingot",
                has(Items.NETHERITE_INGOT)).save(pWriter, getItemName(ModItems.NETHERITE_HORSE_ARMOR.get()) + "_smithing");

        //Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_END_STONE_BRICKS.get())
                .pattern("A")
                .pattern("A")
                .define('A', Items.END_STONE_BRICK_SLAB)
                .unlockedBy("has_end_stone_brick_slab", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.END_STONE_BRICK_SLAB).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MUD_BRICKS.get())
                .pattern("A")
                .pattern("A")
                .define('A', Items.MUD_BRICK_SLAB)
                .unlockedBy("has_mud_brick_slab", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.MUD_BRICK_SLAB).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_RED_NETHER_BRICKS.get())
                .pattern("A")
                .pattern("A")
                .define('A', Items.RED_NETHER_BRICK_SLAB)
                .unlockedBy("has_red_nether_brick_slab", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.RED_NETHER_BRICK_SLAB).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CALCITE)
                .unlockedBy("has_calcite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CALCITE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CALCITE)
                .unlockedBy("has_calcite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CALCITE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CALCITE)
                .unlockedBy("has_calcite", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CALCITE).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_BRICKS)
                .unlockedBy("has_cracked_deepslate_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CRACKED_DEEPSLATE_BRICKS).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_BRICKS)
                .unlockedBy("has_cracked_deepslate_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CRACKED_DEEPSLATE_BRICKS).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_BRICKS)
                .unlockedBy("has_cracked_deepslate_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CRACKED_DEEPSLATE_BRICKS).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_TILES)
                .unlockedBy("has_cracked_deepslate_tiles", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CRACKED_DEEPSLATE_BRICKS).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_TILES)
                .unlockedBy("has_cracked_deepslate_tiles", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CRACKED_DEEPSLATE_BRICKS).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_TILES)
                .unlockedBy("has_cracked_deepslate_tiles", inventoryTrigger(ItemPredicate.Builder.item().
                        of(Items.CRACKED_DEEPSLATE_BRICKS).build()))
                .save(pWriter);


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_MUD_BRICKS.get())
                .unlockedBy("has_cracked_mud_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CRACKED_MUD_BRICKS.get()).build()))
                .save(pWriter);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_MUD_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_STAIRS.get());

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_MUD_BRICKS.get())
                .unlockedBy("has_cracked_mud_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CRACKED_MUD_BRICKS.get()).build()))
                .save(pWriter);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_MUD_BRICKS.get())
                .unlockedBy("has_cracked_mud_bricks", inventoryTrigger(ItemPredicate.Builder.item().
                        of(ModBlocks.CRACKED_MUD_BRICKS.get()).build()))
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
    protected static void netheriteSmithing(Consumer<FinishedRecipe> finishedRecipeConsumer, Item item, RecipeCategory recipeCategory, Item item1) {
        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE), Ingredient.of(item), Ingredient.of(Items.NETHERITE_INGOT), recipeCategory, item1).unlocks("has_netherite_ingot", has(Items.NETHERITE_INGOT)).save(finishedRecipeConsumer, getItemName(item1) + "_smithing");
    }
    public static SingleItemRecipeBuilder stonecutting(Ingredient ingredient, RecipeCategory recipeCategory, ItemLike itemLike) {
        return new SingleItemRecipeBuilder(recipeCategory, RecipeSerializer.STONECUTTER, ingredient, itemLike, 1);
    }
}
