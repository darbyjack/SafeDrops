package me.glaremasters.safedrops.events;

import static me.glaremasters.safedrops.util.ColorUtil.color;
import java.util.HashMap;
import me.glaremasters.safedrops.SafeDrops;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Created by GlareMasters on 2/3/2018.
 */
public class PlayerDropEvent implements Listener {

    public static HashMap<String, Long> dropItem = new HashMap<>();

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        FileConfiguration config = SafeDrops.getI().getConfig();
        int length = config.getInt("droptime");
        if (config.getStringList("whitelist").contains(event.getItemDrop().getItemStack().getType().toString())) {
            if (!dropItem.containsKey(player.getName())) {

                player.sendMessage(color(config.getString("messages.drop").replace("{amount}", Integer.toString(length))));
                dropItem.put(player.getName(), System.currentTimeMillis());
                Bukkit.getServer().getScheduler().runTaskLater(SafeDrops.getI(), () -> dropItem.remove(player.getName()), length * 20);
                event.setCancelled(true);
                return;
            }
            event.setCancelled(false);
        }
    }

}
