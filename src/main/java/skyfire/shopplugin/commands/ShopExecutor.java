package skyfire.shopplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skyfire.shopplugin.configs.Data;
import skyfire.shopplugin.configs.Message;
import skyfire.shopplugin.ShopPlugin;

import java.util.List;

public class ShopExecutor implements Listener, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1){
            if (args[0].equals("reload")) {
                Message.reload();
                Data.reload();
                ShopPlugin.instance.reloadConfig();
                return true;
            }
        }
        sender.sendMessage(Message.getColored("unknown_command"));
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        //List <String> commandList = new ArrayList<>();
        //commandList.add("list");
        //commandList.add("new");
        //commandList.add("remove");
        return null;
    }
}
