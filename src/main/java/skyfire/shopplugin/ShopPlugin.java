package skyfire.shopplugin;

import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.logging.Logger;

public final class ShopPlugin extends JavaPlugin {

    public static JavaPlugin instance;
    public static Logger log;
    public static Economy econ = null;

    private boolean setupEconomy() {
        RegisteredServiceProvider<Economy> economyProvider;
        economyProvider = this.getServer().getServicesManager().getRegistration(Economy.class);
        if (economyProvider != null) {
            econ = (Economy) economyProvider.getProvider();
            return true;
        }
        else return false;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic
        log = getLogger();
        instance = this;
        log.info("Loading ShopPlugin, made by Aak.");
        log.info("Try to load config.yml...");
        File f = new File("config.yml");
        if (!f.exists()) {
            saveDefaultConfig();
        }
        log.info("config.yml is loaded.");
        log.info("Try to load message.yml...");
        saveResource("message.yml", false);
        Message.init("message.yml");
        log.info("message.yml is loaded.");
        log.info("Try to load Vault...");
        if (!setupEconomy()) {
            log.severe("Load vault failed! Disabling plugin...");
            Bukkit.getPluginManager().disablePlugin(this);
            return;
        }
        log.info("ShopPlugin is loaded.");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
