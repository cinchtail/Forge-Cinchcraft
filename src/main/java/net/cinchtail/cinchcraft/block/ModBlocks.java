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
import net.minecraft.world.level.material.Material;
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
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops(),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> DEEPSLATE_RUBY_ORE = registerBlock("deepslate_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(4f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE),
                    UniformInt.of(3, 7)));
    public static final RegistryObject<Block> NETHER_COAL_ORE = registerBlock("nether_coal_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 2)));
    public static final RegistryObject<Block> NETHER_IRON_ORE = registerBlock("nether_iron_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 3)));
    public static final RegistryObject<Block> NETHER_COPPER_ORE = registerBlock("nether_copper_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(0, 3)));
    public static final RegistryObject<Block> NETHER_LAPIS_LAZULI_ORE = registerBlock("nether_lapis_lazuli_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(1, 5)));
    public static final RegistryObject<Block> NETHER_REDSTONE_ORE = registerBlock("nether_redstone_ore",
            () -> new NetherRedStoneOreBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE)));
    public static final RegistryObject<Block> NETHER_RUBY_ORE = registerBlock("nether_ruby_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(1, 5)));
    public static final RegistryObject<Block> NETHER_DIAMOND_ORE = registerBlock("nether_diamond_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(2, 5)));
    public static final RegistryObject<Block> NETHER_EMERALD_ORE = registerBlock("nether_emerald_ore",
            () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.NETHER_GOLD_ORE),
                    UniformInt.of(2, 5)));


    //Miscellaneous Blocks
    public static final RegistryObject<Block> SMOOTH_STONE_STAIRS = registerBlock("smooth_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_STONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_STONE_WALL = registerBlock("smooth_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> STONE_WALL = registerBlock("stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_GRANITE_WALL = registerBlock("polished_granite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_ANDESITE_WALL = registerBlock("polished_andesite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_DIORITE_WALL = registerBlock("polished_diorite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PRISMARINE_BRICK_WALL = registerBlock("prismarine_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> DARK_PRISMARINE_WALL = registerBlock("dark_prismarine_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_SANDSTONE_WALL = registerBlock("cut_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_SANDSTONE_STAIRS = registerBlock("cut_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_RED_SANDSTONE_WALL = registerBlock("cut_red_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_RED_SANDSTONE_STAIRS = registerBlock("cut_red_sandstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_SANDSTONE_WALL = registerBlock("smooth_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_RED_SANDSTONE_WALL = registerBlock("smooth_red_sandstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> QUARTZ_WALL = registerBlock("quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_QUARTZ_WALL = registerBlock("smooth_quartz_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> PURPUR_WALL = registerBlock("purpur_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> TUFF_STAIRS = registerBlock("tuff_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_SLAB = registerBlock("tuff_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> TUFF_WALL = registerBlock("tuff_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.TUFF)));
    public static final RegistryObject<Block> CALCITE_STAIRS = registerBlock("calcite_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_SLAB = registerBlock("calcite_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> CALCITE_WALL = registerBlock("calcite_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.CALCITE)));
    public static final RegistryObject<Block> DRIPSTONE_STAIRS = registerBlock("dripstone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_SLAB = registerBlock("dripstone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> DRIPSTONE_WALL = registerBlock("dripstone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2f).requiresCorrectToolForDrops().sound(SoundType.DRIPSTONE_BLOCK)));
    public static final RegistryObject<Block> QUARTZ_BRICK_STAIRS = registerBlock("quartz_brick_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(1f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> QUARTZ_BRICK_SLAB = registerBlock("quartz_brick_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> QUARTZ_BRICK_WALL = registerBlock("quartz_brick_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(1f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CHISELED_END_STONE_BRICKS = registerBlock("chiseled_end_stone_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 9.0F).sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_STAIRS = registerBlock("end_stone_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_STONE_STAIRS.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.STONE).strength(3.0F, 9.0F)
                            .requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_SLAB = registerBlock("end_stone_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0F, 9.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> END_STONE_WALL = registerBlock("end_stone_wall",
            () -> new WallBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(3.0F, 9.0F).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final RegistryObject<Block> CARVED_MELON = registerBlock("carved_melon",
            () -> new CarvedMelonBlock(BlockBehaviour.Properties.copy(Blocks.CARVED_PUMPKIN).strength(1f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> BLOCK_OF_RUBY = registerBlock("block_of_ruby",
            () -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).strength(5f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> RED_NETHER_BRICK_FENCE = registerBlock("red_nether_brick_fence",
            () -> new FenceBlock(BlockBehaviour.Properties.of(Material.STONE)
                    .strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CRACKED_RED_NETHER_BRICKS = registerBlock("cracked_red_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));
    public static final RegistryObject<Block> CHISELED_RED_NETHER_BRICKS = registerBlock("chiseled_red_nether_bricks",
            () -> new Block(BlockBehaviour.Properties.of(Material.STONE).strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.NETHER_BRICKS)));


    //Plants
    public static final RegistryObject<Block> REEDS = registerBlock("reeds",
            () -> new ReedsBlock(BlockBehaviour.Properties.copy(Blocks.LILAC).sound(SoundType.SMALL_DRIPLEAF)));
    public static final RegistryObject<Block> BUTTER_CUP = registerBlock("butter_cup",
            () -> new FlowerBlock(MobEffects.DARKNESS, 6, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_BUTTER_CUP = BLOCKS.register("potted_butter_cup",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.BUTTER_CUP, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> SMALL_ROSE = registerBlock("small_rose",
            () -> new FlowerBlock(MobEffects.HEALTH_BOOST, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_SMALL_ROSE = BLOCKS.register("potted_small_rose",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.SMALL_ROSE, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> CROCUS = registerBlock("crocus",
            () -> new CrocusFlowerBlock(MobEffects.INVISIBILITY, 5, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_CROCUS = BLOCKS.register("potted_crocus",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.CROCUS, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));
    public static final RegistryObject<Block> BUBBLE_FLOWER = registerBlock("bubble_flower",
            () -> new BubbleFlowerBlock(MobEffects.LEVITATION, 4, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<Block> ALYSSUM = registerBlock("alyssum",
            () -> new AlyssumFlowerBlock(MobEffects.CONFUSION, 12, BlockBehaviour.Properties.copy(Blocks.DANDELION).noOcclusion()));
    public static final RegistryObject<FlowerPotBlock> POTTED_ALYSSUM = BLOCKS.register("potted_alyssum",
            () -> new FlowerPotBlock(() -> (FlowerPotBlock) Blocks.FLOWER_POT, ModBlocks.ALYSSUM, BlockBehaviour.Properties.copy(Blocks.POTTED_DANDELION)));


    //Crops
    public static final RegistryObject<Block> BLUEBERRY_BUSH = BLOCKS.register("blueberry_bush",
            () -> new BlueBerryBushBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().sound(SoundType.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> PINEAPPLE_PLANT = BLOCKS.register("pineapple_plant",
            () -> new PineapplePlantBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH).noOcclusion().sound(SoundType.CROP)));


    //New Block Sets
    public static final RegistryObject<Block> THATCH_BLOCK = BLOCKS.register("thatch_block",
            () -> new ModFlammableRotatedPillarBlock(BlockBehaviour.Properties.copy(Blocks.HAY_BLOCK)));
    public static final RegistryObject<Block> THATCH_STAIRS = BLOCKS.register("thatch_stairs",
            () -> new StairBlock(() -> ModBlocks.SMOOTH_SANDSTONE_WALL.get().defaultBlockState(),
                    BlockBehaviour.Properties.of(Material.GRASS).strength(.5f).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> THATCH_SLAB = BLOCKS.register("thatch_slab",
            () -> new SlabBlock(BlockBehaviour.Properties.of(Material.GRASS)
                    .strength(.5f).sound(SoundType.GRASS)));


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
