package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.advancements.Criterion;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.AbstractCookingRecipe;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.Arrays;
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
    protected void buildRecipes(RecipeOutput consumer) {

        //Ruby Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.BLOCK_OF_RUBY.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.RUBY.get(), 9)
                .requires(ModBlocks.BLOCK_OF_RUBY.get())
                .unlockedBy("has_block_of_ruby", has(ModBlocks.BLOCK_OF_RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_PICKAXE.get())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_AXE.get())
                .pattern("AA ")
                .pattern("AI ")
                .pattern(" I ")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_SHOVEL.get())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.RUBY_HOE.get())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', ModItems.RUBY.get())
                .define('I', Items.STICK)
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_HELMET.get())
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_CHESTPLATE.get())
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_LEGGINGS.get())
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.RUBY_BOOTS.get())
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.RUBY.get())
                .unlockedBy("has_ruby", has(ModItems.RUBY.get()))
                .save(consumer);

        oreSmelting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.8f, 200, "ruby");
        oreBlasting(consumer, RUBY_SMELTABLES, RecipeCategory.MISC, ModItems.RUBY.get(), 0.8f, 100, "ruby");

        //Nether ore Recipes
        oreSmelting(consumer, NETHER_COAL, RecipeCategory.MISC, Items.COAL, 0.1f, 200, "coal");
        oreBlasting(consumer, NETHER_COAL, RecipeCategory.MISC, Items.COAL, 0.1f, 100, "coal");

        oreSmelting(consumer, NETHER_IRON, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 200, "iron_ingot");
        oreBlasting(consumer, NETHER_IRON, RecipeCategory.MISC, Items.IRON_INGOT, 0.7f, 100, "iron_ingot");

        oreSmelting(consumer, NETHER_COPPER, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 200, "copper_ingot");
        oreBlasting(consumer, NETHER_COPPER, RecipeCategory.MISC, Items.COPPER_INGOT, 0.7f, 100, "copper_ingot");

        oreSmelting(consumer, NETHER_REDSTONE, RecipeCategory.MISC, Items.REDSTONE, 0.7f, 200, "redstone");
        oreBlasting(consumer, NETHER_REDSTONE, RecipeCategory.MISC, Items.REDSTONE, 0.7f, 100, "redstone");

        oreSmelting(consumer, NETHER_LAPIS, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 200, "lapis_lazuli");
        oreBlasting(consumer, NETHER_LAPIS, RecipeCategory.MISC, Items.LAPIS_LAZULI, 0.2f, 100, "lapis_lazuli");

        oreSmelting(consumer, NETHER_EMERALD, RecipeCategory.MISC, Items.EMERALD, 1.0f, 200, "emerald");
        oreBlasting(consumer, NETHER_EMERALD, RecipeCategory.MISC, Items.EMERALD, 1.0f, 100, "emerald");

        oreSmelting(consumer, NETHER_DIAMOND, RecipeCategory.MISC, Items.DIAMOND, 1.0f, 200, "diamond");
        oreBlasting(consumer, NETHER_DIAMOND, RecipeCategory.MISC, Items.DIAMOND, 1.0f, 100, "diamond");

        //Cracked Block Smelting Recipes
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.MUD_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICKS.get(), 0.1F, 200)
                .unlockedBy("has_mud_bricks", has(Blocks.MUD_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_mud_bricks"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.QUARTZ_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_QUARTZ_BRICKS.get(), 0.1F, 200)
                .unlockedBy("has_quartz_bricks", has(Blocks.QUARTZ_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_quartz_bricks"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.RED_NETHER_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_RED_NETHER_BRICKS.get(), 0.1F, 200)
                .unlockedBy("has_red_nether_bricks", has(Blocks.RED_NETHER_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_red_nether_bricks"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICKS.get(), 0.1F, 200)
                .unlockedBy("has_bricks", has(Blocks.BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_bricks"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.PRISMARINE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRISMARINE_BRICKS.get(), 0.1F, 200)
                .unlockedBy("has_prismarine_bricks", has(Blocks.PRISMARINE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_prismarine_bricks"));

        SimpleCookingRecipeBuilder.smelting(Ingredient.of(Blocks.END_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_END_STONE_BRICKS.get(), 0.1F, 200)
                .unlockedBy("has_end_stone_bricks", has(Blocks.END_STONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_end_stone_bricks"));

        //Azalea Wood Recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_PLANKS.get(), 4)
                .group("azalea_planks")
                .requires(ModItems.AZALEA_LOG.get())
                .unlockedBy("has_azalea_log", has(ModItems.AZALEA_LOG.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "azalea_planks_from_azalea_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_PLANKS.get(), 4)
                .group("azalea_planks")
                .requires(ModItems.AZALEA_WOOD.get())
                .unlockedBy("has_azalea_wood", has(ModItems.AZALEA_WOOD.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "azalea_planks_from_azalea_wood"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_PLANKS.get(), 4)
                .group("azalea_planks")
                .requires(ModItems.STRIPPED_AZALEA_LOG.get())
                .unlockedBy("has_stripped_azalea_log", has(ModItems.STRIPPED_AZALEA_LOG.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "azalea_planks_from_stripped_azalea_log"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_PLANKS.get(), 4)
                .group("azalea_planks")
                .requires(ModItems.STRIPPED_AZALEA_WOOD.get())
                .unlockedBy("has_stripped_azalea_wood", has(ModItems.STRIPPED_AZALEA_WOOD.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "azalea_planks_from_stripped_azalea_wood"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_WOOD.get(),3)
                .group("azalea_wood")
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.AZALEA_LOG.get())
                .unlockedBy("has_azalea_log", has(ModItems.AZALEA_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.STRIPPED_AZALEA_WOOD.get(),3)
                .group("azalea_wood")
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.STRIPPED_AZALEA_LOG.get())
                .unlockedBy("has_stripped_azalea_log", has(ModItems.STRIPPED_AZALEA_LOG.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_FENCE.get(),3)
                .pattern("ATA")
                .pattern("ATA")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .define('T', Items.STICK)
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_FENCE_GATE.get())
                .pattern("ATA")
                .pattern("ATA")
                .define('T', ModItems.AZALEA_PLANKS.get())
                .define('A', Items.STICK)
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.AZALEA_PRESSURE_PLATE.get())
                .pattern("AA")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_BUTTON.get())
                .requires(ModItems.AZALEA_PLANKS.get())
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_SIGN.get(),3)
                .pattern("AAA")
                .pattern("AAA")
                .pattern(" T ")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .define('T', Items.STICK)
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_HANGING_SIGN.get(),6)
                .pattern("T T")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.STRIPPED_AZALEA_LOG.get())
                .define('T', Items.CHAIN)
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_DOOR.get(),3)
                .pattern("AA")
                .pattern("AA")
                .pattern("AA")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_TRAPDOOR.get(),2)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_BOAT.get())
                .pattern("A A")
                .pattern("AAA")
                .define('A', ModItems.AZALEA_PLANKS.get())
                .unlockedBy("has_azalea_planks", has(ModItems.AZALEA_PLANKS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModItems.AZALEA_CHEST_BOAT.get())
                .requires(ModItems.AZALEA_BOAT.get())
                .requires(Items.CHEST)
                .unlockedBy("has_azalea_boat", has(ModItems.AZALEA_BOAT.get()))
                .save(consumer);

        //Reeds Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.THATCH_BLOCK.get())
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.REEDS.get())
                .unlockedBy("has_reeds", has(ModItems.REEDS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModItems.THATCH_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModItems.THATCH_BLOCK.get())
                .unlockedBy("has_thatch_block", has(ModItems.THATCH_BLOCK.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.THATCH_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModItems.THATCH_BLOCK.get())
                .unlockedBy("has_thatch_block", has(ModItems.THATCH_BLOCK.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REEDS.get(), 9)
                .requires(ModItems.THATCH_BLOCK.get())
                .group("reeds")
                .unlockedBy("has_thatch_block", has(ModItems.THATCH_BLOCK.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "reeds_from_thatch_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REEDS.get(), 6)
                .requires(ModItems.THATCH_STAIRS.get())
                .group("reeds")
                .unlockedBy("has_thatch_stairs", has(ModItems.THATCH_STAIRS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "reeds_from_thatch_stairs"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.REEDS.get(), 4)
                .requires(ModItems.THATCH_SLAB.get())
                .group("reeds")
                .unlockedBy("has_thatch_slab", has(ModItems.THATCH_SLAB.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "reeds_from_thatch_slab"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, Items.PACKED_MUD)
                .pattern("AT")
                .define('A', Items.MUD)
                .define('T', ModItems.REEDS.get())
                .unlockedBy("has_reeds", has(ModItems.REEDS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "packed_mud_from_reeds"));

        //Blackstone Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.BLACKSTONE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_AXE.get())
                .pattern("AA ")
                .pattern("AI ")
                .pattern(" I ")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_SHOVEL.get())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.BLACKSTONE_HOE.get())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', Items.BLACKSTONE)
                .define('I', Items.STICK)
                .unlockedBy("has_blackstone", has(Items.BLACKSTONE))
                .save(consumer);

        //Deepslate Tools
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, ModItems.DEEPSLATE_SWORD.get())
                .pattern("A")
                .pattern("A")
                .pattern("I")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", has(Items.COBBLED_DEEPSLATE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_PICKAXE.get())
                .pattern("AAA")
                .pattern(" I ")
                .pattern(" I ")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", has(Items.COBBLED_DEEPSLATE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_AXE.get())
                .pattern("AA ")
                .pattern("AI ")
                .pattern(" I ")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", has(Items.COBBLED_DEEPSLATE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_SHOVEL.get())
                .pattern("A")
                .pattern("I")
                .pattern("I")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", has(Items.COBBLED_DEEPSLATE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, ModItems.DEEPSLATE_HOE.get())
                .pattern("AA")
                .pattern(" I")
                .pattern(" I")
                .define('A', Items.COBBLED_DEEPSLATE)
                .define('I', Items.STICK)
                .unlockedBy("has_deepslate", has(Items.COBBLED_DEEPSLATE))
                .save(consumer);

        //Copper Recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, Items.COPPER_INGOT)
                .pattern("AAA")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.COPPER_NUGGET.get())
                .unlockedBy("has_copper_nugget", has(ModItems.COPPER_NUGGET.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "copper_ingot_from_nuggets"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.COPPER_NUGGET.get(), 9)
                .requires(Items.COPPER_INGOT)
                .unlockedBy("has_copper_ingot", has(Items.COPPER_INGOT))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 2)
                .requires(Items.CUT_COPPER)
                .group("copper_ingot")
                .unlockedBy("has_cut_copper", has(Items.CUT_COPPER))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "copper_ingot_from_cut_copper"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 2)
                .requires(Items.CUT_COPPER_STAIRS)
                .group("copper_ingot")
                .unlockedBy("has_cut_copper_stairs", has(Items.CUT_COPPER_STAIRS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "copper_ingot_from_cut_copper_stairs"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.COPPER_INGOT, 1)
                .requires(Items.CUT_COPPER_SLAB)
                .group("copper_ingot")
                .unlockedBy("has_cut_copper_slab", has(Items.CUT_COPPER_SLAB))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "copper_ingot_from_cut_copper_slab"));

        //Chainmail recipes
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.CHAINMAIL.get(), 4)
                .pattern("AA")
                .pattern("AA")
                .define('A', Items.CHAIN)
                .unlockedBy("has_chain", has(Items.CHAIN))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_HELMET)
                .pattern("AAA")
                .pattern("A A")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", has(ModItems.CHAINMAIL.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chainmail_helmet_from_chainmail"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_CHESTPLATE)
                .pattern("A A")
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", has(ModItems.CHAINMAIL.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chainmail_chestplate_from_chainmail"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_LEGGINGS)
                .pattern("AAA")
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", has(ModItems.CHAINMAIL.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chainmail_leggings_from_chainmail"));

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, Items.CHAINMAIL_BOOTS)
                .pattern("A A")
                .pattern("A A")
                .define('A', ModItems.CHAINMAIL.get())
                .unlockedBy("has_chainmail", has(ModItems.CHAINMAIL.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chainmail_boots_from_chainmail"));

        //Food Recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.BLUEBERRY_PIE.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(ModItems.BLUEBERRIES.get())
                .requires(Items.EGG)
                .requires(Items.SUGAR)
                .unlockedBy("has_blueberry", has(ModItems.BLUEBERRIES.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.ANCIENT_SLIME_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.BEETROOT)
                .requires(Items.TORCHFLOWER_SEEDS)
                .requires(Items.SLIME_BALL)
                .requires(Items.SLIME_BALL)
                .unlockedBy("has_torchflower_seeds", has(Items.TORCHFLOWER_SEEDS))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.MELON_SLICE,9)
                .requires(Items.MELON)
                .group("melon_slices")
                .unlockedBy("has_melon", has(Items.MELON))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "melon_slices"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, Items.MELON_SLICE,6)
                .requires(ModItems.CARVED_MELON.get())
                .group("melon_slices")
                .unlockedBy("has_carved_melon", has(ModItems.CARVED_MELON.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "melon_slices_from_carved_melon"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.NETHER_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.WARPED_FUNGUS)
                .requires(Items.CRIMSON_FUNGUS)
                .requires(Items.NETHER_WART)
                .requires(Items.MAGMA_CREAM)
                .unlockedBy("has_nether_wart", has(Items.NETHER_WART))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.VEGETABLE_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.POTATO)
                .requires(Items.BEETROOT)
                .requires(Items.CARROT)
                .requires(Items.BROWN_MUSHROOM)
                .group("vegetable_stew")
                .unlockedBy("has_vegetable_stew_ingredient", has(Items.BOWL))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "vegetable_stew_from_brown_mushroom"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.VEGETABLE_STEW.get())
                .requires(Items.BOWL)
                .requires(Items.POTATO)
                .requires(Items.BEETROOT)
                .requires(Items.CARROT)
                .requires(Items.RED_MUSHROOM)
                .group("vegetable_stew")
                .unlockedBy("has_vegetable_stew_ingredient", has(Items.BOWL))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "vegetable_stew_from_red_mushroom"));

        //Dye Recipes
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
                .requires(ModItems.LUPINE.get())
                .unlockedBy("has_lupine", has(ModItems.LUPINE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cyan_dye_from_lupine"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.CYAN_DYE)
                .requires(ModItems.CROCUS.get())
                .unlockedBy("has_crocus", has(ModItems.CROCUS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cyan_dye_from_crocus"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.PURPLE_DYE)
                .requires(ModBlocks.BUBBLE_FLOWER.get())
                .unlockedBy("has_bubble_flower", has(ModBlocks.BUBBLE_FLOWER.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "purple_dye_from_bubble_flower"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.RED_DYE)
                .requires(ModItems.SMALL_ROSE.get())
                .unlockedBy("has_small_rose", has(ModItems.SMALL_ROSE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "red_dye_from_small_rose"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.WHITE_DYE)
                .requires(ModItems.ALYSSUM.get())
                .unlockedBy("has_alyssum", has(ModItems.ALYSSUM.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "white_dye_from_alyssum"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, Items.YELLOW_DYE)
                .requires(ModItems.BUTTER_CUP.get())
                .unlockedBy("has_butter_cup", has(ModItems.BUTTER_CUP.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "yellow_dye_from_butter_cup"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, ModItems.SUNFLOWER_SEEDS.get(), 2)
                .requires(ModItems.SUNFLOWER_HEAD.get())
                .unlockedBy("has_sunflower_head", has(ModItems.SUNFLOWER_HEAD.get()))
                .save(consumer);

        //Miscellaneous
        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, ModItems.SMALL_ROSE.get(), 4)
                .requires(Items.ROSE_BUSH)
                .unlockedBy("has_rose_bush", has(Items.ROSE_BUSH))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.GLOWSTONE_TORCH.get())
                .pattern("A")
                .pattern("T")
                .define('A', Items.GLOWSTONE_DUST)
                .define('T', Items.STICK)
                .unlockedBy("has_glowstone_dust", has(Items.GLOWSTONE_DUST))
                .save(consumer);

        SmithingTransformRecipeBuilder.smithing(Ingredient.of(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE),
                Ingredient.of(Items.DIAMOND_HORSE_ARMOR), Ingredient.of(Items.NETHERITE_INGOT),
                RecipeCategory.TRANSPORTATION, ModItems.NETHERITE_HORSE_ARMOR.get()).unlocks("has_netherite_ingot",
                has(Items.NETHERITE_INGOT))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, getItemName(ModItems.NETHERITE_HORSE_ARMOR.get()) + "_from_smithing"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.DECORATIONS, Items.STRING, 4)
                .requires(Items.WHITE_WOOL)
                .unlockedBy("has_white_wool", has(Items.WHITE_WOOL))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "string_from_wool"));


        //Blocks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_END_STONE_BRICKS.get())
                .pattern("A")
                .pattern("A")
                .define('A', Items.END_STONE_BRICK_SLAB)
                .unlockedBy("has_end_stone_brick_slab", has(Items.END_STONE_BRICK_SLAB))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.END_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_END_STONE_BRICKS.get())
                .unlockedBy("has_end_stone", has(Blocks.END_STONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chiseled_end_stone_bricks_from_end_stone"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.END_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_END_STONE_BRICKS.get())
                .unlockedBy("has_end_stone_bricks", has(Blocks.END_STONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chiseled_end_stone_bricks_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MUD_BRICKS.get())
                .pattern("A")
                .pattern("A")
                .define('A', Items.MUD_BRICK_SLAB)
                .unlockedBy("has_mud_brick_slab", has(Items.MUD_BRICK_SLAB))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.MUD_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_MUD_BRICKS.get())
                .unlockedBy("has_mud_bricks", has(Blocks.MUD_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chiseled_mud_bricks_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_RED_NETHER_BRICKS.get())
                .pattern("A")
                .pattern("A")
                .define('A', Items.RED_NETHER_BRICK_SLAB)
                .unlockedBy("has_red_nether_brick_slab", has(Items.RED_NETHER_BRICK_SLAB))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.RED_NETHER_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CHISELED_RED_NETHER_BRICKS.get())
                .unlockedBy("has_red_nether_bricks", has(Blocks.RED_NETHER_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "chiseled_red_nether_bricks_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CALCITE)
                .unlockedBy("has_calcite", has(Items.CALCITE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_STAIRS.get())
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "calcite_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CALCITE)
                .unlockedBy("has_calcite", has(Items.CALCITE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_SLAB.get(),2)
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "calcite_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CALCITE)
                .unlockedBy("has_calcite", has(Items.CALCITE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CALCITE_WALL.get())
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "calcite_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_BRICKS)
                .unlockedBy("has_cracked_deepslate_bricks", has(Items.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_DEEPSLATE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_deepslate_bricks", has(Blocks.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_deepslate_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_BRICKS)
                .unlockedBy("has_cracked_deepslate_bricks", has(Items.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_DEEPSLATE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_deepslate_bricks", has(Blocks.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_deepslate_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_BRICKS)
                .unlockedBy("has_cracked_deepslate_bricks", has(Items.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_DEEPSLATE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.get())
                .unlockedBy("has_cracked_deepslate_bricks", has(Blocks.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_deepslate_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_TILES)
                .unlockedBy("has_cracked_deepslate_tiles", has(Items.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_DEEPSLATE_TILES), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.get())
                .unlockedBy("has_cracked_deepslate_tiles", has(Blocks.CRACKED_DEEPSLATE_TILES))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_deepslate_tile_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_TILES)
                .unlockedBy("has_cracked_deepslate_tiles", has(Items.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_DEEPSLATE_TILES), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.get(),2)
                .unlockedBy("has_cracked_deepslate_tiles", has(Blocks.CRACKED_DEEPSLATE_TILES))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_deepslate_tile_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CRACKED_DEEPSLATE_TILES)
                .unlockedBy("has_cracked_deepslate_tiles", has(Items.CRACKED_DEEPSLATE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_DEEPSLATE_TILES), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.get())
                .unlockedBy("has_cracked_deepslate_tiles", has(Blocks.CRACKED_DEEPSLATE_TILES))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_deepslate_tile_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_MUD_BRICKS.get())
                .unlockedBy("has_cracked_mud_bricks", has(ModBlocks.CRACKED_MUD_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_MUD_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_mud_bricks", has(ModBlocks.CRACKED_MUD_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_mud_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_MUD_BRICKS.get())
                .unlockedBy("has_cracked_mud_bricks", has(ModBlocks.CRACKED_MUD_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_MUD_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_mud_bricks", has(ModBlocks.CRACKED_MUD_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_mud_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_MUD_BRICKS.get())
                .unlockedBy("has_cracked_mud_bricks", has(ModBlocks.CRACKED_MUD_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_MUD_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_MUD_BRICK_WALL.get())
                .unlockedBy("has_cracked_mud_bricks", has(ModBlocks.CRACKED_MUD_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_mud_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CRACKED_NETHER_BRICKS)
                .unlockedBy("has_cracked_nether_bricks", has(Items.CRACKED_NETHER_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_NETHER_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_nether_bricks", has(Blocks.CRACKED_NETHER_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_nether_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CRACKED_NETHER_BRICKS)
                .unlockedBy("has_cracked_nether_bricks", has(Items.CRACKED_NETHER_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_NETHER_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_nether_bricks", has(Blocks.CRACKED_NETHER_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_nether_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CRACKED_NETHER_BRICKS)
                .unlockedBy("has_cracked_nether_bricks", has(Items.CRACKED_NETHER_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_NETHER_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_NETHER_BRICK_WALL.get())
                .unlockedBy("has_cracked_nether_bricks", has(Blocks.CRACKED_NETHER_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_nether_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CRACKED_POLISHED_BLACKSTONE_BRICKS)
                .unlockedBy("has_cracked_polished_blackstone_bricks", has(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_polished_blackstone_bricks", has(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_polished_blackstone_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CRACKED_POLISHED_BLACKSTONE_BRICKS)
                .unlockedBy("has_cracked_polished_blackstone_bricks", has(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_polished_blackstone_bricks", has(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_polished_blackstone_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CRACKED_POLISHED_BLACKSTONE_BRICKS)
                .unlockedBy("has_cracked_polished_blackstone_bricks", has(Items.CRACKED_POLISHED_BLACKSTONE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get())
                .unlockedBy("has_cracked_polished_blackstone_bricks", has(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_polished_blackstone_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_QUARTZ_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_QUARTZ_BRICKS.get())
                .unlockedBy("has_cracked_quartz_bricks", has(ModBlocks.CRACKED_QUARTZ_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_QUARTZ_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_QUARTZ_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_quartz_bricks", has(ModBlocks.CRACKED_QUARTZ_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_quartz_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_QUARTZ_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_QUARTZ_BRICKS.get())
                .unlockedBy("has_cracked_quartz_bricks", has(ModBlocks.CRACKED_QUARTZ_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_QUARTZ_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_QUARTZ_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_quartz_bricks", has(ModBlocks.CRACKED_QUARTZ_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_quartz_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_QUARTZ_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_QUARTZ_BRICKS.get())
                .unlockedBy("has_cracked_quartz_bricks", has(ModBlocks.CRACKED_QUARTZ_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_QUARTZ_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_QUARTZ_BRICK_WALL.get())
                .unlockedBy("has_cracked_quartz_bricks", has(ModBlocks.CRACKED_QUARTZ_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_quartz_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_RED_NETHER_BRICKS.get())
                .unlockedBy("has_cracked_red_nether_bricks", has(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_red_nether_bricks", has(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_red_nether_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_RED_NETHER_BRICKS.get())
                .unlockedBy("has_cracked_red_nether_bricks", has(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_red_nether_bricks", has(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_red_nether_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_RED_NETHER_BRICKS.get())
                .unlockedBy("has_cracked_red_nether_bricks", has(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get())
                .unlockedBy("has_cracked_red_nether_bricks", has(ModBlocks.CRACKED_RED_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_red_nether_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CRACKED_STONE_BRICKS)
                .unlockedBy("has_cracked_stone_bricks", has(Items.CRACKED_STONE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_stone_bricks", has(Blocks.CRACKED_STONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_stone_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.CRACKED_STONE_BRICKS)
                .unlockedBy("has_cracked_stone_bricks", has(Items.CRACKED_STONE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_stone_bricks", has(Blocks.CRACKED_STONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_stone_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CRACKED_STONE_BRICKS)
                .unlockedBy("has_cracked_stone_bricks", has(Items.CRACKED_STONE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CRACKED_STONE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_STONE_BRICK_WALL.get())
                .unlockedBy("has_cut_red_sandstone_bricks", has(Blocks.CRACKED_STONE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_cut_red_sandstone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CUT_RED_SANDSTONE)
                .unlockedBy("has_cut_red_sandstone", has(Items.CUT_RED_SANDSTONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CUT_RED_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_STAIRS.get())
                .unlockedBy("has_cut_red_sandstone", has(Blocks.CUT_RED_SANDSTONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cut_red_sandstone_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CUT_RED_SANDSTONE)
                .unlockedBy("has_cut_red_sandstone", has(Items.CUT_RED_SANDSTONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CUT_RED_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_RED_SANDSTONE_WALL.get())
                .unlockedBy("has_cut_red_sandstone", has(Blocks.CUT_RED_SANDSTONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cut_red_sandstone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.CUT_SANDSTONE)
                .unlockedBy("has_cut_sandstone", has(Items.CUT_SANDSTONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CUT_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_STAIRS.get())
                .unlockedBy("has_cut_sandstone", has(Blocks.CUT_SANDSTONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cut_sandstone_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.CUT_SANDSTONE)
                .unlockedBy("has_cut_sandstone", has(Items.CUT_SANDSTONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CUT_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CUT_SANDSTONE_WALL.get())
                .unlockedBy("has_cut_sandstone", has(Blocks.CUT_SANDSTONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cut_sandstone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRISMARINE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.DARK_PRISMARINE)
                .unlockedBy("has_dark_prismarine", has(Items.DARK_PRISMARINE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DARK_PRISMARINE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DARK_PRISMARINE_WALL.get())
                .unlockedBy("has_dark_prismarine", has(Blocks.DARK_PRISMARINE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "dark_prismarine_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.DRIPSTONE_BLOCK)
                .unlockedBy("has_dripstone_block", has(Items.DRIPSTONE_BLOCK))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DRIPSTONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_STAIRS.get())
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "dripstone_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.DRIPSTONE_BLOCK)
                .unlockedBy("has_dripstone_block", has(Items.DRIPSTONE_BLOCK))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DRIPSTONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_SLAB.get(),2)
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "dripstone_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.DRIPSTONE_BLOCK)
                .unlockedBy("has_dripstone_block", has(Items.DRIPSTONE_BLOCK))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DRIPSTONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.DRIPSTONE_WALL.get())
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "dripstone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.END_STONE)
                .unlockedBy("has_end_stone", has(Items.END_STONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.END_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_STAIRS.get())
                .unlockedBy("has_end_stone", has(Blocks.END_STONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "end_stone_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.END_STONE)
                .unlockedBy("has_end_stone", has(Items.END_STONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.END_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_SLAB.get(),2)
                .unlockedBy("has_end_stone", has(Blocks.END_STONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "end_stone_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.END_STONE)
                .unlockedBy("has_end_stone", has(Items.END_STONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.END_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.END_STONE_WALL.get())
                .unlockedBy("has_end_stone", has(Blocks.END_STONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "end_stone_wall_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.IRON_INGOT), RecipeCategory.BUILDING_BLOCKS, ModBlocks.IRON_BUTTON.get())
                .unlockedBy("has_iron_ingot", has(Items.IRON_INGOT))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "iron_button_wall_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Items.GOLD_INGOT), RecipeCategory.BUILDING_BLOCKS, ModBlocks.GOLD_BUTTON.get())
                .unlockedBy("has_gold_ingot", has(Items.GOLD_INGOT))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "gold_button_wall_from_stonecutting"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE.get())
                .group("mossy_cobbled_bricks")
                .requires(Blocks.COBBLED_DEEPSLATE)
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_cobbled_deepslate_from_moss_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE.get())
                .group("mossy_cobbled_bricks")
                .requires(Blocks.COBBLED_DEEPSLATE)
                .requires(Blocks.VINE)
                .unlockedBy("has_vine", has(Blocks.VINE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_cobbled_deepslate_from_vine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_COBBLED_DEEPSLATE.get())
                .unlockedBy("has_mossy_cobbled_deepslate", has(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.get())
                .unlockedBy("has_mossy_cobbled_deepslate", has(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_cobbled_deepslate_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_COBBLED_DEEPSLATE.get())
                .unlockedBy("has_mossy_cobbled_deepslate", has(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB.get(),2)
                .unlockedBy("has_mossy_cobbled_deepslate", has(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_cobbled_deepslate_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_COBBLED_DEEPSLATE.get())
                .unlockedBy("has_mossy_cobbled_deepslate", has(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL.get())
                .unlockedBy("has_mossy_cobbled_deepslate", has(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_cobbled_deepslate_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_DEEPSLATE_BRICKS.get())
                .unlockedBy("has_mossy_deepslate_bricks", has(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.get())
                .unlockedBy("has_mossy_deepslate_bricks", has(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_DEEPSLATE_BRICKS.get())
                .unlockedBy("has_mossy_deepslate_bricks", has(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.get(),2)
                .unlockedBy("has_mossy_deepslate_bricks", has(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_DEEPSLATE_BRICKS.get())
                .unlockedBy("has_mossy_deepslate_bricks", has(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get())
                .unlockedBy("has_mossy_deepslate_bricks", has(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_brick_wall_from_stonecutting"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICKS.get())
                .group("mossy_deeplate_bricks")
                .requires(Blocks.DEEPSLATE_BRICKS)
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_brick_from_moss_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_BRICKS.get())
                .group("mossy_deeplate_bricks")
                .requires(Blocks.DEEPSLATE_BRICKS)
                .requires(Blocks.VINE)
                .unlockedBy("has_vine", has(Blocks.VINE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_brick_from_vine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_TILE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_DEEPSLATE_TILES.get())
                .unlockedBy("has_mossy_deepslate_tile_bricks", has(ModBlocks.MOSSY_DEEPSLATE_TILES.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_DEEPSLATE_TILES.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_TILE_STAIRS.get())
                .unlockedBy("has_mossy_deepslate_tile_bricks", has(ModBlocks.MOSSY_DEEPSLATE_TILES.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_tile_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_TILE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_DEEPSLATE_TILES.get())
                .unlockedBy("has_mossy_deepslate_tile_bricks", has(ModBlocks.MOSSY_DEEPSLATE_TILES.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_DEEPSLATE_TILES.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_TILE_SLAB.get(),2)
                .unlockedBy("has_mossy_deepslate_tile_bricks", has(ModBlocks.MOSSY_DEEPSLATE_TILES.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_tile_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_TILE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_DEEPSLATE_TILES.get())
                .unlockedBy("has_mossy_deepslate_tile_bricks", has(ModBlocks.MOSSY_DEEPSLATE_TILES.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_DEEPSLATE_TILES.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_DEEPSLATE_TILE_WALL.get())
                .unlockedBy("has_mossy_deepslate_tile_bricks", has(ModBlocks.MOSSY_DEEPSLATE_TILES.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_tile_wall_from_stonecutting"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MOSSY_DEEPSLATE_TILES.get())
                .group("mossy_deeplate_tiles")
                .requires(Blocks.DEEPSLATE_TILES)
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_tile_from_moss_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.MOSSY_DEEPSLATE_TILES.get())
                .group("mossy_deeplate_tiles")
                .requires(Blocks.DEEPSLATE_TILES)
                .requires(Blocks.VINE)
                .unlockedBy("has_vine", has(Blocks.VINE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_deepslate_tile_from_vine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_MUD_BRICKS.get())
                .unlockedBy("has_mossy_mud_brick_bricks", has(ModBlocks.MOSSY_MUD_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_MUD_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICK_STAIRS.get())
                .unlockedBy("has_mossy_mud_brick_bricks", has(ModBlocks.MOSSY_MUD_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_mud_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_MUD_BRICKS.get())
                .unlockedBy("has_mossy_mud_brick_bricks", has(ModBlocks.MOSSY_MUD_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_MUD_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICK_SLAB.get(),2)
                .unlockedBy("has_mossy_mud_brick_bricks", has(ModBlocks.MOSSY_MUD_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_mud_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_MUD_BRICKS.get())
                .unlockedBy("has_mossy_mud_brick_bricks", has(ModBlocks.MOSSY_MUD_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_MUD_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICK_WALL.get())
                .unlockedBy("has_mossy_mud_brick_bricks", has(ModBlocks.MOSSY_MUD_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_mud_brick_wall_from_stonecutting"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS.get())
                .group("mossy_mud_bricks")
                .requires(Blocks.MUD_BRICKS)
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_mud_brick_from_moss_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_MUD_BRICKS.get())
                .group("mossy_mud_bricks")
                .requires(Blocks.MUD_BRICKS)
                .requires(Blocks.VINE)
                .unlockedBy("has_vine", has(Blocks.VINE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_mud_brick_from_vine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.POLISHED_ANDESITE)
                .unlockedBy("has_polished_andesite", has(Blocks.POLISHED_ANDESITE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.POLISHED_ANDESITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_WALL.get())
                .unlockedBy("has_polished_andesite", has(Blocks.POLISHED_ANDESITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_andesite_wall_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.ANDESITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_ANDESITE_WALL.get())
                .unlockedBy("has_andesite", has(Blocks.ANDESITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_andesite_wall_from_stonecutting_from_andesite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_CALCITE.get())
                .unlockedBy("has_polished_calcite", has(ModBlocks.POLISHED_CALCITE.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_CALCITE.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_STAIRS.get())
                .unlockedBy("has_polished_calcite", has(ModBlocks.POLISHED_CALCITE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_calcite_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_CALCITE.get())
                .unlockedBy("has_polished_calcite", has(ModBlocks.POLISHED_CALCITE.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_CALCITE.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB.get(),2)
                .unlockedBy("has_polished_calcite", has(ModBlocks.POLISHED_CALCITE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_calcite_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_CALCITE.get())
                .unlockedBy("has_polished_calcite", has(ModBlocks.POLISHED_CALCITE.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_CALCITE.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL.get())
                .unlockedBy("has_polished_calcite", has(ModBlocks.POLISHED_CALCITE.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_calcite_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE.get(),4)
                .pattern("AA")
                .pattern("AA")
                .define('A', Blocks.CALCITE)
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE.get())
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_calcite_from_stonecutting"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_STAIRS.get())
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_calcite_stairs_from_stonecutting_from_calcite"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_SLAB.get(),2)
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_calcite_slab_from_stonecutting_from_calcite"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.CALCITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_CALCITE_WALL.get())
                .unlockedBy("has_calcite", has(Blocks.CALCITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_calcite_wall_from_stonecutting_from_calcite"));


        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE.get())
                .pattern("AA")
                .define('A', Blocks.POLISHED_DEEPSLATE)
                .unlockedBy("has_polished_deepslate", has(Blocks.POLISHED_DEEPSLATE))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModBlocks.POLISHED_DEEPSLATE_BUTTON.get())
                .requires(Blocks.POLISHED_DEEPSLATE)
                .unlockedBy("has_polished_deepslate", has(Blocks.POLISHED_DEEPSLATE))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.POLISHED_DIORITE)
                .unlockedBy("has_polished_diorite", has(Blocks.POLISHED_DIORITE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.POLISHED_DIORITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_WALL.get())
                .unlockedBy("has_polished_diorite", has(Blocks.POLISHED_DIORITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_diorite_wall_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DIORITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DIORITE_WALL.get())
                .unlockedBy("has_diorite", has(Blocks.DIORITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_diorite_wall_from_stonecutting_from_andesite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BLOCK.get(),4)
                .pattern("AA")
                .pattern("AA")
                .define('A', Blocks.DRIPSTONE_BLOCK)
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DRIPSTONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_BLOCK.get())
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_dripstone_block_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_DRIPSTONE_BLOCK.get())
                .unlockedBy("has_polished_dripstone_block", has(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_STAIRS.get())
                .unlockedBy("has_polished_dripstone_block", has(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_dripstone_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_DRIPSTONE_BLOCK.get())
                .unlockedBy("has_polished_dripstone_block", has(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_SLAB.get(),2)
                .unlockedBy("has_polished_dripstone_block", has(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_dripstone_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_DRIPSTONE_BLOCK.get())
                .unlockedBy("has_polished_dripstone_block", has(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_WALL.get())
                .unlockedBy("has_polished_dripstone_block", has(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_dripstone_wall_from_stonecutting"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DRIPSTONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_STAIRS.get())
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_dripstone_stairs_from_stonecutting_from_dripstone_block"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DRIPSTONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_SLAB.get(),2)
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_dripstone_slab_from_stonecutting_from_dripstone_block"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.DRIPSTONE_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_DRIPSTONE_WALL.get())
                .unlockedBy("has_dripstone_block", has(Blocks.DRIPSTONE_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_dripstone_wall_from_stonecutting_from_dripstone_block"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.POLISHED_GRANITE)
                .unlockedBy("has_polished_granite", has(Blocks.POLISHED_GRANITE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.POLISHED_GRANITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_WALL.get())
                .unlockedBy("has_polished_granite", has(Blocks.POLISHED_GRANITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_granite_wall_from_stonecutting"));

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.GRANITE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_GRANITE_WALL.get())
                .unlockedBy("has_granite", has(Blocks.GRANITE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_granite_wall_from_stonecutting_from_granite"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF.get(),4)
                .pattern("AA")
                .pattern("AA")
                .define('A', Blocks.TUFF)
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TUFF), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF.get())
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_tuff_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_TUFF.get())
                .unlockedBy("has_polished_tuff", has(ModBlocks.POLISHED_TUFF.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_TUFF.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_STAIRS.get())
                .unlockedBy("has_polished_tuff", has(ModBlocks.POLISHED_TUFF.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_tuff_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_TUFF.get())
                .unlockedBy("has_polished_tuff", has(ModBlocks.POLISHED_TUFF.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_TUFF.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_SLAB.get(),2)
                .unlockedBy("has_polished_tuff", has(ModBlocks.POLISHED_TUFF.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_tuff_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.POLISHED_TUFF.get())
                .unlockedBy("has_polished_tuff", has(ModBlocks.POLISHED_TUFF.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.POLISHED_TUFF.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_WALL.get())
                .unlockedBy("has_polished_tuff", has(ModBlocks.POLISHED_TUFF.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_tuff_wall_from_stonecutting"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TUFF), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_STAIRS.get())
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_tuff_stairs_from_stonecutting_from_tuff"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TUFF), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_SLAB.get(),2)
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_tuff_slab_from_stonecutting_from_tuff"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TUFF), RecipeCategory.BUILDING_BLOCKS, ModBlocks.POLISHED_TUFF_WALL.get())
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "polished_tuff_wall_from_stonecutting_from_tuff"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRISMARINE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.PRISMARINE_BRICKS)
                .unlockedBy("has_prismarine_bricks", has(Blocks.PRISMARINE_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.PRISMARINE_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PRISMARINE_BRICK_WALL.get())
                .unlockedBy("has_prismarine_bricks", has(Blocks.PRISMARINE_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "prismarine_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPUR_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.PURPUR_BLOCK)
                .unlockedBy("has_purpur_block", has(Blocks.PURPUR_BLOCK))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.PURPUR_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.PURPUR_WALL.get())
                .unlockedBy("has_purpur_block", has(Blocks.PURPUR_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "purpur_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Blocks.QUARTZ_BRICKS)
                .unlockedBy("has_quartz_bricks", has(Blocks.QUARTZ_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_STAIRS.get())
                .unlockedBy("has_quartz_bricks", has(Blocks.QUARTZ_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "quartz_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Blocks.QUARTZ_BRICKS)
                .unlockedBy("has_quartz_bricks", has(Blocks.QUARTZ_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_SLAB.get(),2)
                .unlockedBy("has_quartz_bricks", has(Blocks.QUARTZ_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "quartz_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.QUARTZ_BRICKS)
                .unlockedBy("has_quartz_bricks", has(Blocks.QUARTZ_BRICKS))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BRICKS), RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_WALL.get())
                .unlockedBy("has_quartz_bricks", has(Blocks.QUARTZ_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "quartz_brick_wall_from_stonecutting"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_STAIRS.get())
                .unlockedBy("has_block_of_quartz", has(Blocks.QUARTZ_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "quartz_brick_stairs_from_stonecutting_from_block_of_quartz"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_SLAB.get(),2)
                .unlockedBy("has_block_of_quartz", has(Blocks.QUARTZ_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "quartz_brick_slab_from_stonecutting_from_block_of_quartz"));


        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_BRICK_WALL.get())
                .unlockedBy("has_block_of_quartz", has(Blocks.QUARTZ_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "quartz_brick_wall_from_stonecutting_from_block_of_quartz"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.QUARTZ_BLOCK)
                .unlockedBy("has_quartz_block", has(Blocks.QUARTZ_BLOCK))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.QUARTZ_BLOCK), RecipeCategory.BUILDING_BLOCKS, ModBlocks.QUARTZ_WALL.get())
                .unlockedBy("has_quartz_block", has(Blocks.QUARTZ_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "quartz_block_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.RED_NETHER_BRICK_FENCE.get(),3)
                .pattern("ATA")
                .pattern("ATA")
                .define('A', Blocks.RED_NETHER_BRICKS)
                .define('T', Items.NETHER_BRICK)
                .unlockedBy("has_red_nether_bricks", has(Blocks.RED_NETHER_BRICKS))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_BASALT)
                .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_BASALT), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_STAIRS.get())
                .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_basalt_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_BASALT)
                .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_BASALT), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_SLAB.get(),2)
                .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_basalt_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_BASALT)
                .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_BASALT), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_BASALT_WALL.get())
                .unlockedBy("has_smooth_basalt", has(Blocks.SMOOTH_BASALT))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_basalt_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_QUARTZ_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_QUARTZ)
                .unlockedBy("has_smooth_quartz", has(Blocks.SMOOTH_QUARTZ))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_QUARTZ), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_QUARTZ_WALL.get())
                .unlockedBy("has_smooth_quartz", has(Blocks.SMOOTH_QUARTZ))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_quartz_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_RED_SANDSTONE)
                .unlockedBy("has_smooth_red_sandstone", has(Blocks.SMOOTH_RED_SANDSTONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_RED_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get())
                .unlockedBy("has_smooth_red_sandstone", has(Blocks.SMOOTH_RED_SANDSTONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_red_sandstone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SANDSTONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_SANDSTONE)
                .unlockedBy("has_smooth_sandstone", has(Blocks.SMOOTH_SANDSTONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_SANDSTONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_SANDSTONE_WALL.get())
                .unlockedBy("has_smooth_sandstone", has(Blocks.SMOOTH_SANDSTONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_sandstone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_STONE)
                .unlockedBy("has_smooth_stone", has(Blocks.SMOOTH_STONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_STAIRS.get())
                .unlockedBy("has_smooth_stone", has(Blocks.SMOOTH_STONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_stone_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.SMOOTH_STONE)
                .unlockedBy("has_smooth_stone", has(Blocks.SMOOTH_STONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.SMOOTH_STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.SMOOTH_STONE_WALL.get())
                .unlockedBy("has_smooth_stone", has(Blocks.SMOOTH_STONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "smooth_stone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Blocks.STONE)
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.STONE), RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_WALL.get())
                .unlockedBy("has_stone", has(Blocks.STONE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "stone_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', Items.TUFF)
                .unlockedBy("has_tuff", has(Items.TUFF))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TUFF), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_STAIRS.get())
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "tuff_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_SLAB.get(),6)
                .pattern("AAA")
                .define('A', Items.TUFF)
                .unlockedBy("has_tuff", has(Items.TUFF))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TUFF), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_SLAB.get(),2)
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "tuff_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', Items.TUFF)
                .unlockedBy("has_tuff", has(Items.TUFF))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(Blocks.TUFF), RecipeCategory.BUILDING_BLOCKS, ModBlocks.TUFF_WALL.get())
                .unlockedBy("has_tuff", has(Blocks.TUFF))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "tuff_wall_from_stonecutting"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICKS.get())
                .group("mossy_nether_bricks")
                .requires(Blocks.NETHER_BRICKS)
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block_and_mossy_nether_bricks", has(Blocks.NETHER_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_nether_bricks_from_moss_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICKS.get())
                .group("mossy_nether_bricks")
                .requires(Blocks.NETHER_BRICKS)
                .requires(Blocks.VINE)
                .unlockedBy("has_vine_and_mossy_nether_bricks", has(Blocks.NETHER_BRICKS))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_nether_bricks_from_vine"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_mossy_nether_bricks", has(ModBlocks.MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICK_STAIRS.get())
                .unlockedBy("has_mossy_nether_bricks", has(ModBlocks.MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_nether_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_mossy_nether_bricks", has(ModBlocks.MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICK_SLAB.get(),2)
                .unlockedBy("has_mossy_nether_bricks", has(ModBlocks.MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_nether_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_mossy_nether_bricks", has(ModBlocks.MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICK_WALL.get())
                .unlockedBy("has_mossy_nether_bricks", has(ModBlocks.MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_nether_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_NETHER_BRICK_FENCE.get(),3)
                .pattern("ATA")
                .pattern("ATA")
                .define('A', ModBlocks.MOSSY_NETHER_BRICKS.get())
                .define('T', Items.NETHER_BRICK)
                .unlockedBy("has_mossy_nether_bricks", has(ModBlocks.MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get())
                .requires(Blocks.NETHER_BRICKS)
                .requires(Blocks.NETHER_WART_BLOCK)
                .unlockedBy("has_nether_wart_block", has(Blocks.NETHER_WART_BLOCK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_crimson_mossy_nether_bricks", has(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_STAIRS.get())
                .unlockedBy("has_crimson_mossy_nether_bricks", has(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "crimson_mossy_nether_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_crimson_mossy_nether_bricks", has(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_SLAB.get(),2)
                .unlockedBy("has_crimson_mossy_nether_bricks", has(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "crimson_mossy_nether_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_crimson_mossy_nether_bricks", has(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_WALL.get())
                .unlockedBy("has_crimson_mossy_nether_bricks", has(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "crimson_mossy_nether_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_FENCE.get(),3)
                .pattern("ATA")
                .pattern("ATA")
                .define('A', ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get())
                .define('T', Items.NETHER_BRICK)
                .unlockedBy("has_crimson_mossy_nether_bricks", has(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get())
                .requires(Blocks.NETHER_BRICKS)
                .requires(Blocks.WARPED_WART_BLOCK)
                .unlockedBy("has_warped_wart_block", has(Blocks.WARPED_WART_BLOCK))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_warped_mossy_nether_bricks", has(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICK_STAIRS.get())
                .unlockedBy("has_warped_mossy_nether_bricks", has(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "warped_mossy_nether_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_warped_mossy_nether_bricks", has(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICK_SLAB.get(),2)
                .unlockedBy("has_warped_mossy_nether_bricks", has(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "warped_mossy_nether_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get())
                .unlockedBy("has_warped_mossy_nether_bricks", has(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICK_WALL.get())
                .unlockedBy("has_warped_mossy_nether_bricks", has(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "warped_mossy_nether_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.WARPED_MOSSY_NETHER_BRICK_FENCE.get(),3)
                .pattern("ATA")
                .pattern("ATA")
                .define('A', ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get())
                .define('T', Items.NETHER_BRICK)
                .unlockedBy("has_warped_mossy_nether_bricks", has(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get()))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_BRICKS.get())
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_BRICKS.get())
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_BRICKS.get())
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_BRICK_WALL.get())
                .unlockedBy("has_cracked_bricks", has(ModBlocks.CRACKED_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRISMARINE_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_PRISMARINE_BRICKS.get())
                .unlockedBy("has_cracked_prismarine_bricks", has(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRISMARINE_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_prismarine_bricks", has(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_prismarine_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRISMARINE_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_PRISMARINE_BRICKS.get())
                .unlockedBy("has_cracked_prismarine_bricks", has(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRISMARINE_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_prismarine_bricks", has(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_prismarine_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRISMARINE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_PRISMARINE_BRICKS.get())
                .unlockedBy("has_cracked_prismarine_bricks", has(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_PRISMARINE_BRICK_WALL.get())
                .unlockedBy("has_cracked_prismarine_bricks", has(ModBlocks.CRACKED_PRISMARINE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_prismarine_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_END_STONE_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_END_STONE_BRICKS.get())
                .unlockedBy("has_cracked_end_stone_bricks", has(ModBlocks.CRACKED_END_STONE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_END_STONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_END_STONE_BRICK_STAIRS.get())
                .unlockedBy("has_cracked_end_stone_bricks", has(ModBlocks.CRACKED_END_STONE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_end_stone_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_END_STONE_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_END_STONE_BRICKS.get())
                .unlockedBy("has_cracked_end_stone_bricks", has(ModBlocks.CRACKED_END_STONE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_END_STONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_END_STONE_BRICK_SLAB.get(),2)
                .unlockedBy("has_cracked_end_stone_bricks", has(ModBlocks.CRACKED_END_STONE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_end_stone_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_END_STONE_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.CRACKED_END_STONE_BRICKS.get())
                .unlockedBy("has_cracked_end_stone_bricks", has(ModBlocks.CRACKED_END_STONE_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.CRACKED_END_STONE_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.CRACKED_END_STONE_BRICK_WALL.get())
                .unlockedBy("has_cracked_end_stone_bricks", has(ModBlocks.CRACKED_END_STONE_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "cracked_end_stone_brick_wall_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_STAIRS.get(),4)
                .pattern("A  ")
                .pattern("AA ")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_BRICKS.get())
                .unlockedBy("has_mossy_bricks", has(ModBlocks.MOSSY_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_STAIRS.get())
                .unlockedBy("has_mossy_bricks", has(ModBlocks.MOSSY_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_brick_stairs_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_SLAB.get(),6)
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_BRICKS.get())
                .unlockedBy("has_mossy_bricks", has(ModBlocks.MOSSY_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_SLAB.get(),2)
                .unlockedBy("has_mossy_bricks", has(ModBlocks.MOSSY_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_brick_slab_from_stonecutting"));

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_WALL.get(),6)
                .pattern("AAA")
                .pattern("AAA")
                .define('A', ModBlocks.MOSSY_BRICKS.get())
                .unlockedBy("has_mossy_bricks", has(ModBlocks.MOSSY_BRICKS.get()))
                .save(consumer);

        SingleItemRecipeBuilder.stonecutting(Ingredient.of(ModBlocks.MOSSY_BRICKS.get()), RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICK_WALL.get())
                .unlockedBy("has_mossy_bricks", has(ModBlocks.MOSSY_BRICKS.get()))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_brick_wall_from_stonecutting"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS.get())
                .group("mossy_bricks")
                .requires(Blocks.BRICKS)
                .requires(Blocks.MOSS_BLOCK)
                .unlockedBy("has_moss_block", has(Blocks.MOSS_BLOCK))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_brick_from_moss_block"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, ModBlocks.MOSSY_BRICKS.get())
                .group("mossy_bricks")
                .requires(Blocks.BRICKS)
                .requires(Blocks.VINE)
                .unlockedBy("has_vine", has(Items.VINE))
                .save(consumer, new ResourceLocation(Cinchcraft.MOD_ID, "mossy_brick_from_vine"));
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
                    .save((RecipeOutput) pFinishedRecipeConsumer, Cinchcraft.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
