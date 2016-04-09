package co.insou.radio.radio;

import co.insou.radio.Main;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class RadioPlayerManager {

    private final Main plugin;

    private Map<Player, RadioPlayer> players = new HashMap<>();

    public RadioPlayerManager(Main plugin) {
        this.plugin = plugin;
    }

    public void register(Player player) {
        players.put(player, new RadioPlayer(plugin, player));
    }

    public void deregister(Player player) {
        players.remove(player);
    }

    public RadioPlayer getRadioPlayer(Player player) {
        if (players.get(player) == null) {
            register(player);
        }
        return players.get(player);
    }

    public Collection<RadioPlayer> getRadioPlayers() {
        return players.values();
    }

}
