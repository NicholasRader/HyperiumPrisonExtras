package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class AutoChatSpy implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if(e.getPlayer().hasPermission("superior.admin.spy"))
            e.getPlayer().performCommand("cell admin spy");

        if(e.getPlayer().hasPermission("essentials.socialspy"))
            e.getPlayer().performCommand("socialspy on");
    }

}
