package net.cinchtail.cinchcraft.loot;

import com.mojang.serialization.MapCodec;
import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Cinchcraft.MOD_ID);

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> ADD_MULTIPLE_ITEMS =
            LOOT_MODIFIER_SERIALIZERS.register("add_multiple_items", AddMultipleItemsModifier.CODEC);

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> REPLACE_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("replace_item", ReplaceItemModifier.CODEC);

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> COMMON_ADD_ITEM_TO_SINGLE_ITEM_LOOT_TABLE =
            LOOT_MODIFIER_SERIALIZERS.register("common_add_item_to_single_item_loot_table", CommonAddItemToSingleItemLootTableModifier.CODEC);

    public static final RegistryObject<MapCodec<? extends IGlobalLootModifier>> RARE_ADD_ITEM_TO_SINGLE_ITEM_LOOT_TABLE =
            LOOT_MODIFIER_SERIALIZERS.register("rare_add_item_to_single_item_loot_table", RareAddItemToSingleItemLootTableModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
