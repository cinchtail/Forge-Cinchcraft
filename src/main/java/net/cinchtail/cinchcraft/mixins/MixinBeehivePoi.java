package net.cinchtail.cinchcraft.mixins;

import net.minecraft.world.entity.ai.village.poi.PoiType;
import net.minecraft.world.entity.ai.village.poi.PoiTypes;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.lang.reflect.Field;

@Mixin(PoiTypes.class)
public class MixinBeehivePoi {

    @Shadow
    private static PoiType BEEHIVE;

    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void modifyBeehivePOI(CallbackInfoReturnable<PoiType> callbackInfo) {
        if (callbackInfo.getReturnValue() == BEEHIVE) {
            PoiType beehive = callbackInfo.getReturnValue();

            try {
                Field maxTicketsField = PoiType.class.getDeclaredField("maxTickets");
                maxTicketsField.setAccessible(true);
                maxTicketsField.setInt(beehive, 1);

                //Field validRangeField = PoiType.class.getDeclaredField("validRange");
                //validRangeField.setAccessible(true);
                //validRangeField.setInt(beehive, 1);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}





