package net.cinchtail.cinchcraft.villagers;

import com.google.common.collect.ImmutableSet;
import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.mixin.accessor.PointOfInterestTypeAccessor;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModVillagers {
    public static final DeferredRegister<VillagerProfession> VILLAGER_PROFESSIONS =
            DeferredRegister.create(ForgeRegistries.VILLAGER_PROFESSIONS, Cinchcraft.MOD_ID);

    /*public static final RegistryObject<VillagerProfession> BEEKEEPER =
            VILLAGER_PROFESSIONS.register("beekeeper", () -> new VillagerProfession("beekeeper",
                    x -> x.is(((PointOfInterestTypeAccessor)PoiTypes.BEEHIVE).setMaxFreeTickets(1)),
                    x -> x.is((((PointOfInterestTypeAccessor)PoiTypes.BEEHIVE).setMaxFreeTickets(1))),
                    ImmutableSet.of(), ImmutableSet.of(), SoundEvents.BEEHIVE_SHEAR));*/

    public static final RegistryObject<VillagerProfession> BEEKEEPER =
            VILLAGER_PROFESSIONS.register("beekeeper", () -> new VillagerProfession("beekeeper",
                    x -> x.is(key -> key == PoiTypes.BEEHIVE), x -> x.is(key -> key == PoiTypes.BEEHIVE), ImmutableSet.of(), ImmutableSet.of(),
                    SoundEvents.BEEHIVE_SHEAR));

    @Override
    public void init() {
        ((PointOfInterestTypeAccessor)PoiTypes.BEEHIVE).setMaxFreeTickets(1);
    }

    public static void register(IEventBus eventBus) {
        VILLAGER_PROFESSIONS.register(eventBus);
    }
}