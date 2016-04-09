package co.insou.radio.music;

import co.insou.radio.noteblockapi.Song;
import co.insou.radio.songs.RadioSong;
import co.insou.radio.songs.SongManager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueueMaker {

    private final SongManager songManager;

    public QueueMaker(SongManager songManager) {
        this.songManager = songManager;
    }

    public MusicQueue getQueue(RadioSong first, boolean shuffle) {
        List<RadioSong> songs = new ArrayList<>(songManager.getSongs());
        if (shuffle) {
            Collections.shuffle(songs);
            songs.remove(first);
            songs.add(0, first);
            MusicQueue queue = new MusicQueue();
            for (RadioSong song : songs) {
                queue.addToQueue(false, song);
            }
            return queue;
        } else {
            MusicQueue queue = new MusicQueue();
            int index = songs.indexOf(first);
            queue.addToQueue(false, first);
            for (int i = index + 1; i < songs.size(); i++) {
                queue.addToQueue(false, songs.get(i));
            }
            for (int i = 0; i < index; i++) {
                queue.addToQueue(false, songs.get(i));
            }
            return queue;
        }
    }

    public RadioSong getNextSong(RadioSong previous) {
        List<RadioSong> songs = songManager.getSongs();
        if (songs.indexOf(previous) + 1 == songs.size()) {
            return songs.get(0);
        }
        return songs.get(songs.indexOf(previous) + 1);
    }

}
