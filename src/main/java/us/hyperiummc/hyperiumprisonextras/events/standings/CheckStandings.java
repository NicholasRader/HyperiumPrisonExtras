package us.hyperiummc.hyperiumprisonextras.events.standings;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;
import us.hyperiummc.hyperiumprisonextras.events.manager.EventManager;
import us.hyperiummc.hyperiumprisonextras.utils.CenterText;

import java.util.List;

public class CheckStandings implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if(!(EventManager.isEventRunning)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&',
                    HyperiumPrisonExtras.getInstance().messagesConfig.getString("messages.no-event-running")));
            return true;
        }

        String first = Standings.TopThree[0] == null ? "N/A" : Bukkit.getOfflinePlayer(Standings.TopThree[0]).getName();
        String second = Standings.TopThree[1] == null ? "N/A" : Bukkit.getOfflinePlayer(Standings.TopThree[1]).getName();
        String third = Standings.TopThree[2] == null ? "N/A" : Bukkit.getOfflinePlayer(Standings.TopThree[2]).getName();
        int firstScore = first.equalsIgnoreCase("N/A") ? 0 : Standings.eventPlayers.get(Standings.TopThree[0]);
        int secondScore = second.equalsIgnoreCase("N/A") ? 0 : Standings.eventPlayers.get(Standings.TopThree[1]);
        int thirdScore = third.equalsIgnoreCase("N/A") ? 0 : Standings.eventPlayers.get(Standings.TopThree[2]);

        List<String> rawMessages = HyperiumPrisonExtras.getInstance().messagesConfig.getStringList("messages.check-standings");
        for(int i = 0; i < rawMessages.size(); i++) {
            String message = rawMessages.get(i)
                    .replaceAll("%first%", first)
                    .replaceAll("%second%", second)
                    .replaceAll("%third%", third)
                    .replaceAll("%firstScore%", Integer.toString(firstScore))
                    .replaceAll("%secondScore%", Integer.toString(secondScore))
                    .replaceAll("%thirdScore%", Integer.toString(thirdScore));

            CenterText.sendCenteredMessage((Player) sender, message);
        }

        return true;
    }

}
