package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Cinchcraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.BLOCK_OF_RUBY);
        blockWithItem(ModBlocks.RUBY_ORE);
        blockWithItem(ModBlocks.DEEPSLATE_RUBY_ORE);
        blockWithItem(ModBlocks.NETHER_RUBY_ORE);
        blockWithItem(ModBlocks.NETHER_IRON_ORE);
        blockWithItem(ModBlocks.NETHER_COPPER_ORE);
        blockWithItem(ModBlocks.NETHER_COAL_ORE);
        blockWithItem(ModBlocks.NETHER_LAPIS_LAZULI_ORE);
        blockWithItem(ModBlocks.NETHER_REDSTONE_ORE);
        blockWithItem(ModBlocks.NETHER_DIAMOND_ORE);
        blockWithItem(ModBlocks.NETHER_EMERALD_ORE);

        slabBlock((SlabBlock) ModBlocks.TUFF_SLAB.get(), blockTexture(Blocks.TUFF),
                blockTexture(Blocks.TUFF));
        slabBlock((SlabBlock) ModBlocks.CALCITE_SLAB.get(), blockTexture(Blocks.CALCITE),
                blockTexture(Blocks.CALCITE));
        slabBlock((SlabBlock) ModBlocks.DRIPSTONE_SLAB.get(), blockTexture(Blocks.DRIPSTONE_BLOCK),
                blockTexture(Blocks.DRIPSTONE_BLOCK));
        slabBlock((SlabBlock) ModBlocks.QUARTZ_BRICK_SLAB.get(), blockTexture(Blocks.QUARTZ_BRICKS),
                blockTexture(Blocks.QUARTZ_BRICKS));

        stairsBlock((StairBlock) ModBlocks.SMOOTH_STONE_STAIRS.get(), blockTexture(Blocks.SMOOTH_STONE));
        stairsBlock((StairBlock) ModBlocks.TUFF_STAIRS.get(), blockTexture(Blocks.TUFF));
        stairsBlock((StairBlock) ModBlocks.CALCITE_STAIRS.get(), blockTexture(Blocks.CALCITE));
        stairsBlock((StairBlock) ModBlocks.DRIPSTONE_STAIRS.get(), blockTexture(Blocks.DRIPSTONE_BLOCK));
        stairsBlock((StairBlock) ModBlocks.QUARTZ_BRICK_STAIRS.get(), blockTexture(Blocks.QUARTZ_BRICKS));

        wallBlock((WallBlock) ModBlocks.SMOOTH_STONE_WALL.get(), blockTexture(Blocks.SMOOTH_STONE));
        wallBlock((WallBlock) ModBlocks.STONE_WALL.get(), blockTexture(Blocks.STONE));
        wallBlock((WallBlock) ModBlocks.POLISHED_ANDESITE_WALL.get(), blockTexture(Blocks.POLISHED_ANDESITE));
        wallBlock((WallBlock) ModBlocks.POLISHED_GRANITE_WALL.get(), blockTexture(Blocks.POLISHED_GRANITE));
        wallBlock((WallBlock) ModBlocks.POLISHED_DIORITE_WALL.get(), blockTexture(Blocks.POLISHED_DIORITE));
        wallBlock((WallBlock) ModBlocks.PRISMARINE_BRICK_WALL.get(), blockTexture(Blocks.PRISMARINE_BRICKS));
        wallBlock((WallBlock) ModBlocks.DARK_PRISMARINE_WALL.get(), blockTexture(Blocks.DARK_PRISMARINE));
        wallBlock((WallBlock) ModBlocks.PURPUR_WALL.get(), blockTexture(Blocks.PURPUR_BLOCK));
        wallBlock((WallBlock) ModBlocks.TUFF_WALL.get(), blockTexture(Blocks.TUFF));
        wallBlock((WallBlock) ModBlocks.CALCITE_WALL.get(), blockTexture(Blocks.CALCITE));
        wallBlock((WallBlock) ModBlocks.DRIPSTONE_WALL.get(), blockTexture(Blocks.DRIPSTONE_BLOCK));
        wallBlock((WallBlock) ModBlocks.QUARTZ_BRICK_WALL.get(), blockTexture(Blocks.QUARTZ_BRICKS));

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
