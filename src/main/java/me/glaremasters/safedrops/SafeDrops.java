package me.glaremasters.safedrops;

import me.glaremasters.safedrops.events.PlayerDropEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SafeDrops extends JavaPlugin {

    private static SafeDrops i;
    private static String prefix;

    public static SafeDrops getI() {
        return i;
    }


    @Override
    public void onEnable() {
        i = this;
    saveDefaultConfig();
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("plugin-prefix")) + ChatColor.RESET + " ";
        Bukkit.getPluginManager().registerEvents(new PlayerDropEvent(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }


    public static String getPrefix() {
        return prefix;
    }
}
