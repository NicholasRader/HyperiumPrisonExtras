package us.hyperiummc.hyperiumprisonextras.fixes;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RedeemVoucher implements Listener {

    @EventHandler
    public void onRedeem(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        if(p.getInventory().getItemInMainHand().getType().equals(Material.PAPER)) {
            ItemStack item = p.getInventory().getItemInMainHand();
            ItemMeta meta = item.getItemMeta();
            if(meta.getDisplayName().charAt(4) == '⛀') {
                String line4 = meta.getLore().get(3);
                long tokens = 0;
                try {
                    tokens = Long.parseLong(line4.substring(6));
                } catch(NumberFormatException ex) {
                    ex.printStackTrace();
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTOKENS &8» &7Error redeeming tokens, please contact Hyperium staff."));
                    return;
                }

                if((e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) && !e.getPlayer().isSneaking()) {
                    item.setAmount(item.getAmount() - 1);
                    Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "re Currency add Tokens " + p.getName() + " " + tokens + " true");
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTOKENS &8» &e⛀" + tokens + " &7has been added to your account."));
                }
                else if(e.getPlayer().isSneaking()) {
                    int count = item.getAmount();
                    item.setAmount(0);
                    for(int i = 0; i < count; i++) {
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "re Currency add Tokens " + p.getName() + " " + tokens + " true");
                    }
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTOKENS &8» &e⛀" + (tokens * count) + " &7has been added to your account."));
                }

            }
        }
    }

}
