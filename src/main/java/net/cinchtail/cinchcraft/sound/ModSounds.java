package net.cinchtail.cinchcraft.sound;

import net.cinchtail.cinchcraft.Cinchcraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.JukeboxSong;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, Cinchcraft.MOD_ID);

    public static final RegistryObject<SoundEvent> DOG_MUSIC_DISC = registerSoundEvent("dog_music_disc");
    public static final ResourceKey<JukeboxSong> DOG_MUSIC_DISC_KEY = createSong("dog_music_disc");
    public static final RegistryObject<SoundEvent> KYOTO_MUSIC_DISC = registerSoundEvent("kyoto_music_disc");
    public static final ResourceKey<JukeboxSong> KYOTO_MUSIC_DISC_KEY = createSong("kyoto_music_disc");


    private static ResourceKey<JukeboxSong> createSong(String name) {
        return ResourceKey.create(Registries.JUKEBOX_SONG, ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, name));
    }
    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(Cinchcraft.MOD_ID, name);
        return SOUND_EVENTS.register(name, () -> SoundEvent.createVariableRangeEvent(id));
    }
    public static void register(IEventBus eventBus) {
        SOUND_EVENTS.register(eventBus);
    }
}