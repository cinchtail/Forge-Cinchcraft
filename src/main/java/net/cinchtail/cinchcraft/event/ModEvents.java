package net.cinchtail.cinchcraft.event;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarvedPumpkinBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ToolActions;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID)
    public static class ForgeEvents {

        @SubscribeEvent
        public static InteractionResult ShearMelonBlock(PlayerInteractEvent.RightClickBlock event){
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
                if (!level.isClientSide()){
                    if (blockState.is(Blocks.MELON)) {
                        level.setBlock(pos, ModBlocks.CARVED_MELON.get().defaultBlockState().setValue(CarvedPumpkinBlock.FACING, direction1), 11);
                        level.playSound(null, pos, SoundEvents.PUMPKIN_CARVE, SoundSource.BLOCKS, 1.0F, 1.0F);
                        ItemEntity itementity = new ItemEntity(level, (double)pos.getX() + 0.5D + (double)direction1.getStepX() * 0.65D, (double)pos.getY() + 0.1D, (double)pos.getZ() + 0.5D + (double)direction1.getStepZ() * 0.65D, new ItemStack(Items.MELON_SEEDS, 4));
                        itementity.setDeltaMovement(0.05D * (double)direction1.getStepX() + level.random.nextDouble() * 0.02D, 0.05D, 0.05D * (double)direction1.getStepZ() + level.random.nextDouble() * 0.02D);
                        level.addFreshEntity(itementity);
                        stack.hurtAndBreak(1, player, (p_55287_) -> {
                            p_55287_.broadcastBreakEvent(hand);
                        });
                        level.gameEvent(player, GameEvent.SHEAR, pos);
                        player.awardStat(Stats.ITEM_USED.get(Items.SHEARS));}
                }
            } return InteractionResult.sidedSuccess(level.isClientSide);
        }
        @SubscribeEvent
        public static void CancelCarrotPlanting(PlayerInteractEvent.RightClickBlock event) {
            ItemStack stack = event.getItemStack();
            if (stack.is(Items.CARROT)) {
                event.setCanceled(true);
            }
        }
    }
}