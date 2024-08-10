package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, Cinchcraft.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ModItems.RUBY);
        simpleItem(ModItems.COPPER_NUGGET);
        simpleItem(ModItems.CARROT_SEEDS);
        simpleItem(ModItems.VEGETABLE_STEW);
        simpleItem(ModItems.NETHER_STEW);
        simpleItem(ModItems.NETHERITE_HORSE_ARMOR);
        simpleItem(ModItems.RUBY_HORSE_ARMOR);
        simpleItem(ModItems.BLUEBERRIES);
        simpleItem(ModItems.BLUEBERRY_PIE);
        simpleItem(ModItems.PINEAPPLE);
        simpleItem(ModItems.DOG_MUSIC_DISC);
        simpleItem(ModItems.KYOTO_MUSIC_DISC);
        simpleItem(ModItems.STRAWBERRIES);
        simpleItem(ModItems.PITCHER_PLANT_ROOT);
        simpleItem(ModItems.ANCIENT_SLIME_STEW);
        simpleItem(ModItems.SUNFLOWER_SEEDS);
        simpleItem(ModItems.SUNFLOWER_HEAD);
        simpleItem(ModItems.REEDS_SEEDS);
        simpleItem(ModItems.REEDS);


        simpleItem(ModItems.AZALEA_SIGN);
        simpleItem(ModItems.AZALEA_HANGING_SIGN);
        simpleItem(ModItems.AZALEA_BOAT);
        simpleItem(ModItems.AZALEA_CHEST_BOAT);


        handheldItem(ModItems.DEEPSLATE_SWORD);
        handheldItem(ModItems.DEEPSLATE_PICKAXE);
        handheldItem(ModItems.DEEPSLATE_AXE);
        handheldItem(ModItems.DEEPSLATE_SHOVEL);
        handheldItem(ModItems.DEEPSLATE_HOE);
        handheldItem(ModItems.BLACKSTONE_SWORD);
        handheldItem(ModItems.BLACKSTONE_PICKAXE);
        handheldItem(ModItems.BLACKSTONE_AXE);
        handheldItem(ModItems.BLACKSTONE_SHOVEL);
        handheldItem(ModItems.BLACKSTONE_HOE);
        handheldItem(ModItems.RUBY_SWORD);
        handheldItem(ModItems.RUBY_PICKAXE);
        handheldItem(ModItems.RUBY_AXE);
        handheldItem(ModItems.RUBY_SHOVEL);
        handheldItem(ModItems.RUBY_HOE);
    }
    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    private void handheldItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/handheld")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "item/" + item.getId().getPath()));
    }
}