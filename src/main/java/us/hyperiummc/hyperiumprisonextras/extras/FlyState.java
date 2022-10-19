package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;

public class FlyState implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(e.getPlayer().getWorld().getName().equals("Darkzone"))
            return;

        if(e.getPlayer().hasPermission("essentials.fly")) {
            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fly " + e.getPlayer().getName() + " on");
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        Player p = e.getPlayer();
        if(p.getWorld().getName().equals("Darkzone")) {
            if(p.isFlying() && !(p.hasPermission("hyperium.bypassfly"))) {
                Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "fly " + e.getPlayer().getName() + " off");
                p.setFlying(false);
            }
        }
    }

    @EventHandler
    public void onDarkFly(PlayerCommandPreprocessEvent e) {
        if(!(e.getPlayer().hasPermission("hyperium.bypassfly")))
            return;

        String[] array = e.getMessage().split(" ");

        if(array[0].equalsIgnoreCase("/fly")
                && e.getPlayer().getWorld().getName().equalsIgnoreCase("Darkzone")) {
            e.setCancelled(true);
            e.getPlayer().setAllowFlight(true);
            e.getPlayer().setFlying(!(e.getPlayer().isFlying()));
        }
    }

}
