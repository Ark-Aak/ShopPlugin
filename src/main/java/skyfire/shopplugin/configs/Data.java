package skyfire.shopplugin.configs;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nullable;
import skyfire.shopplugin.ShopPlugin;

import java.io.File;

public class Data extends Base {

    public static @Nullable Object get(String id) {
        return config.get(id);
    }
}
