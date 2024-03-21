package net.cinchtail.cinchcraft.world.feature;


import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> RUBY_PLACED_KEY = createKey("ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_RUBY_PLACED_KEY = createKey("nether_ruby_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_COAL_PLACED_KEY = createKey("nether_coal_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_IRON_PLACED_KEY = createKey("nether_iron_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_COPPER_PLACED_KEY = createKey("nether_copper_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_LAPIS_LAZULI_ORE_PLACED_KEY = createKey("nether_lapis_lazuli_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_REDSTONE_PLACED_PLACED_KEY = createKey("nether_redstone_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_EMERALD_PLACED_KEY = createKey("nether_emerald_ore_placed");
    public static final ResourceKey<PlacedFeature> NETHER_DIAMOND_ORE_PLACED_PLACED_KEY = createKey("nether_diamond_ore_placed");
    public static final ResourceKey<PlacedFeature> BUTTER_CUP_PLACED_KEY = createKey("butter_cup_placed");
    public static final ResourceKey<PlacedFeature> CROCUS_PLACED_KEY = createKey("crocus_placed");
    public static final ResourceKey<PlacedFeature> ALYSSUM_PLACED_KEY = createKey("alyssum_placed");
    public static final ResourceKey<PlacedFeature> LUPINE_PLACED_KEY = createKey("lupine_placed");
    public static final ResourceKey<PlacedFeature> BUBBLE_FLOWER_PLACED_KEY = createKey("bubble_flower_placed");
    public static final ResourceKey<PlacedFeature> STAR_CACTUS_PLACED_KEY = createKey("star_cactus_placed");
    public static final ResourceKey<PlacedFeature> BLUEBERRIES_PLACED_KEY = createKey("blueberries_placed");
    public static final ResourceKey<PlacedFeature> PINEAPPLE_PLANT_PLACED_KEY = createKey("pineapple_placed");
    public static final ResourceKey<PlacedFeature> STRAWBERRY_PLACED_KEY = createKey("strawberry_placed");
    public static final ResourceKey<PlacedFeature> REEDS_PLACED_KEY = createKey("reeds_placed");
    public static final ResourceKey<PlacedFeature> CATTAILS_PLACED_KEY = createKey("cattails_placed");
    public static final ResourceKey<PlacedFeature> LUPINE_LARGE_PLACED_KEY = createKey("lupine_large_placed");

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, RUBY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_RUBY_ORE_KEY),
                commonOrePlacement(10, // VeinsPerChunk
                        HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(90))));

        register(context, NETHER_RUBY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_RUBY_ORE_KEY),
                commonOrePlacement(3, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_IRON_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_IRON_ORE_KEY),
                commonOrePlacement(6, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_COPPER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_COPPER_ORE_KEY),
                commonOrePlacement(6, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_COAL_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_COAL_ORE_KEY),
                commonOrePlacement(4, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_LAPIS_LAZULI_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_LAPIS_LAZULI_ORE_KEY),
                commonOrePlacement(3, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_REDSTONE_PLACED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_REDSTONE_KEY),
                commonOrePlacement(3, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_DIAMOND_ORE_PLACED_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_DIAMOND_ORE_KEY),
                commonOrePlacement(2, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));
        register(context, NETHER_EMERALD_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_EMERALD_KEY),
                commonOrePlacement(2, // VeinsPerChunk
                        HeightRangePlacement.uniform(VerticalAnchor.aboveBottom(-80), VerticalAnchor.aboveBottom(80))));

        register(context, REEDS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.REEDS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(5), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));
        register(context, CATTAILS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CATTAILS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_TOP_SOLID, BiomeFilter.biome()));
        register(context, BLUEBERRIES_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BLUEBERRIES_KEY),
                List.of(RarityFilter.onAverageOnceEvery(16),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, BUTTER_CUP_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BUTTER_CUP_KEY),
                List.of(RarityFilter.onAverageOnceEvery(20),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, CROCUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CROCUS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(10),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, ALYSSUM_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALYSSUM_KEY),
                List.of(RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, LUPINE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUPINE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(12),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, BUBBLE_FLOWER_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BUBBLE_FLOWER_KEY),
                List.of(RarityFilter.onAverageOnceEvery(42),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, LUPINE_LARGE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUPINE_LARGE_KEY),
                List.of(RarityFilter.onAverageOnceEvery(2),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, PINEAPPLE_PLANT_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PINEAPPLE_PLANT_KEY),
                List.of(RarityFilter.onAverageOnceEvery(20),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, STRAWBERRY_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STRAWBERRY_KEY),
                List.of(RarityFilter.onAverageOnceEvery(70),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));
        register(context, STAR_CACTUS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STAR_CACTUS_KEY),
                List.of(RarityFilter.onAverageOnceEvery(38),
                        InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome()));

    }

    public static List<PlacementModifier> orePlacement(PlacementModifier placementModifier, PlacementModifier placementModifier1) {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome());
    }
    public static List<PlacementModifier> commonOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(CountPlacement.of(i), placementModifier);
    }
    public static List<PlacementModifier> rareOrePlacement(int i, PlacementModifier placementModifier) {
        return orePlacement(RarityFilter.onAverageOnceEvery(i), placementModifier);
    }

    private static ResourceKey<PlacedFeature> createKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, new ResourceLocation(Cinchcraft.MOD_ID, name));
    }

    private static void register(BootstapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
