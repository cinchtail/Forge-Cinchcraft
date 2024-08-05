package net.cinchtail.cinchcraft.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.SignBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class ModHangingSignBlockEntity extends SignBlockEntity {
    private static final int MAX_TEXT_LINE_WIDTH = 60;
    private static final int TEXT_LINE_HEIGHT = 9;
    public ModHangingSignBlockEntity(BlockPos blockPos, BlockState blockState) {
        super(ModBlockEntities.MOD_HANGING_SIGN.get(), blockPos, blockState);
    }
    public int getTextLineHeight() {
        return 9;
    }
    public int getMaxTextLineWidth() {
        return 60;
    }
    @Override
    public BlockEntityType<?> getType() {
        return ModBlockEntities.MOD_HANGING_SIGN.get();
    }
}
