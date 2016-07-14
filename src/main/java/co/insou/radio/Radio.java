package co.insou.radio;

import co.insou.radio.commands.RadioCommand;
import co.insou.radio.gui.GUIPageType;
import co.insou.radio.listeners.GUIListener;
import co.insou.radio.listeners.InventoryListener;
import co.insou.radio.listeners.PlayerListener;
import co.insou.radio.noteblockapi.NoteBlockManager;
import co.insou.radio.radio.RadioPlayer;
import co.insou.radio.radio.RadioPlayerManager;
import co.insou.radio.songs.SongManager;
import co.insou.radio.util.item.Skulls;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Radio extends JavaPlugin {

    private volatile boolean skullsLoaded = false;
    private NoteBlockManager noteBlockManager;
    private SongManager songManager;
    private RadioPlayerManager playerManager;

    @Override
    public void onEnable() {
        if (!getDataFolder().exists()) {
            getDataFolder().mkdirs();
        }

        Bukkit.getScheduler().runTaskAsynchronously(this, new Runnable() {
            @Override
            public void run() {
                getLogger().info("Loading skulls...");
                long millis = System.currentTimeMillis();
                Skulls.loadItems();
                skullsLoaded = true;
                getLogger().info("Skulls loaded! Took " + (System.currentTimeMillis() - millis) + "ms");
            }
        });

        noteBlockManager = new NoteBlockManager(this);
        playerManager = new RadioPlayerManager(this);
        songManager = new SongManager(this);

        for (Player player : getServer().getOnlinePlayers()) {
            playerManager.register(player);
        }

        Bukkit.getPluginManager().registerEvents(new PlayerListener(this), this);
        Bukkit.getPluginManager().registerEvents(new InventoryListener(this), this);
        Bukkit.getPluginManager().registerEvents(new GUIListener(this), this);

        getCommand("radio").setExecutor(new RadioCommand(this));
    }

    @Override
    public void onDisable() {
        for (Player player : getServer().getOnlinePlayers()) {
            RadioPlayer radioPlayer = playerManager.getRadioPlayer(player);
            radioPlayer.getPage(GUIPageType.CLOSE_GUI);
            radioPlayer.getPlayerRadio().getCurrentSongPlayer().setPlaying(false);
            radioPlayer.getPlayerRadio().getCurrentSongPlayer().destroy();
            radioPlayer.getPlayerRadio().setCurrentSong(null);
            radioPlayer.getPlayerRadio().setCurrentRadioSong(null);
            radioPlayer.getPlayerRadio().setCurrentSongPlayer(null);
            radioPlayer.getPlayerRadio().setMusicQueue(null);
            playerManager.deregister(player);
        }
    }

    public NoteBlockManager getNoteBlockManager() {
        return noteBlockManager;
    }

    public SongManager getSongManager() {
        return songManager;
    }

    public RadioPlayerManager getPlayerManager() {
        return playerManager;
    }

    public boolean isSkullsLoaded() {
        return skullsLoaded;
    }
}
