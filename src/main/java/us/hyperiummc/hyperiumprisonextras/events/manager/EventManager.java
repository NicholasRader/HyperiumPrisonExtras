package us.hyperiummc.hyperiumprisonextras.events.manager;

import org.bukkit.Bukkit;
import org.bukkit.command.ConsoleCommandSender;
import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;
import us.hyperiummc.hyperiumprisonextras.events.standings.Standings;
import us.hyperiummc.hyperiumprisonextras.utils.Broadcast;

import java.util.List;

public class EventManager {

    public static int objective = 0;
    public static int required;

    public static boolean isEventRunning = false;
    public static boolean lastEventFailed = false;

    public static String currentEvent = "None";

    public static void setCurrentEvent(String event) {
        required = HyperiumPrisonExtras.getInstance().getConfig().getInt("events.blocks-mined.required");
        currentEvent = event;
        isEventRunning = true;
        lastEventFailed = false;
    }

    public static String getCurrentEvent() { return currentEvent; }

    public static void stopCurrentEvent() {
        objective = 0;
        currentEvent = "None";
        isEventRunning = false;
        if(!lastEventFailed) {
            ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();

            String first = Standings.TopThree[0] == null ? "N/A" : Bukkit.getOfflinePlayer(Standings.TopThree[0]).getName();
            String second = Standings.TopThree[1] == null ? "N/A" : Bukkit.getOfflinePlayer(Standings.TopThree[1]).getName();
            String third = Standings.TopThree[2] == null ? "N/A" : Bukkit.getOfflinePlayer(Standings.TopThree[2]).getName();
            int firstScore = first.equalsIgnoreCase("N/A") ? 0 : Standings.eventPlayers.get(Standings.TopThree[0]);
            int secondScore = second.equalsIgnoreCase("N/A") ? 0 : Standings.eventPlayers.get(Standings.TopThree[1]);
            int thirdScore = third.equalsIgnoreCase("N/A") ? 0 : Standings.eventPlayers.get(Standings.TopThree[2]);

            List<String> rawMessages = HyperiumPrisonExtras.getInstance().messagesConfig.getStringList("messages.event-completed");
            for(int i = 0; i < rawMessages.size(); i++) {
                String message = rawMessages.get(i)
                        .replaceAll("%first%", first)
                        .replaceAll("%second%", second)
                        .replaceAll("%third%", third)
                        .replaceAll("%firstScore%", Integer.toString(firstScore))
                        .replaceAll("%secondScore%", Integer.toString(secondScore))
                        .replaceAll("%thirdScore%", Integer.toString(thirdScore));

                Broadcast.broadcastCentered(message);
            }

            List<String> eventRewardsFirst = HyperiumPrisonExtras.getInstance().getConfig().getStringList("events.blocks-mined.rewards.first");
            List<String> eventRewardsSecond = HyperiumPrisonExtras.getInstance().getConfig().getStringList("events.blocks-mined.rewards.second");
            List<String> eventRewardsThird = HyperiumPrisonExtras.getInstance().getConfig().getStringList("events.blocks-mined.rewards.third");

            for(int i = 0; i < eventRewardsFirst.size(); i++) {
                String command = eventRewardsFirst.get(i).replaceAll("%player%", first);
                Bukkit.getServer().dispatchCommand(console, command);
            }

            for(int i = 0; i < eventRewardsSecond.size(); i++) {
                String command = eventRewardsSecond.get(i).replaceAll("%player%", second);
                Bukkit.getServer().dispatchCommand(console, command);
            }

            for(int i = 0; i < eventRewardsThird.size(); i++) {
                String command = eventRewardsThird.get(i).replaceAll("%player%", third);
                Bukkit.getServer().dispatchCommand(console, command);
            }

        }
        Standings.eventPlayers.clear();
        Standings.TopThree[0] = null;
        Standings.TopThree[1] = null;
        Standings.TopThree[2] = null;
    }

}
