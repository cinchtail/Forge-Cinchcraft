package net.cinchtail.cinchcraft.item;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.item.custom.CarrotSeedItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cinchcraft.MOD_ID);


    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CARROT_SEEDS = ITEMS.register("carrot_seeds",
            () -> new CarrotSeedItem(Blocks.CARROTS,
                    new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
