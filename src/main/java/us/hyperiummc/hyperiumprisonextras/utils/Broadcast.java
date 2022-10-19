package us.hyperiummc.hyperiumprisonextras.utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Broadcast {

    public static void broadcast(String message) {
        for(Player p : Bukkit.getOnlinePlayers()) {
             p.sendMessage(ChatColor.translateAlternateColorCodes('&', message));
        }
    }

    public static void broadcastAlert(String message) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lALERT &8» &7" + message));
            p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&9&lALERT"),
                    ChatColor.translateAlternateColorCodes('&', "&7" + message), 20, 80, 20);
        }
    }

    public static void broadcastCentered(String message) {
        for(Player p : Bukkit.getOnlinePlayers()) {
            CenterText.sendCenteredMessage(p, message);
        }
    }

}
