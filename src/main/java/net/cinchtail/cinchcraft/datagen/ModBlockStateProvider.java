package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.*;
import net.minecraftforge.client.model.generators.BlockModelBuilder;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ModelFile;
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
        blockWithItem(CRACKED_TUFF_BRICKS);

        vanillaSlabBlock(CALCITE_SLAB, Blocks.CALCITE);
        vanillaSlabBlock(DRIPSTONE_SLAB, Blocks.DRIPSTONE_BLOCK);
        vanillaSlabBlock(QUARTZ_BRICK_SLAB, Blocks.QUARTZ_BRICKS);
        vanillaSlabBlock(END_STONE_SLAB, Blocks.END_STONE);
        modSlabBlock(MOSSY_MUD_BRICK_SLAB, MOSSY_MUD_BRICKS);
        modSlabBlock(POLISHED_CALCITE_SLAB, POLISHED_CALCITE);
        modSlabBlock(POLISHED_DRIPSTONE_SLAB, POLISHED_DRIPSTONE_BLOCK);
        modSlabBlock(MOSSY_COBBLED_DEEPSLATE_SLAB, MOSSY_COBBLED_DEEPSLATE);
        modSlabBlock(MOSSY_DEEPSLATE_BRICK_SLAB, MOSSY_DEEPSLATE_BRICKS);
        modSlabBlock(MOSSY_DEEPSLATE_TILE_SLAB, MOSSY_DEEPSLATE_TILES);
        vanillaSlabBlock(CRACKED_STONE_BRICK_SLAB, Blocks.CRACKED_STONE_BRICKS);
        vanillaSlabBlock(CRACKED_DEEPSLATE_BRICK_SLAB, Blocks.CRACKED_DEEPSLATE_BRICKS);
        vanillaSlabBlock(CRACKED_DEEPSLATE_TILE_SLAB, Blocks.CRACKED_DEEPSLATE_TILES);
        vanillaSlabBlock(CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        vanillaSlabBlock(CRACKED_NETHER_BRICK_SLAB, Blocks.CRACKED_NETHER_BRICKS);
        modSlabBlock(CRACKED_RED_NETHER_BRICK_SLAB, CRACKED_RED_NETHER_BRICKS);
        modSlabBlock(CRACKED_MUD_BRICK_SLAB, CRACKED_MUD_BRICKS);
        modSlabBlock(CRACKED_QUARTZ_BRICK_SLAB, CRACKED_QUARTZ_BRICKS);
        vanillaSlabBlock(SMOOTH_BASALT_SLAB, Blocks.SMOOTH_BASALT);
        modSlabBlock(MOSSY_NETHER_BRICK_SLAB, MOSSY_NETHER_BRICKS);
        modSlabBlock(CRIMSON_MOSSY_NETHER_BRICK_SLAB, CRIMSON_MOSSY_NETHER_BRICKS);
        modSlabBlock(WARPED_MOSSY_NETHER_BRICK_SLAB, WARPED_MOSSY_NETHER_BRICKS);
        modSlabBlock(CRACKED_BRICK_SLAB, CRACKED_BRICKS);
        modSlabBlock(CRACKED_PRISMARINE_BRICK_SLAB, CRACKED_PRISMARINE_BRICKS);
        modSlabBlock(CRACKED_END_STONE_BRICK_SLAB, CRACKED_END_STONE_BRICKS);
        modSlabBlock(AZALEA_SLAB, AZALEA_PLANKS);
        modSlabBlock(MOSSY_BRICK_SLAB, MOSSY_BRICKS);
        modSlabBlock(MOSSY_QUARTZ_BRICK_SLAB, MOSSY_QUARTZ_BRICKS);
        modSlabBlock(CRACKED_TUFF_BRICK_SLAB, CRACKED_TUFF_BRICKS);

        vanillaStairsBlock(SMOOTH_STONE_STAIRS, Blocks.SMOOTH_STONE);
        vanillaStairsBlock(CALCITE_STAIRS, Blocks.CALCITE);
        vanillaStairsBlock(DRIPSTONE_STAIRS, Blocks.DRIPSTONE_BLOCK);
        vanillaStairsBlock(QUARTZ_BRICK_STAIRS, Blocks.QUARTZ_BRICKS);
        vanillaStairsBlock(END_STONE_STAIRS, Blocks.END_STONE);
        modStairsBlock(MOSSY_MUD_BRICK_STAIRS, MOSSY_MUD_BRICKS);
        modStairsBlock(POLISHED_CALCITE_STAIRS, POLISHED_CALCITE);
        modStairsBlock(POLISHED_DRIPSTONE_STAIRS, POLISHED_DRIPSTONE_BLOCK);
        modStairsBlock(MOSSY_COBBLED_DEEPSLATE_STAIRS, MOSSY_COBBLED_DEEPSLATE);
        modStairsBlock(MOSSY_DEEPSLATE_BRICK_STAIRS, MOSSY_DEEPSLATE_BRICKS);
        modStairsBlock(MOSSY_DEEPSLATE_TILE_STAIRS, MOSSY_DEEPSLATE_TILES);
        vanillaStairsBlock(CRACKED_STONE_BRICK_STAIRS, Blocks.CRACKED_STONE_BRICKS);
        vanillaStairsBlock(CRACKED_DEEPSLATE_BRICK_STAIRS, Blocks.CRACKED_DEEPSLATE_BRICKS);
        vanillaStairsBlock( CRACKED_DEEPSLATE_TILE_STAIRS, Blocks.CRACKED_DEEPSLATE_TILES);
        vanillaStairsBlock(CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        vanillaStairsBlock(CRACKED_NETHER_BRICK_STAIRS, Blocks.CRACKED_NETHER_BRICKS);
        modStairsBlock(CRACKED_RED_NETHER_BRICK_STAIRS, CRACKED_RED_NETHER_BRICKS);
        modStairsBlock(CRACKED_MUD_BRICK_STAIRS, CRACKED_MUD_BRICKS);
        modStairsBlock(CRACKED_QUARTZ_BRICK_STAIRS, CRACKED_QUARTZ_BRICKS);
        vanillaStairsBlock(SMOOTH_BASALT_STAIRS, Blocks.SMOOTH_BASALT);
        modStairsBlock(MOSSY_NETHER_BRICK_STAIRS, MOSSY_NETHER_BRICKS);
        modStairsBlock(CRIMSON_MOSSY_NETHER_BRICK_STAIRS, CRIMSON_MOSSY_NETHER_BRICKS);
        modStairsBlock(WARPED_MOSSY_NETHER_BRICK_STAIRS, WARPED_MOSSY_NETHER_BRICKS);
        modStairsBlock(CRACKED_BRICK_STAIRS, CRACKED_BRICKS);
        modStairsBlock(CRACKED_PRISMARINE_BRICK_STAIRS, CRACKED_PRISMARINE_BRICKS);
        modStairsBlock(CRACKED_END_STONE_BRICK_STAIRS, CRACKED_END_STONE_BRICKS);
        modStairsBlock(AZALEA_STAIRS, AZALEA_PLANKS);
        modStairsBlock(MOSSY_BRICK_STAIRS, MOSSY_BRICKS);
        modStairsBlock(MOSSY_QUARTZ_BRICK_STAIRS, MOSSY_QUARTZ_BRICKS);
        modStairsBlock(CRACKED_TUFF_BRICK_STAIRS, CRACKED_TUFF_BRICKS);


        vanillaWallBlock(SMOOTH_STONE_WALL, Blocks.SMOOTH_STONE);
        vanillaWallBlock(STONE_WALL, Blocks.STONE);
        vanillaWallBlock(POLISHED_ANDESITE_WALL, Blocks.POLISHED_ANDESITE);
        vanillaWallBlock(POLISHED_DIORITE_WALL, Blocks.POLISHED_DIORITE);
        vanillaWallBlock(POLISHED_GRANITE_WALL, Blocks.POLISHED_GRANITE);
        vanillaWallBlock(PRISMARINE_BRICK_WALL, Blocks.PRISMARINE_BRICKS);
        vanillaWallBlock(DARK_PRISMARINE_WALL, Blocks.DARK_PRISMARINE);
        vanillaWallBlock(PURPUR_WALL, Blocks.PURPUR_BLOCK);
        vanillaWallBlock(CALCITE_WALL, Blocks.CALCITE);
        vanillaWallBlock(DRIPSTONE_WALL, Blocks.DRIPSTONE_BLOCK);
        vanillaWallBlock(QUARTZ_BRICK_WALL, Blocks.QUARTZ_BRICKS);
        vanillaWallBlock(CUT_SANDSTONE_WALL, Blocks.CUT_SANDSTONE);
        vanillaWallBlock(CUT_RED_SANDSTONE_WALL, Blocks.CUT_RED_SANDSTONE);
        vanillaWallBlock(END_STONE_WALL, Blocks.END_STONE);
        vanillaWallBlock(CRACKED_STONE_BRICK_WALL, Blocks.CRACKED_STONE_BRICKS);
        vanillaWallBlock(CRACKED_DEEPSLATE_BRICK_WALL, Blocks.CRACKED_DEEPSLATE_BRICKS);
        vanillaWallBlock(CRACKED_DEEPSLATE_TILE_WALL, Blocks.CRACKED_DEEPSLATE_TILES);
        vanillaWallBlock(CRACKED_POLISHED_BLACKSTONE_BRICK_WALL, Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS);
        vanillaWallBlock(CRACKED_NETHER_BRICK_WALL, Blocks.CRACKED_NETHER_BRICKS);
        vanillaWallBlock(SMOOTH_BASALT_WALL, Blocks.SMOOTH_BASALT);
        vanillaWallBlock(DEEPSLATE_WALL, Blocks.DEEPSLATE);
        modWallBlock(MOSSY_MUD_BRICK_WALL, MOSSY_MUD_BRICKS);
        modWallBlock(POLISHED_CALCITE_WALL, POLISHED_CALCITE);
        modWallBlock(POLISHED_DRIPSTONE_WALL, POLISHED_DRIPSTONE_BLOCK);
        modWallBlock(MOSSY_COBBLED_DEEPSLATE_WALL, MOSSY_COBBLED_DEEPSLATE);
        modWallBlock(MOSSY_DEEPSLATE_BRICK_WALL, MOSSY_DEEPSLATE_BRICKS);
        modWallBlock(MOSSY_DEEPSLATE_TILE_WALL, MOSSY_DEEPSLATE_TILES);
        modWallBlock(CRACKED_RED_NETHER_BRICK_WALL, CRACKED_RED_NETHER_BRICKS);
        modWallBlock(CRACKED_MUD_BRICK_WALL, CRACKED_MUD_BRICKS);
        modWallBlock(CRACKED_QUARTZ_BRICK_WALL, CRACKED_QUARTZ_BRICKS);
        modWallBlock(MOSSY_NETHER_BRICK_WALL, MOSSY_NETHER_BRICKS);
        modWallBlock(CRIMSON_MOSSY_NETHER_BRICK_WALL, CRIMSON_MOSSY_NETHER_BRICKS);
        modWallBlock(WARPED_MOSSY_NETHER_BRICK_WALL, WARPED_MOSSY_NETHER_BRICKS);
        modWallBlock(CRACKED_BRICK_WALL, CRACKED_BRICKS);
        modWallBlock(CRACKED_PRISMARINE_BRICK_WALL, CRACKED_PRISMARINE_BRICKS);
        modWallBlock(CRACKED_END_STONE_BRICK_WALL, CRACKED_END_STONE_BRICKS);
        modWallBlock(MOSSY_BRICK_WALL, MOSSY_BRICKS);
        modWallBlock(MOSSY_QUARTZ_BRICK_WALL, MOSSY_QUARTZ_BRICKS);
        modWallBlock(CRACKED_TUFF_BRICK_WALL, CRACKED_TUFF_BRICKS);


        vanillaFenceBlock(RED_NETHER_BRICK_FENCE, Blocks.RED_NETHER_BRICKS);
        vanillaFenceBlock(CRACKED_NETHER_BRICK_FENCE, Blocks.CRACKED_NETHER_BRICKS);
        modFenceBlock(MOSSY_NETHER_BRICK_FENCE, MOSSY_NETHER_BRICKS);
        modFenceBlock(CRIMSON_MOSSY_NETHER_BRICK_FENCE, CRIMSON_MOSSY_NETHER_BRICKS);
        modFenceBlock(WARPED_MOSSY_NETHER_BRICK_FENCE, WARPED_MOSSY_NETHER_BRICKS);
        modFenceBlock(AZALEA_FENCE, AZALEA_PLANKS);
        modFenceBlock(CRACKED_RED_NETHER_BRICK_FENCE, CRACKED_RED_NETHER_BRICKS);

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
    private void blockItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("cinchcraft:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath()));
    }
    public void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
    public void vanillaStairsBlock(RegistryObject<Block> block, Block texture) {
        simpleBlockItem(block.get(), models().withExistingParent((block.get()).asItem().toString(), blockTexture(block)));
        stairsBlock((StairBlock) block.get(), blockTexture(texture));
    }
    public void modStairsBlock(RegistryObject<Block> block, RegistryObject<Block> texture) {
        simpleBlockItem(block.get(), models().withExistingParent((block.get()).asItem().toString(), blockTexture(block)));
        stairsBlock((StairBlock) block.get(), blockTexture(texture));
    }
    public void vanillaSlabBlock(RegistryObject<Block> block, Block texture) {
        simpleBlockItem(block.get(), models().withExistingParent((block.get()).asItem().toString(), blockTexture(block)));
        slabBlock((SlabBlock)block.get(), block.getId(), blockTexture(texture));
    }
    public void modSlabBlock(RegistryObject<Block> block, RegistryObject<Block> texture) {
        simpleBlockItem(block.get(), models().withExistingParent((block.get()).asItem().toString(), blockTexture(block)));
        slabBlock((SlabBlock)block.get(), texture.getId(), blockTexture(texture));
    }
    public void vanillaFenceBlock(RegistryObject<Block> block, Block texture) {
        simpleBlockItem(block.get(), models().fenceInventory(key(block).toString(), blockTexture(texture)));
        fenceBlock((FenceBlock) block.get(), blockTexture(texture));
    }
    public void modFenceBlock(RegistryObject<Block> block, RegistryObject<Block> texture) {
        simpleBlockItem(block.get(), models().fenceInventory(key(block).toString(), blockTexture(texture)));
        fenceBlock((FenceBlock) block.get(), blockTexture(texture));
    }
    private void trapDoorBlockItem(RegistryObject<Block> blockRegistryObject, String appendix) {
        simpleBlockItem(blockRegistryObject.get(), new ModelFile.UncheckedModelFile("cinchcraft:block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get())).getPath() + appendix));
    }
    public void vanillaWallBlock(RegistryObject<Block> block, Block texture) {
        simpleBlockItem(block.get(), models().wallInventory(key(block).toString(), blockTexture(texture)));
        wallBlock((WallBlock) block.get(), blockTexture(texture));
    }
    public void modWallBlock(RegistryObject<Block> block, RegistryObject<Block> texture) {
        simpleBlockItem(block.get(), models().wallInventory(key(block).toString(), blockTexture(texture)));
        wallBlock((WallBlock) block.get(), blockTexture(texture));
    }
    public String getName(Supplier<? extends Block> block) {
        return block.get().builtInRegistryHolder().key().location().getPath();
    }
    public ResourceLocation blockLoc(Supplier<? extends Block> block) {
        return ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/" + getName(block));
    }
    public ResourceLocation blockTexture(RegistryObject<Block> block) {
        ResourceLocation name = key(block);
        return ResourceLocation.fromNamespaceAndPath(name.getNamespace(), ModItemModelProvider.BLOCK_FOLDER + "/" + name.getPath());
    }
    private ResourceLocation key(RegistryObject<Block> block) {
        return ForgeRegistries.BLOCKS.getKey(block.get());
    }
    private ResourceLocation key(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block);
    }
}
