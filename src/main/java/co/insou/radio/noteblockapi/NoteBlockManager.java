package co.insou.radio.noteblockapi;

import co.insou.radio.Radio;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.List;

public class NoteBlockManager {

    private final Radio plugin;
    private HashMap<String, List<SongPlayer>> playingSongs = new HashMap<>();
    private HashMap<String, Byte> playerVolume = new HashMap<>();

    public NoteBlockManager(Radio plugin) {
        this.plugin = plugin;
    }

    public boolean isReceivingSong(Player p) {
        return ((playingSongs.get(p.getName()) != null) && (!playingSongs.get(p.getName()).isEmpty()));
    }

    public void stopPlaying(Player p) {
        if (playingSongs.get(p.getName()) == null) {
            return;
        }
        for (SongPlayer s : playingSongs.get(p.getName())) {
            s.removePlayer(p);
        }
    }

    public void setPlayerVolume(Player p, byte volume) {
        playerVolume.put(p.getName(), volume);
    }

    public byte getPlayerVolume(Player p) {
        Byte b = playerVolume.get(p.getName());
        if (b == null) {
            b = 100;
            playerVolume.put(p.getName(), b);
        }
        return b;
    }

    public HashMap<String, List<SongPlayer>> getPlayingSongs() {
        return playingSongs;
    }

    public HashMap<String, Byte> getPlayerVolume() {
        return playerVolume;
    }

}
