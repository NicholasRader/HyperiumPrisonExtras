package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.ItemStack;

public class LockPickaxe implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if(e.getClickedInventory() == null)
            return;

        Player p = (Player) e.getWhoClicked();
        if(p.hasPermission("hyperium.unlocked"))
            return;

        if(e.getClick() == ClickType.NUMBER_KEY) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lPICKAXE &8» &7Moving items with the number keys is disabled."));
        }

        if(e.getClickedInventory().getType() == InventoryType.PLAYER && e.getClickedInventory().getHolder() != null && e.getClickedInventory().getHolder() == p) {
            if(e.getCurrentItem() != null && e.getCurrentItem().getType() != null && e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE) {
                if(!(e.isShiftClick())) {
                    e.setCancelled(true);
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lPICKAXE &8» &7To move your pickaxe, use &9shift-click&7."));
                }
                else {
                    if(p.getInventory().firstEmpty() == -1) {
                        e.setCancelled(true);
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lPICKAXE &8» &7You must have an open slot in your inventory to move your pickaxe."));
                    }
                    else {
                        e.setCancelled(true);
                        ItemStack item = e.getCurrentItem();
                        p.getInventory().remove(item);
                        if(e.getSlot() > 8) {
                            for(int i = 0; i < 9; i++) {
                                if(p.getInventory().getItem(i) == null) {
                                    p.getInventory().setItem(i, item);
                                    return;
                                }
                            }
                            for(int i = 35; i > 8; i--) {
                                if(p.getInventory().getItem(i) == null) {
                                    if(i == e.getSlot())
                                        continue;
                                    p.getInventory().setItem(i, item);
                                    return;
                                }
                            }
                        }
                        else {
                            for(int i = 35; i > 8; i--) {
                                if(p.getInventory().getItem(i) == null) {
                                    p.getInventory().setItem(i, item);
                                    return;
                                }
                            }
                            for(int i = 0; i < 9; i++) {
                                if(p.getInventory().getItem(i) == null) {
                                    if(i == e.getSlot())
                                        continue;
                                    p.getInventory().setItem(i, item);
                                    return;
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onItemDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();
        if(e.getItemDrop().getItemStack().getType() == Material.DIAMOND_PICKAXE) {
            e.setCancelled(true);
            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lPICKAXE &8» &7Your pickaxe is bound to your inventory."));
        }
    }

}
