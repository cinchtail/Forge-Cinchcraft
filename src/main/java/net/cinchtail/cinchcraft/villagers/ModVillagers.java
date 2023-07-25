package net.cinchtail.cinchcraft.villagers;

import com.google.common.collect.ImmutableSet;
import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<PoiType> POI_TYPES =
            DeferredRegister.create(ForgeRegistries.POI_TYPES, Cinchcraft.MOD_ID);
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Cinchcraft.MOD_ID);
    public static final RegistryObject<PoiType> BEEHIVE_POI = POI_TYPES.register("beehive_poi",
            () -> new PoiType(ImmutableSet.copyOf(Blocks.STONE.getStateDefinition().getPossibleStates()),
                    1, 1));

    public static final RegistryObject<VillagerProfession> BEE_KEEPER =
            VILLAGER_PROFESSIONS.register("bee_keeper", () -> new VillagerProfession("bee_keeper",
                    x -> x.get() == BEEHIVE_POI.get(), x -> x.get() == BEEHIVE_POI.get(), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.BEEHIVE_SHEAR));

    public static void register(IEventBus eventBus) {
        POI_TYPES.register(eventBus);
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}