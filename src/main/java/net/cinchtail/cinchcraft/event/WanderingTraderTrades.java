package net.cinchtail.cinchcraft.event;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID)
public class WanderingTraderTrades {
    @SubscribeEvent
    public void ModWanderingTraderTrades(WandererTradesEvent event)
    {
        new VillagerTrades.ItemsForEmeralds(Items.TADPOLE_BUCKET, 5, 1, 4, 1),
                new VillagerTrades.ItemsForEmeralds(Items.POWDER_SNOW_BUCKET, 2, 1, 5, 10),
                new VillagerTrades.ItemsForEmeralds(ModItems.CROCUS.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(ModItems.BUTTER_CUP.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(ModItems.SMALL_ROSE.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(ModItems.STAR_CACTUS.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(ModItems.ALYSSUM.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(ModItems.LUPINE.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(Items.PINK_PETALS, 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(ModItems.CATTAILS.get(), 1, 1, 5, 3),
                new VillagerTrades.ItemsForEmeralds(Items.WITHER_ROSE, 30, 1, 1, 12),
                new VillagerTrades.ItemsForEmeralds(Items.SWEET_BERRIES, 1, 3, 7, 3),
                new VillagerTrades.ItemsForEmeralds(Items.GLOW_BERRIES, 1, 3, 7, 3),
                new VillagerTrades.ItemsForEmeralds(ModItems.BLUEBERRIES.get(), 1, 3, 7, 3),
                new VillagerTrades.ItemsForEmeralds(ModItems.STRAWBERRIES.get(), 1, 3, 7, 3),
                new VillagerTrades.ItemsForEmeralds(ModItems.PINEAPPLE.get(), 2, 1, 5, 3),
                new VillagerTrades.ItemsForEmeralds(ModItems.SUNFLOWER_SEEDS.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(ModItems.REEDS_SEEDS.get(), 1, 1, 12, 1),
                new VillagerTrades.ItemsForEmeralds(Items.SPYGLASS, 6, 1, 1, 10),
                new VillagerTrades.ItemsForEmeralds(Items.SADDLE, 9, 1, 1, 10),
                new VillagerTrades.ItemsForEmeralds(Items.PAINTING, 1, 1, 5, 10),
                new VillagerTrades.ItemsForEmeralds(Items.CANDLE, 1, 4, 5, 10),
                new VillagerTrades.ItemsForEmeralds(Items.SCAFFOLDING, 1, 8, 4, 10),
                new VillagerTrades.ItemsForEmeralds(Items.HONEYCOMB, 1, 1, 6, 3),
                new VillagerTrades.ItemsForEmeralds(Items.INK_SAC, 1, 1, 5, 3),
                new VillagerTrades.ItemsForEmeralds(Items.GLOW_INK_SAC, 1, 1, 5, 3),
                new VillagerTrades.ItemsForEmeralds(Items.GLOW_LICHEN, 1, 2, 5, 5),
                new VillagerTrades.ItemsForEmeralds(ModBlocks.ICICLE.get(), 1, 2, 5, 1),
                new VillagerTrades.ItemsForEmeralds(Items.SNOWBALL, 1, 4, 4, 3),
                new VillagerTrades.ItemsForEmeralds(ModItems.RUBY.get(), 1, 1, 9, 3)
    }
}
