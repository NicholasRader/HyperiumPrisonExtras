package us.hyperiummc.hyperiumprisonextras.extras;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Random;

public class RandomTag implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player && !sender.isOp()) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHN &8» &7Unknown command. Type &9\'\'/help\'\' &7for help."));
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("randomtagt1")) {
            if(args.length == 1) {
                Player p;
                try {
                    p = Bukkit.getPlayer(args[0]);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHN &8» &7Invalid player specified."));
                    return true;
                }

                Random random = new Random();
                int selection = random.nextInt(8);
                switch(selection) {
                    case 0:
                        if(p.hasPermission("deluxetags.tag.heart")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.heart");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &c&l<3 &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 1:
                        if(p.hasPermission("deluxetags.tag.money")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.money");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &a&l$$$ &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 2:
                        if(p.hasPermission("deluxetags.tag.happy")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.happy");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &a&l:) &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 3:
                        if(p.hasPermission("deluxetags.tag.sad")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.sad");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &7&l:( &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 4:
                        if(p.hasPermission("deluxetags.tag.meh")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.meh");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &6&l:I &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 5:
                        if(p.hasPermission("deluxetags.tag.angry")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.angry");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &4&l>:( &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 6:
                        if(p.hasPermission("deluxetags.tag.king")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.king");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &e&lKING &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 7:
                        if(p.hasPermission("deluxetags.tag.queen")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Vote 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.queen");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &e&lQUEEN &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                }

                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid args."));
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("randomtagt2")) {
            if(args.length == 1) {
                Player p;
                try {
                    p = Bukkit.getPlayer(args[0]);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid player specified."));
                    return true;
                }

                Random random = new Random();
                int selection = random.nextInt(2);
                switch(selection) {
                    case 0:
                        if(p.hasPermission("deluxetags.tag.demonic")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Dream 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.demonic");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &4&lDemonic &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 1:
                        if(p.hasPermission("deluxetags.tag.og")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Dream 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.og");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &5&lOG &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                }

                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid args."));
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("randomtagt3")) {
            if(args.length == 1) {
                Player p;
                try {
                    p = Bukkit.getPlayer(args[0]);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid player specified."));
                    return true;
                }

                Random random = new Random();
                int selection = random.nextInt(2);
                switch(selection) {
                    case 0:
                        if(p.hasPermission("deluxetags.tag.pro")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Galactic 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.pro");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &1&lP&3&lR&b&lO &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 1:
                        if(p.hasPermission("deluxetags.tag.god")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Galactic 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.god");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &e&l&oGOD &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                }

                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid args."));
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("randomtagt4")) {
            if(args.length == 1) {
                Player p;
                try {
                    p = Bukkit.getPlayer(args[0]);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid player specified."));
                    return true;
                }

                Random random = new Random();
                int selection = random.nextInt(2);
                switch(selection) {
                    case 0:
                        if(p.hasPermission("deluxetags.tag.hitman")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Celestial 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.hitman");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &7&lHITMAN &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 1:
                        if(p.hasPermission("deluxetags.tag.warden")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Celestial 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.warden");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &7&lWARDEN &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                }

                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid args."));
            return true;
        }

        if(cmd.getName().equalsIgnoreCase("randomtagt5")) {
            if(args.length == 1) {
                Player p;
                try {
                    p = Bukkit.getPlayer(args[0]);
                } catch (Exception e) {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&5&lHN &8» &7Invalid player specified."));
                    return true;
                }

                Random random = new Random();
                int selection = random.nextInt(3);
                switch(selection) {
                    case 0:
                        if(p.hasPermission("deluxetags.tag.toxic")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Mythic 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.toxic");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &2&lTOXIC &6&lTAG&7&7! Use &9/tags &7to equip."));
                        break;
                    case 1:
                        if(p.hasPermission("deluxetags.tag.soul")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Mythic 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.soul");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &c&lSOUL &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                    case 2:
                        if(p.hasPermission("deluxetags.tag.menace")) {
                            p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You have this tag already, so you've been given another key!"));
                            Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "crate givephys " + p.getName() + " Mythic 1");
                            break;
                        }
                        Bukkit.getServer().dispatchCommand(Bukkit.getServer().getConsoleSender(), "lp user " + p.getName() + " perm set deluxetags.tag.menace");
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lTAGS &8» &7You received the &4&lMENACE &6&lTAG&7! Use &9/tags &7to equip."));
                        break;
                }

                return true;
            }
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&9&lHN &8» &7Invalid args."));
            return true;
        }

        return true;
    }

}
