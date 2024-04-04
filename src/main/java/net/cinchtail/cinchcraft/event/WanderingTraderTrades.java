package net.cinchtail.cinchcraft.event;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID)
public class WanderingTraderTrades {
    @SubscribeEvent
    public void ModWanderingTraderTrades(WandererTradesEvent event)
    {
        event.getGenericTrades().add(new BasicItemListing(5, new ItemStack(Items.TADPOLE_BUCKET, 1)
                , 5, 5));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.CROCUS.get(), 1)
                , 7, 4));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.BUTTER_CUP.get(), 1)
                , 7, 4));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.SMALL_ROSE.get(), 1)
                , 7, 4));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.STAR_CACTUS.get(), 1)
                , 7, 4));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.ALYSSUM.get(), 1)
                , 7, 4));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.LUPINE.get(), 1)
                , 7, 4));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.SWEET_BERRIES, 3)
                , 7, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.GLOW_BERRIES, 3)
                , 7, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.BLUEBERRIES.get(), 3)
                , 7, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.STRAWBERRIES.get(), 3)
                , 7, 3));
        event.getRareTrades().add(new BasicItemListing(6, new ItemStack(Items.SPYGLASS, 1)
                , 1, 10));
        event.getRareTrades().add(new BasicItemListing(9, new ItemStack(Items.SADDLE, 1)
                , 1, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.GLOW_LICHEN, 2)
                , 5, 5));
        event.getRareTrades().add(new BasicItemListing(10, new ItemStack(Items.WITHER_ROSE, 1)
                , 1, 10));
        event.getGenericTrades().add(new BasicItemListing(2, new ItemStack(Items.POWDER_SNOW_BUCKET, 1)
                , 5, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.PAINTING, 1)
                , 5, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.CANDLE, 3)
                , 5, 10));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.SCAFFOLDING, 8)
                , 4, 10));
        event.getRareTrades().add(new BasicItemListing(2, new ItemStack(ModItems.PINEAPPLE.get(), 1)
                , 5, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.HONEYCOMB, 1)
                , 6, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.INK_SAC, 1)
                , 5, 3));
        event.getGenericTrades().add(new BasicItemListing(2, new ItemStack(Items.GLOW_INK_SAC, 1)
                , 5, 3));
        event.getRareTrades().add(new BasicItemListing(1, new ItemStack(ModItems.RUBY.get(), 1)
                , 9, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.SUNFLOWER_SEEDS.get(), 2)
                , 7, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.REEDS_SEEDS.get(), 2)
                , 9, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModItems.CATTAILS.get(), 1)
                , 5, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(Items.SNOWBALL, 4)
                , 4, 3));
        event.getGenericTrades().add(new BasicItemListing(1, new ItemStack(ModBlocks.ICICLE.get(), 1)
                , 8, 3));
    }
}
