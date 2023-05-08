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

import static net.cinchtail.cinchcraft.block.ModBlocks.MOSSY_MUD_BRICKS;

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
        blockWithItem(ModBlocks.CHISELED_END_STONE_BRICKS);
        blockWithItem(ModBlocks.CHISELED_RED_NETHER_BRICKS);
        blockWithItem(ModBlocks.CRACKED_RED_NETHER_BRICKS);
        blockWithItem(MOSSY_MUD_BRICKS);
        blockWithItem(ModBlocks.CHISELED_MUD_BRICKS);
        blockWithItem(ModBlocks.CRACKED_MUD_BRICKS);

        slabBlock((SlabBlock) ModBlocks.TUFF_SLAB.get(), blockTexture(Blocks.TUFF),
                blockTexture(Blocks.TUFF));
        slabBlock((SlabBlock) ModBlocks.CALCITE_SLAB.get(), blockTexture(Blocks.CALCITE),
                blockTexture(Blocks.CALCITE));
        slabBlock((SlabBlock) ModBlocks.DRIPSTONE_SLAB.get(), blockTexture(Blocks.DRIPSTONE_BLOCK),
                blockTexture(Blocks.DRIPSTONE_BLOCK));
        slabBlock((SlabBlock) ModBlocks.QUARTZ_BRICK_SLAB.get(), blockTexture(Blocks.QUARTZ_BRICKS),
                blockTexture(Blocks.QUARTZ_BRICKS));
        slabBlock((SlabBlock) ModBlocks.END_STONE_SLAB.get(), blockTexture(Blocks.END_STONE),
                blockTexture(Blocks.END_STONE));
        slabBlock((SlabBlock) ModBlocks.MOSSY_MUD_BRICK_SLAB.get(), blockLoc(MOSSY_MUD_BRICKS),
                blockLoc(MOSSY_MUD_BRICKS));

        stairsBlock((StairBlock) ModBlocks.SMOOTH_STONE_STAIRS.get(), blockTexture(Blocks.SMOOTH_STONE));
        stairsBlock((StairBlock) ModBlocks.TUFF_STAIRS.get(), blockTexture(Blocks.TUFF));
        stairsBlock((StairBlock) ModBlocks.CALCITE_STAIRS.get(), blockTexture(Blocks.CALCITE));
        stairsBlock((StairBlock) ModBlocks.DRIPSTONE_STAIRS.get(), blockTexture(Blocks.DRIPSTONE_BLOCK));
        stairsBlock((StairBlock) ModBlocks.QUARTZ_BRICK_STAIRS.get(), blockTexture(Blocks.QUARTZ_BRICKS));
        stairsBlock((StairBlock) ModBlocks.END_STONE_STAIRS.get(), blockTexture(Blocks.END_STONE));
        stairsBlock((StairBlock) ModBlocks.MOSSY_MUD_BRICK_STAIRS.get(), blockLoc(MOSSY_MUD_BRICKS));

        vanillaWallBlock(ModBlocks.SMOOTH_STONE_WALL, blockVanillaBlockLoc(Blocks.SMOOTH_STONE));
        vanillaWallBlock(ModBlocks.STONE_WALL, blockVanillaBlockLoc(Blocks.STONE));
        vanillaWallBlock(ModBlocks.POLISHED_ANDESITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_ANDESITE));
        vanillaWallBlock(ModBlocks.POLISHED_DIORITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_DIORITE));
        vanillaWallBlock(ModBlocks.POLISHED_GRANITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_GRANITE));
        vanillaWallBlock(ModBlocks.PRISMARINE_BRICK_WALL, blockVanillaBlockLoc(Blocks.PRISMARINE_BRICKS));
        vanillaWallBlock(ModBlocks.DARK_PRISMARINE_WALL, blockVanillaBlockLoc(Blocks.DARK_PRISMARINE));
        vanillaWallBlock(ModBlocks.PURPUR_WALL, blockVanillaBlockLoc(Blocks.PURPUR_BLOCK));
        vanillaWallBlock(ModBlocks.TUFF_WALL, blockVanillaBlockLoc(Blocks.TUFF));
        vanillaWallBlock(ModBlocks.CALCITE_WALL, blockVanillaBlockLoc(Blocks.CALCITE));
        vanillaWallBlock(ModBlocks.DRIPSTONE_WALL, blockVanillaBlockLoc(Blocks.DRIPSTONE_BLOCK));
        vanillaWallBlock(ModBlocks.QUARTZ_BRICK_WALL, blockVanillaBlockLoc(Blocks.QUARTZ_BRICKS));
        vanillaWallBlock(ModBlocks.CUT_SANDSTONE_WALL, blockVanillaBlockLoc(Blocks.CUT_SANDSTONE));
        vanillaWallBlock(ModBlocks.CUT_RED_SANDSTONE_WALL, blockVanillaBlockLoc(Blocks.CUT_RED_SANDSTONE));
        vanillaWallBlock(ModBlocks.END_STONE_WALL, blockVanillaBlockLoc(Blocks.END_STONE));
        modWallBlock(ModBlocks.MOSSY_MUD_BRICK_WALL, blockLoc(MOSSY_MUD_BRICKS));
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
