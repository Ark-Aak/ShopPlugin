package skyfire.shopplugin.configs;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skyfire.shopplugin.ShopPlugin;

import java.io.File;
import java.util.Objects;

public class Message extends Base {

    public static @Nullable String get(String id) {
        return config.getString(id);
    }

    public static @NotNull String getColored(String id) {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(get(id)));
    }
}
