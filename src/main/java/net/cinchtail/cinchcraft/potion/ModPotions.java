package net.cinchtail.cinchcraft.potion;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModPotions {
    public static DeferredRegister<Potion> POTIONS
            = DeferredRegister.create(ForgeRegistries.POTIONS, Cinchcraft.MOD_ID);

    public static final RegistryObject<Potion> GLOWING_POTION = POTIONS.register("glowing_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.GLOWING,3600,0)));
    public static final RegistryObject<Potion> LONG_GLOWING_POTION = POTIONS.register("long_glowing_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.GLOWING,9600,0)));
    public static final RegistryObject<Potion> BLINDNESS_POTION = POTIONS.register("blindness_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS,1200,0)));
    public static final RegistryObject<Potion> LONG_BLINDNESS_POTION = POTIONS.register("long_blindness_potion",
            () -> new Potion(new MobEffectInstance(MobEffects.BLINDNESS,2400,0)));


    public static void register(IEventBus eventBus) {
        POTIONS.register(eventBus);
    }
}
