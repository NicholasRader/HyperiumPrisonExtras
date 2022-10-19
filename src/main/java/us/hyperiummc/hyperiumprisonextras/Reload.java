package us.hyperiummc.hyperiumprisonextras;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.jetbrains.annotations.NotNull;

public class Reload implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender.hasPermission("hpe.reload"))) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    HyperiumPrisonExtras.getInstance().messagesConfig.getString("messages.unknown-command")));
            return true;
        }

        if(command.getName().equalsIgnoreCase("hpereload")) {
            HyperiumPrisonExtras.getInstance().reloadConfig();
            HyperiumPrisonExtras.getInstance().messagesConfig = YamlConfiguration.loadConfiguration(HyperiumPrisonExtras.getInstance().messages);
        }
        if(command.getName().equalsIgnoreCase("hpetest")) {
            sender.sendMessage("" + HyperiumPrisonExtras.getInstance().getConfig().getInt("events.blocks-mined.required"));
            sender.sendMessage("" + HyperiumPrisonExtras.getInstance().messagesConfig.getString("messages.test"));
        }
        return true;
    }

}
