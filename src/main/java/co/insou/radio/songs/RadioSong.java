package co.insou.radio.songs;

import co.insou.radio.noteblockapi.Song;
import org.bukkit.inventory.ItemStack;

public class RadioSong {

    private int id;
    private Song song;
    private String name;
    private ItemStack icon;

    public RadioSong(Song song, int id, String name, ItemStack icon) {
        this.song = song;
        this.id = id;
        this.name = name;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public Song getSong() {
        return song;
    }

    public String getName() {
        return name;
    }

    public ItemStack getIcon() {
        return icon;
    }
}
