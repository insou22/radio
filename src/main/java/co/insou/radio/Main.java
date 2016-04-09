package co.insou.radio;

import co.insou.radio.noteblockapi.NoteBlockManager;
import co.insou.radio.radio.RadioManager;
import co.insou.radio.radio.RadioPlayerManager;
import co.insou.radio.songs.SongManager;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private NoteBlockManager noteBlockManager;
    private SongManager songManager;
    private RadioManager radioManager;
    private RadioPlayerManager playerManager;

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        noteBlockManager = new NoteBlockManager(this);
        playerManager = new RadioPlayerManager(this);
        songManager = new SongManager(this);
        radioManager = new RadioManager(this);

        for (Player player : getServer().getOnlinePlayers()) {
            playerManager.register(player);
        }
    }

    @Override
    public void onDisable() {
        for (Player player : getServer().getOnlinePlayers()) {
            playerManager.deregister(player);
        }
    }

    public NoteBlockManager getNoteBlockManager() {
        return noteBlockManager;
    }

    public SongManager getSongManager() {
        return songManager;
    }

    public RadioManager getRadioManager() {
        return radioManager;
    }

    public RadioPlayerManager getPlayerManager() {
        return playerManager;
    }

}
