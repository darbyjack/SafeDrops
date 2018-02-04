package me.glaremasters.safedrops;

import java.util.stream.Stream;
import me.glaremasters.safedrops.commands.CommandHelp;
import me.glaremasters.safedrops.commands.CommandReload;
import me.glaremasters.safedrops.commands.base.CommandHandler;
import me.glaremasters.safedrops.events.PlayerDropEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SafeDrops extends JavaPlugin {

    private static SafeDrops i;
    public static String prefix;
    private CommandHandler commandHandler;

    public static SafeDrops getI() {
        return i;
    }


    @Override
    public void onEnable() {
        i = this;
        saveDefaultConfig();
        prefix = ChatColor.translateAlternateColorCodes('&', getConfig().getString("plugin-prefix"))
                + ChatColor.RESET + " ";
        Bukkit.getPluginManager().registerEvents(new PlayerDropEvent(), this);

        commandHandler = new CommandHandler();
        commandHandler.enable();

        getCommand("safedrops").setExecutor(commandHandler);

        Stream.of(
                new CommandHelp(), new CommandReload()
        ).forEach(commandHandler::register);

    }

    @Override
    public void onDisable() {
        commandHandler.disable();
        if (PlayerDropEvent.dropItem.size() > 0) {
            PlayerDropEvent.dropItem.clear();
        }
    }


    public static String getPrefix() {
        return prefix;
    }
}
