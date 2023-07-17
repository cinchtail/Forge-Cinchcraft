package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.loot.AddItemModifier;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.PitcherCropBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;


public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output) {
        super(output, Cinchcraft.MOD_ID);
    }

    @Override
    protected void start() {
        add("pitcher_plant_root_from_pitcher_crop", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.PITCHER_CROP)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PitcherCropBlock.AGE, 4)
                                .hasProperty(PitcherCropBlock.HALF, DoubleBlockHalf.UPPER)).build(),
                }, ModItems.PITCHER_PLANT_ROOT.get()));

        add("ruby_horse_armor_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_village_armorer", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));
    }

}
