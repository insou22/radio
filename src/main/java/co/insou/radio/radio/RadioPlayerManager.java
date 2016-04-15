package co.insou.radio.radio;

import co.insou.radio.Radio;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RadioPlayerManager {

    private final Radio plugin;

    private File storage;
    private YamlConfiguration config;

    private Map<Player, RadioPlayer> players = new HashMap<>();

    public RadioPlayerManager(Radio plugin) {
        this.plugin = plugin;
        storage = new File(plugin.getDataFolder(), "database.yml");
        if (!storage.exists()) {
            try {
                storage.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        config = YamlConfiguration.loadConfiguration(storage);
    }

    public void register(Player player) {
        players.put(player, new RadioPlayer(plugin, player));
        plugin.getPlayerManager().setValues(players.get(player));
    }

    public void deregister(Player player) {
        plugin.getNoteBlockManager().stopPlaying(player);
        PlayerRadio radio = getRadioPlayer(player).getPlayerRadio();
        if (radio != null) {
            radio.getCurrentSongPlayer().setPlaying(false);
            radio.getCurrentSongPlayer().destroy();
            radio.setCurrentSongPlayer(null);
            radio.setCurrentSong(null);
            radio.setCurrentRadioSong(null);
        }
        players.remove(player);
    }

    public RadioPlayer getRadioPlayer(Player player) {
        if (players.get(player) == null) {
            register(player);
        }
        return players.get(player);
    }

    public Collection<RadioPlayer> getRadioPlayers() {
        return players.values();
    }

    public void setValues(RadioPlayer player) {
        String uuid = player.getPlayer().getUniqueId().toString();
        PlayerRadio radio = player.getPlayerRadio();
        if (config.contains(uuid + ".repeat")) {
            radio.setRepeatSong(config.getBoolean(uuid + ".repeat", false), false);
        }
        if (config.contains(uuid + ".shuffle")) {
            radio.setShuffle(config.getBoolean(uuid + ".shuffle", false), false);
        }
        if (config.contains(uuid + ".notify")) {
            radio.setNotify(config.getBoolean(uuid + ".notify", true), false);
        }
        saveValues(player);
    }

    public void saveValues(RadioPlayer player) {
        String uuid = player.getPlayer().getUniqueId().toString();
        PlayerRadio radio = player.getPlayerRadio();
        config.set(uuid + ".repeat", radio.isRepeatSong());
        config.set(uuid + ".shuffle", radio.isShuffle());
        config.set(uuid + ".notify", radio.isNotify());
        save();
    }

    private synchronized void save() {
        Bukkit.getScheduler().runTaskAsynchronously(plugin, new Runnable() {
            @Override
            public void run() {
                synchronized (RadioPlayerManager.this) {
                    try {
                        config.save(storage);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

}
