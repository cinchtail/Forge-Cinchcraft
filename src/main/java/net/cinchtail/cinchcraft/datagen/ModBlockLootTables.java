package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    public ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }
    @Override
    protected void generate() {
        dropSelf(ModBlocks.BLOCK_OF_RUBY.get());

        add(ModBlocks.RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.DEEPSLATE_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.DEEPSLATE_RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.NETHER_COAL_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_COAL_ORE.get(), Items.COAL));
        add(ModBlocks.NETHER_IRON_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_IRON_ORE.get(), Items.IRON_NUGGET));
        add(ModBlocks.NETHER_COPPER_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_COPPER_ORE.get(), ModItems.COPPER_NUGGET.get()));
        add(ModBlocks.NETHER_RUBY_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_RUBY_ORE.get(), ModItems.RUBY.get()));
        add(ModBlocks.NETHER_LAPIS_LAZULI_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_LAPIS_LAZULI_ORE.get(), Items.LAPIS_LAZULI));
        add(ModBlocks.NETHER_REDSTONE_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_REDSTONE_ORE.get(), Items.REDSTONE));
        add(ModBlocks.NETHER_DIAMOND_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_DIAMOND_ORE.get(), Items.DIAMOND));
        add(ModBlocks.NETHER_EMERALD_ORE.get(),
                (block) -> createOreDrop(ModBlocks.NETHER_EMERALD_ORE.get(), Items.EMERALD));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
