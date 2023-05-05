package net.cinchtail.cinchcraft.item;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.custom.CarrotSeedItem;
import net.cinchtail.cinchcraft.item.custom.ThatchFullBlock;
import net.cinchtail.cinchcraft.item.custom.ThatchSlabBlock;
import net.cinchtail.cinchcraft.item.custom.ThatchStairsBlock;
import net.minecraft.world.item.BowlFoodItem;
import net.minecraft.world.item.HorseArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cinchcraft.MOD_ID);


    //Miscellaneous
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHAINMAIL = ITEMS.register("chainmail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARROT_SEEDS = ITEMS.register("carrot_seeds",
            () -> new CarrotSeedItem(Blocks.CARROTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor",
            () -> new HorseArmorItem(14, "netherite",
                    new Item.Properties().fireResistant().stacksTo(1)));

    //Foods
    public static final RegistryObject<Item> VEGETABLE_STEW = ITEMS.register("vegetable_stew",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoods.VEGETABLE_STEW)));
    public static final RegistryObject<Item> NETHER_STEW = ITEMS.register("nether_stew",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoods.NETHER_STEW)));

    //Block Items
    public static final RegistryObject<Item> THATCH_BLOCK = ITEMS.register("thatch_block",
            () -> new ThatchFullBlock(ModBlocks.THATCH_BLOCK.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> THATCH_STAIRS = ITEMS.register("thatch_stairs",
            () -> new ThatchStairsBlock(ModBlocks.THATCH_STAIRS.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> THATCH_SLAB = ITEMS.register("thatch_slab",
            () -> new ThatchSlabBlock(ModBlocks.THATCH_SLAB.get(),
                    new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
