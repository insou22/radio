package co.insou.radio.commands;

import co.insou.radio.Main;
import co.insou.radio.gui.pages.RadioHomePage;
import co.insou.radio.gui.pages.SongSelectionPage;
import co.insou.radio.noteblockapi.NBSDecoder;
import co.insou.radio.noteblockapi.PositionSongPlayer;
import co.insou.radio.noteblockapi.RadioSongPlayer;
import co.insou.radio.noteblockapi.Song;
import co.insou.radio.radio.PlayerRadio;
import co.insou.radio.radio.RadioPlayer;
import co.insou.radio.songs.RadioSong;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RadioCommand implements CommandExecutor {

    private final Main plugin;

    public RadioCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Please run this command as a player!");
            return false;
        }
        Player player = (Player) sender;
        RadioPlayer radioPlayer = plugin.getPlayerManager().getRadioPlayer(player);
        if (!plugin.isSkullsLoaded()) {
            radioPlayer.sendMessage("&cRadio is still loading, please wait...");
            return false;
        }


        try {
            radioPlayer.openPage(new RadioHomePage(radioPlayer));
        } catch (IllegalStateException e) {
            radioPlayer.openPage(new SongSelectionPage(radioPlayer));
        }


        /*if (args[0].equalsIgnoreCase("stop")) {
            radioPlayer.getPlayerRadio().getCurrentSongPlayer().setPlaying(false);
            radioPlayer.getPlayerRadio().getCurrentSongPlayer().destroy();
            return false;
        }

        radioPlayer.setGlobal(false);
        RadioSong radioSong = plugin.getSongManager().getSongs().get(Integer.parseInt(args[0]));
        if (radioSong == null) {
            player.sendMessage(ChatColor.RED + "No songs :(");
            return false;
        }
        PlayerRadio playerRadio = radioPlayer.getPlayerRadio();
        RadioSongPlayer songPlayer = new RadioSongPlayer(plugin.getNoteBlockManager(), radioSong.getSong());
        playerRadio.setCurrentRadioSong(radioSong);
        playerRadio.setCurrentSongPlayer(songPlayer);
        songPlayer.addPlayer(player);
        songPlayer.setAutoDestroy(true);
        songPlayer.setPlaying(true);*/

        return false;
    }

}
