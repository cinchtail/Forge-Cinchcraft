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
    @ModifyVariable(
            method = "register",
            ordinal = 0,
            at = @At(
                    value = "LOAD"
            )
    )
    private static PoiType modifyBeehivePOI(
            PoiType poiType,
            Registry<PoiType> registry,
            ResourceKey<PoiType> key,
            Set<BlockState> states,
            int ticketCount,
            int searchDistance
    ) {
        if (key != PoiTypes.BEEHIVE) {
            return poiType;
        }

        ticketCount = 1;

        return new PoiType(
                states,
                ticketCount,
                searchDistance
        );
    }
}
//@Inject(method = "bootstrap", at = @At(value = "INVOKE", target = "Lnet/minecraft/world/entity/ai/village/poi/PoiTypes;register(Lnet/minecraft/core/Registry;Lnet/minecraft/resources/ResourceKey;Ljava/util/Set;II)Lnet/minecraft/world/entity/ai/village/poi/PoiType;"))

/*@Mixin(PoiTypes.class)
public class MixinBeehivePoi {
    private static final Logger LOGGER = LogUtils.getLogger();
    @Shadow
    private static ResourceKey<PoiType> BEEHIVE;

    @Inject(method = "bootstrap", at = @At("TAIL"))
    private static void modifyBeehivePOI(Registry<PoiType> registry, CallbackInfoReturnable<PoiType> callbackInfo) {
        PoiType beehive = registry.get(BEEHIVE);
        LOGGER.info("hive " + beehive);
        LOGGER.info("return value " + callbackInfo.getReturnValue());
        if (callbackInfo.getReturnValue() == beehive) {
            try {

                LOGGER.info("trying?");
                Field maxTicketsField = PoiType.class.getDeclaredField("maxTickets");
                maxTicketsField.setAccessible(true);
                maxTicketsField.setInt(beehive, 1);

                Field validRangeField = PoiType.class.getDeclaredField("validRange");
                validRangeField.setAccessible(true);
                validRangeField.setInt(beehive, 1);
            } catch (NoSuchFieldException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}*/




