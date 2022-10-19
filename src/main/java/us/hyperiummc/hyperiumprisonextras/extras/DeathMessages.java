package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;
import us.hyperiummc.hyperiumprisonextras.utils.Broadcast;

public class DeathMessages implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        if(e.getEntity().getKiller() == null)
            return;

        Broadcast.broadcast(HyperiumPrisonExtras.getInstance().messagesConfig.getString("messages.death")
                .replaceAll("%player1%", e.getEntity().getName())
                .replaceAll("%player2%", e.getEntity().getKiller().getName()));
    }

}
