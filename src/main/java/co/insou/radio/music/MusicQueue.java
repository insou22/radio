package co.insou.radio.music;

import co.insou.radio.songs.RadioSong;

import java.util.ArrayList;
import java.util.List;

public class MusicQueue {

    private List<RadioSong> queue = new ArrayList<>();

    public List<RadioSong> getQueue() {
        return queue;
    }

    public void addToQueue(RadioSong song) {
        queue.add(song);
    }

}
