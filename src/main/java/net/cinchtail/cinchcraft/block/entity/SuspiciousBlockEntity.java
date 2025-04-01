package net.cinchtail.cinchcraft.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.BrushableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class SuspiciousBlockEntity extends BrushableBlockEntity
{
    public SuspiciousBlockEntity(BlockPos pos, BlockState state)
    {
        super(pos, state);
    }

    @Override
    public boolean isValidBlockState(@NotNull BlockState blockState)
    {
        return ModBlockEntities.SUSPICIOUSBLOCK.get().isValid(blockState) || super.isValidBlockState(blockState);
    }

    @Override
    public @NotNull BlockEntityType<?> getType()
    {
        return ModBlockEntities.SUSPICIOUSBLOCK.get();
    }
}