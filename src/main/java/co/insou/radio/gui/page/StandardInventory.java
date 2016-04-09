package co.insou.radio.gui.page;

import co.insou.radio.gui.GUIPageType;
import co.insou.radio.gui.ItemClickHandler;
import co.insou.radio.radio.RadioPlayer;
import co.insou.radio.util.item.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by insou on 17/12/2015.
 */
public class StandardInventory implements RadioInventory {

    private RadioPlayer player;
    private Inventory inventory;
    private Map<Integer, GUIPageType> pageItems;
    private Map<Integer, ItemClickHandler> handlers;

    public StandardInventory(RadioPlayer player, int size, String title) {
        this.player = player;
        pageItems = new HashMap<>();
        handlers = new HashMap<>();
        inventory = Bukkit.createInventory(null, size, title);
    }

    public StandardInventory setItem(int slot, ItemBuilder item) {
        return setItem(slot, item.build());
    }

    public StandardInventory setItem(int slot, ItemBuilder item, GUIPageType page) {
        return setItem(slot, item.build(), page);
    }

    public StandardInventory setItem(int slot, ItemStack item) {
        inventory.setItem(slot, item);
        return this;
    }

    public StandardInventory setItem(int slot, ItemStack item, GUIPageType page) {
        inventory.setItem(slot, item);
        setPageItem(1, slot, page);
        return this;
    }

    public StandardInventory setItem(int slot, ItemStack item, ItemClickHandler handler) {
        inventory.setItem(slot, item);
        setClickItem(slot, handler);
        return this;
    }

    public StandardInventory setItem(int slot, ItemBuilder item, ItemClickHandler handler) {
        inventory.setItem(slot, item.build());
        setClickItem(slot, handler);
        return this;
    }

    @Override
    public void displayInventory() {
        player.getPlayer().openInventory(inventory);
    }

    @Override
    public void setPageItem(int pageNumber, int slot, GUIPageType page) {
        pageItems.put(slot, page);
    }

    @Override
    public GUIPageType getPageItem(int pageNumber, int slot) {
        return getPageItem(slot);
    }

    @Override
    public boolean isPageItem(int pageNumber, int slot) {
        return isPageItem(slot);
    }

    @Override
    public GUIPageType getPageItem(int slot) {
        return pageItems.get(slot);
    }

    @Override
    public boolean isPageItem(int slot) {
        return pageItems.get(slot) != null;
    }

    @Override
    public void setClickItem(int slot, ItemClickHandler handler) {
        handlers.put(slot, handler);
    }

    @Override
    public boolean isClickItem(int pageNumber, int slot) {
        return getClickItem(pageNumber, slot) != null;
    }

    @Override
    public ItemClickHandler getClickItem(int pageNumber, int slot) {
        return handlers.get(slot);
    }

    @Override
    public boolean isClickItem(int slot) {
        return getClickItem(1, slot) != null;
    }

    @Override
    public ItemClickHandler getClickItem(int slot) {
        return getClickItem(1, slot);
    }
}
