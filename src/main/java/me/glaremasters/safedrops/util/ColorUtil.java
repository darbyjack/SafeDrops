package me.glaremasters.safedrops.util;

import me.glaremasters.safedrops.SafeDrops;
import org.bukkit.ChatColor;

/**
 * Created by GlareMasters on 2/3/2018.
 */
public class ColorUtil {

    public static String color(String string) {
        return ChatColor.translateAlternateColorCodes('&', SafeDrops.getPrefix() + string);
    }

}