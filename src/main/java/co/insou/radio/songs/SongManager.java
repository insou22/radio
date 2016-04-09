package co.insou.radio.songs;

import co.insou.radio.Main;
import co.insou.radio.noteblockapi.NBSDecoder;
import co.insou.radio.noteblockapi.Song;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SongManager {

    private final Main plugin;

    private List<RadioSong> loadedSongs;
    private File file;
    private YamlConfiguration songConf;

    public SongManager(Main plugin) {
        this.plugin = plugin;
        this.loadedSongs = new ArrayList<>();
        file = new File(plugin.getDataFolder(), "songs.yml");
        if (!file.exists()) {
            try {
                if (!file.createNewFile()) {
                    throw new IOException("Could not create the file!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        songConf = YamlConfiguration.loadConfiguration(file);
        loadSongs();
        save();
    }

    private void loadSongs() {
        if (!songConf.isConfigurationSection("songs")) {
            songConf.createSection("songs");
        }
        System.out.println("===========================");
        System.out.println("| LOADING ALL RADIO SONGS");
        for (String key : songConf.getConfigurationSection("songs").getKeys(false)) {
            Integer id;
            try {
                id = Integer.parseInt(key);
            } catch (NumberFormatException e) {
                plugin.getLogger().warning("| Could not load song: Invalid song id: " + key);
                continue;
            }
            loadSong(id);
        }
        System.out.println("| FINISHED LOADING RADIO SONGS");
        System.out.println("============================");
    }

    public void loadSong(int id) {
        RadioSongBuilder builder = new RadioSongBuilder();
        String songFile = songConf.getString("songs." + id + ".file").replace(".nbs", "") + ".nbs";
        File file = new File(plugin.getDataFolder() + File.separator + "songs", songFile);
        if (!file.exists()) {
            plugin.getLogger().warning("Could not load song " + id + ": Could not find song file " + songFile);
            return;
        }
        Song song = NBSDecoder.parse(file);
        String name = songConf.getString("songs." + id + ".name");
        if (name == null) {
            plugin.getLogger().warning("Could not load song " + id + ": Name not set");
            return;
        }
        ItemStack icon;
        String materialName = songConf.getString("songs." + id + ".icon.material").toUpperCase();
        Material material = Material.getMaterial(materialName);
        if (material == null) {
            plugin.getLogger().warning("Could not load song " + id + ": Material " + materialName + " not valid");
            return;
        }
        if (material == Material.AIR) {
            plugin.getLogger().warning("Could not load song " + id + ": You can't use Material AIR!");
            return;
        }
        Integer data = songConf.getInt("songs." + id + ".icon.data");
        if (data < 0) {
            data = 0;
        }
        icon = new ItemStack(material, 1, data.shortValue());
        loadedSongs.add(builder.withId(id).withSong(song).withName(name).withIcon(icon).build());
        System.out.println("| Successfully loaded song " + name + ": " + songFile);
    }

    public void saveSong(RadioSong song) {
        
    }

    private void save() {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                synchronized (SongManager.this) {
                    try {
                        songConf.save(file);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public List<RadioSong> getSongs() {
        return loadedSongs;
    }

}
