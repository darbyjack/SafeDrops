package me.glaremasters.safedrops.events;

import java.util.HashMap;
import me.glaremasters.safedrops.SafeDrops;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

/**
 * Created by GlareMasters on 2/3/2018.
 */
public class PlayerDropEvent implements Listener {

    public HashMap<String, Long> dropItem = new HashMap<>();

    @EventHandler
    public void onPlayerDrop(PlayerDropItemEvent event) {
        Player player = event.getPlayer();
        if (!dropItem.containsKey(player.getName())) {
            player.sendMessage("Drop again within 3 seconds to drop items.");
            dropItem.put(player.getName(), System.currentTimeMillis());
            Bukkit.getServer().getScheduler().runTaskLater(SafeDrops.getI(), () -> {
                dropItem.remove(player.getName());
            }, 20 * 3);
            event.setCancelled(true);
            return;
        }
        event.setCancelled(false);
    }

}
