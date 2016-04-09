package co.insou.radio.music;

import co.insou.radio.radio.RadioPlayer;
import co.insou.radio.songs.RadioSong;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MusicQueue {

    private List<RadioSong> queue = new ArrayList<>();

    public MusicQueue() {

    }

    public List<RadioSong> getQueue() {
        return queue;
    }

    public void addToQueue(boolean front, RadioSong song) {
        if (front) {
            queue.add(0, song);
        } else {
            queue.add(song);
        }
    }

    public RadioSong nextSong() {
        if (queue.isEmpty()) {
            return null;
        }
        queue.remove(0);
        if (queue.isEmpty()) {
            return null;
        }
        return queue.get(0);
    }

}
