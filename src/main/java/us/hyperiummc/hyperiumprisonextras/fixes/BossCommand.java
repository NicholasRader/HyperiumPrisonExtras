package us.hyperiummc.hyperiumprisonextras.fixes;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;

public class BossCommand {

    public static void execute(Player p) {
        p.sendMessage(ChatColor.translateAlternateColorCodes('&',
                HyperiumPrisonExtras.getInstance().messagesConfig.getString("messages.boss")
                .replaceAll("%time%", PlaceholderAPI.setPlaceholders(p, "%elitebosses_autospawn___NEXT%"))));
    }

}
