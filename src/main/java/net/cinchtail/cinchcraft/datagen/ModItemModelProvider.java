package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
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

        withExistingParent("smooth_stone_stairs", modLoc("block/smooth_stone_stairs"));
        withExistingParent("tuff_stairs", modLoc("block/tuff_stairs"));
        withExistingParent("tuff_slab", modLoc("block/tuff_slab"));
        withExistingParent("calcite_stairs", modLoc("block/calcite_stairs"));
        withExistingParent("calcite_slab", modLoc("block/calcite_slab"));
        withExistingParent("dripstone_stairs", modLoc("block/dripstone_stairs"));
        withExistingParent("dripstone_slab", modLoc("block/dripstone_slab"));
        withExistingParent("quartz_brick_stairs", modLoc("block/quartz_brick_stairs"));
        withExistingParent("quartz_brick_slab", modLoc("block/quartz_brick_slab"));

    }

    private ItemModelBuilder simpleItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Cinchcraft.MOD_ID,"item/" + item.getId().getPath()));
    }

    private ItemModelBuilder handheldItem(RegistryObject<Item> item) {
        return withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Cinchcraft.MOD_ID,"item/" + item.getId().getPath()));
    }
}