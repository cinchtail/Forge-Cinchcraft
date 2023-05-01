package net.cinchtail.cinchcraft.event;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class ModEvents {
    @Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID)
    public static class ForgeEvents {
        /*@SubscribeEvent
        public static void CancelCarrotPlanting(PlayerInteractEvent.RightClickBlock event) {
            ItemStack stack = event.getItemStack();
            if (stack.is(Items.CARROT)) {
                event.setCanceled(true);
            }
        }*/
    }
}