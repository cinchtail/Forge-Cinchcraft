package net.cinchtail.cinchcraft.event;

import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.villagers.ModVillagers;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;

@Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModVillagerTrades {
    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {
        if(event.getType() == ModVillagers.BEEKEEPER.get()) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();

        //Level 1 Trades
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.HONEYCOMB, 3), 7, 1, 0.02f
            ));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Items.BEE_NEST, 1), 5, 3, 0.02f
            ));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 5),
                    new ItemStack(Items.BEEHIVE, 1), 5, 3, 0.02f
            ));
            trades.get(1).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.SMALL_ROSE.get(), 4), 10, 2, 0.02f
            ));
        //Level 2 Trades
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.RED_TULIP, 2), 6, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.ORANGE_TULIP, 2), 6, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.PINK_TULIP, 2), 6, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.WHITE_TULIP, 2), 6, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.CROCUS.get(), 2), 8, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.ALYSSUM.get(), 2), 8, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.LUPINE.get(), 2), 8, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModBlocks.BUTTER_CUP.get(), 2), 8, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.LILY_OF_THE_VALLEY, 2), 8, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.BLUE_ORCHID, 2), 8, 2, 0.02f
            ));
            trades.get(2).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.ALLIUM, 2), 8, 2, 0.02f
            ));
        //Level 3 Trades
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.GLASS_BOTTLE, 4), 6, 2, 0.02f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.SUGAR, 6), 16, 2, 0.02f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 4),
                    new ItemStack(Items.SHEARS, 1), 7, 3, 0.02f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.ROSE_BUSH, 2), 8, 3, 0.02f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.LILAC, 2), 8, 3, 0.02f
            ));
            trades.get(3).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(Items.PEONY, 2), 8, 3, 0.02f
            ));
        //Level 4 Trades
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.HONEY_BOTTLE, 2),
                    new ItemStack(Items.EMERALD, 1), 6, 4, 0.02f
            ));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModItems.BLUEBERRIES.get(), 6), 12, 4, 0.02f
            ));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 1),
                    new ItemStack(ModItems.STRAWBERRIES.get(), 6), 12, 4, 0.02f
            ));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(ModItems.SUNFLOWER_SEEDS.get(), 12),
                    new ItemStack(Items.EMERALD, 1), 6, 4, 0.02f
            ));
        //Level 5 Trades
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Items.HONEYCOMB_BLOCK, 1), 4, 4, 0.02f
            ));
            trades.get(4).add((pTrader, pRandom) -> new MerchantOffer(
                    new ItemCost(Items.EMERALD, 2),
                    new ItemStack(Items.HONEY_BLOCK, 1), 4, 4, 0.02f
            ));
        }
    }
}
