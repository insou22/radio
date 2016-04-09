package co.insou.radio.listeners;

import co.insou.radio.Main;
import co.insou.radio.radio.RadioPlayer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class GUIListener implements Listener {

    private final Main plugin;

    public GUIListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (! (e.getWhoClicked() instanceof Player)) {
            return;
        }
        Player p = (Player) e.getWhoClicked();
        RadioPlayer player = plugin.getPlayerManager().getRadioPlayer(p);
        if (player == null) {
            plugin.getLogger().info("SellPlayer is null InventoryCloseEvent");
            return;
        }
        if (player.inGUI()) {
            player.onInventoryClick(e);
        }
    }

    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if (! (e.getPlayer() instanceof Player)) {
            return;
        }
        Player p = (Player) e.getPlayer();
        RadioPlayer player = plugin.getPlayerManager().getRadioPlayer(p);
        if (player == null) {
            plugin.getLogger().info("PluginPlayer is null InventoryCloseEvent");
            return;
        }
        if (player.inGUI()) {
            player.onInventoryClose(e);
        }
    }

}