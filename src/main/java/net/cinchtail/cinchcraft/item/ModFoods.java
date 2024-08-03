package net.cinchtail.cinchcraft.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    static final FoodProperties VEGETABLE_STEW = modStew(6).build();
    static final FoodProperties BLUEBERRIES = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).build();
    static final FoodProperties BLUEBERRY_PIE = (new FoodProperties.Builder()).nutrition(8).saturationModifier(0.3F).build();
    static final FoodProperties PINEAPPLE = (new FoodProperties.Builder()).nutrition(6).saturationModifier(0.5F).build();
    static final FoodProperties SUNFLOWER_SEEDS = (new FoodProperties.Builder().fast()).nutrition(2).saturationModifier(0.1F).build();
    static final FoodProperties STRAWBERRIES = (new FoodProperties.Builder()).nutrition(2).saturationModifier(0.1F).build();
    static final FoodProperties NETHER_STEW = modStew(6).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 300, 0), 1F).build();
    static final FoodProperties ANCIENT_SLIME_STEW = modStew(6).effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 300, 0), 1F).build();
    static final FoodProperties PITCHER_PLANT_ROOT = (new FoodProperties.Builder()).nutrition(1).saturationModifier(0.1F).build();

    private static FoodProperties.Builder modStew(int i) {
        return (new FoodProperties.Builder()).nutrition(i).saturationModifier(0.6F);
    }
}