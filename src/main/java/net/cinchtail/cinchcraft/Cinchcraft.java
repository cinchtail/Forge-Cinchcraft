package net.cinchtail.cinchcraft;

import com.mojang.logging.LogUtils;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.event.ModEvents;
import net.cinchtail.cinchcraft.event.WanderingTraderTrades;
import net.cinchtail.cinchcraft.item.ModCreativeModeTabs;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.loot.ModLootModifiers;
import net.cinchtail.cinchcraft.potion.ModPotions;
import net.cinchtail.cinchcraft.sound.ModSounds;
import net.cinchtail.cinchcraft.util.BetterBrewingRecipe;
import net.cinchtail.cinchcraft.world.biomemods.ModBiomeModifiers;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(Cinchcraft.MOD_ID)
public class Cinchcraft
{
    public static final String MOD_ID = "cinchcraft";
    private static final Logger LOGGER = LogUtils.getLogger();

    public Cinchcraft() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        modEventBus.addListener(this::commonSetup);

        ModCreativeModeTabs.register(modEventBus);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModPotions.register(modEventBus);
        //ModEffects.register(modEventBus);

        //ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);

        //ModVillagers.register(modEventBus);

        ModBiomeModifiers.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(new WanderingTraderTrades());
        MinecraftForge.EVENT_BUS.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        ComposterBlock.COMPOSTABLES.put(Items.ROTTEN_FLESH, 0.2f);
        ComposterBlock.COMPOSTABLES.put(Items.BAMBOO, 0.65f);
        ComposterBlock.COMPOSTABLES.put(Items.POISONOUS_POTATO, 0.2f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CARROT_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModItems.SUNFLOWER_SEEDS.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRY_PIE.get(), 1f);
        ComposterBlock.COMPOSTABLES.put(ModItems.BLUEBERRIES.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModItems.STRAWBERRIES.get(), 0.3f);
        ComposterBlock.COMPOSTABLES.put(ModItems.PINEAPPLE.get(), 0.5f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CARVED_MELON.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.BUTTER_CUP.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.SMALL_ROSE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CROCUS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.ALYSSUM.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.LUPINE.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.SMALL_CACTUS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.FIRE_FERN.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.REEDS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CATTAILS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.STALK.get(), 0.65f);
    }

    @Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class commonSetup {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BUTTER_CUP.getId(), ModBlocks.POTTED_BUTTER_CUP);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SMALL_ROSE.getId(), ModBlocks.POTTED_SMALL_ROSE);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CROCUS.getId(), ModBlocks.POTTED_CROCUS);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ALYSSUM.getId(), ModBlocks.POTTED_ALYSSUM);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LUPINE.getId(), ModBlocks.POTTED_LUPINE);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SMALL_CACTUS.getId(), ModBlocks.POTTED_SMALL_CACTUS);

                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                        Items.GLOW_BERRIES, ModPotions.GLOWING_POTION.get()));
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(Potions.AWKWARD,
                        Items.INK_SAC, ModPotions.BLINDNESS_POTION.get()));
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.GLOWING_POTION.get(),
                        Items.REDSTONE, ModPotions.LONG_GLOWING_POTION.get()));
                BrewingRecipeRegistry.addRecipe(new BetterBrewingRecipe(ModPotions.BLINDNESS_POTION.get(),
                        Items.REDSTONE, ModPotions.LONG_BLINDNESS_POTION.get()));
            });
        }
    }

    public void clientSetup(final FMLClientSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == ModCreativeModeTabs.CINCHCRAFT_BLOCK_TAB.get()) {
            event.accept(ModBlocks.BLOCK_OF_RUBY);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.NETHER_COAL_ORE);
            event.accept(ModBlocks.NETHER_COPPER_ORE);
            event.accept(ModBlocks.NETHER_IRON_ORE);
            event.accept(ModBlocks.NETHER_LAPIS_LAZULI_ORE);
            event.accept(ModBlocks.NETHER_REDSTONE_ORE);
            event.accept(ModBlocks.NETHER_EMERALD_ORE);
            event.accept(ModBlocks.NETHER_RUBY_ORE);
            event.accept(ModBlocks.NETHER_DIAMOND_ORE);
            event.accept(ModBlocks.TUFF_STAIRS);
            event.accept(ModBlocks.TUFF_SLAB);
            event.accept(ModBlocks.TUFF_WALL);
            event.accept(ModBlocks.CALCITE_STAIRS);
            event.accept(ModBlocks.CALCITE_SLAB);
            event.accept(ModBlocks.CALCITE_WALL);
            event.accept(ModBlocks.DRIPSTONE_STAIRS);
            event.accept(ModBlocks.DRIPSTONE_SLAB);
            event.accept(ModBlocks.DRIPSTONE_WALL);
            event.accept(ModBlocks.POLISHED_TUFF);
            event.accept(ModBlocks.POLISHED_TUFF_STAIRS);
            event.accept(ModBlocks.POLISHED_TUFF_SLAB);
            event.accept(ModBlocks.POLISHED_TUFF_WALL);
            event.accept(ModBlocks.POLISHED_CALCITE);
            event.accept(ModBlocks.POLISHED_CALCITE_STAIRS);
            event.accept(ModBlocks.POLISHED_CALCITE_SLAB);
            event.accept(ModBlocks.POLISHED_CALCITE_WALL);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_BLOCK);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_STAIRS);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_SLAB);
            event.accept(ModBlocks.POLISHED_DRIPSTONE_WALL);
            event.accept(ModBlocks.CRACKED_STONE_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_STONE_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_STONE_BRICK_WALL);
            event.accept(ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL);
            event.accept(ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS);
            event.accept(ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB);
            event.accept(ModBlocks.CRACKED_DEEPSLATE_TILE_WALL);
            event.accept(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL);
            event.accept(ModBlocks.CRACKED_NETHER_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_NETHER_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_NETHER_BRICK_WALL);
            event.accept(ModBlocks.MOSSY_NETHER_BRICKS);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_STAIRS);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_SLAB);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_WALL);
            event.accept(ModBlocks.MOSSY_NETHER_BRICK_FENCE);
            //event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS);
            //event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_STAIRS);
            //event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_SLAB);
            //event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_WALL);
            //event.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_FENCE);
            //event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICKS);
            //event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_STAIRS);
            //event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_SLAB);
            //event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_WALL);
            //event.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_FENCE);
            event.accept(ModBlocks.CHISELED_RED_NETHER_BRICKS);
            event.accept(ModBlocks.RED_NETHER_BRICK_FENCE);
            event.accept(ModBlocks.CRACKED_RED_NETHER_BRICKS);
            event.accept(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL);
            event.accept(ModBlocks.CRACKED_MUD_BRICKS);
            event.accept(ModBlocks.CRACKED_MUD_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_MUD_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_MUD_BRICK_WALL);
            event.accept(ModBlocks.CHISELED_MUD_BRICKS);
            event.accept(ModBlocks.MOSSY_MUD_BRICKS);
            event.accept(ModBlocks.MOSSY_MUD_BRICK_STAIRS);
            event.accept(ModBlocks.MOSSY_MUD_BRICK_SLAB);
            event.accept(ModBlocks.MOSSY_MUD_BRICK_WALL);
            event.accept(ModBlocks.CRACKED_QUARTZ_BRICKS);
            event.accept(ModBlocks.CRACKED_QUARTZ_BRICK_STAIRS);
            event.accept(ModBlocks.CRACKED_QUARTZ_BRICK_SLAB);
            event.accept(ModBlocks.CRACKED_QUARTZ_BRICK_WALL);
            event.accept(ModBlocks.QUARTZ_BRICK_STAIRS);
            event.accept(ModBlocks.QUARTZ_BRICK_SLAB);
            event.accept(ModBlocks.QUARTZ_BRICK_WALL);
            event.accept(ModBlocks.CHISELED_END_STONE_BRICKS);
            event.accept(ModBlocks.END_STONE_STAIRS);
            event.accept(ModBlocks.END_STONE_SLAB);
            event.accept(ModBlocks.END_STONE_WALL);
            event.accept(ModBlocks.SMOOTH_BASALT_STAIRS);
            event.accept(ModBlocks.SMOOTH_BASALT_SLAB);
            event.accept(ModBlocks.SMOOTH_BASALT_WALL);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB);
            event.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICKS);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_SLAB);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_WALL);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILES);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_STAIRS);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_SLAB);
            event.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_WALL);
            event.accept(ModBlocks.SMOOTH_STONE_STAIRS);
            event.accept(ModBlocks.SMOOTH_STONE_WALL);
            event.accept(ModBlocks.CUT_SANDSTONE_STAIRS);
            event.accept(ModBlocks.CUT_SANDSTONE_WALL);
            event.accept(ModBlocks.CUT_RED_SANDSTONE_STAIRS);
            event.accept(ModBlocks.CUT_RED_SANDSTONE_WALL);
            event.accept(ModBlocks.STONE_WALL);
            event.accept(ModBlocks.POLISHED_GRANITE_WALL);
            event.accept(ModBlocks.POLISHED_ANDESITE_WALL);
            event.accept(ModBlocks.POLISHED_DIORITE_WALL);
            event.accept(ModBlocks.PRISMARINE_BRICK_WALL);
            event.accept(ModBlocks.DARK_PRISMARINE_WALL);
            event.accept(ModBlocks.SMOOTH_SANDSTONE_WALL);
            event.accept(ModBlocks.SMOOTH_RED_SANDSTONE_WALL);
            event.accept(ModBlocks.QUARTZ_WALL);
            event.accept(ModBlocks.SMOOTH_QUARTZ_WALL);
            event.accept(ModBlocks.PURPUR_WALL);
            event.accept(ModBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE);
            event.accept(ModBlocks.POLISHED_DEEPSLATE_BUTTON);
            event.accept(ModBlocks.IRON_BUTTON);
            event.accept(ModBlocks.GOLD_BUTTON);
            event.accept(ModItems.CARVED_MELON);
            event.accept(ModItems.GLOWSTONE_TORCH);
            event.accept(ModItems.THATCH_BLOCK);
            event.accept(ModItems.THATCH_STAIRS);
            event.accept(ModItems.THATCH_SLAB);
            event.accept(ModItems.REEDS);
            event.accept(ModItems.CATTAILS);
            //event.accept(ModItems.APPLE_LOG);
            //event.accept(ModItems.APPLE_WOOD);
            //event.accept(ModItems.STRIPPED_APPLE_LOG);
            //event.accept(ModItems.STRIPPED_APPLE_WOOD);
            //event.accept(ModBlocks.APPLE_PLANKS);
            //event.accept(ModItems.APPLE_STAIRS);
            //event.accept(ModItems.APPLE_SLAB);
            //event.accept(ModItems.APPLE_FENCE);
            //event.accept(ModItems.APPLE_FENCE_GATE);
            //event.accept(ModItems.APPLE_TRAPDOOR);
            //event.accept(ModItems.APPLE_DOOR);
            //event.accept(ModItems.APPLE_SIGN);
            //event.accept(ModItems.APPLE_PRESSURE_PLATE);
            //event.accept(ModItems.APPLE_BUTTON);
            //event.accept(ModBlocks.APPLE_LEAVES);
            //event.accept(ModBlocks.PERMAFROST);
            //event.accept(ModBlocks.ICICLE);
            event.accept(ModItems.FIRE_FERN);
            event.accept(ModBlocks.BUBBLE_FLOWER);
            event.accept(ModItems.BUTTER_CUP);
            event.accept(ModItems.CROCUS);
            event.accept(ModItems.ALYSSUM);
            event.accept(ModItems.SMALL_ROSE);
            event.accept(ModItems.LUPINE);
            event.accept(ModItems.SMALL_CACTUS);
            event.accept(ModItems.STALK);
        }
        if(event.getTab() == ModCreativeModeTabs.CINCHCRAFT_ITEM_TAB.get()) {
            event.accept(ModItems.RUBY_SWORD);
            event.accept(ModItems.RUBY_PICKAXE);
            event.accept(ModItems.RUBY_AXE);
            event.accept(ModItems.RUBY_SHOVEL);
            event.accept(ModItems.RUBY_HOE);
            event.accept(ModItems.RUBY_HELMET);
            event.accept(ModItems.RUBY_CHESTPLATE);
            event.accept(ModItems.RUBY_LEGGINGS);
            event.accept(ModItems.RUBY_BOOTS);
            //event.accept(ModItems.EMERALD_SWORD);
            //event.accept(ModItems.EMERALD_PICKAXE);
            //event.accept(ModItems.EMERALD_AXE);
            //event.accept(ModItems.EMERALD_SHOVEL);
            //event.accept(ModItems.EMERALD_HOE);
            //event.accept(ModItems.EMERALD_HELMET);
            //event.accept(ModItems.EMERALD_CHESTPLATE);
            //event.accept(ModItems.EMERALD_LEGGING);
            //event.accept(ModItems.EMERALD_BOOTS);
            event.accept(ModItems.DEEPSLATE_SWORD);
            event.accept(ModItems.DEEPSLATE_PICKAXE);
            event.accept(ModItems.DEEPSLATE_AXE);
            event.accept(ModItems.DEEPSLATE_SHOVEL);
            event.accept(ModItems.DEEPSLATE_HOE);
            event.accept(ModItems.BLACKSTONE_SWORD);
            event.accept(ModItems.BLACKSTONE_PICKAXE);
            event.accept(ModItems.BLACKSTONE_AXE);
            event.accept(ModItems.BLACKSTONE_SHOVEL);
            event.accept(ModItems.BLACKSTONE_HOE);
            event.accept(ModItems.NETHERITE_HORSE_ARMOR);
            event.accept(ModItems.RUBY_HORSE_ARMOR);
            //event.accept(ModItems.EMERALD_HORSE_ARMOR);
            event.accept(ModItems.RUBY);
            event.accept(ModItems.COPPER_NUGGET);
            event.accept(ModItems.CHAINMAIL);
            event.accept(ModItems.DOG_MUSIC_DISC);
            event.accept(ModItems.KYOTO_MUSIC_DISC);
            event.accept(ModItems.CARROT_SEEDS);
            event.accept(ModItems.SUNFLOWER_SEEDS);
            event.accept(ModItems.SUNFLOWER_HEAD);
            event.accept(ModItems.BLUEBERRIES);
            event.accept(ModItems.STRAWBERRIES);
            event.accept(ModItems.PINEAPPLE);
            event.accept(ModItems.BLUEBERRY_PIE);
            event.accept(ModItems.PITCHER_PLANT_ROOT);
            event.accept(ModItems.VEGETABLE_STEW);
            event.accept(ModItems.NETHER_STEW);
            event.accept(ModItems.ANCIENT_SLIME_STEW);
        }
    }
}
