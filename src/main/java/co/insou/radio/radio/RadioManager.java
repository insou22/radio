package co.insou.radio.radio;

import co.insou.radio.Main;
import co.insou.radio.music.MusicQueue;
import co.insou.radio.noteblockapi.SongPlayer;
import co.insou.radio.songs.RadioSong;

import java.util.ArrayList;
import java.util.List;

public class RadioManager {

    private final Main plugin;

    private SongPlayer currentGlobalSongPlayer;
    private RadioSong currentGlobalRadioSong;
    private MusicQueue globalMusicQueue;

    public RadioManager(Main plugin) {
        this.plugin = plugin;
        globalMusicQueue = new MusicQueue();
    }

    public SongPlayer getCurrentGlobalSongPlayer() {
        return currentGlobalSongPlayer;
    }

    public void setCurrentGlobalSongPlayer(SongPlayer currentGlobalSongPlayer) {
        this.currentGlobalSongPlayer = currentGlobalSongPlayer;
    }

    public RadioSong getCurrentGlobalRadioSong() {
        return currentGlobalRadioSong;
    }

    public void setCurrentGlobalRadioSong(RadioSong currentGlobalRadioSong) {
        this.currentGlobalRadioSong = currentGlobalRadioSong;
    }

    public MusicQueue getGlobalMusicQueue() {
        return globalMusicQueue;
    }

    public List<RadioPlayer> optedIn() {
        List<RadioPlayer> players = new ArrayList<>();
        for (RadioPlayer player : plugin.getPlayerManager().getRadioPlayers()) {
            if (player.isGlobal()) {
                players.add(player);
            }
        }
        return players;
    }

}
