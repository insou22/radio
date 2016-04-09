package co.insou.radio.gui.pages;

import co.insou.radio.gui.GUIPageType;
import co.insou.radio.gui.page.PageInventory;
import co.insou.radio.music.QueueMaker;
import co.insou.radio.radio.RadioPlayer;
import co.insou.radio.songs.RadioSong;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SongSelectionPage extends GUIPage {

    private static final String TITLE = ChatColor.translateAlternateColorCodes('&', "&dRadio > Select Song");

    private final RadioPlayer player;

    public SongSelectionPage(RadioPlayer player) {
        super(player);
        this.player = player;
        setup();
    }

    private void setup() {
        PageInventory inventory = new PageInventory(TITLE, player.getPlayer());

        List<ItemStack> items = new ArrayList<>();

        for (RadioSong song : player.getPlugin().getSongManager().getSongs()) {
            ItemStack icon = song.getIcon();
            ItemMeta meta = icon.getItemMeta();
            meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE);
            meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', song.getName()));
            meta.setLore(Collections.singletonList(
                    ChatColor.translateAlternateColorCodes('&', "&8ID: " + song.getId())
            ));
            icon.setItemMeta(meta);
            items.add(icon);
        }

        inventory.setPages(items);
        this.display = inventory;
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {
        ItemStack item = event.getCurrentItem();
        if (item == null) {
            return;
        }
        if (item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.hasLore() && meta.getLore().size() == 1) {
                String idString = ChatColor.stripColor(meta.getLore().get(0));
                if (idString.startsWith("ID: ")) {
                    Integer id = Integer.parseInt(idString.substring("ID: ".length()));
                    for (RadioSong song : player.getPlugin().getSongManager().getSongs()) {
                        if (song.getId() == id) {
                            QueueMaker maker = new QueueMaker(player.getPlugin().getSongManager());
                            if (player.getPlayerRadio().getCurrentSongPlayer() != null) {
                                player.getPlayerRadio().getCurrentSongPlayer().setPlaying(false);
                                player.getPlayerRadio().getCurrentSongPlayer().destroy();
                                player.getPlayerRadio().setCurrentSongPlayer(null);
                            }
                            player.getPlayerRadio().setMusicQueue(maker.getQueue(song, player.getPlayerRadio().isShuffle()));
                            player.getPlayerRadio().setCurrentRadioSong(song);
                            player.getPlayerRadio().setCurrentSong(song.getSong());
                            player.getPlayerRadio().play();
                            player.getPage(GUIPageType.CLOSE_GUI);
                            player.openPage(new RadioHomePage(player));
                        }
                    }
                }
            }
        }
    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public GUIPageType getType() {
        return GUIPageType.SONG_SELECT;
    }

}
