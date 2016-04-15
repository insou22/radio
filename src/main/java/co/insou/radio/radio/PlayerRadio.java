package co.insou.radio.radio;

import co.insou.radio.Radio;
import co.insou.radio.gui.pages.RadioHomePage;
import co.insou.radio.music.MusicQueue;
import co.insou.radio.music.QueueMaker;
import co.insou.radio.noteblockapi.FinishListener;
import co.insou.radio.noteblockapi.RadioSongPlayer;
import co.insou.radio.noteblockapi.Song;
import co.insou.radio.noteblockapi.SongPlayer;
import co.insou.radio.songs.RadioSong;
import co.insou.radio.util.title.Title;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class PlayerRadio {

    private final Radio plugin;

    private final Player player;

    private Song currentSong;
    private SongPlayer currentSongPlayer;
    private RadioSong currentRadioSong;
    private MusicQueue musicQueue;

    private boolean repeatSong;
    private boolean shuffle;
    private boolean notify;

    public PlayerRadio(Radio plugin, Player player, boolean repeatSong, boolean shuffle, boolean notify) {
        this.plugin = plugin;
        this.player = player;
        this.repeatSong = repeatSong;
        this.shuffle = shuffle;
        this.notify = notify;
    }

    public RadioSong getCurrentRadioSong() {
        return currentRadioSong;
    }

    public void setCurrentRadioSong(RadioSong currentRadioSong) {
        this.currentRadioSong = currentRadioSong;
    }

    public Song getCurrentSong() {
        return currentSong;
    }

    public void setCurrentSong(Song currentSong) {
        this.currentSong = currentSong;
    }

    public MusicQueue getMusicQueue() {
        return musicQueue;
    }

    public void setMusicQueue(MusicQueue queue) {
        this.musicQueue = musicQueue;
    }

    public boolean isShuffle() {
        return shuffle;
    }

    public void setShuffle(boolean shuffle, boolean save) {
        this.shuffle = shuffle;
        if (currentRadioSong != null) {
            QueueMaker maker = new QueueMaker(plugin.getSongManager());
            musicQueue = maker.getQueue(currentRadioSong, shuffle);
        }
        if (save) {
            plugin.getPlayerManager().saveValues(plugin.getPlayerManager().getRadioPlayer(player));
        }
    }

    public boolean isEmpty() {
        return currentSong == null || currentRadioSong == null || currentSongPlayer == null;
    }

    public SongPlayer getCurrentSongPlayer() {
        return currentSongPlayer;
    }

    public void setCurrentSongPlayer(SongPlayer currentSongPlayer) {
        this.currentSongPlayer = currentSongPlayer;
    }

    public void play() {
        if (currentSongPlayer != null && !currentSongPlayer.isPlaying()) {
            currentSongPlayer.setPlaying(true);
        } else {
            currentSongPlayer = new RadioSongPlayer(plugin.getNoteBlockManager(), currentSong, new FinishListener() {
                @Override
                public void onFinish() {
                    nextSong();
                    Bukkit.getScheduler().runTaskLater(plugin, new Runnable() {
                        @Override
                        public void run() {
                            RadioPlayer player = plugin.getPlayerManager().getRadioPlayer(PlayerRadio.this.player);
                            if (player.inGUI() && player.getCurrentPage() instanceof RadioHomePage) {
                                ((RadioHomePage) player.getCurrentPage()).refresh();
                            }
                        }
                    }, 2);
                }
            });
            currentSongPlayer.addPlayer(player);
            currentSongPlayer.setPlaying(true);
            if (musicQueue == null || musicQueue.getQueue() == null || musicQueue.getQueue().size() == 1) {
                QueueMaker maker = new QueueMaker(plugin.getSongManager());
                musicQueue = maker.getQueue(currentRadioSong, shuffle);
            }
            if (notify) {
                new Title(player, ChatColor.LIGHT_PURPLE + "Now playing").subtitle(ChatColor.YELLOW + currentRadioSong.getName()).send();
            }
        }
    }

    public void restartSong() {
        if (currentSongPlayer == null) {
            return;
        }
        currentSongPlayer.setTick((short) -1);
    }

    public void nextSong() {
        if (currentSongPlayer != null) {
            if (repeatSong) {
                currentSongPlayer = null;
                play();
                return;
            }
            currentSongPlayer.setPlaying(false);
            currentSongPlayer.destroy();
        }
        RadioSong nextSong = (musicQueue == null ? null : musicQueue.nextSong());
        if (nextSong != null) {
            currentRadioSong = nextSong;
            currentSong = currentRadioSong.getSong();
            currentSongPlayer = null;
            play();
        } else {
            QueueMaker maker = new QueueMaker(plugin.getSongManager());
            musicQueue = maker.getQueue(maker.getNextSong(currentRadioSong), shuffle);
            currentRadioSong = musicQueue.getQueue().get(0);
            currentSong = currentRadioSong.getSong();
            currentSongPlayer = null;
            play();
        }
    }

    public void pause() {
        if (currentSongPlayer != null) {
            currentSongPlayer.setPlaying(false);
        }
    }

    public boolean isPlaying() {
        return currentSongPlayer != null && currentSongPlayer.isPlaying();
    }

    public boolean isRepeatSong() {
        return repeatSong;
    }

    public void setRepeatSong(boolean repeatSong, boolean save) {
        this.repeatSong = repeatSong;
        if (save) {
            plugin.getPlayerManager().saveValues(plugin.getPlayerManager().getRadioPlayer(player));
        }
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify, boolean save) {
        this.notify = notify;
        if (save) {
            plugin.getPlayerManager().saveValues(plugin.getPlayerManager().getRadioPlayer(player));
        }
    }
}
