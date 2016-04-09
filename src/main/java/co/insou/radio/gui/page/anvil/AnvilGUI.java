package co.insou.radio.gui.page.anvil;

import co.insou.radio.gui.page.RadioInventory;
import co.insou.radio.util.item.Reflection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class AnvilGUI implements RadioInventory {

    public static AnvilGUI getAnvilGUI(Player player, AnvilClickEventHandler clickHandler, AnvilCloseEventHandler closeHandler) {
        switch (Reflection.getVersion()) {
            case "v1_9_R1.":
                return new Anvil_1_9_R1(player, clickHandler, closeHandler);
            default:
                return new Anvil_1_9_R1(player, clickHandler, closeHandler);
        }
    }

    public abstract void setSlot(AnvilSlot slot, ItemStack item);

}