package co.insou.radio.radio;

import co.insou.radio.noteblockapi.SongPlayer;
import co.insou.radio.songs.RadioSong;
import org.bukkit.entity.Player;

public class PlayerRadio {

    private final Player player;

    private SongPlayer currentSongPlayer;
    private RadioSong currentRadioSong;

    public PlayerRadio(Player player) {
        this.player = player;
    }

    public SongPlayer getCurrentSongPlayer() {
        return currentSongPlayer;
    }

    public void setCurrentSongPlayer(SongPlayer currentSongPlayer) {
        this.currentSongPlayer = currentSongPlayer;
    }

    public RadioSong getCurrentRadioSong() {
        return currentRadioSong;
    }

    public void setCurrentRadioSong(RadioSong currentRadioSong) {
        this.currentRadioSong = currentRadioSong;
    }
}
