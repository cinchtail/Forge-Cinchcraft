package net.cinchtail.cinchcraft.world.feature;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.block.custom.BlueBerryBushBlock;
import net.cinchtail.cinchcraft.block.custom.ReedsCropBlock;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_RUBY_ORE_KEY = registerKey("overworld_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_RUBY_ORE_KEY = registerKey("nether_ruby_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COAL_ORE_KEY = registerKey("nether_coal_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_IRON_ORE_KEY = registerKey("nether_iron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_COPPER_ORE_KEY = registerKey("nether_copper_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_LAPIS_LAZULI_ORE_KEY = registerKey("lapis_lazuli_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_REDSTONE_ORE_KEY = registerKey("nether_redstone_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_EMERALD_ORE_KEY = registerKey("nether_emerald_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NETHER_DIAMOND_ORE_KEY = registerKey("nether_diamond_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUTTER_CUP_KEY = registerKey("butter_cup");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CROCUS_KEY = registerKey("crocus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALYSSUM_KEY = registerKey("alyssum");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUPINE_KEY = registerKey("lupine");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BUBBLE_FLOWER_KEY = registerKey("bubble_flower");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STAR_CACTUS_KEY = registerKey("starl_cactus");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BLUEBERRIES_KEY = registerKey("blueberries");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PINEAPPLE_PLANT_KEY = registerKey("pineapple");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRAWBERRY_KEY = registerKey("strawberry");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REEDS_KEY = registerKey("reeds");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CATTAILS_KEY = registerKey("cattails");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);

        List<OreConfiguration.TargetBlockState> overworldRubyOres = List.of(
                OreConfiguration.target(stoneReplaceables, ModBlocks.RUBY_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, ModBlocks.DEEPSLATE_RUBY_ORE.get().defaultBlockState()));


        register(context, OVERWORLD_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldRubyOres, 8));
        register(context, NETHER_RUBY_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_RUBY_ORE.get().defaultBlockState(), 3));
        register(context, NETHER_IRON_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_IRON_ORE.get().defaultBlockState(), 5));
        register(context, NETHER_COPPER_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_COPPER_ORE.get().defaultBlockState(),5));
        register(context, NETHER_COAL_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_COAL_ORE.get().defaultBlockState(),4));
        register(context, NETHER_LAPIS_LAZULI_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_LAPIS_LAZULI_ORE.get().defaultBlockState(),3));
        register(context, NETHER_REDSTONE_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_REDSTONE_ORE.get().defaultBlockState(),3));
        register(context, NETHER_EMERALD_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_EMERALD_ORE.get().defaultBlockState(),3));
        register(context, NETHER_DIAMOND_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables,
                ModBlocks.NETHER_DIAMOND_ORE.get().defaultBlockState(),3));

        register(context, CATTAILS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(50, 6, 2, PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CATTAILS.get().defaultBlockState())))));
        register(context, BUTTER_CUP_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUTTER_CUP.get())))));
        register(context, CROCUS_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(40, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CROCUS.get())))));
        register(context, ALYSSUM_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.ALYSSUM.get())))));
        register(context, LUPINE_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.LUPINE.get())))));
        register(context, BUBBLE_FLOWER_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(20, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUBBLE_FLOWER.get())))));
        register(context, STAR_CACTUS_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(10, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STAR_CACTUS.get())))));

        register(context, PINEAPPLE_PLANT_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(15, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.PINEAPPLE_PLANT.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3))))));
        register(context, STRAWBERRY_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.STRAWBERRY_PLANT.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3))))));
        register(context, BLUEBERRIES_KEY, Feature.FLOWER,
                new RandomPatchConfiguration(32, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BLUEBERRY_BUSH.get().defaultBlockState().setValue(BlueBerryBushBlock.AGE, 3))))));
        register(context, REEDS_KEY, Feature.RANDOM_PATCH,
                new RandomPatchConfiguration(50, 6, 2, PlacementUtils.inlinePlaced(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.REEDS_CROP_BLOCK.get().defaultBlockState().setValue(ReedsCropBlock.AGE, 4))))));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
