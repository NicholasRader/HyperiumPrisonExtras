package us.hyperiummc.hyperiumprisonextras.fixes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class HideCommands implements Listener {

    @EventHandler
    public void onCmd(PlayerCommandPreprocessEvent e) {
        String[] array = e.getMessage().split(" ");

        if((array[0].equalsIgnoreCase("/token") || array[0].equalsIgnoreCase("/tokens")) && array.length > 1) {
            if(array[1].equalsIgnoreCase("withdraw")) {
                e.setCancelled(true);
                TokenWithdraw.execute(e.getPlayer(), array);
                return;
            }
            for(Player p : Bukkit.getOnlinePlayers()) {
                if(array[1].equalsIgnoreCase(p.getName()) || array[1].equals(p.getDisplayName()))
                    return;
            }
            e.setCancelled(true);
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lBALANCE &8» &7Invalid or offline player specified."));
            return;
        }

        if(e.getPlayer().isOp())
            return;

        if(array[0].equalsIgnoreCase("/eb")
                || array[0].equalsIgnoreCase("/boss")
                || array[0].equalsIgnoreCase("/bosses")
                || array[0].equalsIgnoreCase("/eboss")
                || array[0].equalsIgnoreCase("/ebosses")
                || array[0].equalsIgnoreCase("/eliteboss")
                || array[0].equalsIgnoreCase("/elitebosses")
                || array[0].equalsIgnoreCase("/eliteb")
                || array[0].equalsIgnoreCase("/reaction")
                || array[0].equalsIgnoreCase("/chatreaction:reaction")) {
            e.setCancelled(true);
            if (array[0].equalsIgnoreCase("/boss") || array[0].equalsIgnoreCase("/bosses")) {
                BossCommand.execute(e.getPlayer());
                return;
            }
            e.getPlayer().sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHN &8» &7Unknown command. Type &9''/help'' &7for help."));
        }
        if(array[0].equalsIgnoreCase("/prestigemax") || array[0].equalsIgnoreCase("/pmax") || array[0].equalsIgnoreCase("/maxprestige")) {
            e.setCancelled(true);
            PrestigeMax.execute(e.getPlayer());
            return;
        }
    }

}
