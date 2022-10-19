package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.NotNull;

public class Rename implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player))
            return true;

        Player p = (Player) sender;

        if(!(p.hasPermission("hyperium.rename"))) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lRENAME &8» &7You must be &d&lSTARDRIFTER &7or higher to rename items."));
            return true;
        }

        if(p.getInventory().getItemInMainHand().getType() != Material.DIAMOND_SWORD
                && p.getInventory().getItemInMainHand().getType() != Material.DIAMOND_HELMET
                && p.getInventory().getItemInMainHand().getType() != Material.DIAMOND_CHESTPLATE
                && p.getInventory().getItemInMainHand().getType() != Material.DIAMOND_LEGGINGS
                && p.getInventory().getItemInMainHand().getType() != Material.DIAMOND_BOOTS) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lRENAME &8» &7You may only rename &bswords and armor&7."));
            return true;
        }

        if(args.length < 1) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lRENAME &8» &7Usage: &b/rename <name>&7."));
            return true;
        }

        String newName = "";

        for(int i = 0; i < args.length; i++) {
            newName += args[i] + " ";
        }

        ItemMeta meta = p.getInventory().getItemInMainHand().getItemMeta();
        meta.setDisplayName(ChatColor.translateAlternateColorCodes('&', newName));
        p.getInventory().getItemInMainHand().setItemMeta(meta);

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lRENAME &8» &7Successfully renamed item in hand."));

        return true;
    }

}
