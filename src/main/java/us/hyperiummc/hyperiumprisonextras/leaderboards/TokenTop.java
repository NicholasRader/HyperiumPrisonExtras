package us.hyperiummc.hyperiumprisonextras.leaderboards;

import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import us.hyperiummc.hyperiumprisonextras.HyperiumPrisonExtras;
import us.hyperiummc.hyperiumprisonextras.utils.CenterText;

import java.util.List;

public class TokenTop implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player))
            return true;

        String top1 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_1_alltime_name%");
        String top2 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_2_alltime_name%");
        String top3 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_3_alltime_name%");
        String top4 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_4_alltime_name%");
        String top5 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_5_alltime_name%");
        String top6 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_6_alltime_name%");
        String top7 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_7_alltime_name%");
        String top8 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_8_alltime_name%");
        String top9 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_9_alltime_name%");
        String top10 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_10_alltime_name%");

        String value1 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_1_alltime_value%");
        String value2 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_2_alltime_value%");
        String value3 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_3_alltime_value%");
        String value4 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_4_alltime_value%");
        String value5 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_5_alltime_value%");
        String value6 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_6_alltime_value%");
        String value7 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_7_alltime_value%");
        String value8 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_8_alltime_value%");
        String value9 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_9_alltime_value%");
        String value10 = PlaceholderAPI.setPlaceholders((Player)sender, "%ajlb_lb_RevEnchants_Currency_Tokens_10_alltime_value%");

        String positionPlaceholder = PlaceholderAPI.setPlaceholders((Player) sender,"%ajlb_position_RevEnchants_Currency_Tokens_alltime%");

        List<String> rawMessages = HyperiumPrisonExtras.getInstance().messagesConfig.getStringList("messages.token-top");
        for(int i = 0; i < rawMessages.size(); i++) {
            String message = rawMessages.get(i)
                    .replaceAll("%top1%", top1)
                    .replaceAll("%top2%", top2)
                    .replaceAll("%top3%", top3)
                    .replaceAll("%top4%", top4)
                    .replaceAll("%top5%", top5)
                    .replaceAll("%top6%", top6)
                    .replaceAll("%top7%", top7)
                    .replaceAll("%top8%", top8)
                    .replaceAll("%top9%", top9)
                    .replaceAll("%top10%", top10)
                    .replaceAll("%value1%", value1)
                    .replaceAll("%value2%", value2)
                    .replaceAll("%value3%", value3)
                    .replaceAll("%value4%", value4)
                    .replaceAll("%value5%", value5)
                    .replaceAll("%value6%", value6)
                    .replaceAll("%value7%", value7)
                    .replaceAll("%value8%", value8)
                    .replaceAll("%value9%", value9)
                    .replaceAll("%value10%", value10)
                    .replaceAll("%rank%", positionPlaceholder);

            CenterText.sendCenteredMessage((Player) sender, message);
        }

        return true;
    }
}
