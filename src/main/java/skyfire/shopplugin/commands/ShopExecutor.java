package skyfire.shopplugin.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.event.Listener;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import skyfire.shopplugin.data.FDataManager;
import skyfire.shopplugin.data.MessageManager;
import skyfire.shopplugin.ShopPlugin;
import skyfire.shopplugin.utils.StringUtil;

import java.util.List;

import static skyfire.shopplugin.ShopPlugin.message;
import static skyfire.shopplugin.ShopPlugin.shop;

public class ShopExecutor implements Listener, TabExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (args.length == 1){
            if (args[0].equals("reload")) {
                message.reload();
                shop.reload();
                ShopPlugin.instance.reloadConfig();
                return true;
            }
        }
        else if (args.length == 3) {
            if (args[0].equals("create")) {
                String name = args[2];
                shop.createShop(name);
                sender.sendMessage(StringUtil.replacePlaceholder(message.getColored("create_shop"), "%name%", name));
            }
        }
        sender.sendMessage(message.getColored("unknown_command"));
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
