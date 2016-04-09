package co.insou.radio.songs;

import co.insou.radio.noteblockapi.Song;
import org.bukkit.inventory.ItemStack;

public class RadioSongBuilder {

    private Integer id;
    private Song song;
    private String name;
    private ItemStack icon;

    public RadioSongBuilder() {

    }

    public RadioSongBuilder withId(int id) {
        this.id = id;
        return this;
    }

    public RadioSongBuilder withSong(Song song) {
        this.song = song;
        return this;
    }

    public RadioSongBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public RadioSongBuilder withIcon(ItemStack icon) {
        this.icon = icon;
        return this;
    }

    public RadioSong build() {
        if (id == null) {
            throw new IllegalStateException("ID is null");
        }
        if (song == null) {
            throw new IllegalStateException("Song is null");
        }
        if (name == null) {
            throw new IllegalStateException("Name is null");
        }
        if (icon == null) {
            throw new IllegalStateException("Icon is null");
        }
        return new RadioSong(song, id, name, icon);
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
