package net.cinchtail.cinchcraft.item;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.entity.custom.ModBoatEntity;
import net.cinchtail.cinchcraft.item.custom.*;
import net.cinchtail.cinchcraft.sound.ModSounds;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, Cinchcraft.MOD_ID);


    //Miscellaneous
    public static final RegistryObject<Item> RUBY = ITEMS.register("ruby",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> COPPER_NUGGET = ITEMS.register("copper_nugget",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CHAINMAIL = ITEMS.register("chainmail",
            () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CARROT_SEEDS = ITEMS.register("carrot_seeds",
            () -> new CarrotSeedItem(Blocks.CARROTS,
                    new Item.Properties()));
    public static final RegistryObject<Item> SUNFLOWER_HEAD = ITEMS.register("sunflower_head",
            () -> new Item(new Item.Properties().craftRemainder(Items.YELLOW_DYE)));
    public static final RegistryObject<Item> NETHERITE_HORSE_ARMOR = ITEMS.register("netherite_horse_armor",
            () -> new HorseArmorItem(14, "netherite",
                    new Item.Properties().fireResistant().stacksTo(1)));
    public static final RegistryObject<Item> RUBY_HORSE_ARMOR = ITEMS.register("ruby_horse_armor",
            () -> new HorseArmorItem(8, "ruby",
                    new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> DOG_MUSIC_DISC = ITEMS.register("dog_music_disc",
            () -> new RecordItem(8, ModSounds.DOG_MUSIC_DISC, new Item.Properties().rarity(Rarity.RARE).stacksTo(1), 2900));
    public static final RegistryObject<Item> KYOTO_MUSIC_DISC = ITEMS.register("kyoto_music_disc",
            () -> new RecordItem(6, ModSounds.KYOTO_MUSIC_DISC, new Item.Properties().rarity(Rarity.RARE).stacksTo(1), 4980));
    public static final RegistryObject<Item> AZALEA_BOAT = ITEMS.register("azalea_boat",
            () -> new ModBoatItem(false, ModBoatEntity.Type.AZALEA, new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> AZALEA_CHEST_BOAT = ITEMS.register("azalea_chest_boat",
            () -> new ModBoatItem(true, ModBoatEntity.Type.AZALEA, new Item.Properties().stacksTo(1)));

    //Foods
    public static final RegistryObject<Item> VEGETABLE_STEW = ITEMS.register("vegetable_stew",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoods.VEGETABLE_STEW)));
    public static final RegistryObject<Item> NETHER_STEW = ITEMS.register("nether_stew",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoods.NETHER_STEW)));
    public static final RegistryObject<Item> ANCIENT_SLIME_STEW = ITEMS.register("ancient_slime_stew",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(1).food(ModFoods.ANCIENT_SLIME_STEW)));
    public static final RegistryObject<Item> BLUEBERRIES = ITEMS.register("blueberries",
            () -> new ItemNameBlockItem(ModBlocks.BLUEBERRY_BUSH.get(),
                    new Item.Properties().food(ModFoods.BLUEBERRIES)));
    public static final RegistryObject<Item> BLUEBERRY_PIE = ITEMS.register("blueberry_pie",
            () -> new Item(new Item.Properties().food(ModFoods.BLUEBERRY_PIE)));
    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new ItemNameBlockItem(ModBlocks.PINEAPPLE_PLANT.get(),
                    new Item.Properties().food(ModFoods.PINEAPPLE)));
    public static final RegistryObject<Item> STRAWBERRIES = ITEMS.register("strawberries",
            () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_PLANT.get(),
                    new Item.Properties().food(ModFoods.STRAWBERRIES)));
    public static final RegistryObject<Item> PITCHER_PLANT_ROOT = ITEMS.register("pitcher_plant_root",
            () -> new Item(new Item.Properties().food(ModFoods.PITCHER_PLANT_ROOT)));
    public static final RegistryObject<Item> SUNFLOWER_SEEDS = ITEMS.register("sunflower_seeds",
            () -> new ItemNameBlockItem(ModBlocks.SUNFLOWER_CROP.get(),
                    new Item.Properties().food(ModFoods.SUNFLOWER_SEEDS)));


    //Tools and Weapons
    public static final RegistryObject<Item> BLACKSTONE_SWORD = ITEMS.register("blackstone_sword",
            () -> new SwordItem(ModTiers.BLACKSTONE,3, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_PICKAXE = ITEMS.register("blackstone_pickaxe",
            () -> new PickaxeItem(ModTiers.BLACKSTONE,1, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_AXE = ITEMS.register("blackstone_axe",
            () -> new AxeItem(ModTiers.BLACKSTONE,7, -3.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_SHOVEL = ITEMS.register("blackstone_shovel",
            () -> new ShovelItem(ModTiers.BLACKSTONE,1, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> BLACKSTONE_HOE = ITEMS.register("blackstone_hoe",
            () -> new HoeItem(ModTiers.BLACKSTONE,-1, -2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_SWORD = ITEMS.register("deepslate_sword",
            () -> new SwordItem(ModTiers.DEEPSLATE,3, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_PICKAXE = ITEMS.register("deepslate_pickaxe",
            () -> new PickaxeItem(ModTiers.DEEPSLATE,1, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_AXE = ITEMS.register("deepslate_axe",
            () -> new AxeItem(ModTiers.DEEPSLATE,7, -3.2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_SHOVEL = ITEMS.register("deepslate_shovel",
            () -> new ShovelItem(ModTiers.DEEPSLATE,1, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> DEEPSLATE_HOE = ITEMS.register("deepslate_hoe",
            () -> new HoeItem(ModTiers.DEEPSLATE,-1, -2f,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SWORD = ITEMS.register("ruby_sword",
            () -> new SwordItem(ModTiers.RUBY,4, -2.4f,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_PICKAXE = ITEMS.register("ruby_pickaxe",
            () -> new PickaxeItem(ModTiers.RUBY,2, -2.8f,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_AXE = ITEMS.register("ruby_axe",
            () -> new AxeItem(ModTiers.RUBY,6, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_SHOVEL = ITEMS.register("ruby_shovel",
            () -> new ShovelItem(ModTiers.RUBY,2, -3f,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HOE = ITEMS.register("ruby_hoe",
            () -> new HoeItem(ModTiers.RUBY,-2, -.5f,
                    new Item.Properties()));
    public static final RegistryObject<Item> RUBY_HELMET = ITEMS.register("ruby_helmet",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.HELMET, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_CHESTPLATE = ITEMS.register("ruby_chestplate",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.CHESTPLATE, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_LEGGINGS = ITEMS.register("ruby_leggings",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.LEGGINGS, new Item.Properties()));
    public static final RegistryObject<Item> RUBY_BOOTS = ITEMS.register("ruby_boots",
            () -> new ArmorItem(ModArmorMaterials.RUBY, ArmorItem.Type.BOOTS, new Item.Properties()));


    //Block Items
    public static final RegistryObject<Item> THATCH_BLOCK = ITEMS.register("thatch_block",
            () -> new ThatchFullBlock(ModBlocks.THATCH_BLOCK.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> THATCH_STAIRS = ITEMS.register("thatch_stairs",
            () -> new ThatchStairsBlock(ModBlocks.THATCH_STAIRS.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> THATCH_SLAB = ITEMS.register("thatch_slab",
            () -> new ThatchSlabBlock(ModBlocks.THATCH_SLAB.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> GLOWSTONE_TORCH = ITEMS.register("glowstone_torch",
            () -> new ModStandingAndWallBlockItem(ModBlocks.GLOWSTONE_TORCH.get(), ModBlocks.GLOWSTONE_WALL_TORCH.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> FIRE_FERN = ITEMS.register("fire_fern",
            () -> new ItemNameBlockItem(ModBlocks.FIRE_FERN.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> CARVED_MELON = ITEMS.register("carved_melon",
            () -> new ItemNameBlockItem(ModBlocks.CARVED_MELON.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> REEDS_SEEDS = ITEMS.register("reeds_seeds",
            () -> new CarrotSeedItem(ModBlocks.REEDS_CROP_BLOCK.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> CATTAILS = ITEMS.register("cattails",
            () -> new ItemNameBlockItem(ModBlocks.CATTAILS.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> BUTTER_CUP = ITEMS.register("butter_cup",
            () -> new ItemNameBlockItem(ModBlocks.BUTTER_CUP.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> SMALL_ROSE = ITEMS.register("small_rose",
            () -> new ItemNameBlockItem(ModBlocks.SMALL_ROSE.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> CROCUS = ITEMS.register("crocus",
            () -> new ItemNameBlockItem(ModBlocks.CROCUS.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> ALYSSUM = ITEMS.register("alyssum",
            () -> new ItemNameBlockItem(ModBlocks.ALYSSUM.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> LUPINE = ITEMS.register("lupine",
            () -> new ItemNameBlockItem(ModBlocks.LUPINE.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> STAR_CACTUS = ITEMS.register("star_cactus",
            () -> new ItemNameBlockItem(ModBlocks.STAR_CACTUS.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> STALK = ITEMS.register("stalk",
            () -> new StalkItem(ModBlocks.STALK.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_LOG = ITEMS.register("azalea_log",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_LOG.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_WOOD = ITEMS.register("azalea_wood",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_WOOD.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_AZALEA_LOG = ITEMS.register("stripped_azalea_log",
            () -> new ModWoodenFullBlockItem(ModBlocks.STRIPPED_AZALEA_LOG.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> STRIPPED_AZALEA_WOOD = ITEMS.register("stripped_azalea_wood",
            () -> new ModWoodenFullBlockItem(ModBlocks.STRIPPED_AZALEA_WOOD.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_PLANKS = ITEMS.register("azalea_planks",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_PLANKS.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_STAIRS = ITEMS.register("azalea_stairs",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_STAIRS.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_SLAB = ITEMS.register("azalea_slab",
            () -> new ModWoodenSlabItem(ModBlocks.AZALEA_SLAB.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_FENCE = ITEMS.register("azalea_fence",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_FENCE.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_FENCE_GATE = ITEMS.register("azalea_fence_gate",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_FENCE_GATE.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_TRAPDOOR = ITEMS.register("azalea_trapdoor",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_TRAPDOOR.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_DOOR = ITEMS.register("azalea_door",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_DOOR.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_BUTTON = ITEMS.register("azalea_button",
            () -> new ModWoodenButtonItem(ModBlocks.AZALEA_BUTTON.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_PRESSURE_PLATE = ITEMS.register("azalea_pressure_plate",
            () -> new ModWoodenFullBlockItem(ModBlocks.AZALEA_PRESSURE_PLATE.get(),
                    new Item.Properties()));
    public static final RegistryObject<Item> AZALEA_SIGN = ITEMS.register("azalea_sign",
            () -> new ModSignItem(new Item.Properties().stacksTo(16), ModBlocks.AZALEA_SIGN.get(), ModBlocks.AZALEA_WALL_SIGN.get()));
    public static final RegistryObject<Item> AZALEA_HANGING_SIGN = ITEMS.register("azalea_hanging_sign",
            () -> new ModHangingSignItem(ModBlocks.AZALEA_HANGING_SIGN.get(), ModBlocks.AZALEA_WALL_HANGING_SIGN.get(),
                    new Item.Properties().stacksTo(16)));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
