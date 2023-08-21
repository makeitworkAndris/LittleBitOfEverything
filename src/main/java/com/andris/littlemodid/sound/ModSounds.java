package com.andris.littlemodid.sound;

import com.andris.littlemodid.LittleModMain;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.util.Identifier;

public class ModSounds {
    public static SoundEvent MUSIC_DISC_ACID_BALADE = registerSoundEvent("music_disc_acid_balade");
    private static SoundEvent registerSoundEvent(String name) {
        Identifier id = new Identifier(LittleModMain.MOD_ID, name);
        return Registry.register(Registries.SOUND_EVENT, id, SoundEvent.of(id));
    }
}
