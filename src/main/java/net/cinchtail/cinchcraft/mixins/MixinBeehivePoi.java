package net.cinchtail.cinchcraft.mixins;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

import java.util.Set;

@Mixin(PoiTypes.class)
public class MixinBeehivePoi {
    @ModifyVariable(method = "register", ordinal = 0, at = @At(value = "LOAD"))
    private static PoiType cinchcraft$modifyBeehivePOI(
            PoiType poiType,
            Registry<PoiType> registry,
            ResourceKey<PoiType> key,
            Set<BlockState> states,
            int ticketCount,
            int searchDistance) {

        if (key != PoiTypes.BEEHIVE) {
            return poiType;
        }

        ticketCount = 1;

        return new PoiType(
                states,
                ticketCount,
                searchDistance);
    }
}