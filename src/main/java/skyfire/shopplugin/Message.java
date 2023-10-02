package skyfire.shopplugin;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class Message {

    public static FileConfiguration config;
    public static File configFile;

    public static void init(String filename) {
        configFile = new File(ShopPlugin.instance.getDataFolder(), filename);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void reload() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static String get(String id) {
        return config.getString(id);
    }

    public static String getColored(String id) {
        return ChatColor.translateAlternateColorCodes('&', get(id));
    }
}
