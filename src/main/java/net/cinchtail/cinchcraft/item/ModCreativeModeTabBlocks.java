package net.cinchtail.cinchcraft.item;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Cinchcraft.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabBlocks {
    public static CreativeModeTab CINCHCRAFT_BLOCK_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        CINCHCRAFT_BLOCK_TAB = event.registerCreativeModeTab(new ResourceLocation(Cinchcraft.MOD_ID, "cinchcraft_block_tab"),
                builder -> builder.icon(() -> new ItemStack(ModBlocks.BLOCK_OF_RUBY.get())).title(Component.literal("Cinchcraft Block Tab")).build());
    }
}
