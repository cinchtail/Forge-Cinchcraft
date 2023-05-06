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

        stairsBlock((StairBlock) ModBlocks.SMOOTH_STONE_STAIRS.get(), blockTexture(Blocks.SMOOTH_STONE));
        stairsBlock((StairBlock) ModBlocks.TUFF_STAIRS.get(), blockTexture(Blocks.TUFF));
        stairsBlock((StairBlock) ModBlocks.CALCITE_STAIRS.get(), blockTexture(Blocks.CALCITE));
        stairsBlock((StairBlock) ModBlocks.DRIPSTONE_STAIRS.get(), blockTexture(Blocks.DRIPSTONE_BLOCK));
        stairsBlock((StairBlock) ModBlocks.QUARTZ_BRICK_STAIRS.get(), blockTexture(Blocks.QUARTZ_BRICKS));
        stairsBlock((StairBlock) ModBlocks.END_STONE_STAIRS.get(), blockTexture(Blocks.END_STONE));

        modWallBlock(ModBlocks.SMOOTH_STONE_WALL, blockVanillaBlockLoc(Blocks.SMOOTH_STONE));
        modWallBlock(ModBlocks.STONE_WALL, blockVanillaBlockLoc(Blocks.STONE));
        modWallBlock(ModBlocks.POLISHED_ANDESITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_ANDESITE));
        modWallBlock(ModBlocks.POLISHED_DIORITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_DIORITE));
        modWallBlock(ModBlocks.POLISHED_GRANITE_WALL, blockVanillaBlockLoc(Blocks.POLISHED_GRANITE));
        modWallBlock(ModBlocks.PRISMARINE_BRICK_WALL, blockVanillaBlockLoc(Blocks.PRISMARINE_BRICKS));
        modWallBlock(ModBlocks.DARK_PRISMARINE_WALL, blockVanillaBlockLoc(Blocks.DARK_PRISMARINE));
        modWallBlock(ModBlocks.PURPUR_WALL, blockVanillaBlockLoc(Blocks.PURPUR_BLOCK));
        modWallBlock(ModBlocks.TUFF_WALL, blockVanillaBlockLoc(Blocks.TUFF));
        modWallBlock(ModBlocks.CALCITE_WALL, blockVanillaBlockLoc(Blocks.CALCITE));
        modWallBlock(ModBlocks.DRIPSTONE_WALL, blockVanillaBlockLoc(Blocks.DRIPSTONE_BLOCK));
        modWallBlock(ModBlocks.QUARTZ_BRICK_WALL, blockVanillaBlockLoc(Blocks.QUARTZ_BRICKS));
        modWallBlock(ModBlocks.CUT_SANDSTONE_WALL, blockVanillaBlockLoc(Blocks.CUT_SANDSTONE));
        modWallBlock(ModBlocks.CUT_RED_SANDSTONE_WALL, blockVanillaBlockLoc(Blocks.CUT_RED_SANDSTONE));
        modWallBlock(ModBlocks.END_STONE_WALL, blockVanillaBlockLoc(Blocks.END_STONE));
    }
    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public void modWallBlock(RegistryObject<Block> block, ResourceLocation texture) {
        super.wallBlock((WallBlock) block.get(), texture);
        models().wallInventory(getName(block) + "_inventory", texture);
    }

    public String getName(Supplier<? extends Block> block) {
        return block.get().builtInRegistryHolder().key().location().getPath();
    }
    public ResourceLocation blockVanillaBlockLoc(Block block) {
        return new ResourceLocation("block/" + block.asItem().toString());
    }
}
