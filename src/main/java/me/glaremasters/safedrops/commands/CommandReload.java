package me.glaremasters.safedrops.commands;

import me.glaremasters.safedrops.SafeDrops;
import me.glaremasters.safedrops.commands.base.CommandBase;
import me.glaremasters.safedrops.util.ColorUtil;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

/**
 * Created by GlareMasters on 2/4/2018.
 */
public class CommandReload extends CommandBase {

    public CommandReload() {
        super("reload", "Reload the configuration", "safedrops.reload", false, null, null, 0,
                0);
    }

    public void execute(Player player, String[] args) {
        SafeDrops.getI().reloadConfig();

        FileConfiguration config = SafeDrops.getI().getConfig();

        SafeDrops.prefix =
                ChatColor.translateAlternateColorCodes('&', config.getString("plugin-prefix"))
                        + ChatColor.RESET + " ";

        player.sendMessage(ColorUtil.color(config.getString("messages.reload-success")));

    }

}
