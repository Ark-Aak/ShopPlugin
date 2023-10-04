package skyfire.shopplugin.shop;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopItem implements ConfigurationSerializable {

    ItemStack item;
    long limit;

    public ShopItem(ItemStack item, long limit) {
        this.item = item;
        this.limit = limit;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        //The serialization of ShopItem
        Map<String, Object> map = new HashMap<>();
        map.put("item", item);
        map.put("limit", limit);
        return map;
    }

    public static @NotNull ShopItem deserialize(Map<String, Object> map) {
        //The deserialization of ShopItem
        return new ShopItem(
                (map.get("item") != null ? (ItemStack) map.get("name") : null),
                (map.get("limit") != null ? (long) map.get("limit") : 0L)
        );
    }

    public @Nullable ItemStack getItem() {
        return item;
    }

    public long getLimit() {
        return limit;
    }
}
