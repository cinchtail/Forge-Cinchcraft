package net.cinchtail.cinchcraft.block.entity;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, Cinchcraft.MOD_ID);


    public static final RegistryObject<BlockEntityType<ModSignBlockEntity>> MOD_SIGN =
            BLOCK_ENTITIES.register("mod_sign", () ->
                    BlockEntityType.Builder.of(ModSignBlockEntity::new,
                            ModBlocks.AZALEA_SIGN.get(), ModBlocks.AZALEA_WALL_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<ModHangingSignBlockEntity>> MOD_HANGING_SIGN =
            BLOCK_ENTITIES.register("mod_hanging_sign", () ->
                    BlockEntityType.Builder.of(ModHangingSignBlockEntity::new,
                            ModBlocks.AZALEA_HANGING_SIGN.get(), ModBlocks.AZALEA_WALL_HANGING_SIGN.get()).build(null));

    public static final RegistryObject<BlockEntityType<SuspiciousBlockEntity>> SUSPICIOUSBLOCK =
            BLOCK_ENTITIES.register("suspicious_block",() ->
                    BlockEntityType.Builder.of(SuspiciousBlockEntity::new,
                        ModBlocks.SUSPICIOUS_PERMAFROST.get()).build(null));


    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}