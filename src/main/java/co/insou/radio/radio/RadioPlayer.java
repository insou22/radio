package co.insou.radio.radio;

import co.insou.radio.Main;
import co.insou.radio.noteblockapi.SongPlayer;
import co.insou.radio.songs.RadioSong;
import org.bukkit.entity.Player;

import java.util.UUID;

public class RadioPlayer {

    private final Main plugin;
    private final Player player;

    private boolean global = true;
    private PlayerRadio playerRadio;

    public RadioPlayer(Main plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        playerRadio = new PlayerRadio(player);
    }

    public PlayerRadio getPlayerRadio() {
        return playerRadio;
    }

    public boolean isGlobal() {
        return global;
    }

    public void setGlobal(boolean global) {
        this.global = global;
        if (global && playerRadio.getCurrentSongPlayer() != null) {
            playerRadio.getCurrentSongPlayer().removePlayer(player);
            playerRadio.setCurrentSongPlayer(null);
            playerRadio.setCurrentRadioSong(null);
        } else if (!global && plugin.getRadioManager().getCurrentGlobalSongPlayer() != null) {
            plugin.getRadioManager().getCurrentGlobalSongPlayer().removePlayer(player);
        }
    }

}
