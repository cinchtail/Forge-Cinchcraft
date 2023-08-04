package net.cinchtail.cinchcraft.mixin.accessor;

import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PoiTypes.class)
public interface PointOfInterestTypeAccessor {
    @Accessor
    void setMaxFreeTickets(int ticketCount);

    @Invoker("registerBlockStates")
    static PoiTypes invokeRegisterBlockStates(PoiTypes poiTypes) {
        throw new IllegalStateException();
    }
}
