package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static net.cinchtail.cinchcraft.block.ModBlocks.*;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Cinchcraft.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BLOCK_OF_RUBY);
        blockWithItem(RUBY_ORE);
        blockWithItem(DEEPSLATE_RUBY_ORE);
        blockWithItem(NETHER_RUBY_ORE);
        blockWithItem(NETHER_IRON_ORE);
        blockWithItem(NETHER_COPPER_ORE);
        blockWithItem(NETHER_COAL_ORE);
        blockWithItem(NETHER_LAPIS_LAZULI_ORE);
        blockWithItem(NETHER_REDSTONE_ORE);
        blockWithItem(NETHER_DIAMOND_ORE);
        blockWithItem(NETHER_EMERALD_ORE);
        blockWithItem(CHISELED_END_STONE_BRICKS);
        blockWithItem(CHISELED_RED_NETHER_BRICKS);
        blockWithItem(CRACKED_RED_NETHER_BRICKS);
        blockWithItem(MOSSY_MUD_BRICKS);
        blockWithItem(CHISELED_MUD_BRICKS);
        blockWithItem(CRACKED_MUD_BRICKS);
        blockWithItem(POLISHED_TUFF);
        blockWithItem(POLISHED_CALCITE);
        blockWithItem(POLISHED_DRIPSTONE_BLOCK);
        blockWithItem(MOSSY_COBBLED_DEEPSLATE);
        blockWithItem(MOSSY_DEEPSLATE_BRICKS);
        blockWithItem(MOSSY_DEEPSLATE_TILES);

        slabBlock((SlabBlock) TUFF_SLAB.get(), blockTexture(Blocks.TUFF),
                blockTexture(Blocks.TUFF));
        slabBlock((SlabBlock) CALCITE_SLAB.get(), blockTexture(Blocks.CALCITE),
                blockTexture(Blocks.CALCITE));
        slabBlock((SlabBlock) DRIPSTONE_SLAB.get(), blockTexture(Blocks.DRIPSTONE_BLOCK),
                blockTexture(Blocks.DRIPSTONE_BLOCK));
        slabBlock((SlabBlock) QUARTZ_BRICK_SLAB.get(), blockTexture(Blocks.QUARTZ_BRICKS),
                blockTexture(Blocks.QUARTZ_BRICKS));
        slabBlock((SlabBlock) END_STONE_SLAB.get(), blockTexture(Blocks.END_STONE),
                blockTexture(Blocks.END_STONE));
        slabBlock((SlabBlock) MOSSY_MUD_BRICK_SLAB.get(), blockLoc(MOSSY_MUD_BRICKS),
                blockLoc(MOSSY_MUD_BRICKS));
        slabBlock((SlabBlock) POLISHED_TUFF_SLAB.get(), blockLoc(POLISHED_TUFF),
                blockLoc(POLISHED_TUFF));
        slabBlock((SlabBlock) POLISHED_CALCITE_SLAB.get(), blockLoc(POLISHED_CALCITE),
                blockLoc(POLISHED_CALCITE));
        slabBlock((SlabBlock) POLISHED_DRIPSTONE_SLAB.get(), blockLoc(POLISHED_DRIPSTONE_BLOCK),
                blockLoc(POLISHED_DRIPSTONE_BLOCK));
        slabBlock((SlabBlock) MOSSY_COBBLED_DEEPSLATE_SLAB.get(), blockLoc(MOSSY_COBBLED_DEEPSLATE),
                blockLoc(MOSSY_COBBLED_DEEPSLATE));
        slabBlock((SlabBlock) MOSSY_DEEPSLATE_BRICK_SLAB.get(), blockLoc(MOSSY_DEEPSLATE_BRICKS),
                blockLoc(MOSSY_DEEPSLATE_BRICKS));
        slabBlock((SlabBlock) MOSSY_DEEPSLATE_TILE_SLAB.get(), blockLoc(MOSSY_DEEPSLATE_TILES),
                blockLoc(MOSSY_DEEPSLATE_TILES));
        slabBlock((SlabBlock) CRACKED_STONE_BRICK_SLAB.get(), blockTexture(Blocks.CRACKED_STONE_BRICKS),
                blockTexture(Blocks.CRACKED_STONE_BRICKS));
        slabBlock((SlabBlock) CRACKED_DEEPSLATE_BRICK_SLAB.get(), blockTexture(Blocks.CRACKED_DEEPSLATE_BRICKS),
                blockTexture(Blocks.CRACKED_DEEPSLATE_BRICKS));
        slabBlock((SlabBlock) CRACKED_DEEPSLATE_TILE_SLAB.get(), blockTexture(Blocks.CRACKED_DEEPSLATE_TILES),
                blockTexture(Blocks.CRACKED_DEEPSLATE_TILES));

        stairsBlock((StairBlock) SMOOTH_STONE_STAIRS.get(), blockTexture(Blocks.SMOOTH_STONE));
        stairsBlock((StairBlock) TUFF_STAIRS.get(), blockTexture(Blocks.TUFF));
        stairsBlock((StairBlock) CALCITE_STAIRS.get(), blockTexture(Blocks.CALCITE));
        stairsBlock((StairBlock) DRIPSTONE_STAIRS.get(), blockTexture(Blocks.DRIPSTONE_BLOCK));
        stairsBlock((StairBlock) QUARTZ_BRICK_STAIRS.get(), blockTexture(Blocks.QUARTZ_BRICKS));
        stairsBlock((StairBlock) END_STONE_STAIRS.get(), blockTexture(Blocks.END_STONE));
        stairsBlock((StairBlock) MOSSY_MUD_BRICK_STAIRS.get(), blockLoc(MOSSY_MUD_BRICKS));
        stairsBlock((StairBlock) POLISHED_TUFF_STAIRS.get(), blockLoc(POLISHED_TUFF));
        stairsBlock((StairBlock) POLISHED_CALCITE_STAIRS.get(), blockLoc(POLISHED_CALCITE));
        stairsBlock((StairBlock) POLISHED_DRIPSTONE_STAIRS.get(), blockLoc(POLISHED_DRIPSTONE_BLOCK));
        stairsBlock((StairBlock) MOSSY_COBBLED_DEEPSLATE_STAIRS.get(), blockLoc(MOSSY_COBBLED_DEEPSLATE));
        stairsBlock((StairBlock) MOSSY_DEEPSLATE_BRICK_STAIRS.get(), blockLoc(MOSSY_DEEPSLATE_BRICKS));
        stairsBlock((StairBlock) MOSSY_DEEPSLATE_TILE_STAIRS.get(), blockLoc(MOSSY_DEEPSLATE_TILES));
        stairsBlock((StairBlock) CRACKED_STONE_BRICK_STAIRS.get(), blockTexture(Blocks.CRACKED_STONE_BRICKS));
        stairsBlock((StairBlock) CRACKED_DEEPSLATE_BRICK_STAIRS.get(), blockTexture(Blocks.CRACKED_DEEPSLATE_BRICKS));
        stairsBlock((StairBlock) CRACKED_DEEPSLATE_TILE_STAIRS.get(), blockTexture(Blocks.CRACKED_DEEPSLATE_TILES));

        vanillaWallBlock(SMOOTH_STONE_WALL, blockVanillaBlockLoc(Blocks.SMOOTH_STONE));
        vanillaWallBlock(STONE_WALL, blockVanillaBlockLoc(Blocks.STONE));
        vanillaWallBlock(POLISHED_ANDESITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_ANDESITE));
        vanillaWallBlock(POLISHED_DIORITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_DIORITE));
        vanillaWallBlock(POLISHED_GRANITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_GRANITE));
        vanillaWallBlock(PRISMARINE_BRICK_WALL, blockVanillaBlockLoc(Blocks.PRISMARINE_BRICKS));
        vanillaWallBlock(DARK_PRISMARINE_WALL, blockVanillaBlockLoc(Blocks.DARK_PRISMARINE));
        vanillaWallBlock(PURPUR_WALL, blockVanillaBlockLoc(Blocks.PURPUR_BLOCK));
        vanillaWallBlock(TUFF_WALL, blockVanillaBlockLoc(Blocks.TUFF));
        vanillaWallBlock(CALCITE_WALL, blockVanillaBlockLoc(Blocks.CALCITE));
        vanillaWallBlock(DRIPSTONE_WALL, blockVanillaBlockLoc(Blocks.DRIPSTONE_BLOCK));
        vanillaWallBlock(QUARTZ_BRICK_WALL, blockVanillaBlockLoc(Blocks.QUARTZ_BRICKS));
        vanillaWallBlock(CUT_SANDSTONE_WALL, blockVanillaBlockLoc(Blocks.CUT_SANDSTONE));
        vanillaWallBlock(CUT_RED_SANDSTONE_WALL, blockVanillaBlockLoc(Blocks.CUT_RED_SANDSTONE));
        vanillaWallBlock(END_STONE_WALL, blockVanillaBlockLoc(Blocks.END_STONE));
        vanillaWallBlock(CRACKED_STONE_BRICK_WALL, blockVanillaBlockLoc(Blocks.CRACKED_STONE_BRICKS));
        vanillaWallBlock(CRACKED_DEEPSLATE_BRICK_WALL, blockVanillaBlockLoc(Blocks.CRACKED_DEEPSLATE_BRICKS));
        vanillaWallBlock(CRACKED_DEEPSLATE_TILE_WALL, blockVanillaBlockLoc(Blocks.CRACKED_DEEPSLATE_TILES));
        modWallBlock(MOSSY_MUD_BRICK_WALL, blockLoc(MOSSY_MUD_BRICKS));
        modWallBlock(POLISHED_TUFF_WALL, blockLoc(POLISHED_TUFF));
        modWallBlock(POLISHED_CALCITE_WALL, blockLoc(POLISHED_CALCITE));
        modWallBlock(POLISHED_DRIPSTONE_WALL, blockLoc(POLISHED_DRIPSTONE_BLOCK));
        modWallBlock(MOSSY_COBBLED_DEEPSLATE_WALL, blockLoc(MOSSY_COBBLED_DEEPSLATE));
        modWallBlock(MOSSY_DEEPSLATE_BRICK_WALL, blockLoc(MOSSY_DEEPSLATE_BRICKS));
        modWallBlock(MOSSY_DEEPSLATE_TILE_WALL, blockLoc(MOSSY_DEEPSLATE_TILES));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public void vanillaWallBlock(RegistryObject<Block> block, ResourceLocation texture) {
        super.wallBlock((WallBlock) block.get(), texture);
        models().wallInventory(getName(block) + "_inventory", texture);
    }
    public void modWallBlock(RegistryObject<Block> block, ResourceLocation texture) {
        super.wallBlock((WallBlock) block.get(), texture);
        models().wallInventory(getName(block) + "_inventory", texture);
    }

    public String getName(Supplier<? extends Block> block) {
        return block.get().builtInRegistryHolder().key().location().getPath();
    }
    public ResourceLocation blockVanillaBlockLoc(Block block) {
        return new ResourceLocation("block/" + block.asItem());
    }
    public ResourceLocation blockLoc(Supplier<? extends Block> block) {
        return new ResourceLocation(Cinchcraft.MOD_ID, "block/" + getName(block));
    }
}
