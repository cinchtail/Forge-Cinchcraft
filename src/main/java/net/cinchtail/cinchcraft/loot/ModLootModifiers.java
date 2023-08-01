package net.cinchtail.cinchcraft.loot;

import com.mojang.serialization.Codec;
import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIER_SERIALIZERS =
            DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, Cinchcraft.MOD_ID);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("add_item", AddItemModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> REMOVE_ITEM =
            LOOT_MODIFIER_SERIALIZERS.register("remove_item", RemoveItemModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> COMMON_ADD_ITEM_TO_SUSPICIOUSE_BLOCK =
            LOOT_MODIFIER_SERIALIZERS.register("common_add_suspiciouse_block", CommonAddItemToSuspiciouseBlockModifier.CODEC);

    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> RARE_ADD_ITEM_TO_SUSPICIOUSE_BLOCK =
            LOOT_MODIFIER_SERIALIZERS.register("rare_add_suspiciouse_block", RareAddItemToSuspiciousBlockModifier.CODEC);

    public static void register(IEventBus eventBus) {
        LOOT_MODIFIER_SERIALIZERS.register(eventBus);
    }
}
