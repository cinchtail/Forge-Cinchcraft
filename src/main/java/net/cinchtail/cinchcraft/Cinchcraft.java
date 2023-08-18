package net.cinchtail.cinchcraft;

import com.google.common.collect.ImmutableSet;
import com.mojang.logging.LogUtils;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.block.entity.ModBlockEntities;
import net.cinchtail.cinchcraft.entity.ModEntities;
import net.cinchtail.cinchcraft.entity.client.ModBoatRenderer;
import net.cinchtail.cinchcraft.event.ModEvents;
import net.cinchtail.cinchcraft.event.WanderingTraderTrades;
import net.cinchtail.cinchcraft.item.ModCreativeModeTabs;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.loot.ModLootModifiers;
import net.cinchtail.cinchcraft.potion.ModPotions;
import net.cinchtail.cinchcraft.sound.ModSounds;
import net.cinchtail.cinchcraft.util.ModWoodTypes;
import net.cinchtail.cinchcraft.villagers.ModVillagers;
import net.cinchtail.cinchcraft.world.biomemods.ModBiomeModifiers;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FlowerPotBlock;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

import java.util.stream.Collectors;
import java.util.stream.Stream;

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

        ModBlockEntities.register(modEventBus);

        ModSounds.register(modEventBus);
        ModVillagers.register(modEventBus);

        ModBiomeModifiers.register(modEventBus);
        ModLootModifiers.register(modEventBus);

        ModEntities.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

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
        ComposterBlock.COMPOSTABLES.put(ModItems.SUNFLOWER_HEAD.get(), 1f);
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
        ComposterBlock.COMPOSTABLES.put(ModItems.STAR_CACTUS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.FIRE_FERN.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.REEDS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.CATTAILS.get(), 0.65f);
        ComposterBlock.COMPOSTABLES.put(ModItems.STALK.get(), 0.65f);

        Stream<Item> vanillaWantedItems = Villager.WANTED_ITEMS.stream();
        Stream<Item> modWantedItems = Stream.of(ModItems.CARROT_SEEDS.get());
        Villager.WANTED_ITEMS = ImmutableSet.copyOf(
                Stream.concat(vanillaWantedItems, modWantedItems)
                        .collect(Collectors.toSet()));
    }

    @Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class ClientModEvents  {

        @OnlyIn(Dist.CLIENT)
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
                Sheets.addWoodType(ModWoodTypes.AZALEA);

                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.BUTTER_CUP.getId(), ModBlocks.POTTED_BUTTER_CUP);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.SMALL_ROSE.getId(), ModBlocks.POTTED_SMALL_ROSE);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.CROCUS.getId(), ModBlocks.POTTED_CROCUS);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.ALYSSUM.getId(), ModBlocks.POTTED_ALYSSUM);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.LUPINE.getId(), ModBlocks.POTTED_LUPINE);
                ((FlowerPotBlock) Blocks.FLOWER_POT).addPlant(ModBlocks.STAR_CACTUS.getId(), ModBlocks.POTTED_STAR_CACTUS);

                PotionBrewing.addMix(Potions.AWKWARD, Items.GLOW_BERRIES, ModPotions.GLOWING_POTION.get());
                PotionBrewing.addMix(Potions.AWKWARD, Items.INK_SAC, ModPotions.BLINDNESS_POTION.get());
                PotionBrewing.addMix(ModPotions.GLOWING_POTION.get(), Items.REDSTONE, ModPotions.LONG_GLOWING_POTION.get());
                PotionBrewing.addMix(ModPotions.BLINDNESS_POTION.get(), Items.REDSTONE, ModPotions.LONG_BLINDNESS_POTION.get());

                EntityRenderers.register(ModEntities.MOD_BOAT.get(), pContext -> new ModBoatRenderer(pContext, false));
                EntityRenderers.register(ModEntities.MOD_CHEST_BOAT.get(), pContext -> new ModBoatRenderer(pContext, true));
            });
        }
    }
    public void clientSetup(final FMLClientSetupEvent event) {
    }
}
