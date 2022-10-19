package us.hyperiummc.hyperiumprisonextras;

import me.clip.ezblocks.EZBlocks;
import me.clip.placeholderapi.PlaceholderAPI;
import me.clip.placeholderapi.expansion.PlaceholderExpansion;
import me.prisonranksx.PrisonRanksX;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Placeholders extends PlaceholderExpansion {

    private PrisonRanksX prx = (PrisonRanksX) Bukkit.getPluginManager().getPlugin("PrisonRanksX");

    @Override
    public String getAuthor() {
        return "ItzRade";
    }
    @Override
    public String getIdentifier() {
        return "hyperium";
    }
    @Override
    public String getVersion() {
        return "1.3.0";
    }

    @Override
    public boolean persist() {
        return true; // This is required or else PlaceholderAPI will unregister the Expansion on reload
    }

    @Override
    public String onPlaceholderRequest(Player p, String identifier) {

        if(p == null) {
            return "";
        }

        if (identifier.equals("cell")) {
            if(p.hasPermission("hyperium.ignore"))
                return "";

            String cell = (PlaceholderAPI.setPlaceholders(p, "%superior_island_name%").equals("")) ? "" : ChatColor.translateAlternateColorCodes('&', "&8[&9" + PlaceholderAPI.setPlaceholders(p, "%superior_island_name%") + "&8] ");

            return cell;
        }

        if (identifier.equals("prestige")) {
            if(p.hasPermission("hyperium.ignore"))
                return "";

            if(prx.prxAPI.getPlayerPrestigeNumber(p) == 0)
                return "";

            return ChatColor.translateAlternateColorCodes('&', "&8[" + prx.prxAPI.getPlayerPrestigeDisplay(p) + "&8] ");
        }

        if (identifier.equals("rank")) {
            if (p.hasPermission("hyperium.ignore"))
                return "";

            return ChatColor.translateAlternateColorCodes('&', "&8[" + prx.prxAPI.getPlayerRankDisplay(p) + "&8] ");
        }

        if (identifier.equals("multiplier")) {
            double multi = Double.parseDouble(PlaceholderAPI.setPlaceholders(p, "%autosell_total_multiplier%"));
            multi = Math.round(multi * 100);
            multi /= 100;
            return String.valueOf(multi + 1);
        }

        if (identifier.equals("blocks_mined"))
            return "" + EZBlocks.getEZBlocks().getBlocksBroken(p);

        return null;
    }
}
