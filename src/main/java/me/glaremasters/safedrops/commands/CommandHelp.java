package me.glaremasters.safedrops.commands;

import static me.glaremasters.safedrops.util.ColorUtil.color;
import me.glaremasters.safedrops.SafeDrops;
import me.glaremasters.safedrops.commands.base.CommandBase;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

/**
 * Created by GlareMasters on 2/4/2018.
 */
public class CommandHelp extends CommandBase {

    public CommandHelp() {
        super("help", "List all commands", "safedrops.help", false, null, null, 0, 0);
    }

    public void execute(CommandSender sender, String[] args) {
        FileConfiguration config = SafeDrops.getI().getConfig();

        sender.sendMessage(color(config.getString("messages.help")));
        sender.sendMessage(color(config.getString("messages.reload")));
    }

}