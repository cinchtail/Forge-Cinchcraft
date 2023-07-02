package net.cinchtail.cinchcraft.item;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Cinchcraft.MOD_ID);

    public static RegistryObject<CreativeModeTab> CINCHCRAFT_BLOCK_TAB = CREATIVE_MODE_TABS.register("cinchcraft_block_tab",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BLOCK_OF_RUBY.get())).title(Component.literal("Cinchcraft Block Tab")).build());

    public static RegistryObject<CreativeModeTab> CINCHCRAFT_ITEM_TAB = CREATIVE_MODE_TABS.register("cinchcraft_item_tab",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BLOCK_OF_RUBY.get())).title(Component.literal("Cinchcraft Item Tab")).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
