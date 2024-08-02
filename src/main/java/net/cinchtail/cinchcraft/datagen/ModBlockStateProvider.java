package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;
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
        blockWithItem(CRACKED_QUARTZ_BRICKS);
        blockWithItem(MOSSY_NETHER_BRICKS);
        blockWithItem(CRIMSON_MOSSY_NETHER_BRICKS);
        blockWithItem(WARPED_MOSSY_NETHER_BRICKS);
        blockWithItem(CRACKED_BRICKS);
        blockWithItem(CRACKED_PRISMARINE_BRICKS);
        blockWithItem(CRACKED_END_STONE_BRICKS);
        blockWithItem(AZALEA_PLANKS);
        blockWithItem(MOSSY_BRICKS);
        blockWithItem(MOSSY_QUARTZ_BRICKS);

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
        slabBlock((SlabBlock) CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get(), blockTexture(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS),
                blockTexture(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
        slabBlock((SlabBlock) CRACKED_NETHER_BRICK_SLAB.get(), blockTexture(Blocks.CRACKED_NETHER_BRICKS),
                blockTexture(Blocks.CRACKED_NETHER_BRICKS));
        slabBlock((SlabBlock) CRACKED_RED_NETHER_BRICK_SLAB.get(), blockLoc(CRACKED_RED_NETHER_BRICKS),
                blockLoc(CRACKED_RED_NETHER_BRICKS));
        slabBlock((SlabBlock) CRACKED_MUD_BRICK_SLAB.get(), blockLoc(CRACKED_MUD_BRICKS),
                blockLoc(CRACKED_MUD_BRICKS));
        slabBlock((SlabBlock) CRACKED_QUARTZ_BRICK_SLAB.get(), blockLoc(CRACKED_QUARTZ_BRICKS),
                blockLoc(CRACKED_QUARTZ_BRICKS));
        slabBlock((SlabBlock) SMOOTH_BASALT_SLAB.get(), blockTexture(Blocks.SMOOTH_BASALT),
                blockTexture(Blocks.SMOOTH_BASALT));
        slabBlock((SlabBlock) MOSSY_NETHER_BRICK_SLAB.get(), blockLoc(MOSSY_NETHER_BRICKS),
                blockLoc(MOSSY_NETHER_BRICKS));
        slabBlock((SlabBlock) CRIMSON_MOSSY_NETHER_BRICK_SLAB.get(), blockLoc(CRIMSON_MOSSY_NETHER_BRICKS),
                blockLoc(CRIMSON_MOSSY_NETHER_BRICKS));
        slabBlock((SlabBlock) WARPED_MOSSY_NETHER_BRICK_SLAB.get(), blockLoc(WARPED_MOSSY_NETHER_BRICKS),
                blockLoc(WARPED_MOSSY_NETHER_BRICKS));
        slabBlock((SlabBlock) CRACKED_BRICK_SLAB.get(), blockLoc(CRACKED_BRICKS),
                blockLoc(CRACKED_BRICKS));
        slabBlock((SlabBlock) CRACKED_PRISMARINE_BRICK_SLAB.get(), blockLoc(CRACKED_PRISMARINE_BRICKS),
                blockLoc(CRACKED_PRISMARINE_BRICKS));
        slabBlock((SlabBlock) CRACKED_END_STONE_BRICK_SLAB.get(), blockLoc(CRACKED_END_STONE_BRICKS),
                blockLoc(CRACKED_END_STONE_BRICKS));
        slabBlock((SlabBlock) AZALEA_SLAB.get(), blockLoc(AZALEA_PLANKS),
                blockLoc(AZALEA_PLANKS));
        slabBlock((SlabBlock) MOSSY_BRICK_SLAB.get(), blockLoc(MOSSY_BRICKS),
                blockLoc(MOSSY_BRICKS));
        slabBlock((SlabBlock) MOSSY_QUARTZ_BRICK_SLAB.get(), blockLoc(MOSSY_QUARTZ_BRICKS),
                blockLoc(MOSSY_QUARTZ_BRICKS));

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
        stairsBlock((StairBlock) CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get(), blockTexture(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
        stairsBlock((StairBlock) CRACKED_NETHER_BRICK_STAIRS.get(), blockTexture(Blocks.CRACKED_NETHER_BRICKS));
        stairsBlock((StairBlock) CRACKED_RED_NETHER_BRICK_STAIRS.get(), blockLoc(CRACKED_RED_NETHER_BRICKS));
        stairsBlock((StairBlock) CRACKED_MUD_BRICK_STAIRS.get(), blockLoc(CRACKED_MUD_BRICKS));
        stairsBlock((StairBlock) CRACKED_QUARTZ_BRICK_STAIRS.get(), blockLoc(CRACKED_QUARTZ_BRICKS));
        stairsBlock((StairBlock) SMOOTH_BASALT_STAIRS.get(), blockTexture(Blocks.SMOOTH_BASALT));
        stairsBlock((StairBlock) MOSSY_NETHER_BRICK_STAIRS.get(), blockLoc(MOSSY_NETHER_BRICKS));
        stairsBlock((StairBlock) CRIMSON_MOSSY_NETHER_BRICK_STAIRS.get(), blockLoc(CRIMSON_MOSSY_NETHER_BRICKS));
        stairsBlock((StairBlock) WARPED_MOSSY_NETHER_BRICK_STAIRS.get(), blockLoc(WARPED_MOSSY_NETHER_BRICKS));
        stairsBlock((StairBlock) CRACKED_BRICK_STAIRS.get(), blockLoc(CRACKED_BRICKS));
        stairsBlock((StairBlock) CRACKED_PRISMARINE_BRICK_STAIRS.get(), blockLoc(CRACKED_PRISMARINE_BRICKS));
        stairsBlock((StairBlock) CRACKED_END_STONE_BRICK_STAIRS.get(), blockLoc(CRACKED_END_STONE_BRICKS));
        stairsBlock((StairBlock) AZALEA_STAIRS.get(), blockLoc(AZALEA_PLANKS));
        stairsBlock((StairBlock) MOSSY_BRICK_STAIRS.get(), blockLoc(MOSSY_BRICKS));
        stairsBlock((StairBlock) MOSSY_QUARTZ_BRICK_STAIRS.get(), blockLoc(MOSSY_QUARTZ_BRICKS));


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
        vanillaWallBlock(CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, blockVanillaBlockLoc(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS));
        vanillaWallBlock(CRACKED_NETHER_BRICK_WALL, blockVanillaBlockLoc(Blocks.CRACKED_NETHER_BRICKS));
        vanillaWallBlock(SMOOTH_BASALT_WALL, blockVanillaBlockLoc(Blocks.SMOOTH_BASALT));
        vanillaWallBlock(DEEPSLATE_WALL, blockVanillaBlockLoc(Blocks.DEEPSLATE));
        modWallBlock(MOSSY_MUD_BRICK_WALL, blockLoc(MOSSY_MUD_BRICKS));
        modWallBlock(POLISHED_TUFF_WALL, blockLoc(POLISHED_TUFF));
        modWallBlock(POLISHED_CALCITE_WALL, blockLoc(POLISHED_CALCITE));
        modWallBlock(POLISHED_DRIPSTONE_WALL, blockLoc(POLISHED_DRIPSTONE_BLOCK));
        modWallBlock(MOSSY_COBBLED_DEEPSLATE_WALL, blockLoc(MOSSY_COBBLED_DEEPSLATE));
        modWallBlock(MOSSY_DEEPSLATE_BRICK_WALL, blockLoc(MOSSY_DEEPSLATE_BRICKS));
        modWallBlock(MOSSY_DEEPSLATE_TILE_WALL, blockLoc(MOSSY_DEEPSLATE_TILES));
        modWallBlock(CRACKED_RED_NETHER_BRICK_WALL, blockLoc(CRACKED_RED_NETHER_BRICKS));
        modWallBlock(CRACKED_MUD_BRICK_WALL, blockLoc(CRACKED_MUD_BRICKS));
        modWallBlock(CRACKED_QUARTZ_BRICK_WALL, blockLoc(CRACKED_QUARTZ_BRICKS));
        modWallBlock(MOSSY_NETHER_BRICK_WALL, blockLoc(MOSSY_NETHER_BRICKS));
        modWallBlock(CRIMSON_MOSSY_NETHER_BRICK_WALL, blockLoc(CRIMSON_MOSSY_NETHER_BRICKS));
        modWallBlock(WARPED_MOSSY_NETHER_BRICK_WALL, blockLoc(WARPED_MOSSY_NETHER_BRICKS));
        modWallBlock(CRACKED_BRICK_WALL, blockLoc(CRACKED_BRICKS));
        modWallBlock(CRACKED_PRISMARINE_BRICK_WALL, blockLoc(CRACKED_PRISMARINE_BRICKS));
        modWallBlock(CRACKED_END_STONE_BRICK_WALL, blockLoc(CRACKED_END_STONE_BRICKS));
        modWallBlock(MOSSY_BRICK_WALL, blockLoc(MOSSY_BRICKS));
        modWallBlock(MOSSY_QUARTZ_BRICK_WALL, blockLoc(MOSSY_QUARTZ_BRICKS));


        vanillaFenceBlock((FenceBlock) RED_NETHER_BRICK_FENCE.get(), blockVanillaBlockLoc(Blocks.RED_NETHER_BRICKS));
        vanillaFenceBlock((FenceBlock) CRACKED_NETHER_BRICK_FENCE.get(), blockVanillaBlockLoc(Blocks.CRACKED_NETHER_BRICKS));
        fenceBlock((FenceBlock) MOSSY_NETHER_BRICK_FENCE.get(), blockLoc(MOSSY_NETHER_BRICKS));
        fenceBlock((FenceBlock) CRIMSON_MOSSY_NETHER_BRICK_FENCE.get(), blockLoc(CRIMSON_MOSSY_NETHER_BRICKS));
        fenceBlock((FenceBlock) WARPED_MOSSY_NETHER_BRICK_FENCE.get(), blockLoc(WARPED_MOSSY_NETHER_BRICKS));
        fenceBlock((FenceBlock) AZALEA_FENCE.get(), blockLoc(AZALEA_PLANKS));
        fenceBlock((FenceBlock) CRACKED_RED_NETHER_BRICK_FENCE.get(), blockLoc(CRACKED_RED_NETHER_BRICKS));

        fenceGateBlock((FenceGateBlock) AZALEA_FENCE_GATE.get(), blockLoc(AZALEA_PLANKS));


        buttonBlock((ButtonBlock) POLISHED_DEEPSLATE_BUTTON.get(), blockTexture(Blocks.POLISHED_DEEPSLATE));
        buttonBlock((ButtonBlock) IRON_BUTTON.get(), blockTexture(Blocks.IRON_BLOCK));
        buttonBlock((ButtonBlock) GOLD_BUTTON.get(), blockTexture(Blocks.GOLD_BLOCK));
        buttonBlock((ButtonBlock) AZALEA_BUTTON.get(), blockLoc(AZALEA_PLANKS));


        pressurePlateBlock((PressurePlateBlock) POLISHED_DEEPSLATE_PRESSURE_PLATE.get(), blockTexture(Blocks.POLISHED_DEEPSLATE));
        pressurePlateBlock((PressurePlateBlock) AZALEA_PRESSURE_PLATE.get(), blockLoc(AZALEA_PLANKS));


        logBlock(((RotatedPillarBlock) AZALEA_LOG.get()));
        axisBlock(((RotatedPillarBlock) AZALEA_WOOD.get()), blockTexture(AZALEA_LOG.get()), blockTexture(AZALEA_LOG.get()));
        axisBlock((RotatedPillarBlock) STRIPPED_AZALEA_LOG.get(), ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/stripped_azalea_log"),
                ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/stripped_azalea_log_top"));
        axisBlock((RotatedPillarBlock) STRIPPED_AZALEA_WOOD.get(), ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/stripped_azalea_log"),
                ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/stripped_azalea_log"));


        signBlock(((StandingSignBlock) AZALEA_SIGN.get()), ((WallSignBlock) ModBlocks.AZALEA_WALL_SIGN.get()),
                blockTexture(ModBlocks.AZALEA_PLANKS.get()));

        doorBlockWithRenderType((DoorBlock) AZALEA_DOOR.get(), modLoc("block/azalea_door_bottom"), modLoc("block/azalea_door_top"), "cutout");
        trapdoorBlockWithRenderType((TrapDoorBlock) AZALEA_TRAPDOOR.get(), modLoc("block/azalea_trapdoor"), true, "cutout");


        blockItem(AZALEA_PRESSURE_PLATE);
        blockItem(POLISHED_DEEPSLATE_PRESSURE_PLATE);
        blockItem(AZALEA_LOG);
        blockItem(AZALEA_WOOD);
        blockItem(STRIPPED_AZALEA_LOG);
        blockItem(STRIPPED_AZALEA_WOOD);
        blockItem(AZALEA_FENCE_GATE);
        trapDoorBlockItem(AZALEA_TRAPDOOR, "_bottom");


    }
    private void trapDoorBlockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("cinchcraft:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath() + appendix));
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
    public void vanillaFenceBlock(FenceBlock block, ResourceLocation texture) {
        super.fenceBlock( block, texture);
        String baseName = key(block).toString();
        fourWayBlock(block,
                models().fencePost(baseName + "_post", texture),
                models().fenceSide(baseName + "_side", texture),
                models().fenceInventory(baseName + "_inventory", texture));
    }
    private void fourWayBlock(FenceBlock block, BlockModelBuilder fencePost, BlockModelBuilder fenceSide, BlockModelBuilder fenceInventory) {
    }
    public String getName(Supplier<? extends Block> block) {
        return block.get().builtInRegistryHolder().key().location().getPath();
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
    public ResourceLocation blockVanillaBlockLoc(Block block) {
        return ResourceLocation.parse("block/" + block.asItem());
    }
    public ResourceLocation blockLoc(Supplier<? extends Block> block) {
        return ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/" + getName(block));
    }
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("cinchcraft:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
    }
}
