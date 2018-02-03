package me.glaremasters.safedrops;

import me.glaremasters.safedrops.events.PlayerDropEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class SafeDrops extends JavaPlugin {

    private static SafeDrops i;

    public static SafeDrops getI() {
        return i;
    }

    @Override
    public void onEnable() {
        i = this;
        Bukkit.getPluginManager().registerEvents(new PlayerDropEvent(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
