package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.item.ModItems;
import net.cinchtail.cinchcraft.loot.AddItemModifier;
import net.cinchtail.cinchcraft.loot.CommonAddItemToSuspiciouseBlockModifier;
import net.cinchtail.cinchcraft.loot.RareAddItemToSuspiciousBlockModifier;
import net.cinchtail.cinchcraft.loot.RemoveItemModifier;
import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.PitcherCropBlock;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;

import java.util.concurrent.CompletableFuture;


public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, Cinchcraft.MOD_ID, registries);
    }

    @Override
    protected void start(HolderLookup.Provider provider) {
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
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/jungle_temple")).build(),
                LootItemRandomChanceCondition.randomChance(0.4f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_village_armorer", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/village/village_weaponsmith")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_dungeon", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/simple_dungeon")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("ruby_horse_armor_from_desert_pyramid", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/desert_pyramid")).build(),
                LootItemRandomChanceCondition.randomChance(0.35f).build() }, ModItems.RUBY_HORSE_ARMOR.get()));

        add("spyglass_from_shipwreck", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/shipwreck_map")).build(),
                LootItemRandomChanceCondition.randomChance(0.25f).build() }, Items.SPYGLASS));

        add("carrot_seeds_from_shipwreck", new AddItemModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("chests/shipwreck_supply")).build(),
                LootItemRandomChanceCondition.randomChance(0.75f).build() }, ModItems.CARROT_SEEDS.get()));

        add("nautilus_shell_from_cold_ocean_ruin", new RareAddItemToSuspiciousBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("archaeology/ocean_ruin_cold")).build() },
                Items.NAUTILUS_SHELL));

        add("nautilus_shell_from_cold_ocean_ruin", new RareAddItemToSuspiciousBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("archaeology/ocean_ruin_warm")).build() },
                Items.NAUTILUS_SHELL));

        add("book_from_trail_ruin_common", new CommonAddItemToSuspiciouseBlockModifier(new LootItemCondition[] {
                new LootTableIdCondition.Builder(ResourceLocation.parse("archaeology/trail_ruins_common")).build() },
                Items.BOOK));
    }
}
//give Dev chest[container_loot={loot_table:"cinchcraft:chests/ruined_tower_creeper_room"}]
//give Dev minecraft:decorated_pot{BlockEntityTag:{LootTable:"cinchcraft:pots/archaeology/abandoned_archaeology_site_basic",sherds:["minecraft:howl_pottery_sherd","minecraft:brick","minecraft:brick","minecraft:brick"]}}