package skyfire.shopplugin.shop;

import org.bukkit.Location;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Shop implements ConfigurationSerializable {

    List<Location> locationList;
    List<ShopItem> shopItemList;

    public Shop(List<Location> locationList, List<ShopItem> shopItemList) {
        this.locationList = locationList;
        this.shopItemList = shopItemList;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        //The serialization of Shop
        Map<String,Object> map = new HashMap<>();
        map.put("locationList", locationList);
        map.put("shopItemList", shopItemList);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static @NotNull Shop deserialize(Map<String, Object> map) {
        //The deserialization of Shop
        return new Shop(
                map.get("locationList") != null ? (List<Location>) map.get("locationList") : new ArrayList<>(),
                map.get("shopItemList") != null ? (List<ShopItem>) map.get("shopItemList") : new ArrayList<>()
        );
    }

    public List<Location> getLocationList() {
        return locationList;
    }
}
