package skyfire.shopplugin.data;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.Nullable;
import skyfire.shopplugin.ShopPlugin;

import java.io.File;

public class FDataManager{

    //Config Base 类，配置文件类基础

    public FileConfiguration config;
    public File configFile;

    public FDataManager(String filename) {
        configFile = new File(ShopPlugin.instance.getDataFolder(), filename);
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public void reload() {
        config = YamlConfiguration.loadConfiguration(configFile);
    }

    public @Nullable FileConfiguration getConfig() {
        return config;
    }

    public @Nullable File getConfigFile() {
        return configFile;
    }

    public @Nullable String get(String id) {
        return config.getString(id);
    }

    public void set(String id, Object value) {
        config.set(id, value);
    }
}
