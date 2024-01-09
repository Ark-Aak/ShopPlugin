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
    List<String> shopItemList;
    String shopName;

    public Shop(List<Location> locationList, List<String> shopItemList, String shopName) {
        this.locationList = locationList;
        this.shopItemList = shopItemList;
        this.shopName = shopName;
    }

    public Shop(String shopName) {
        this.locationList = new ArrayList<>();
        this.shopItemList = new ArrayList<>();
        this.shopName = shopName;
    }

    @Override
    public @NotNull Map<String, Object> serialize() {
        //The serialization of Shop
        Map<String,Object> map = new HashMap<>();
        map.put("locationList", locationList);
        map.put("shopItemList", shopItemList);
        map.put("shopName", shopName);
        return map;
    }

    @SuppressWarnings("unchecked")
    public static @NotNull Shop deserialize(Map<String, Object> map) {
        //The deserialization of Shop
        return new Shop(
                map.get("locationList") != null ? (List<Location>) map.get("locationList") : new ArrayList<>(),
                map.get("shopItemList") != null ? (List<String>) map.get("shopItemList") : new ArrayList<>(),
                map.get("shopName") != null ? (String) map.get("shopName") : ""
        );
    }

    public List<Location> getLocationList() {
        return locationList;
    }
}
