package net.cinchtail.cinchcraft.mixin.accessor;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PoiTypes.class)
public interface PointOfInterestTypeAccessor {
    @Accessor
    ResourceLocation setMaxFreeTickets(int ticketCount);

    @Invoker("registerBlockStates")
    static PoiTypes invokeRegisterBlockStates(PoiTypes poiTypes) {
        throw new IllegalStateException();
    }
}
