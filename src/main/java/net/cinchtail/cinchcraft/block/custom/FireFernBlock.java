package net.cinchtail.cinchcraft.block.custom;

import net.cinchtail.cinchcraft.util.ModBlockTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.DoublePlantBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraftforge.common.PlantType;


public class FireFernBlock extends DoublePlantBlock {
    public static final EnumProperty<DoubleBlockHalf> HALF = BlockStateProperties.DOUBLE_BLOCK_HALF;

    public FireFernBlock(BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().setValue(HALF, DoubleBlockHalf.LOWER));
    }
    @Override
    public PlantType getPlantType(BlockGetter level, BlockPos pos) {
        return null;
    }

    public void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!entity.isSteppingCarefully() && entity instanceof LivingEntity) {
            entity.hurt(level.damageSources().inFire(),4.0F);
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    public boolean canSurvive(BlockState blockState, LevelReader levelReader, BlockPos pos)
    {
        if (blockState.getValue(HALF) == DoubleBlockHalf.UPPER)
        {
            BlockState blockstate = levelReader.getBlockState(pos.below());
            if (blockState.getBlock() != this)
                return blockstate.is(ModBlockTags.FIRE_FERN_PLACEABLE) || blockstate.is(this);
            return blockstate.is(this) && blockstate.getValue(HALF) == DoubleBlockHalf.LOWER;
        }

        else if(blockState.getValue(HALF) == DoubleBlockHalf.LOWER)
        {
            return levelReader.getBlockState(pos.below()).is(ModBlockTags.FIRE_FERN_PLACEABLE);
        }
        else
        {
            return false;
        }
    }
}
