package us.hyperiummc.hyperiumprisonextras.fixes;

import me.prisonranksx.PrisonRanksX;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;

public class PrestigeMax {

    private static PrisonRanksX prx = (PrisonRanksX) Bukkit.getPluginManager().getPlugin("PrisonRanksX");

    public static void execute(Player p) {
        if(!(prx.prxAPI.getPlayerRank(p.getUniqueId()).equalsIgnoreCase("Z"))) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lPRESTIGE &8» &7You are not &bRank Z&7. Try ''&9/rumax&7'' first."));
            return;
        }

        String prestige;
        if(prx.prxAPI.getPlayerPrestige(p.getUniqueId()) == null)
            prestige = "0";
        else
            prestige = prx.prxAPI.getPlayerPrestige(p.getUniqueId());

        if(prestige.equalsIgnoreCase("200")) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lPRESTIGE &8» &7You are already at the max prestige."));
            return;
        }

        if(!(HyperiumPrisonExtras.getEconomy().getBalance(p) >= prx.prxAPI.getPlayerNextPrestigeCost(p.getUniqueId()))) {
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lPRESTIGE &8» &7You need &a$" +
                    prx.prxAPI.getPlayerNextPrestigeCostFormatted(p.getUniqueId()) + " &7to prestige to &b" + prx.prxAPI.getPlayerNextPrestige(p.getUniqueId()) + "&7."));
            return;
        }

        double rumaxCost = 670685000;

        String nextPrestige = prx.prxAPI.getPlayerNextPrestige(p.getUniqueId());
        int count = 0;
        double cond = HyperiumPrisonExtras.getEconomy().getBalance(p);
        while(cond >= prx.prxAPI.getPrestigeCost(nextPrestige)) {
            HyperiumPrisonExtras.getEconomy().withdrawPlayer(p, prx.prxAPI.getPrestigeCost(nextPrestige));
            cond -= prx.prxAPI.getPrestigeCost(nextPrestige);
            cond -= rumaxCost;
            count++;
            try {
                if(prx.prxAPI.getPrestigeNameFromNumber(Integer.parseInt(prx.prxAPI.getPrestigeNumber(nextPrestige)) + 1) == null)
                    break;
                nextPrestige = prx.prxAPI.getPrestigeNameFromNumber(Integer.parseInt(prx.prxAPI.getPrestigeNumber(nextPrestige)) + 1);
            } catch(Exception e) {
                p.sendMessage("&9&lPRESTIGE &8» &7Unknown error, please open a ticket.");
                break;
            }
        }

        if(nextPrestige.equalsIgnoreCase("200"))
            prx.prxAPI.setPlayerPrestige(p, prx.prxAPI.getPrestigeNameFromNumber(Integer.parseInt(prx.prxAPI.getPrestigeNumber(nextPrestige)) - 1));
        else
            prx.prxAPI.setPlayerPrestige(p, prx.prxAPI.getPrestigeNameFromNumber(Integer.parseInt(prx.prxAPI.getPrestigeNumber(nextPrestige)) - 2));

        HyperiumPrisonExtras.getEconomy().depositPlayer(p, prx.prxAPI.getPlayerNextPrestigeCost(p.getUniqueId()));
        p.performCommand("prestige");

        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mp tokens-1 " + p.getName() + " " + 12*(count-1));
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mp tokens-2 " + p.getName() + " " + 12*(count-1));
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "mp tokens-3 " + p.getName() + " " + (count-1));
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Dream " + (count-1));

        int newPrestige = prx.prxAPI.getPlayerPrestigeNumber(p.getUniqueId());
        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto2");

        if(newPrestige >= 1) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set autosell.shop.Mine-Prestige");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto2");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p1");
        }
        if(newPrestige >= 5) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto3");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p5");
        }
        if(newPrestige >= 10) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto4");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p10");
        }
        if(newPrestige >= 15) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto5");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p15");
        }
        if(newPrestige >= 20) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto6");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p20");
        }
        if(newPrestige >= 30) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto7");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p30");
        }
        if(newPrestige >= 40) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto8");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p40");
        }
        if(newPrestige >= 50) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto9");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p50");
        }
        if(newPrestige >= 60) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto10");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p60");
        }
        if(newPrestige >= 70) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto11");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p70");
        }
        if(newPrestige >= 80) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto12");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p80");
        }
        if(newPrestige >= 90) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto13");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p90");
        }
        if(newPrestige >= 100) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto14");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p100");
        }
        if(newPrestige >= 110) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto15");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p110");
        }
        if(newPrestige >= 120) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto16");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p120");
        }
        if(newPrestige >= 130) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto17");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p130");
        }
        if(newPrestige >= 140) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto18");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p140");
        }
        if(newPrestige >= 150) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto19");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p150");
        }
        if(newPrestige >= 160) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto20");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p160");
        }
        if(newPrestige >= 170) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto21");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p170");
        }
        if(newPrestige >= 180) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto22");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p180");
        }
        if(newPrestige >= 190) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.auto23");
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set essentials.warps.p190");
        }

        return;
    }

}
