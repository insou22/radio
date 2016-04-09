package co.insou.radio.gui.pages;

import co.insou.radio.gui.GUIPageType;
import co.insou.radio.gui.ItemClickHandler;
import co.insou.radio.gui.page.StandardInventory;
import co.insou.radio.radio.PlayerRadio;
import co.insou.radio.radio.RadioPlayer;
import co.insou.radio.util.item.*;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import org.apache.commons.codec.binary.Base64;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.util.io.BukkitObjectInputStream;
import org.bukkit.util.io.BukkitObjectOutputStream;

import java.io.*;
import java.lang.reflect.Field;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.UUID;

public class RadioHomePage extends GUIPage {

    private static final String TITLE = ChatColor.translateAlternateColorCodes('&', "&dRadio > Home");

    private final RadioPlayer player;

    public RadioHomePage(RadioPlayer player) throws IllegalStateException {
        super(player);
        this.player = player;
        setup();
    }

    private void setup() throws IllegalStateException {
        final StandardInventory inventory = new StandardInventory(player, 27, TITLE);

        // Background
        ItemBuilder background = new ItemBuilder(Material.STAINED_GLASS_PANE);
        background.withDurability(15).withMeta(
                new MetaBuilder(background)
                        .withDisplayName(" ")
        );
        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, background);
        }
        // End Background

        if (player.getPlayerRadio().isEmpty()) {
            throw new IllegalStateException("Player radio is empty");
        }

        final PlayerRadio radio = player.getPlayerRadio();

        ItemBuilder icon = new ItemBuilder(radio.getCurrentRadioSong().getIcon());

        icon.withMeta(
                new MetaBuilder(icon)
                        .withDisplayName(ChatColor.LIGHT_PURPLE + "Loaded Track: " + radio.getCurrentRadioSong().getName())
                        .withLore(
                                Collections.singletonList(
                                        ChatColor.DARK_GRAY + "Click to select a track"
                                )
                        )
                        .withItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_DESTROYS, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_PLACED_ON, ItemFlag.HIDE_POTION_EFFECTS, ItemFlag.HIDE_UNBREAKABLE)
        );


        inventory.setItem(4, icon, GUIPageType.SONG_SELECT);

        ItemBuilder screen = new ItemBuilder(Skulls.getScreen());

        screen.withMeta(
                new MetaBuilder(screen)
                        .withDisplayName(radio.isNotify() ? ChatColor.LIGHT_PURPLE + "Showing Notifications" : ChatColor.LIGHT_PURPLE + "Not Showing Notifications")
                        .withLore(
                                Collections.singletonList(
                                        radio.isNotify() ? ChatColor.DARK_GRAY + "Click to disable notifications" : ChatColor.DARK_GRAY + "Click to enable notifications"
                                )
                        )
        );

        inventory.setItem(8, screen, new ItemClickHandler() {
            @Override
            public void onClick(InventoryClickEvent event) {
                radio.setNotify(!radio.isNotify(), true);
                refresh();
            }
        });

        ItemBuilder play = new ItemBuilder(Skulls.getPlay());
        ItemBuilder pause = new ItemBuilder(Skulls.getPause());

        if (radio.isPlaying()) {
            play.withMeta(
                    new MetaBuilder(play)
                            .withDisplayName(ChatColor.translateAlternateColorCodes('&', "&dCurrently Playing - Click to pause"))
                            .withLore(
                                    Collections.singletonList(
                                            ChatColor.translateAlternateColorCodes('&', "&8Playing " + radio.getCurrentRadioSong().getName())
                                    )
                            )
            );
            inventory.setItem(13, play, new ItemClickHandler() {
                @Override
                public void onClick(InventoryClickEvent event) {
                    radio.pause();
                    refresh();
                }
            });
        } else {
            pause.withMeta(
                    new MetaBuilder(pause)
                            .withDisplayName(ChatColor.translateAlternateColorCodes('&', "&dCurrently Paused - Click to play"))
                            .withLore(
                                    Collections.singletonList(
                                        ChatColor.translateAlternateColorCodes('&', "&8Playing " + radio.getCurrentRadioSong().getName())
                                    )
                            )
            );
            inventory.setItem(13, pause, new ItemClickHandler() {
                @Override
                public void onClick(InventoryClickEvent event) {
                    radio.play();
                    refresh();
                }
            });
        }

        ItemBuilder restart = new ItemBuilder(Skulls.getArrowLeft());

        restart.withMeta(
                new MetaBuilder(restart)
                        .withDisplayName(ChatColor.LIGHT_PURPLE + "Restart song")
                        .withLore(
                                Collections.singletonList(
                                        ChatColor.DARK_GRAY + "Start " + radio.getCurrentRadioSong().getName() + " again"
                                )
                        )
        );

        inventory.setItem(11, restart, new ItemClickHandler() {
            @Override
            public void onClick(InventoryClickEvent event) {
                radio.restartSong();
                refresh();
            }
        });

        ItemBuilder next = new ItemBuilder(Skulls.getArrowRight());

        next.withMeta(
                new MetaBuilder(next)
                        .withDisplayName(ChatColor.LIGHT_PURPLE + "Next song")
                        .withLore(
                                Collections.singletonList(
                                        ChatColor.DARK_GRAY + "Next track: " + radio.getMusicQueue().getQueue().get(1).getName()
                                )
                        )
        );

        inventory.setItem(15, next, new ItemClickHandler() {
            @Override
            public void onClick(InventoryClickEvent event) {
                radio.nextSong();
                refresh();
            }
        });

        ItemBuilder repeat = new ItemBuilder(Skulls.getRepeat());

        repeat.withMeta(
                new MetaBuilder(repeat)
                        .withDisplayName(radio.isRepeatSong() ? ChatColor.LIGHT_PURPLE + "Repeating current song" : ChatColor.LIGHT_PURPLE + "Repeating all songs")
                        .withLore(
                                Collections.singletonList(
                                        radio.isRepeatSong() ? ChatColor.DARK_GRAY + "Click to repeat all songs" : ChatColor.DARK_GRAY + "Click to repeat current song"
                                )
                        )
        );

        inventory.setItem(21, repeat, new ItemClickHandler() {
            @Override
            public void onClick(InventoryClickEvent event) {
                radio.setRepeatSong(!radio.isRepeatSong(), true);
                refresh();
            }
        });

        ItemBuilder shuffle = new ItemBuilder(Skulls.getShuffle());

        shuffle.withMeta(
                new MetaBuilder(shuffle)
                        .withDisplayName(radio.isShuffle() ? ChatColor.LIGHT_PURPLE + "Shuffling all songs" : ChatColor.LIGHT_PURPLE + "Playing songs in order")
                        .withLore(
                                Collections.singletonList(
                                        radio.isShuffle() ? ChatColor.DARK_GRAY + "Click to play in order" : ChatColor.DARK_GRAY + "Click to shuffle songs"
                                )
                        )
        );

        inventory.setItem(23, shuffle, new ItemClickHandler() {
            @Override
            public void onClick(InventoryClickEvent event) {
                radio.setShuffle(!radio.isShuffle(), true);
                refresh();
            }
        });

        this.display = inventory;
    }

    public void refresh() {
        RadioHomePage newPage = new RadioHomePage(player);
        player.getBreadcrumb().remove(this);
        player.openPage(newPage);
    }

    @Override
    public void onInventoryClick(InventoryClickEvent event) {

    }

    @Override
    public String getTitle() {
        return TITLE;
    }

    @Override
    public GUIPageType getType() {
        return GUIPageType.RADIO_HOME;
    }


}
