package us.hyperiummc.hyperiumprisonextras.fixes;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;

public class BlockCertainInventories implements Listener {

    @EventHandler
    public void onInvOpen(InventoryOpenEvent e) {
        if (e.getInventory().getType() == InventoryType.BREWING | e.getInventory().getType() == InventoryType.BEACON
                | e.getInventory().getType() == InventoryType.ANVIL
                | e.getInventory().getType() == InventoryType.ENCHANTING) {
            e.setCancelled(true);
        }
    }

}
