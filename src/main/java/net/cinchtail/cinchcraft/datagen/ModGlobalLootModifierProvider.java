package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.loot.AddItemModifier;
import net.cinchtail.cinchcraft.loot.AddItemToSuspiciousBlockModifier;
import net.cinchtail.cinchcraft.loot.RemoveItemModifier;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CarrotBlock;
import net.minecraft.world.level.block.DoublePlantBlock;
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

        add("stalk_from_sunflower", new RemoveItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SUNFLOWER)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)).build(),
        }, ModItems.SUNFLOWER_HEAD.get()));

        add("sunflower_head_from_sunflower", new AddItemModifier(new LootItemCondition[] {
                LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SUNFLOWER)
                        .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(DoublePlantBlock.HALF, DoubleBlockHalf.LOWER)).build(),
        }, ModItems.STALK.get()));

        add("ruby_horse_armor_from_jungle_temple", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_village_armorer", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_desert_pyramid", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("spyglass_from_shipwreck", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_map")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, Items.SPYGLASS));

        add("carrot_seeds_from_shipwreck", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("chests/shipwreck_supply")).build(),
                LootItemRandomChanceCondition.randomChance(0.75f).build() }, ModItems.CARROT_SEEDS.get()));

        add("nautilus_shell_from_cold_ocean_ruin", new AddItemToSuspiciousBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(new ResourceLocation("archaeology/ocean_ruin_cold")).build() },
                Items.NAUTILUS_SHELL));
    }

}
///give Dev minecraft:chest{BlockEntityTag:{LootTable:"minecraft:chests/shipwreck_map"}}
