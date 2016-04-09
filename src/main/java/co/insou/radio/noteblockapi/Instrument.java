package co.insou.radio.noteblockapi;

import org.bukkit.Sound;

public class Instrument {

    public static Sound getInstrument(byte instrument) {
        switch (instrument) {
            case 0:
                return Sound.BLOCK_NOTE_HARP;
            case 1:
                return Sound.BLOCK_NOTE_BASS;
            case 2:
                return Sound.BLOCK_NOTE_BASEDRUM;
            case 3:
                return Sound.BLOCK_NOTE_SNARE;
            case 4:
                return Sound.BLOCK_NOTE_HAT;
//                return Sound.NOTE_STICKS;
            case 5:
                return Sound.BLOCK_NOTE_PLING;
            default:
                return Sound.BLOCK_NOTE_HARP;
        }
    }

    public static org.bukkit.Instrument getBukkitInstrument(byte instrument) {
        switch (instrument) {
            case 0:
                return org.bukkit.Instrument.PIANO;
            case 1:
                return org.bukkit.Instrument.BASS_GUITAR;
            case 2:
                return org.bukkit.Instrument.BASS_DRUM;
            case 3:
                return org.bukkit.Instrument.SNARE_DRUM;
            case 4:
                return org.bukkit.Instrument.STICKS;
            case 5:
                System.out.println("Instrument 5 PLING was requested, removed 1.9. Returned PIANO.");
                return org.bukkit.Instrument.PIANO;
                // return org.bukkit.Instrument.PLING;
            default:
                return org.bukkit.Instrument.PIANO;
        }
    }
}