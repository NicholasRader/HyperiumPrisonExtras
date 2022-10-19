package us.hyperiummc.hyperiumprisonextras.fixes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class OptimizedKeyall implements CommandExecutor {

    String voteCommand = "crate givephys %player% Vote %amount%";
    String dreamCommand = "crate givephys %player% Dream %amount%";
    String galacticCommand = "crate givephys %player% Galactic %amount%";
    String celestialCommand = "crate givephys %player% Celestial %amount%";
    String mythicCommand = "crate givephys %player% Mythic %amount%";

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender.hasPermission("hyperium.keyall"))) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHN &8» &7Unknown command. Type &9''/help'' &7for help."));
            return true;
        }

        if(args.length < 1)
            return false;

        String keyType;
        try {
            keyType = args[0].toLowerCase();
        } catch (Exception e) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lKEYALL &8» &7Input a valid key type."));
            return true;
        }

        String keyColor;
        String commandToRun;
        switch(keyType) {
            case "vote":
                keyColor = "&2";
                commandToRun = voteCommand;
                break;
            case "dream":
                keyColor = "&a";
                commandToRun = dreamCommand;
                break;
            case "galactic":
                keyColor = "&3";
                commandToRun = galacticCommand;
                break;
            case "celestial":
                keyColor = "&c";
                commandToRun = celestialCommand;
                break;
            case "mythic":
                keyColor = "&5";
                commandToRun = mythicCommand;
                break;
            default:
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lKEYALL &8» &7Input a valid key type."));
                return true;
        }

        int amount = 1;
        if(args.length > 1) {
            try {
                amount = Integer.parseInt(args[1]);
                if(amount > 10) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lKEYALL &8» &7Cannot give more than 10 keys."));
                    return true;
                }
            } catch(Exception e) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lKEYALL &8» &7Input a valid amount."));
                return true;
            }
        }

        commandToRun = commandToRun.replaceAll("%amount%", Integer.toString(amount));

        for(Player p : Bukkit.getOnlinePlayers()) {
            String giveThisPlayer = commandToRun.replaceAll("%player%", p.getName());
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), giveThisPlayer);
            p.sendTitle(ChatColor.translateAlternateColorCodes('&', "&9&lKEYALL"),
                    ChatColor.translateAlternateColorCodes('&', "&7x" + amount + " " + keyColor + "&l" +
                            keyType.toUpperCase() + " &7Keys given!"), 20, 40, 20);
        }

        return true;
    }

}
