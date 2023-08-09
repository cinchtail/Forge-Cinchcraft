package net.cinchtail.cinchcraft.item;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB,
            Cinchcraft.MOD_ID);

    public static final RegistryObject<CreativeModeTab> CINCHCRAFT_BLOCK_TAB = CREATIVE_MODE_TABS.register("cinchcraft_block_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModBlocks.BLOCK_OF_RUBY.get()))
                    .title(Component.literal("Cinchcraft Block Tab"))
                    .displayItems((displayParameters, output) -> {
                        output.accept(ModBlocks.BLOCK_OF_RUBY.get());
                        output.accept(ModBlocks.RUBY_ORE.get());
                        output.accept(ModBlocks.DEEPSLATE_RUBY_ORE.get());
                        output.accept(ModBlocks.NETHER_COAL_ORE.get());
                        output.accept(ModBlocks.NETHER_COPPER_ORE.get());
                        output.accept(ModBlocks.NETHER_IRON_ORE.get());
                        output.accept(ModBlocks.NETHER_LAPIS_LAZULI_ORE.get());
                        output.accept(ModBlocks.NETHER_REDSTONE_ORE.get());
                        output.accept(ModBlocks.NETHER_EMERALD_ORE.get());
                        output.accept(ModBlocks.NETHER_RUBY_ORE.get());
                        output.accept(ModBlocks.NETHER_DIAMOND_ORE.get());
                        output.accept(ModBlocks.TUFF_STAIRS.get());
                        output.accept(ModBlocks.TUFF_SLAB.get());
                        output.accept(ModBlocks.TUFF_WALL.get());
                        output.accept(ModBlocks.CALCITE_STAIRS.get());
                        output.accept(ModBlocks.CALCITE_SLAB.get());
                        output.accept(ModBlocks.CALCITE_WALL.get());
                        output.accept(ModBlocks.DRIPSTONE_STAIRS.get());
                        output.accept(ModBlocks.DRIPSTONE_SLAB.get());
                        output.accept(ModBlocks.DRIPSTONE_WALL.get());
                        output.accept(ModBlocks.POLISHED_TUFF.get());
                        output.accept(ModBlocks.POLISHED_TUFF_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_TUFF_SLAB.get());
                        output.accept(ModBlocks.POLISHED_TUFF_WALL.get());
                        output.accept(ModBlocks.POLISHED_CALCITE.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_CALCITE_WALL.get());
                        output.accept(ModBlocks.POLISHED_DRIPSTONE_BLOCK.get());
                        output.accept(ModBlocks.POLISHED_DRIPSTONE_STAIRS.get());
                        output.accept(ModBlocks.POLISHED_DRIPSTONE_SLAB.get());
                        output.accept(ModBlocks.POLISHED_DRIPSTONE_WALL.get());
                        output.accept(ModBlocks.CRACKED_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_STONE_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_DEEPSLATE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_DEEPSLATE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_DEEPSLATE_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_DEEPSLATE_TILE_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_DEEPSLATE_TILE_SLAB.get());
                        output.accept(ModBlocks.CRACKED_DEEPSLATE_TILE_WALL.get());
                        output.accept(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_POLISHED_BLACKSTONE_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_NETHER_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_NETHER_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_NETHER_BRICK_WALL.get());
                        output.accept(ModBlocks.MOSSY_NETHER_BRICKS.get());
                        output.accept(ModBlocks.MOSSY_NETHER_BRICK_STAIRS.get());
                        output.accept(ModBlocks.MOSSY_NETHER_BRICK_SLAB.get());
                        output.accept(ModBlocks.MOSSY_NETHER_BRICK_WALL.get());
                        output.accept(ModBlocks.MOSSY_NETHER_BRICK_FENCE.get());
                        output.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS.get());
                        output.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_WALL.get());
                        output.accept(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_FENCE.get());
                        output.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICKS.get());
                        output.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_STAIRS.get());
                        output.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_SLAB.get());
                        output.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_WALL.get());
                        output.accept(ModBlocks.WARPED_MOSSY_NETHER_BRICK_FENCE.get());
                        output.accept(ModBlocks.CHISELED_RED_NETHER_BRICKS.get());
                        output.accept(ModBlocks.RED_NETHER_BRICK_FENCE.get());
                        output.accept(ModBlocks.CRACKED_RED_NETHER_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_RED_NETHER_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_RED_NETHER_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_RED_NETHER_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_MUD_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_MUD_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_MUD_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_MUD_BRICK_WALL.get());
                        output.accept(ModBlocks.CHISELED_MUD_BRICKS.get());
                        output.accept(ModBlocks.MOSSY_MUD_BRICKS.get());
                        output.accept(ModBlocks.MOSSY_MUD_BRICK_STAIRS.get());
                        output.accept(ModBlocks.MOSSY_MUD_BRICK_SLAB.get());
                        output.accept(ModBlocks.MOSSY_MUD_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_QUARTZ_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_QUARTZ_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_QUARTZ_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_QUARTZ_BRICK_WALL.get());
                        output.accept(ModBlocks.QUARTZ_BRICK_STAIRS.get());
                        output.accept(ModBlocks.QUARTZ_BRICK_SLAB.get());
                        output.accept(ModBlocks.QUARTZ_BRICK_WALL.get());
                        output.accept(ModBlocks.CRACKED_PRISMARINE_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_PRISMARINE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_PRISMARINE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_PRISMARINE_BRICK_WALL.get());
                        output.accept(ModBlocks.CHISELED_END_STONE_BRICKS.get());
                        output.accept(ModBlocks.END_STONE_STAIRS.get());
                        output.accept(ModBlocks.END_STONE_SLAB.get());
                        output.accept(ModBlocks.END_STONE_WALL.get());
                        output.accept(ModBlocks.CRACKED_END_STONE_BRICKS.get());
                        output.accept(ModBlocks.CRACKED_END_STONE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.CRACKED_END_STONE_BRICK_SLAB.get());
                        output.accept(ModBlocks.CRACKED_END_STONE_BRICK_WALL.get());
                        output.accept(ModBlocks.SMOOTH_BASALT_STAIRS.get());
                        output.accept(ModBlocks.SMOOTH_BASALT_SLAB.get());
                        output.accept(ModBlocks.SMOOTH_BASALT_WALL.get());
                        output.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE.get());
                        output.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_STAIRS.get());
                        output.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_SLAB.get());
                        output.accept(ModBlocks.MOSSY_COBBLED_DEEPSLATE_WALL.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_BRICKS.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_STAIRS.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_SLAB.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_BRICK_WALL.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_TILES.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_STAIRS.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_SLAB.get());
                        output.accept(ModBlocks.MOSSY_DEEPSLATE_TILE_WALL.get());
                        output.accept(ModItems.AZALEA_LOG.get());
                        output.accept(ModItems.AZALEA_WOOD.get());
                        output.accept(ModItems.STRIPPED_AZALEA_LOG.get());
                        output.accept(ModItems.STRIPPED_AZALEA_WOOD.get());
                        output.accept(ModItems.AZALEA_PLANKS.get());
                        output.accept(ModItems.AZALEA_STAIRS.get());
                        output.accept(ModItems.AZALEA_SLAB.get());
                        output.accept(ModItems.AZALEA_FENCE.get());
                        output.accept(ModItems.AZALEA_FENCE_GATE.get());
                        output.accept(ModItems.AZALEA_DOOR.get());
                        output.accept(ModItems.AZALEA_TRAPDOOR.get());
                        output.accept(ModItems.AZALEA_SIGN.get());
                        output.accept(ModItems.AZALEA_HANGING_SIGN.get());
                        output.accept(ModItems.AZALEA_PRESSURE_PLATE.get());
                        output.accept(ModItems.AZALEA_BUTTON.get());
                        output.accept(ModBlocks.SMOOTH_STONE_STAIRS.get());
                        output.accept(ModBlocks.SMOOTH_STONE_WALL.get());
                        output.accept(ModBlocks.CUT_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.CUT_SANDSTONE_WALL.get());
                        output.accept(ModBlocks.CUT_RED_SANDSTONE_STAIRS.get());
                        output.accept(ModBlocks.CUT_RED_SANDSTONE_WALL.get());
                        output.accept(ModBlocks.STONE_WALL.get());
                        output.accept(ModBlocks.POLISHED_GRANITE_WALL.get());
                        output.accept(ModBlocks.POLISHED_ANDESITE_WALL.get());
                        output.accept(ModBlocks.POLISHED_DIORITE_WALL.get());
                        output.accept(ModBlocks.PRISMARINE_BRICK_WALL.get());
                        output.accept(ModBlocks.DARK_PRISMARINE_WALL.get());
                        output.accept(ModBlocks.SMOOTH_SANDSTONE_WALL.get());
                        output.accept(ModBlocks.SMOOTH_RED_SANDSTONE_WALL.get());
                        output.accept(ModBlocks.QUARTZ_WALL.get());
                        output.accept(ModBlocks.SMOOTH_QUARTZ_WALL.get());
                        output.accept(ModBlocks.PURPUR_WALL.get());
                        output.accept(ModBlocks.POLISHED_DEEPSLATE_PRESSURE_PLATE.get());
                        output.accept(ModBlocks.POLISHED_DEEPSLATE_BUTTON.get());
                        output.accept(ModBlocks.IRON_BUTTON.get());
                        output.accept(ModBlocks.GOLD_BUTTON.get());
                        output.accept(ModItems.CARVED_MELON.get());
                        output.accept(ModItems.GLOWSTONE_TORCH.get());
                        output.accept(ModItems.THATCH_BLOCK.get());
                        output.accept(ModItems.THATCH_STAIRS.get());
                        output.accept(ModItems.THATCH_SLAB.get());
                        output.accept(ModItems.REEDS.get());
                        output.accept(ModItems.CATTAILS.get());
                        output.accept(ModItems.FIRE_FERN.get());
                        output.accept(ModBlocks.BUBBLE_FLOWER.get());
                        output.accept(ModItems.BUTTER_CUP.get());
                        output.accept(ModItems.CROCUS.get());
                        output.accept(ModItems.ALYSSUM.get());
                        output.accept(ModItems.SMALL_ROSE.get());
                        output.accept(ModItems.LUPINE.get());
                        output.accept(ModItems.STAR_CACTUS.get());
                        output.accept(ModItems.STALK.get());
                    }).build());


    public static RegistryObject<CreativeModeTab> CINCHCRAFT_ITEM_TAB = CREATIVE_MODE_TABS.register("cinchcraft_item_tab",() ->
            CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.RUBY.get()))
                    .title(Component.literal("Cinchcraft Item Tab")).displayItems((displayParameters, output) -> {
                        output.accept(ModItems.RUBY_SWORD.get());
                        output.accept(ModItems.RUBY_PICKAXE.get());
                        output.accept(ModItems.RUBY_AXE.get());
                        output.accept(ModItems.RUBY_SHOVEL.get());
                        output.accept(ModItems.RUBY_HOE.get());
                        output.accept(ModItems.RUBY_HELMET.get());
                        output.accept(ModItems.RUBY_CHESTPLATE.get());
                        output.accept(ModItems.RUBY_LEGGINGS.get());
                        output.accept(ModItems.RUBY_BOOTS.get());
                        //output.accept(ModItems.EMERALD_SWORD.get());
                        //output.accept(ModItems.EMERALD_PICKAXE.get());
                        //output.accept(ModItems.EMERALD_AXE.get());
                        //output.accept(ModItems.EMERALD_SHOVEL.get());
                        //output.accept(ModItems.EMERALD_HOE.get());
                        //output.accept(ModItems.EMERALD_HELMET.get());
                        //output.accept(ModItems.EMERALD_CHESTPLATE.get());
                        //output.accept(ModItems.EMERALD_LEGGING.get());
                        //output.accept(ModItems.EMERALD_BOOTS.get());
                        output.accept(ModItems.DEEPSLATE_SWORD.get());
                        output.accept(ModItems.DEEPSLATE_PICKAXE.get());
                        output.accept(ModItems.DEEPSLATE_AXE.get());
                        output.accept(ModItems.DEEPSLATE_SHOVEL.get());
                        output.accept(ModItems.DEEPSLATE_HOE.get());
                        output.accept(ModItems.BLACKSTONE_SWORD.get());
                        output.accept(ModItems.BLACKSTONE_PICKAXE.get());
                        output.accept(ModItems.BLACKSTONE_AXE.get());
                        output.accept(ModItems.BLACKSTONE_SHOVEL.get());
                        output.accept(ModItems.BLACKSTONE_HOE.get());
                        output.accept(ModItems.AZALEA_BOAT.get());
                        output.accept(ModItems.AZALEA_CHEST_BOAT.get());
                        output.accept(ModItems.NETHERITE_HORSE_ARMOR.get());
                        output.accept(ModItems.RUBY_HORSE_ARMOR.get());
                        //output.accept(ModItems.EMERALD_HORSE_ARMOR.get());
                        output.accept(ModItems.RUBY.get());
                        output.accept(ModItems.COPPER_NUGGET.get());
                        output.accept(ModItems.CHAINMAIL.get());
                        output.accept(ModItems.DOG_MUSIC_DISC.get());
                        output.accept(ModItems.KYOTO_MUSIC_DISC.get());
                        output.accept(ModItems.CARROT_SEEDS.get());
                        output.accept(ModItems.SUNFLOWER_SEEDS.get());
                        output.accept(ModItems.SUNFLOWER_HEAD.get());
                        output.accept(ModItems.BLUEBERRIES.get());
                        output.accept(ModItems.STRAWBERRIES.get());
                        output.accept(ModItems.PINEAPPLE.get());
                        output.accept(ModItems.BLUEBERRY_PIE.get());
                        output.accept(ModItems.PITCHER_PLANT_ROOT.get());
                        output.accept(ModItems.VEGETABLE_STEW.get());
                        output.accept(ModItems.NETHER_STEW.get());
                        output.accept(ModItems.ANCIENT_SLIME_STEW.get());
                    }).build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
