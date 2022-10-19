package us.hyperiummc.hyperiumprisonextras.fixes;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class TokenWithdraw {

    public static void execute(Player p, String[] args) {
        if(args.length < 3) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7Usage: &b/tokens withdraw (amount) [times]"));
            return;
        }

        String value = PlaceholderAPI.setPlaceholders(p, "%RevEnchants_Currency_Tokens%");
        long bal = 0;
        try {
            bal = Long.parseLong(value);
        } catch (NumberFormatException ex) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7Error retrieving token balance."));
            return;
        }

        long amount = 0;
        try {
            amount = Long.parseLong(args[2]);
        } catch (NumberFormatException ex) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7Please enter a valid amount to withdraw."));
            return;
        }

        int times = 1;
        if(args.length > 3) {
            try {
                times = Integer.parseInt(args[3]);
            } catch (NumberFormatException ex) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7Please enter a valid amount of times to withdraw."));
                return;
            }
        }

        if(times < 1) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7Times must be greater than 0."));
            return;
        }

        if(bal < amount) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7You do not have enough tokens."));
            return;
        }

        if(p.getInventory().firstEmpty() == -1) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7You must have space in your inventory."));
            return;
        }

        int storeTimes = times;
        int count = 0;

        while(bal >= amount && times > 0) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "re Currency remove Tokens " + p.getName() + " " + amount + " true");
            count++;
            times--;
            bal -= amount;

            ItemStack voucher = new ItemStack(Material.PAPER, 1);

            ItemMeta voucherMeta = voucher.getItemMeta();
            voucherMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&', "&e&l⛀" + amount + " &6&lVOUCHER"));
            List<String> lore = new ArrayList<>();
            lore.add(ChatColor.translateAlternateColorCodes('&', ""));
            lore.add(ChatColor.translateAlternateColorCodes('&', "&8➥ &bRight-click &7to add the following"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "   &7tokens to your balance:"));
            lore.add(ChatColor.translateAlternateColorCodes('&', "   &e⛀" + amount));
            lore.add(ChatColor.translateAlternateColorCodes('&', ""));
            voucherMeta.setLore(lore);

            voucher.setItemMeta(voucherMeta);

            p.getInventory().addItem(voucher);
        }

        if(count < storeTimes) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7You did not have enough tokens to withdraw &b" + storeTimes + " &7times."));
        }

        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lWITHDRAW &8» &7You have withdrawn &e⛀" + amount + " &b" + count + " &7time(s)."));

    }

}
