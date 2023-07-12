package net.cinchtail.cinchcraft.block.custom;

import net.cinchtail.cinchcraft.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DoubleBlockHalf;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import javax.annotation.Nullable;

public class ModSunflowerCropBlock extends DoublePlantBlock implements BonemealableBlock {
    public static final IntegerProperty AGE = BlockStateProperties.AGE_4;
    public static final int MAX_AGE = 4;
    private static final int DOUBLE_PLANT_AGE_INTERSECTION = 3;
    private static final int BONEMEAL_INCREASE = 1;

    private static final VoxelShape FULL_UPPER_SHAPE = Block.box(3.0D, 0.0D, 3.0D, 13.0D, 15.0D, 13.0D);
    private static final VoxelShape FULL_LOWER_SHAPE = Block.box(3.0D, -1.0D, 3.0D, 13.0D, 16.0D, 13.0D);
    private static final VoxelShape[] UPPER_SHAPE_BY_AGE = new VoxelShape[]{Block.box(3.0D, 0.0D, 3.0D, 13.0D, 11.0D, 13.0D), FULL_UPPER_SHAPE};
    private static final VoxelShape[] LOWER_SHAPE_BY_AGE = new VoxelShape[]{Block.box(3.0D, -1.0D, 3.0D, 13.0D, 14.0D, 13.0D), FULL_LOWER_SHAPE, FULL_LOWER_SHAPE, FULL_LOWER_SHAPE};
    public ModSunflowerCropBlock(Properties p_52861_) {
        super(p_52861_);
    }
    private boolean isMaxAge(BlockState p_277387_) {
        return p_277387_.getValue(AGE) >= 4;
    }

    public boolean isRandomlyTicking(BlockState p_277483_) {
        return p_277483_.getValue(HALF) == DoubleBlockHalf.LOWER && !this.isMaxAge(p_277483_);
    }
    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext p_277448_) {
        return this.defaultBlockState();
    }
    protected boolean mayPlaceOn(BlockState p_277418_, BlockGetter p_277461_, BlockPos p_277608_) {
        return p_277418_.is(BlockTags.DIRT);
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> p_277573_) {
        p_277573_.add(AGE);
        super.createBlockStateDefinition(p_277573_);
    }

    public VoxelShape getShape(BlockState p_277602_, BlockGetter p_277617_, BlockPos p_278005_, CollisionContext p_277514_) {
        return p_277602_.getValue(HALF) == DoubleBlockHalf.UPPER ? UPPER_SHAPE_BY_AGE[Math.min(Math.abs(4 - (p_277602_.getValue(AGE) + 1)), UPPER_SHAPE_BY_AGE.length - 1)] : LOWER_SHAPE_BY_AGE[p_277602_.getValue(AGE)];
    }

    public BlockState updateShape(BlockState p_277518_, Direction p_277700_, BlockState p_277660_, LevelAccessor p_277653_, BlockPos p_277982_, BlockPos p_278106_) {
        return !p_277518_.canSurvive(p_277653_, p_277982_) ? Blocks.AIR.defaultBlockState() : p_277518_;
    }
    public boolean canSurvive(BlockState p_277671_, LevelReader p_277477_, BlockPos p_278085_) {
        if (!isLower(p_277671_)) {
            return super.canSurvive(p_277671_, p_277477_, p_278085_);
        } else {
            return this.mayPlaceOn(p_277477_.getBlockState(p_278085_.below()), p_277477_, p_278085_.below()) && sufficientLight(p_277477_, p_278085_) && (p_277671_.getValue(AGE) < 3 || isUpper(p_277477_.getBlockState(p_278085_.above())));
        }
    }
    public boolean canBeReplaced(BlockState p_277627_, BlockPlaceContext p_277759_) {
        return false;
    }

    public void setPlacedBy(Level p_277432_, BlockPos p_277632_, BlockState p_277479_, LivingEntity p_277805_, ItemStack p_277663_) {
    }

    public void randomTick(BlockState p_277950_, ServerLevel p_277589_, BlockPos p_277937_, RandomSource p_277887_) {
        float f = ModSunflowerCropBlock.modGetGrowthSpeed(this, p_277589_, p_277937_);
        boolean flag = p_277887_.nextInt((int)(25.0F / f) + 1) == 0;
        if (flag) {
            this.grow(p_277589_, p_277950_, p_277937_, 1);
        }

    }
    protected static float modGetGrowthSpeed(Block p_52273_, BlockGetter p_52274_, BlockPos p_52275_) {
        float f = 1.0F;
        BlockPos blockpos = p_52275_.below();

        for(int i = -1; i <= 1; ++i) {
            for(int j = -1; j <= 1; ++j) {
                float f1 = 0.0F;
                BlockState blockstate = p_52274_.getBlockState(blockpos.offset(i, 0, j));
                if (blockstate.canSustainPlant(p_52274_, blockpos.offset(i, 0, j), net.minecraft.core.Direction.UP, (net.minecraftforge.common.IPlantable) p_52273_)) {
                    f1 = 3.0F;
                }

                if (i != 0 || j != 0) {
                    f1 /= 4.0F;
                }

                f += f1;
            }
        }

        BlockPos blockpos1 = p_52275_.north();
        BlockPos blockpos2 = p_52275_.south();
        BlockPos blockpos3 = p_52275_.west();
        BlockPos blockpos4 = p_52275_.east();
        boolean flag = p_52274_.getBlockState(blockpos3).is(p_52273_) || p_52274_.getBlockState(blockpos4).is(p_52273_);
        boolean flag1 = p_52274_.getBlockState(blockpos1).is(p_52273_) || p_52274_.getBlockState(blockpos2).is(p_52273_);
        if (flag && flag1) {
            f /= 2.0F;
        } else {
            boolean flag2 = p_52274_.getBlockState(blockpos3.north()).is(p_52273_) || p_52274_.getBlockState(blockpos4.north()).is(p_52273_) || p_52274_.getBlockState(blockpos4.south()).is(p_52273_) || p_52274_.getBlockState(blockpos3.south()).is(p_52273_);
            if (flag2) {
                f /= 2.0F;
            }
        }

        return f;
    }
    private void grow(ServerLevel p_277975_, BlockState p_277349_, BlockPos p_277585_, int p_277498_) {
        int i = Math.min(p_277349_.getValue(AGE) + p_277498_, 4);
        if (this.canGrow(p_277975_, p_277585_, p_277349_, i)) {
            p_277975_.setBlock(p_277585_, p_277349_.setValue(AGE, i), 2);
            if (i >= 3) {
                BlockPos blockpos = p_277585_.above();
                p_277975_.setBlock(blockpos, copyWaterloggedFrom(p_277975_, p_277585_, this.defaultBlockState().setValue(AGE, i).setValue(HALF, DoubleBlockHalf.UPPER)), 3);
            }

        }
    }
    private static boolean canGrowInto(LevelReader p_290010_, BlockPos p_277823_) {
        BlockState blockstate = p_290010_.getBlockState(p_277823_);
        return blockstate.isAir() || blockstate.is(ModBlocks.SUNFLOWER_CROP.get());
    }
    private static boolean sufficientLight(LevelReader p_290018_, BlockPos p_290011_) {
        return p_290018_.getRawBrightness(p_290011_, 0) >= 8 || p_290018_.canSeeSky(p_290011_);
    }

    private static boolean isLower(BlockState p_279488_) {
        return p_279488_.is(ModBlocks.SUNFLOWER_CROP.get()) && p_279488_.getValue(HALF) == DoubleBlockHalf.LOWER;
    }

    private static boolean isUpper(BlockState p_290013_) {
        return p_290013_.is(ModBlocks.SUNFLOWER_CROP.get()) && p_290013_.getValue(HALF) == DoubleBlockHalf.UPPER;
    }

    private boolean canGrow(LevelReader p_290007_, BlockPos p_290014_, BlockState p_290017_, int p_290008_) {
        return !this.isMaxAge(p_290017_) && sufficientLight(p_290007_, p_290014_) && (p_290008_ < 3 || canGrowInto(p_290007_, p_290014_.above()));
    }
    @Nullable
    private ModSunflowerCropBlock.PosAndState getLowerHalf(LevelReader p_290009_, BlockPos p_290016_, BlockState p_290015_) {
        if (isLower(p_290015_)) {
            return new ModSunflowerCropBlock.PosAndState(p_290016_, p_290015_);
        } else {
            BlockPos blockpos = p_290016_.below();
            BlockState blockstate = p_290009_.getBlockState(blockpos);
            return isLower(blockstate) ? new ModSunflowerCropBlock.PosAndState(blockpos, blockstate) : null;
        }
    }
    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos pos, BlockState blockState, boolean p_277487_) {
        ModSunflowerCropBlock.PosAndState modsunflowercropblock$posandstate = this.getLowerHalf(levelReader, pos, blockState);
        return modsunflowercropblock$posandstate != null && this.canGrow(levelReader, modsunflowercropblock$posandstate.pos, modsunflowercropblock$posandstate.state, modsunflowercropblock$posandstate.state.getValue(AGE) + 1);
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos pos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel p_220874_, RandomSource p_220875_, BlockPos p_220876_, BlockState p_220877_) {

    }
    record PosAndState(BlockPos pos, BlockState state) {
    }
}
