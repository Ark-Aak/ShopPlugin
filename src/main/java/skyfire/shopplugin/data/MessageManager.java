package skyfire.shopplugin.data;

import org.bukkit.ChatColor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class MessageManager extends FDataManager {

    public MessageManager(String filename) {
        super(filename);
    }

    public @NotNull String getColored(String id) {
        return ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(get(id)));
    }
}
