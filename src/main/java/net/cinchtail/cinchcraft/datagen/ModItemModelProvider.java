package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

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


        fenceItem(ModBlocks.MOSSY_NETHER_BRICK_FENCE, ModBlocks.MOSSY_NETHER_BRICKS);
        fenceItem(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_FENCE, ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS);
        fenceItem(ModBlocks.WARPED_MOSSY_NETHER_BRICK_FENCE, ModBlocks.WARPED_MOSSY_NETHER_BRICKS);


        buttonItem(ModBlocks.POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);
        buttonItem(ModBlocks.IRON_BUTTON, Blocks.IRON_BLOCK);
        buttonItem(ModBlocks.GOLD_BUTTON, Blocks.GOLD_BLOCK);


        withExistingParent("smooth_stone_stairs", modLoc("block/smooth_stone_stairs"));
        withExistingParent("smooth_stone_wall", modLoc("block/smooth_stone_wall_inventory"));
        withExistingParent("tuff_stairs", modLoc("block/tuff_stairs"));
        withExistingParent("tuff_slab", modLoc("block/tuff_slab"));
        withExistingParent("tuff_wall", modLoc("block/tuff_wall_inventory"));
        withExistingParent("calcite_stairs", modLoc("block/calcite_stairs"));
        withExistingParent("calcite_slab", modLoc("block/calcite_slab"));
        withExistingParent("calcite_wall", modLoc("block/calcite_wall_inventory"));
        withExistingParent("dripstone_stairs", modLoc("block/dripstone_stairs"));
        withExistingParent("dripstone_slab", modLoc("block/dripstone_slab"));
        withExistingParent("dripstone_wall", modLoc("block/dripstone_wall_inventory"));
        withExistingParent("quartz_brick_stairs", modLoc("block/quartz_brick_stairs"));
        withExistingParent("quartz_brick_slab", modLoc("block/quartz_brick_slab"));
        withExistingParent("quartz_brick_wall", modLoc("block/quartz_brick_wall_inventory"));
        withExistingParent("thatch_block", modLoc("block/thatch_block"));
        withExistingParent("thatch_stairs", modLoc("block/thatch_stairs"));
        withExistingParent("thatch_slab", modLoc("block/thatch_slab"));
        withExistingParent("stone_wall", modLoc("block/stone_wall_inventory"));
        withExistingParent("polished_granite_wall", modLoc("block/polished_granite_wall_inventory"));
        withExistingParent("polished_andesite_wall", modLoc("block/polished_andesite_wall_inventory"));
        withExistingParent("polished_diorite_wall", modLoc("block/polished_diorite_wall_inventory"));
        withExistingParent("prismarine_brick_wall", modLoc("block/prismarine_brick_wall_inventory"));
        withExistingParent("dark_prismarine_wall", modLoc("block/dark_prismarine_wall_inventory"));
        withExistingParent("cut_sandstone_wall", modLoc("block/cut_sandstone_wall_inventory"));
        withExistingParent("cut_sandstone_wall", modLoc("block/cut_sandstone_wall_inventory"));
        withExistingParent("cut_red_sandstone_wall", modLoc("block/cut_red_sandstone_wall_inventory"));
        withExistingParent("purpur_wall", modLoc("block/purpur_wall_inventory"));
        withExistingParent("end_stone_stairs", modLoc("block/end_stone_stairs"));
        withExistingParent("end_stone_slab", modLoc("block/end_stone_slab"));
        withExistingParent("end_stone_wall", modLoc("block/end_stone_wall_inventory"));
        withExistingParent("chiseled_end_stone_bricks", modLoc("block/chiseled_end_stone_bricks"));
        withExistingParent("red_nether_brick_fence", modLoc("block/red_nether_brick_fence_inventory"));
        withExistingParent("cracked_red_nether_bricks", modLoc("block/cracked_red_nether_bricks"));
        withExistingParent("mossy_mud_brick_stairs", modLoc("block/mossy_mud_brick_stairs"));
        withExistingParent("mossy_mud_brick_slab", modLoc("block/mossy_mud_brick_slab"));
        withExistingParent("mossy_mud_brick_wall", modLoc("block/mossy_mud_brick_wall_inventory"));
        withExistingParent("polished_tuff_stairs", modLoc("block/polished_tuff_stairs"));
        withExistingParent("polished_tuff_slab", modLoc("block/polished_tuff_slab"));
        withExistingParent("polished_tuff_wall", modLoc("block/polished_tuff_wall_inventory"));
        withExistingParent("polished_calcite_stairs", modLoc("block/polished_calcite_stairs"));
        withExistingParent("polished_calcite_slab", modLoc("block/polished_calcite_slab"));
        withExistingParent("polished_calcite_wall", modLoc("block/polished_calcite_wall_inventory"));
        withExistingParent("polished_dripstone_stairs", modLoc("block/polished_dripstone_stairs"));
        withExistingParent("polished_dripstone_slab", modLoc("block/polished_dripstone_slab"));
        withExistingParent("polished_dripstone_wall", modLoc("block/polished_dripstone_wall_inventory"));
        withExistingParent("mossy_cobbled_deepslate_stairs", modLoc("block/mossy_cobbled_deepslate_stairs"));
        withExistingParent("mossy_cobbled_deepslate_slab", modLoc("block/mossy_cobbled_deepslate_slab"));
        withExistingParent("mossy_cobbled_deepslate_wall", modLoc("block/mossy_cobbled_deepslate_wall_inventory"));
        withExistingParent("mossy_deepslate_brick_stairs", modLoc("block/mossy_deepslate_brick_stairs"));
        withExistingParent("mossy_deepslate_brick_slab", modLoc("block/mossy_deepslate_brick_slab"));
        withExistingParent("mossy_deepslate_brick_wall", modLoc("block/mossy_deepslate_brick_wall_inventory"));
        withExistingParent("mossy_deepslate_tile_stairs", modLoc("block/mossy_deepslate_tile_stairs"));
        withExistingParent("mossy_deepslate_tile_slab", modLoc("block/mossy_deepslate_tile_slab"));
        withExistingParent("mossy_deepslate_tile_wall", modLoc("block/mossy_deepslate_tile_wall_inventory"));
        withExistingParent("cracked_stone_brick_stairs", modLoc("block/cracked_stone_brick_stairs"));
        withExistingParent("cracked_stone_brick_slab", modLoc("block/cracked_stone_brick_slab"));
        withExistingParent("cracked_stone_brick_wall", modLoc("block/cracked_stone_brick_wall_inventory"));
        withExistingParent("cracked_deepslate_brick_stairs", modLoc("block/cracked_deepslate_brick_stairs"));
        withExistingParent("cracked_deepslate_brick_slab", modLoc("block/cracked_deepslate_brick_slab"));
        withExistingParent("cracked_deepslate_brick_wall", modLoc("block/cracked_deepslate_brick_wall_inventory"));
        withExistingParent("cracked_deepslate_tile_stairs", modLoc("block/cracked_deepslate_tile_stairs"));
        withExistingParent("cracked_deepslate_tile_slab", modLoc("block/cracked_deepslate_tile_slab"));
        withExistingParent("cracked_deepslate_tile_wall", modLoc("block/cracked_deepslate_tile_wall_inventory"));
        withExistingParent("cracked_polished_blackstone_brick_stairs", modLoc("block/cracked_polished_blackstone_brick_stairs"));
        withExistingParent("cracked_polished_blackstone_brick_slab", modLoc("block/cracked_polished_blackstone_brick_slab"));
        withExistingParent("cracked_polished_blackstone_brick_wall", modLoc("block/cracked_polished_blackstone_brick_wall_inventory"));
        withExistingParent("cracked_nether_brick_stairs", modLoc("block/cracked_nether_brick_stairs"));
        withExistingParent("cracked_nether_brick_slab", modLoc("block/cracked_nether_brick_slab"));
        withExistingParent("cracked_nether_brick_wall", modLoc("block/cracked_nether_brick_wall_inventory"));
        withExistingParent("cracked_red_nether_brick_stairs", modLoc("block/cracked_red_nether_brick_stairs"));
        withExistingParent("cracked_red_nether_brick_slab", modLoc("block/cracked_red_nether_brick_slab"));
        withExistingParent("cracked_red_nether_brick_wall", modLoc("block/cracked_red_nether_brick_wall_inventory"));
        withExistingParent("cracked_mud_brick_stairs", modLoc("block/cracked_mud_brick_stairs"));
        withExistingParent("cracked_mud_brick_slab", modLoc("block/cracked_mud_brick_slab"));
        withExistingParent("cracked_mud_brick_wall", modLoc("block/cracked_mud_brick_wall_inventory"));
        withExistingParent("cracked_quartz_brick_stairs", modLoc("block/cracked_quartz_brick_stairs"));
        withExistingParent("cracked_quartz_brick_slab", modLoc("block/cracked_quartz_brick_slab"));
        withExistingParent("cracked_quartz_brick_wall", modLoc("block/cracked_quartz_brick_wall_inventory"));
        withExistingParent("smooth_basalt_stairs", modLoc("block/smooth_basalt_stairs"));
        withExistingParent("smooth_basalt_slab", modLoc("block/smooth_basalt_slab"));
        withExistingParent("smooth_basalt_wall", modLoc("block/smooth_basalt_wall_inventory"));
        withExistingParent("mossy_nether_brick_stairs", modLoc("block/mossy_nether_brick_stairs"));
        withExistingParent("mossy_nether_brick_slab", modLoc("block/mossy_nether_brick_slab"));
        withExistingParent("mossy_nether_brick_wall", modLoc("block/mossy_nether_brick_wall_inventory"));
        withExistingParent("crimson_mossy_nether_brick_stairs", modLoc("block/crimson_mossy_nether_brick_stairs"));
        withExistingParent("crimson_mossy_nether_brick_slab", modLoc("block/crimson_mossy_nether_brick_slab"));
        withExistingParent("crimson_mossy_nether_brick_wall", modLoc("block/crimson_mossy_nether_brick_wall_inventory"));
        withExistingParent("warped_mossy_nether_brick_stairs", modLoc("block/warped_mossy_nether_brick_stairs"));
        withExistingParent("warped_mossy_nether_brick_slab", modLoc("block/warped_mossy_nether_brick_slab"));
        withExistingParent("warped_mossy_nether_brick_wall", modLoc("block/warped_mossy_nether_brick_wall_inventory"));
    }
    private void simpleItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/generated")).texture("layer0",
                new ResourceLocation(Cinchcraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    private void handheldItem(RegistryObject<Item> item) {
        withExistingParent(item.getId().getPath(),
                new ResourceLocation("item/handheld")).texture("layer0",
                new ResourceLocation(Cinchcraft.MOD_ID, "item/" + item.getId().getPath()));
    }
    public void buttonItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  new ResourceLocation("minecraft", "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  new ResourceLocation(Cinchcraft.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }
}