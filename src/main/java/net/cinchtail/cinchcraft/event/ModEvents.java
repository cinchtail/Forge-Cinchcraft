package net.cinchtail.cinchcraft.event;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.potion.ModPotions;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionBrewing;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.brewing.BrewingRecipeRegisterEvent;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class ForgeEvents {

        @SubscribeEvent
        public static InteractionResult ShearMelonBlock(PlayerInteractEvent.RightClickBlock event) {
            Level level = event.getLevel();
            Player player = event.getEntity();
            BlockPos pos = event.getPos();
            BlockState blockState = level.getBlockState(pos);
            BlockHitResult result = event.getHitVec();
            Direction direction = result.getDirection();
            Direction direction1 = direction.getAxis() == Direction.Axis.Y ? player.getDirection().getOpposite() : direction;
            InteractionHand hand = event.getHand();
            ItemStack stack = event.getItemStack();
            if (stack.canPerformAction(ToolActions.SHEARS_CARVE)) {
                if (!level.isClientSide()) {
                    if (blockState.is(Blocks.MELON)) {
                        level.setBlock(pos, ModBlocks.CARVED_MELON.get().defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction1), 11);
                        level.playSound(null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
                        ItemEntity itementity = new ItemEntity(level, (double) pos.getX() + 0.5D + (double) direction1.getStepX() * 0.65D, (double) pos.getY() + 0.1D, (double) pos.getZ() + 0.5D + (double) direction1.getStepZ() * 0.65D, new ItemStack(Items.MELON_SEEDS, 4));
                        itementity.setDeltaMovement(0.05D * (double) direction1.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double) direction1.getStepZ() + level.random.nextDouble() * 0.02D);
                        level.addFreshEntity(itementity);
                        stack.hurtAndBreak(1, player, LivingEntity.getSlotForHand(hand));
                        level.gameEvent(player, GameEvent.SHEAR, pos);
                        player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));
                    }
                }
            }
            return InteractionResult.sidedSuccess(level.isClientSide);
        }
        @SubscribeEvent
        public static void CancelCarrotPlanting(PlayerInteractEvent.RightClickBlock event) {
            ItemStack stack = event.getItemStack();
            if (stack.is(Items.CARROT)) {
                event.setCanceled(true);
            }
        }
        @SubscribeEvent
        public static void CancelSunflowerBoneMealing(BonemealEvent event) {
            Block targetBlock = event.getLevel().getBlockState(event.getPos()).getBlock();
            if (targetBlock == Blocks.SUNFLOWER) {
                event.setCanceled(true);
            }
        }
    }
    @SubscribeEvent
    public static void onBrewingRecipeRegister(BrewingRecipeRegisterEvent event) {
        PotionBrewing.Builder builder = event.getBuilder();

        builder.addMix(Potions.AWKWARD, Items.GLOW_BERRIES, ModPotions.GLOWING_POTION.getHolder().get());
        builder.addMix(Potions.AWKWARD, Items.INK_SAC, ModPotions.BLINDNESS_POTION.getHolder().get());
        builder.addMix(ModPotions.GLOWING_POTION.getHolder().get(), Items.REDSTONE, ModPotions.LONG_GLOWING_POTION.getHolder().get());
        builder.addMix(ModPotions.BLINDNESS_POTION.getHolder().get(), Items.REDSTONE, ModPotions.LONG_BLINDNESS_POTION.getHolder().get());
    }
    @SubscribeEvent
    public static void addWanderingTrades(WandererTradesEvent event) {
        List<VillagerTrades.ItemListing> genericTrades = event.getGenericTrades();
        List<VillagerTrades.ItemListing> rareTrades = event.getRareTrades();

        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 5),
                new ItemStack(Items.TADPOLE_BUCKET, 1), 4, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 2),
                new ItemStack(Items.POWDER_SNOW_BUCKET, 1), 5, 10, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.CROCUS.get(), 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.BUTTER_CUP.get(), 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.SMALL_ROSE.get(), 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.STAR_CACTUS.get(), 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.ALYSSUM.get(), 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.LUPINE.get(), 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.PINK_PETALS, 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.CATTAILS.get(), 1), 5, 3, 0.02f
        ));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 30),
                new ItemStack(Items.WITHER_ROSE, 1), 1, 12, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.SWEET_BERRIES, 3), 7, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.GLOW_BERRIES, 3), 7, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.BLUEBERRIES.get(), 3), 7, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.STRAWBERRIES.get(), 3), 7, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.PINEAPPLE.get(), 1), 5, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.SUNFLOWER_SEEDS.get(), 1), 12, 1, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModItems.REEDS_SEEDS.get(), 1), 12, 1, 0.02f
        ));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 6),
                new ItemStack(Items.SPYGLASS, 1), 1, 10, 0.02f
        ));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 9),
                new ItemStack(Items.SADDLE, 1), 1, 10, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.PAINTING, 1), 5, 10, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.PAINTING, 4), 5, 10, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.SCAFFOLDING, 8), 4, 10, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.SCAFFOLDING, 1), 6, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.INK_SAC, 1), 5, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.GLOW_INK_SAC, 1), 5, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.GLOW_LICHEN, 2), 5, 5, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(ModBlocks.ICICLE.get(), 2), 5, 3, 0.02f
        ));
        genericTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(Items.EMERALD, 1),
                new ItemStack(Items.SNOWBALL, 4), 4, 3, 0.02f
        ));
        rareTrades.add((pTrader, pRandom) -> new MerchantOffer(
                new ItemCost(ModItems.RUBY.get(), 1),
                new ItemStack(Items.EMERALD, 1), 9, 3, 0.02f
        ));
    }
}