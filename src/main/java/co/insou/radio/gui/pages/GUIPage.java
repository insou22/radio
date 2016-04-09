package co.insou.radio.gui.pages;

import co.insou.radio.gui.GUIPageType;
import co.insou.radio.gui.page.RadioInventory;
import co.insou.radio.radio.RadioPlayer;
import org.bukkit.event.inventory.InventoryClickEvent;

public abstract class GUIPage {

    private final RadioPlayer player;

    protected RadioInventory display;

    public GUIPage(RadioPlayer player) {
        this.player = player;
    }

    public void display() {
        if (display == null) {
            throw new IllegalStateException("Display is null");
        }
        display.displayInventory();
    }

    public void onClose() {
        player.closePage(getType());
        if (player.inGUI()) {
            player.openUndocumentedPage(player.getCurrentPage());
        }
    }

    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        if (display.isClickItem(event.getSlot())) {
            display.getClickItem(event.getSlot()).onClick(event);
        }
        if (display.isPageItem(event.getSlot())) {
            GUIPage page = player.getPage(display.getPageItem(event.getSlot()));
            if (page != null) {
                player.openPage(page);
            }
        } else {
            onInventoryClick(event);
        }
    }

    public abstract void onInventoryClick(InventoryClickEvent event);

    public abstract String getTitle();

    public abstract GUIPageType getType();

    protected void setDisplay(RadioInventory display) {
        this.display = display;
    }

}
