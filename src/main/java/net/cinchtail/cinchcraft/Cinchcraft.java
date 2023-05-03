package net.cinchtail.cinchcraft;

import com.mojang.logging.LogUtils;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.event.ModEvents;
import net.cinchtail.cinchcraft.event.WanderingTraderTrades;
import net.cinchtail.cinchcraft.item.ModCreativeModeTabBlocks;
import net.cinchtail.cinchcraft.item.ModCreativeModeTabItems;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.potion.ModPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.PotionUtils;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.common.brewing.IBrewingRecipe;
import net.minecraftforge.event.CreativeModeTabEvent;
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

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        ModPotions.register(modEventBus);
        //ModEffects.register(modEventBus);

        //ModBlockEntities.register(modEventBus);

        //ModVillagers.register(modEventBus);

        //ModBiomeModifiers.register(modEventBus);
        //ModLootModifiers.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::clientSetup);

        modEventBus.addListener(this::addCreative);

        MinecraftForge.EVENT_BUS.register(new WanderingTraderTrades());
        MinecraftForge.EVENT_BUS.register(new ModEvents());

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        BrewingRecipeRegistry.addRecipe(new IBrewingRecipe() {
            @Override
            public boolean isInput(ItemStack input) {return PotionUtils.getPotion(input) == ModPotions.GLOWING_POTION.get();}
            @Override
            public boolean isIngredient(ItemStack ingredient) {return ingredient.is(Items.GLOW_BERRIES);}
            @Override
            public ItemStack getOutput(ItemStack input, ItemStack ingredient) {return PotionUtils.setPotion(input.copy(), ModPotions.LONG_GLOWING_POTION.get());}
        });
    }

    @Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class commonSetup {

        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
            });
        }
    }

    public void clientSetup(final FMLClientSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == ModCreativeModeTabBlocks.CINCHCRAFT_BLOCK_TAB) {
            event.accept(ModBlocks.BLOCK_OF_RUBY);
            event.accept(ModBlocks.RUBY_ORE);
            event.accept(ModBlocks.DEEPSLATE_RUBY_ORE);
            event.accept(ModBlocks.NETHER_COAL_ORE);
            event.accept(ModBlocks.NETHER_COPPER_ORE);
            event.accept(ModBlocks.NETHER_IRON_ORE);
            event.accept(ModBlocks.NETHER_LAPIS_LAZULI_ORE);
            event.accept(ModBlocks.NETHER_RUBY_ORE);
            event.accept(ModBlocks.NETHER_EMERALD_ORE);
            event.accept(ModBlocks.NETHER_DIAMOND_ORE);
            event.accept(ModBlocks.CARVED_MELON);
        }
        if(event.getTab() == ModCreativeModeTabItems.CINCHCRAFT_ITEM_TAB) {
            event.accept(ModItems.RUBY);
            event.accept(ModItems.COPPER_NUGGET);
            event.accept(ModItems.CARROT_SEEDS);
        }
    }
}
