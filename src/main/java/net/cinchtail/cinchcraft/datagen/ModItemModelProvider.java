package net.cinchtail.cinchcraft.datagen;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.cinchtail.cinchcraft.block.ModBlocks;
import net.cinchtail.cinchcraft.item.ModItems;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
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
        simpleItem(ModItems.REEDS_SEEDS);
        simpleItem(ModItems.REEDS);


        simpleItem(ModItems.AZALEA_SIGN);
        simpleItem(ModItems.AZALEA_HANGING_SIGN);
        simpleItem(ModItems.AZALEA_BOAT);
        simpleItem(ModItems.AZALEA_CHEST_BOAT);


        simpleBlockItem(ModBlocks.AZALEA_DOOR);


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


        fenceItem(ModBlocks.CRACKED_NETHER_BRICK_FENCE, Blocks.CRACKED_NETHER_BRICKS);
        modFenceItem(ModBlocks.MOSSY_NETHER_BRICK_FENCE, ModBlocks.MOSSY_NETHER_BRICKS);
        modFenceItem(ModBlocks.CRIMSON_MOSSY_NETHER_BRICK_FENCE, ModBlocks.CRIMSON_MOSSY_NETHER_BRICKS);
        modFenceItem(ModBlocks.WARPED_MOSSY_NETHER_BRICK_FENCE, ModBlocks.WARPED_MOSSY_NETHER_BRICKS);
        modFenceItem(ModBlocks.AZALEA_FENCE, ModBlocks.AZALEA_PLANKS);
        modFenceItem(ModBlocks.CRACKED_RED_NETHER_BRICK_FENCE, ModBlocks.CRACKED_RED_NETHER_BRICKS);


        buttonItem(ModBlocks.POLISHED_DEEPSLATE_BUTTON, Blocks.POLISHED_DEEPSLATE);
        buttonItem(ModBlocks.IRON_BUTTON, Blocks.IRON_BLOCK);
        buttonItem(ModBlocks.GOLD_BUTTON, Blocks.GOLD_BLOCK);
        modButtonItem(ModBlocks.AZALEA_BUTTON, ModBlocks.AZALEA_PLANKS.get());
    }
    private ItemModelBuilder simpleBlockItem(RegistryObject<Block> item) {
        return withExistingParent(item.getId().getPath(),
                ResourceLocation.parse("item/generated")).texture("layer0",
                ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID,"item/" + item.getId().getPath()));
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
    public void buttonItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath()));
    }
    public void modButtonItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/button_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath()));
    }
    public void modFenceItem(RegistryObject<Block> block, RegistryObject<Block> baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock.get())).getPath()));
    }
    public void fenceItem(RegistryObject<Block> block, Block baseBlock) {
        this.withExistingParent(Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(block.get())).getPath(), mcLoc("block/fence_inventory"))
                .texture("texture",  ResourceLocation.fromNamespaceAndPath("minecraft", "block/" + Objects.requireNonNull(ForgeRegistries.BLOCKS.getKey(baseBlock)).getPath()));
    }
}