package us.hyperiummc.hyperiumprisonextras;

import net.milkbowl.vault.chat.Chat;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import us.hyperiummc.hyperiumprisonextras.events.manager.Schedule;
import us.hyperiummc.hyperiumprisonextras.events.objectives.MineBlocks;
import us.hyperiummc.hyperiumprisonextras.events.standings.CheckStandings;
import us.hyperiummc.hyperiumprisonextras.extras.*;
import us.hyperiummc.hyperiumprisonextras.fixes.*;
import us.hyperiummc.hyperiumprisonextras.leaderboards.BlockTop;
import us.hyperiummc.hyperiumprisonextras.leaderboards.KillTop;
import us.hyperiummc.hyperiumprisonextras.leaderboards.PrestigeTop;
import us.hyperiummc.hyperiumprisonextras.leaderboards.TokenTop;

import java.io.File;

public final class HyperiumPrisonExtras extends JavaPlugin {

    private static HyperiumPrisonExtras instance;

    public static HyperiumPrisonExtras getInstance() {
        return instance;
    }

    public FileConfiguration config;
    public File messages;
    public FileConfiguration messagesConfig;

    public static Chat chat = null;
    private static Economy econ = null;

    public static Economy getEconomy() {
        return econ;
    }

    @Override
    public void onEnable() {
        instance = this;

        if(getServer().getPluginManager().getPlugin("Vault") == null) {
            getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bVault &cnot found. Disabling."));
            getServer().getPluginManager().disablePlugin(this);
        }
        if(getServer().getPluginManager().getPlugin("PlaceholderAPI") == null) {
            getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bPlaceholderAPI &cnot found. Disabling."));
            getServer().getPluginManager().disablePlugin(this);
        }
        if(getServer().getPluginManager().getPlugin("EZBlocks") == null) {
            getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bEZBlocks &cnot found. Disabling."));
            getServer().getPluginManager().disablePlugin(this);
        }

        loadFiles();
        this.getCommand("hpereload").setExecutor(new Reload());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/hpereload &aloaded."));
        this.getCommand("hpetest").setExecutor(new Reload());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/hpetest &aloaded."));

        getServer().getPluginManager().registerEvents(new LockPickaxe(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bPickaxe Lock &aloaded."));
        getServer().getPluginManager().registerEvents(new BlockCertainInventories(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bInventory Blocks &aloaded."));
        getServer().getPluginManager().registerEvents(new BlockCrafting(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bCrafting Blocks &aloaded."));
        getServer().getPluginManager().registerEvents(new FlyState(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bFly Manipulation &aloaded."));
        getServer().getPluginManager().registerEvents(new AutoAutoSell(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bAuto AutoSell &aloaded."));
        getServer().getPluginManager().registerEvents(new AutoChatSpy(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bAuto ChatSpy &aloaded."));
        getServer().getPluginManager().registerEvents(new HideCommands(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bHide Commands &aloaded."));
        getServer().getPluginManager().registerEvents(new DeathMessages(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bDeath Messages &aloaded."));
        getServer().getPluginManager().registerEvents(new RedeemVoucher(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bRedeem Voucher &aloaded."));

        getServer().getPluginManager().registerEvents(new MineBlocks(), this);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bMine Blocks Objective &aloaded."));
        getServer().getScheduler().scheduleSyncRepeatingTask(this, new Schedule(), 0L, 20L);
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bSchedule &aloaded."));

        this.getCommand("event").setExecutor(new CheckStandings());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/event &aloaded."));

        this.getCommand("blocktop").setExecutor(new BlockTop());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/blocktop &aloaded."));
        this.getCommand("tokentop").setExecutor(new TokenTop());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/tokentop &aloaded."));
        this.getCommand("kills").setExecutor(new KillTop());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/kills &aloaded."));
        this.getCommand("killtop").setExecutor(new KillTop());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/killtop &aloaded."));
        this.getCommand("prestigetop").setExecutor(new PrestigeTop());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/prestigetop &aloaded."));

        this.getCommand("randomtagt1").setExecutor(new RandomTag());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/randomtagt1 &aloaded."));
        this.getCommand("randomtagt2").setExecutor(new RandomTag());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/randomtagt2 &aloaded."));
        this.getCommand("randomtagt3").setExecutor(new RandomTag());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/randomtagt3 &aloaded."));
        this.getCommand("randomtagt4").setExecutor(new RandomTag());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/randomtagt4 &aloaded."));
        this.getCommand("randomtagt5").setExecutor(new RandomTag());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/randomtagt5 &aloaded."));
        this.getCommand("keyall").setExecutor(new OptimizedKeyall());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/keyall &aloaded."));
        this.getCommand("alert").setExecutor(new Alerts());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/alert &aloaded."));
        this.getCommand("rename").setExecutor(new Rename());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/rename &aloaded."));
        this.getCommand("hyperiumseasonreset").setExecutor(new ResetSeason());
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &b/hyperiumseasonreset &aloaded."));


        if(Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null)
            new Placeholders().register();
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bPlaceholders &aloaded."));


        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }

        setupChat();
    }

    private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bVault &aloaded."));
        return econ != null;
    }

    private void loadFiles() {
        try {
            // Config
            getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bLoading &fconfig.yml."));
            config = this.getConfig();
            config.options().copyDefaults();
            saveDefaultConfig();
            // Config

            // Messages
            messages = new File(getDataFolder(), "messages.yml");
            if(!(messages.exists())) {
                getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &aCreating &fmessages.yml."));
                saveResource("messages.yml", true);
            }
            else {
                getLogger().info(ChatColor.translateAlternateColorCodes('&', "&9&lHPE&8 -&r &bLoading &fmessages.yml."));
            }
            messagesConfig = YamlConfiguration.loadConfiguration(messages);
            // Messages
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean setupChat() {
        RegisteredServiceProvider<Chat> chatProvider = getServer().getServicesManager().getRegistration(net.milkbowl.vault.chat.Chat.class);
        if (chatProvider != null) {
            chat = chatProvider.getProvider();
        }

        return (chat != null);
    }
}
