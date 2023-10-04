package skyfire.shopplugin.configs;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nullable;
import skyfire.shopplugin.ShopPlugin;

import java.io.File;

public class Base {

    //Config Base 类，配置文件类基础

    public static FileConfiguration config;
    public static File configFile;

    public static void init(String filename) {
        configFile = new File(ShopPlugin.instance.getDataFolder(), filename);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static void reload() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public static @Nullable FileConfiguration getConfig() {
        return config;
    }

    public static @Nullable File getConfigFile() {
        return configFile;
    }
}
