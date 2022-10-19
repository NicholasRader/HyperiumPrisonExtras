package us.hyperiummc.hyperiumprisonextras.fixes;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.CraftItemEvent;

public class BlockCrafting implements Listener {

    @EventHandler
    public void onCraft(CraftItemEvent e) {
        if(e.getCurrentItem().getType() == Material.DIAMOND_PICKAXE)
            e.setCancelled(true);
    }

}
