package co.insou.radio.radio;

import co.insou.radio.Radio;
import co.insou.radio.gui.GUIPageType;
import co.insou.radio.gui.page.ExternalIgnorance;
import co.insou.radio.gui.pages.GUIPage;
import co.insou.radio.gui.pages.RadioHomePage;
import co.insou.radio.gui.pages.SongSelectionPage;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

import java.util.*;

public class RadioPlayer {

    private final Radio plugin;
    private final Player player;

    private PlayerRadio playerRadio;

    // GUI
    private List<GUIPage> breadcrumb = new ArrayList<>();

    private volatile boolean internalIgnore = false;
    private volatile Set<ExternalIgnorance> externalIgnore = new HashSet<>();
    private volatile Set<ExternalIgnorance> externalCancel = new HashSet<>();

    private volatile GUIPage absoluteInventory;
    //END GUI

    public RadioPlayer(Radio plugin, Player player) {
        this.plugin = plugin;
        this.player = player;
        playerRadio = new PlayerRadio(plugin, player, false, false, true);
    }

    public PlayerRadio getPlayerRadio() {
        return playerRadio;
    }

    public void sendMessage(String message) {
        if (message != null) {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Radio getPlugin() {
        return plugin;
    }

    // GUI

    public void openPage(GUIPage page) {
        breadcrumb.add(page);
        absoluteInventory = page;
        internalIgnore = true;
        page.display();
        internalIgnore = false;
    }

    public void openUndocumentedPage(final GUIPage page) {
        internalIgnore = true;
        Bukkit.getScheduler().scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
                closePage(GUIPageType.CLOSE_PAGE);
                openPage(page);
                internalIgnore = false;
            }
        }, 1);
    }

    public void closePage(GUIPageType page) {
        breadcrumb.remove(getCurrentIndex());
    }

    public List<GUIPage> getBreadcrumb() {
        return breadcrumb;
    }

    public Set<ExternalIgnorance> getExternalIgnorance() {
        return externalIgnore;
    }

    public Set<ExternalIgnorance> getExternalCancellation() {
        return externalCancel;
    }

    public boolean inGUI() {
        return breadcrumb.size() > 0;
    }

    public GUIPage getCurrentPage() {
        if (!inGUI()) {
            return null;
        }
        return breadcrumb.get(getCurrentIndex());
    }

    private int getCurrentIndex() {
        return breadcrumb.size() - 1;
    }

    public void onInventoryClick(InventoryClickEvent event) {
        if (inGUI()) {
            if (event.getClickedInventory() != null) {
                if (event.getClickedInventory().equals(player.getOpenInventory().getTopInventory())) {
                    getCurrentPage().onClick(event);
                }
            }
        }
    }

    public void onInventoryClose(InventoryCloseEvent event) {
        if (internalIgnore || getExternalIgnore()) {
            return;
        }
        if (getExternalCancel()) {
            openUndocumentedPage(absoluteInventory);
            return;
        }
        if (inGUI()) {
            getCurrentPage().onClose();
        }
    }

    public GUIPage getPage(GUIPageType type) {
        switch (type) {
            case RADIO_HOME:
                return new RadioHomePage(this);
            case SONG_SELECT:
                return new SongSelectionPage(this);
            case CLOSE_PAGE: {
                getCurrentPage().onClose();
                return null;
            }
            case CLOSE_GUI: {
                breadcrumb.clear();
                externalCancel.clear();
                externalIgnore.clear();
                absoluteInventory = null;
                player.closeInventory();
                return null;
            }
            default: {
                return null;
            }
        }
    }

    public boolean getExternalIgnore() {
        return externalIgnore.size() > 0;
    }

    public void addExternalIgnore(ExternalIgnorance ignorance) {
        this.externalIgnore.add(ignorance);
    }

    public void removeExternalIgnore(ExternalIgnorance ignorance) {
        this.externalIgnore.remove(ignorance);
    }

    public boolean getExternalCancel() {
        return externalCancel.size() > 0;
    }

    public void addExternalCancel(ExternalIgnorance ignorance) {
        this.externalCancel.add(ignorance);
    }

    public void removeExternalCancel(ExternalIgnorance ignorance) {
        this.externalCancel.remove(ignorance);
    }

    public void setAbsoluteInventory(GUIPage page) {
        this.absoluteInventory = page;
    }

    // END GUI

}
