package co.insou.radio.gui.page;

import co.insou.radio.gui.GUIPageType;
import co.insou.radio.gui.ItemClickHandler;

/**
 * Created by insou on 10/01/2016.
 */
public interface RadioInventory {

    void displayInventory();

    void setPageItem(int pageNumber, int slot, GUIPageType page);

    GUIPageType getPageItem(int pageNumber, int slot);

    boolean isPageItem(int pageNumber, int slot);

    GUIPageType getPageItem(int slot);

    boolean isPageItem(int slot);

    void setClickItem(int slot, ItemClickHandler handler);

    boolean isClickItem(int pageNumber, int slot);

    ItemClickHandler getClickItem(int pageNumber, int slot);

    boolean isClickItem(int slot);

    ItemClickHandler getClickItem(int slot);

}
