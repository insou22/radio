package co.insou.radio.listeners;

import co.insou.radio.Main;
import co.insou.radio.radio.RadioPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerListener implements Listener {

    private final Main plugin;

    public PlayerListener(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void on(PlayerJoinEvent event) {
        plugin.getPlayerManager().register(event.getPlayer());
    }

    @EventHandler
    public void on(PlayerQuitEvent event) {
        plugin.getPlayerManager().deregister(event.getPlayer());
    }

}
