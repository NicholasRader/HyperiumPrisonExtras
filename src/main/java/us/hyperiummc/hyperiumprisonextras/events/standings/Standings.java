package us.hyperiummc.hyperiumprisonextras.events.standings;

import org.bukkit.Bukkit;

import java.util.HashMap;
import java.util.UUID;

public class Standings {

    public static HashMap<UUID, Integer> eventPlayers = new HashMap<>();
    public static UUID TopThree[] = new UUID[3];

    public static void updateStandings(UUID u) {
        boolean full = true;
        boolean placed = false;
        for(int i = 0; i < 3; i++) {
            if(TopThree[i] == null)
                full = false;
            else if(TopThree[i] == u || Bukkit.getOfflinePlayer(TopThree[i]).getName().equalsIgnoreCase(Bukkit.getOfflinePlayer(u).getName()))
                placed = true;
        }

        if(!full && !placed) {
            if (TopThree[0] == null) {
                TopThree[0] = u;
                return;
            }

            if (TopThree[1] == null) {
                TopThree[1] = u;
                return;
            }

            if (TopThree[2] == null) {
                TopThree[2] = u;
                return;
            }
        }

        if(TopThree[0] == u || Bukkit.getOfflinePlayer(TopThree[0]).getName().equalsIgnoreCase(Bukkit.getOfflinePlayer(u).getName()))
            return;

        if(eventPlayers.get(u) > eventPlayers.get(TopThree[0])) {
            if (TopThree[1] == u) {
                UUID swap = TopThree[0];
                TopThree[0] = u;
                TopThree[1] = swap;
                return;
            }

            UUID move1 = TopThree[0];
            UUID move2 = TopThree[1];
            TopThree[0] = u;
            TopThree[1] = move1;
            TopThree[2] = move2;
            return;
        }

        if(TopThree[1] == u || Bukkit.getOfflinePlayer(TopThree[1]).getName().equalsIgnoreCase(Bukkit.getOfflinePlayer(u).getName()))
            return;

        if(eventPlayers.get(u) > eventPlayers.get(TopThree[1])) {
            UUID swap = TopThree[1];
            TopThree[1] = u;
            TopThree[2] = swap;
            return;
        }

        if(TopThree[2] == u || Bukkit.getOfflinePlayer(TopThree[2]).getName().equalsIgnoreCase(Bukkit.getOfflinePlayer(u).getName()))
            return;

        if(eventPlayers.get(u) > eventPlayers.get(TopThree[2]))
            TopThree[2] = u;
    }
}
