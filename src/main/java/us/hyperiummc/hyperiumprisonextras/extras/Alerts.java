package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;
import us.hyperiummc.hyperiumprisonextras.utils.Broadcast;

public class Alerts implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender.hasPermission("hyperium.alert"))) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHN &8» &7Unknown command. Type &9''/help'' &7for help."));
            return true;
        }

        if(args.length < 1)
            return false;

        String alert = "";

        for(int i = 0; i < args.length; i++) {
            alert += args[i] + " ";
        }

        Broadcast.broadcastAlert(alert);

        return true;
    }

}
