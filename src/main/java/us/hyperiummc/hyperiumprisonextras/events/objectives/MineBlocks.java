package us.hyperiummc.hyperiumprisonextras.events.objectives;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;
import us.hyperiummc.hyperiumprisonextras.events.manager.EventManager;
import us.hyperiummc.hyperiumprisonextras.events.standings.Standings;

public class MineBlocks implements Listener {

    @EventHandler (priority = EventPriority.MONITOR)
    public void eventMine(BlockBreakEvent e) {
        if(!(EventManager.isEventRunning && EventManager.getCurrentEvent().equalsIgnoreCase("Mine")))
            return;

        if(!(Standings.eventPlayers.containsKey(e.getPlayer().getUniqueId())))
            Standings.eventPlayers.put(e.getPlayer().getUniqueId(), 1);
        else
            Standings.eventPlayers.put(e.getPlayer().getUniqueId(), Standings.eventPlayers.get(e.getPlayer().getUniqueId()) + 1);

        EventManager.objective++;
        double current = EventManager.objective;
        double required = EventManager.required;
        double progress = current/required;
        progress = Math.round(progress * 10000);
        progress = progress/100;
        String message = ChatColor.translateAlternateColorCodes('&',
                HyperiumPrisonExtras.getInstance().messagesConfig.getString("messages.action-bar").replaceAll("%progress%", Double.toString(progress)));
        e.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(message));

        if(Standings.TopThree[2] != null && Standings.eventPlayers.get(e.getPlayer().getUniqueId()) < Standings.eventPlayers.get(Standings.TopThree[2]))
            return;

        Standings.updateStandings(e.getPlayer().getUniqueId());

        if(EventManager.objective >= EventManager.required)
            EventManager.stopCurrentEvent();

    }

}
