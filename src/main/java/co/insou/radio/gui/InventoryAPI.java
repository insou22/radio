package co.insou.radio.gui;

import co.insou.radio.gui.page.ClickInventory;
import co.insou.radio.gui.page.PageInventory;
import org.apache.commons.lang.StringUtils;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InventoryAPI implements Listener {

    private static ArrayList<ClickInventory> inventories = new ArrayList<ClickInventory>();

    /**
     * Generates a empty array of ItemStack rounded up to the nearest 9
     */

    public static ItemStack[] generateEmptyPage(int itemsSize) {
        itemsSize = (int) (Math.ceil((double) itemsSize / 9)) * 9;
        return new ItemStack[Math.min(54, itemsSize)];
    }

    /**
     * Returns a hidden string in the itemstack which is hidden using displayname
     */

    public static String getHiddenString(ItemStack item) {
        // Only the color chars at the end of the string is it
        StringBuilder builder = new StringBuilder();
        if (!item.getItemMeta().hasDisplayName())
            return null;
        char[] chars = item.getItemMeta().getDisplayName().toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == ChatColor.COLOR_CHAR)
                continue;
            if (i + 1 < chars.length) {
                if (chars[i + 1] == ChatColor.COLOR_CHAR && i > 1 && chars[i - 1] == ChatColor.COLOR_CHAR)
                    builder.append(c);
                else if (builder.length() > 0)
                    builder = new StringBuilder();
            } else if (i > 0 && chars[i - 1] == ChatColor.COLOR_CHAR)
                builder.append(c);
        }
        if (builder.length() == 0)
            return null;
        return builder.toString();
    }

    public static PageInventory[] getPageInventories(Player p) {
        if (!p.hasMetadata("PageInventory"))
            return new PageInventory[2];
        return ((PageInventory[]) p.getMetadata("PageInventory").get(0).value()).clone();
    }

    /**
     * Gets the page inventory of a player
     */

    public static PageInventory getPageInventory(Player p) {
        PageInventory[] invs = getPageInventories(p);
        return invs[0];
    }

    /**
     * Does the itemstack have a hidden string using chatcolors in it
     */

    public static boolean hasHiddenString(ItemStack item) {
        return getHiddenString(item) != null;
    }

    public static void registerInventory(ClickInventory inv) {
        inventories.add(inv);
    }

    /**
     * Sets a hidden string in the itemstack displayname
     */
    public static ItemStack setHiddenString(ItemStack itemToName, String name) {
        String itemName = ChatColor.WHITE + toReadable(itemToName.getType().name());
        ItemMeta meta = itemToName.getItemMeta();
        if (meta.hasDisplayName())
            itemName = meta.getDisplayName();
        for (int i = 0; i < name.length(); i++) {
            itemName += ChatColor.COLOR_CHAR + name.substring(i, i + 1);
        }
        meta.setDisplayName(itemName);
        itemToName.setItemMeta(meta);
        return itemToName;
    }

    /**
     * Generates a item with the given Material, Data, Name and Lore
     */
    @Deprecated
    public static ItemStack setNameAndLore(ItemStack item, String name, List<String> lore) {
        ItemMeta meta = item.getItemMeta();
        if (name != null) {
            if (ChatColor.stripColor(name).equals(name))
                name = ChatColor.WHITE + name;
            meta.setDisplayName(name);
        }
        if (lore != null && lore.size() > 0) {
            meta.setLore(lore);
        }
        item.setItemMeta(meta);
        return item;
    }

    /**
     * Generates a item with the given Material, Data, Name and Lore
     */
    public static ItemStack setNameAndLore(ItemStack item, String name, String... lore) {
        return setNameAndLore(item, name, Arrays.asList(lore));
    }

    /**
     * Creates a itemstack which is unlike existing itemstacks in that it has a unique displayname
     */
    public static ItemStack setUniqueItem(ItemStack item) {
        return setHiddenString(item, System.currentTimeMillis() + "");
    }

    private static String toReadable(String string) {
        String[] names = string.split("_");
        for (int i = 0; i < names.length; i++) {
            names[i] = names[i].substring(0, 1) + names[i].substring(1).toLowerCase();
        }
        return (StringUtils.join(names, " "));
    }

    public static void unregisterInventory(ClickInventory inv) {
        inventories.remove(inv);
    }

}
