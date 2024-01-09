package skyfire.shopplugin.data;

import org.bukkit.inventory.ItemStack;
import skyfire.shopplugin.shop.Shop;
import skyfire.shopplugin.shop.ShopItem;

import java.util.ArrayList;
import java.util.Objects;

public class ShopManager extends FDataManager{

    private void setShop(String name, Shop shop) {
        set("shop." + name, shop);
    }

    private void setItem(String name, ShopItem item) {
        set("item." + name, item);
    }

    private ShopItem getItem(String name) {
        if (getConfig() != null) {
            return ShopItem.deserialize(Objects.requireNonNull(getConfig().getConfigurationSection("item." + name)).getValues(false));
        }
        return null;
    }

    private Shop getShop(String name) {
        if (getConfig() != null) {
            return Shop.deserialize(Objects.requireNonNull(getConfig().getConfigurationSection("shop." + name)).getValues(false));
        }
        return null;
    }

    public boolean hasShop(String name) {
        return getShop(name) != null;
    }

    public boolean hasItem(String name) {
        return getItem(name) != null;
    }

    public ShopManager(String filename) {
        super(filename);
    }

    public void createShop(String name) {
        Shop newShop = new Shop(name);
        setShop(name, newShop);
    }

    public void createItem(String name, ItemStack item) {
        ShopItem newItem = new ShopItem(item, name);
        setItem(name, newItem);
    }
}
