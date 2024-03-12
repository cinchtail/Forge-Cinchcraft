package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.world.feature.ModConfiguredFeatures;
import net.cinchtail.cinchcraft.world.feature.ModPlacedFeatures;
import net.minecraft.core.Cloner;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.registries.RegistriesDatapackGenerator;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraftforge.data.event.GatherDataEvent;

import java.util.HashSet;
import java.util.Set;

public class ModWorldGenProvider {
    private static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
            .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap);

    private static HolderLookup.Provider buildWorldgenRegistries(HolderLookup.Provider original) {
        var keys = new HashSet<>(ModWorldGenProvider.BUILDER.getEntryKeys());
        Cloner.Factory clonerFactory = new Cloner.Factory();
        RegistryDataLoader.WORLDGEN_REGISTRIES.forEach(data -> {
            if (!keys.contains(data.key())) {
                ModWorldGenProvider.BUILDER.add(data.key(), context -> {
                });
            }
            data.runWithArguments(clonerFactory::addCodec);
        });
        return ModWorldGenProvider.BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), original, clonerFactory).patches();
    }

    public static RegistriesDatapackGenerator RegistriesDatapackGenerator(GatherDataEvent event, PackOutput packOutput) {
        return new RegistriesDatapackGenerator(packOutput, event.getLookupProvider().thenApply(ModWorldGenProvider::buildWorldgenRegistries), Set.of("nature_arise"));
    }
}