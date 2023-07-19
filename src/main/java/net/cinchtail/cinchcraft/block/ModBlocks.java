package net.cinchtail.cinchcraft.block;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.custom.*;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, Cinchcraft.MOD_ID);

    //Ores
    public static final RegistryObject<Block> RUBY_ORE = registerBlock("ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.EMERALD_ORE).strength(4f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_EMERALD_ORE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 2)));
    public static final RegistryObject<Block> NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 3)));
    public static final RegistryObject<Block> NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 3)));
    public static final RegistryObject<Block> NETHER_LAPIS_LAZULI_ORE = registerBlock("nether_lapis_lazuli_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(1, 5)));
    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = registerBlock("nether_redstone_ore",
            () -> new NetherRedStoneOreBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));
    public static final RegistryObject<Block> NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(1, 5)));
    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_GOLD_ORE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(2, 5)));


    //Miscellaneous Blocks
    public static final RegistryObject<Block> SMOOTH_STONE_STAIRS = registerBlock("smooth_stone_stairs",
            () -> new StairBlock(Blocks.SMOOTH_STONE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_STONE_WALL = registerBlock("smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STONE_WALL = registerBlock("stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_GRANITE_WALL = registerBlock("polished_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_ANDESITE_WALL = registerBlock("polished_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_DIORITE_WALL = registerBlock("polished_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PRISMARINE_BRICK_WALL = registerBlock("prismarine_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_PRISMARINE_WALL = registerBlock("dark_prismarine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_SANDSTONE_WALL = registerBlock("cut_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_SANDSTONE_STAIRS = registerBlock("cut_sandstone_stairs",
            () -> new StairBlock(Blocks.CUT_SANDSTONE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_RED_SANDSTONE_WALL = registerBlock("cut_red_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_RED_SANDSTONE_STAIRS = registerBlock("cut_red_sandstone_stairs",
            () -> new StairBlock(Blocks.CUT_RED_SANDSTONE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_WALL = registerBlock("smooth_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_WALL = registerBlock("smooth_red_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> QUARTZ_WALL = registerBlock("quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_WALL = registerBlock("smooth_quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PURPUR_WALL = registerBlock("purpur_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TUFF_STAIRS = registerBlock("tuff_stairs",
            () -> new StairBlock(Blocks.TUFF::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_SLAB = registerBlock("tuff_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_WALL = registerBlock("tuff_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> CALCITE_STAIRS = registerBlock("calcite_stairs",
            () -> new StairBlock(Blocks.CALCITE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_WALL = registerBlock("calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> DRIPSTONE_STAIRS = registerBlock("dripstone_stairs",
            () -> new StairBlock(Blocks.DRIPSTONE_BLOCK::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_SLAB = registerBlock("dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_WALL = registerBlock("dripstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> QUARTZ_BRICK_STAIRS = registerBlock("quartz_brick_stairs",
            () -> new StairBlock(Blocks.QUARTZ_BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> QUARTZ_BRICK_SLAB = registerBlock("quartz_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> QUARTZ_BRICK_WALL = registerBlock("quartz_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.0F, 9.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_STAIRS = registerBlock("end_stone_stairs",
            () -> new StairBlock(Blocks.END_STONE::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(3.0F, 9.0F)
                            .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_SLAB = registerBlock("end_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F, 9.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_WALL = registerBlock("end_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(3.0F, 9.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CARVED_MELON = BLOCKS.register("carved_melon",
            () -> new CarvedMelonBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN).strength(1f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLOCK_OF_RUBY = registerBlock("block_of_ruby",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RED_NETHER_BRICK_FENCE = registerBlock("red_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CHISELED_MUD_BRICKS = registerBlock("chiseled_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.5f).sound(SoundType.MUD_BRICKS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> GLOWSTONE_TORCH = BLOCKS.register("glowstone_torch",
            () -> new GlowStoneTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH)
                    .noOcclusion().sound(SoundType.WOOD).instabreak().lightLevel((blockState) -> 9).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> GLOWSTONE_WALL_TORCH = BLOCKS.register("glowstone_wall_torch",
            () -> new GlowStoneWallTorchBlock(BlockBehaviour.Properties.copy(Blocks.TORCH)
                    .noOcclusion().sound(SoundType.WOOD).instabreak().lightLevel((blockState) -> 9).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CRACKED_STONE_BRICK_STAIRS = registerBlock("cracked_stone_brick_stairs",
            () -> new StairBlock(Blocks.CRACKED_STONE_BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS).strength(1.5F, 6.0F)
                            .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_STONE_BRICK_SLAB = registerBlock("cracked_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS)
                    .strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_STONE_BRICK_WALL = registerBlock("cracked_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_STONE_BRICKS)
                    .strength(1.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICK_STAIRS = registerBlock("cracked_deepslate_brick_stairs",
            () -> new StairBlock(Blocks.CRACKED_DEEPSLATE_BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS).strength(3.5F, 6.0F)
                            .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICK_SLAB = registerBlock("cracked_deepslate_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)
                    .strength(3.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> CRACKED_DEEPSLATE_BRICK_WALL = registerBlock("cracked_deepslate_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_BRICKS)
                    .strength(3.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILE_STAIRS = registerBlock("cracked_deepslate_tile_stairs",
            () -> new StairBlock(Blocks.CRACKED_DEEPSLATE_TILES::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES).strength(3.5F, 6.0F)
                            .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILE_SLAB = registerBlock("cracked_deepslate_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)
                    .strength(3.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> CRACKED_DEEPSLATE_TILE_WALL = registerBlock("cracked_deepslate_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_DEEPSLATE_TILES)
                    .strength(3.5F, 6.0F).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS = registerBlock("cracked_polished_blackstone_brick_stairs",
            () -> new StairBlock(Blocks.CRACKED_POLISHED_BLACKSTONE_BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)
                            .requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB = registerBlock("cracked_polished_blackstone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> CRACKED_POLISHED_BLACKSTONE_BRICK_WALL = registerBlock("cracked_polished_blackstone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> CRACKED_NETHER_BRICK_STAIRS = registerBlock("cracked_nether_brick_stairs",
            () -> new StairBlock(Blocks.CRACKED_NETHER_BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS).requiresCorrectToolForDrops()
                            .strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_NETHER_BRICK_SLAB = registerBlock("cracked_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_NETHER_BRICK_WALL = registerBlock("cracked_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> SMOOTH_BASALT_STAIRS = registerBlock("smooth_basalt_stairs",
            () -> new StairBlock(Blocks.SMOOTH_BASALT::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.SMOOTH_BASALT).requiresCorrectToolForDrops()
                            .strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_SLAB = registerBlock("smooth_basalt_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_BASALT)
                    .requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> SMOOTH_BASALT_WALL = registerBlock("smooth_basalt_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.SMOOTH_BASALT)
                    .requiresCorrectToolForDrops().strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> POLISHED_DEEPSLATE_PRESSURE_PLATE = registerBlock("polished_deepslate_pressure_plate",
            () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING,
                    BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_PRESSURE_PLATE).sound(SoundType.POLISHED_DEEPSLATE), BlockSetType.STONE));
    public static final RegistryObject<Block> POLISHED_DEEPSLATE_BUTTON = registerBlock("polished_deepslate_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.POLISHED_BLACKSTONE_BUTTON).sound(SoundType.POLISHED_DEEPSLATE),
                    BlockSetType.STONE, 10, true));
    public static final RegistryObject<Block> IRON_BUTTON = registerBlock("iron_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.METAL),
                    BlockSetType.IRON, 10, true));
    public static final RegistryObject<Block> GOLD_BUTTON = registerBlock("gold_button",
            () -> new ButtonBlock(BlockBehaviour.Properties.copy(Blocks.STONE_BUTTON).sound(SoundType.METAL),
                    BlockSetType.GOLD, 10, true));



    //Plants
    public static final RegistryObject<Block> BUTTER_CUP = BLOCKS.register("butter_cup",
            () -> new FlowerBlock(MobEffects.DARKNESS, 6, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_BUTTER_CUP = BLOCKS.register("potted_butter_cup",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.BUTTER_CUP, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> SMALL_ROSE = BLOCKS.register("small_rose",
            () -> new FlowerBlock(MobEffects.HEALTH_BOOST, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_SMALL_ROSE = BLOCKS.register("potted_small_rose",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.SMALL_ROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> CROCUS = BLOCKS.register("crocus",
            () -> new CrocusFlowerBlock(MobEffects.INVISIBILITY, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_CROCUS = BLOCKS.register("potted_crocus",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.CROCUS, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BUBBLE_FLOWER = registerBlock("bubble_flower",
            () -> new BubbleFlowerBlock(MobEffects.LEVITATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<Block> ALYSSUM = BLOCKS.register("alyssum",
            () -> new AlyssumFlowerBlock(MobEffects.CONFUSION, 12, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_ALYSSUM = BLOCKS.register("potted_alyssum",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.ALYSSUM, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> LUPINE = BLOCKS.register("lupine",
            () -> new FlowerBlock(MobEffects.DOLPHINS_GRACE, 8, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_LUPINE = BLOCKS.register("potted_lupine",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.LUPINE, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> STAR_CACTUS = BLOCKS.register("star_cactus",
            () -> new SmallCactusBlock(BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_STAR_CACTUS = BLOCKS.register("potted_star_cactus",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.STAR_CACTUS, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> FIRE_FERN = BLOCKS.register("fire_fern",
            () -> new FireFernBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH).noCollission().instabreak()
                    .sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> STALK = BLOCKS.register("stalk",
            () -> new DoublePlantBlock(BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> CATTAILS = BLOCKS.register("cattails",
            () -> new Cattails(BlockBehaviour.Properties.copy(Blocks.LILAC).sound(SoundType.SMALL_DRIPLEAF)));


    //Crops
    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueBerryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)
                    .noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> PINEAPPLE_PLANT = BLOCKS.register("pineapple_plant",
            () -> new PineapplePlantBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)
                    .noOcclusion().sound(SoundType.CROP)));
    public static final RegistryObject<Block> STRAWBERRY_PLANT = BLOCKS.register("strawberry_plant",
            () -> new StrawberryPlantBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)
                    .noOcclusion().sound(SoundType.CROP)));
    public static final RegistryObject<Block> SUNFLOWER_CROP = BLOCKS.register("sunflower_crop",
            () -> new ModSunflowerCropBlock(BlockBehaviour.Properties.copy(Blocks.PITCHER_CROP)
                    .noOcclusion().sound(SoundType.GRASS)));
    public static final RegistryObject<Block> REEDS_CROP = BLOCKS.register("reeds_crop",
            () -> new ReedsCropBlock(BlockBehaviour.Properties.copy(Blocks.PITCHER_CROP)
                    .noOcclusion().sound(SoundType.SMALL_DRIPLEAF)));


    //New Block Sets
    public static final RegistryObject<Block> THATCH_BLOCK = BLOCKS.register("thatch_block",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)));
    public static final RegistryObject<Block> THATCH_STAIRS = BLOCKS.register("thatch_stairs",
            () -> new StairBlock(ModBlocks.THATCH_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.SPRUCE_STAIRS).strength(.5f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> THATCH_SLAB = BLOCKS.register("thatch_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.SPRUCE_SLAB)
                    .strength(.5f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> MOSSY_MUD_BRICKS = registerBlock("mossy_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.5f)
                    .sound(SoundType.MUD_BRICKS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_MUD_BRICK_STAIRS = registerBlock("mossy_mud_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.MOSSY_MUD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(1.5f)
                            .requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> MOSSY_MUD_BRICK_SLAB = registerBlock("mossy_mud_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> MOSSY_MUD_BRICK_WALL = registerBlock("mossy_mud_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1.5f).requiresCorrectToolForDrops().sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> POLISHED_TUFF = registerBlock("polished_tuff",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
                    .sound(SoundType.TUFF).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_TUFF_STAIRS = registerBlock("polished_tuff_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_TUFF.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
                            .requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF_SLAB = registerBlock("polished_tuff_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> POLISHED_TUFF_WALL = registerBlock("polished_tuff_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> POLISHED_CALCITE = registerBlock("polished_calcite",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(1f)
                    .sound(SoundType.CALCITE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_CALCITE_STAIRS = registerBlock("polished_calcite_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_CALCITE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(1f)
                            .requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_SLAB = registerBlock("polished_calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> POLISHED_CALCITE_WALL = registerBlock("polished_calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_BLOCK = registerBlock("polished_dripstone_block",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
                    .sound(SoundType.DRIPSTONE_BLOCK).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_STAIRS = registerBlock("polished_dripstone_stairs",
            () -> new StairBlock(() -> ModBlocks.POLISHED_DRIPSTONE_BLOCK.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
                            .requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_SLAB = registerBlock("polished_dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.STONE).strength(2f)
                    .requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> POLISHED_DRIPSTONE_WALL = registerBlock("polished_dripstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE = registerBlock("mossy_cobbled_deepslate",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).strength(3.5f)
                    .sound(SoundType.DEEPSLATE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE_STAIRS = registerBlock("mossy_cobbled_deepslate_stairs",
            () -> new StairBlock(() -> ModBlocks.MOSSY_COBBLED_DEEPSLATE.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE).strength(3.5f)
                            .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE_SLAB = registerBlock("mossy_cobbled_deepslate_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> MOSSY_COBBLED_DEEPSLATE_WALL = registerBlock("mossy_cobbled_deepslate_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.COBBLED_DEEPSLATE)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICKS = registerBlock("mossy_deepslate_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).strength(3.5f)
                    .sound(SoundType.DEEPSLATE_BRICKS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_STAIRS = registerBlock("mossy_deepslate_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.MOSSY_DEEPSLATE_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS).strength(3.5f)
                            .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_SLAB = registerBlock("mossy_deepslate_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_BRICK_WALL = registerBlock("mossy_deepslate_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_BRICKS)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_BRICKS)));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILES = registerBlock("mossy_deepslate_tiles",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES).strength(3.5f)
                    .sound(SoundType.DEEPSLATE_TILES).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILE_STAIRS = registerBlock("mossy_deepslate_tile_stairs",
            () -> new StairBlock(() -> ModBlocks.MOSSY_DEEPSLATE_TILES.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES).strength(3.5f)
                            .requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILE_SLAB = registerBlock("mossy_deepslate_tile_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> MOSSY_DEEPSLATE_TILE_WALL = registerBlock("mossy_deepslate_tile_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.DEEPSLATE_TILES)
                    .strength(3.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE_TILES)));
    public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICKS = registerBlock("cracked_red_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_NETHER_BRICKS).strength(2.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICK_STAIRS = registerBlock("cracked_red_nether_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.CRACKED_RED_NETHER_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS).requiresCorrectToolForDrops()
                            .strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICK_SLAB = registerBlock("cracked_red_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICK_WALL = registerBlock("cracked_red_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.CRACKED_NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_MUD_BRICKS = registerBlock("cracked_mud_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).strength(1.5f)
                    .sound(SoundType.MUD_BRICKS).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_MUD_BRICK_STAIRS = registerBlock("cracked_mud_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.CRACKED_MUD_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS).requiresCorrectToolForDrops()
                            .strength(1.5F, 3.0F).sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> CRACKED_MUD_BRICK_SLAB = registerBlock("cracked_mud_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS)
                    .requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> CRACKED_MUD_BRICK_WALL = registerBlock("cracked_mud_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.MUD_BRICKS)
                    .requiresCorrectToolForDrops().strength(1.5F, 3.0F).sound(SoundType.MUD_BRICKS)));
    public static final RegistryObject<Block> CRACKED_QUARTZ_BRICKS = registerBlock("cracked_quartz_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BRICKS).strength(0.8F)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_QUARTZ_BRICK_STAIRS = registerBlock("cracked_quartz_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.CRACKED_QUARTZ_BRICKS.get().defaultBlockState(),
                    BlockBehaviour.Properties.copy(Blocks.QUARTZ_BRICKS).requiresCorrectToolForDrops()
                            .strength(0.8F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_QUARTZ_BRICK_SLAB = registerBlock("cracked_quartz_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BRICKS)
                    .requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_QUARTZ_BRICK_WALL = registerBlock("cracked_quartz_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BRICKS)
                    .requiresCorrectToolForDrops().strength(0.8F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> MOSSY_NETHER_BRICKS = registerBlock("mossy_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).strength(2.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_STAIRS = registerBlock("mossy_nether_brick_stairs",
            () -> new StairBlock(Blocks.NETHER_BRICK_STAIRS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).requiresCorrectToolForDrops()
                            .strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_SLAB = registerBlock("mossy_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_WALL = registerBlock("mossy_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> MOSSY_NETHER_BRICK_FENCE = registerBlock("mossy_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICKS = registerBlock("crimson_mossy_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).strength(2.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_STAIRS = registerBlock("crimson_mossy_nether_brick_stairs",
            () -> new StairBlock(Blocks.NETHER_BRICK_STAIRS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).requiresCorrectToolForDrops()
                            .strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_SLAB = registerBlock("crimson_mossy_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_WALL = registerBlock("crimson_mossy_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRIMSON_MOSSY_NETHER_BRICK_FENCE = registerBlock("crimson_mossy_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICKS = registerBlock("warped_mossy_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).strength(2.0F, 6.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_STAIRS = registerBlock("warped_mossy_nether_brick_stairs",
            () -> new StairBlock(Blocks.NETHER_BRICK_STAIRS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS).requiresCorrectToolForDrops()
                            .strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_SLAB = registerBlock("warped_mossy_nether_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_WALL = registerBlock("warped_mossy_nether_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> WARPED_MOSSY_NETHER_BRICK_FENCE = registerBlock("warped_mossy_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.copy(Blocks.NETHER_BRICKS)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_BRICKS = registerBlock("cracked_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.BRICKS).instrument(NoteBlockInstrument.BASEDRUM).strength(2.0F, 6.0F)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_BRICK_STAIRS = registerBlock("cracked_brick_stairs",
            () -> new StairBlock(Blocks.BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.BRICKS).requiresCorrectToolForDrops()
                            .strength(2.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_BRICK_SLAB = registerBlock("cracked_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_BRICK_WALL = registerBlock("cracked_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS)
                    .requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_PRISMARINE_BRICKS = registerBlock("cracked_prismarine_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS).instrument(NoteBlockInstrument.BASEDRUM).strength(1.5F, 6.0F)
                    .sound(SoundType.STONE).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CRACKED_PRISMARINE_BRICK_STAIRS = registerBlock("cracked_prismarine_brick_stairs",
            () -> new StairBlock(Blocks.PRISMARINE_BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS).requiresCorrectToolForDrops()
                            .strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_PRISMARINE_BRICK_SLAB = registerBlock("cracked_prismarine_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_PRISMARINE_BRICK_WALL = registerBlock("cracked_prismarine_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.PRISMARINE_BRICKS)
                    .requiresCorrectToolForDrops().strength(1.5F, 6.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_END_STONE_BRICKS = registerBlock("cracked_end_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS).instrument(NoteBlockInstrument.BASEDRUM)
                    .requiresCorrectToolForDrops().strength(3.0F, 9.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_END_STONE_BRICK_STAIRS = registerBlock("cracked_end_stone_brick_stairs",
            () -> new StairBlock(Blocks.END_STONE_BRICKS::defaultBlockState,
                    BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS).requiresCorrectToolForDrops()
                            .strength(3.0F, 9.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_END_STONE_BRICK_SLAB = registerBlock("cracked_end_stone_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS)
                    .requiresCorrectToolForDrops().strength(3.0F, 9.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> CRACKED_END_STONE_BRICK_WALL = registerBlock("cracked_end_stone_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.copy(Blocks.END_STONE_BRICKS)
                    .requiresCorrectToolForDrops().strength(3.0F, 9.0F).sound(SoundType.STONE)));



    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, RegistryObject<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
