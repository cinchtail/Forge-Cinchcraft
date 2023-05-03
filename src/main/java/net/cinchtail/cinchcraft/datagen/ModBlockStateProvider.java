package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
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

        stairsBlock((StairBlock) ModBlocks.SMOOTH_STONE_STAIRS.get(), blockTexture(Blocks.SMOOTH_STONE));
        stairsBlock((StairBlock) ModBlocks.CUT_SANDSTONE_STAIRS.get(), blockTexture(Blocks.CUT_SANDSTONE));
        stairsBlock((StairBlock) ModBlocks.CUT_RED_SANDSTONE_STAIRS.get(), blockTexture(Blocks.CUT_RED_SANDSTONE));

        wallBlock((WallBlock) ModBlocks.SMOOTH_STONE_WALL.get(), blockTexture(Blocks.SMOOTH_STONE));
        wallBlock((WallBlock) ModBlocks.STONE_WALL.get(), blockTexture(Blocks.STONE));
        wallBlock((WallBlock) ModBlocks.POLISHED_ANDESITE_WALL.get(), blockTexture(Blocks.POLISHED_ANDESITE));
        wallBlock((WallBlock) ModBlocks.POLISHED_GRANITE_WALL.get(), blockTexture(Blocks.POLISHED_GRANITE));
        wallBlock((WallBlock) ModBlocks.POLISHED_DIORITE_WALL.get(), blockTexture(Blocks.POLISHED_DIORITE));
        wallBlock((WallBlock) ModBlocks.PRISMARINE_BRICK_WALL.get(), blockTexture(Blocks.PRISMARINE_BRICKS));
        wallBlock((WallBlock) ModBlocks.DARK_PRISMARINE_WALL.get(), blockTexture(Blocks.DARK_PRISMARINE));
        wallBlock((WallBlock) ModBlocks.CUT_SANDSTONE_WALL.get(), blockTexture(Blocks.CUT_SANDSTONE));
        wallBlock((WallBlock) ModBlocks.CUT_RED_SANDSTONE_WALL.get(), blockTexture(Blocks.CUT_RED_SANDSTONE));
        wallBlock((WallBlock) ModBlocks.PURPUR_WALL.get(), blockTexture(Blocks.PURPUR_BLOCK));

    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
