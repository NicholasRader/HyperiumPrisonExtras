package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ResetSeason implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(sender instanceof Player) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHN &8» &7Unknown command. Type &9''/help'' &7for help."));
            return true;
        }

        // b-z warps
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.B\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.C\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.D\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.E\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.F\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.G\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.H\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.I\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.J\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.K\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.L\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.M\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.N\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.O\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.P\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.Q\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.R\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.S\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.T\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.U\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.V\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.W\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.X\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.Y\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.Z\"");

        // pmines
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p5\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p10\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p15\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p20\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p30\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p40\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p50\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p60\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p70\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p80\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p90\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p100\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p110\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p120\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p130\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.p140\"");

        // automines
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto1\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto2\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto3\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto4\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto5\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto6\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto7\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto8\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto9\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto10\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto11\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto12\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto13\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto14\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto15\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto16\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto17\"");
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == essentials.warps.auto18\"");

        // autosell
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp bulkupdate users delete \"permission == autosell.shop.Mine-Prestige\"");

        return true;
    }
}
