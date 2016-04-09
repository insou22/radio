package co.insou.radio.noteblockapi;

import org.bukkit.entity.Player;

public class RadioSongPlayer extends SongPlayer {

    private final NoteBlockManager manager;

    public RadioSongPlayer(NoteBlockManager manager, Song song) {
        this(manager, song, null);
    }

    public RadioSongPlayer(NoteBlockManager manager, Song song, FinishListener finishListener) {
        super(manager, song, finishListener);
        this.manager = manager;
    }

    @Override
    public void playTick(Player p, int tick) {
        byte playerVolume = manager.getPlayerVolume(p);

        for (Layer l : song.getLayerHashMap().values()) {
            Note note = l.getNote(tick);
            if (note == null) {
                continue;
            }
            p.playSound(p.getEyeLocation(),
                    Instrument.getInstrument(note.getInstrument()),
                    (l.getVolume() * (int) volume * (int) playerVolume) / 1000000f,
                    NotePitch.getPitch(note.getKey() - 33));
        }
    }
}