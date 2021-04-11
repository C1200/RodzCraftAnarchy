package org.js.c1200.rodzcraftanarchy.events;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.js.c1200.rodzcraftanarchy.Main;

public class PlayerJoin implements Listener {
    @EventHandler
    void onPlayerJoin(PlayerJoinEvent event) {
        FileConfiguration config = Main.getPlugin(Main.class).getConfig(); // Get config from main class

        if (config.getBoolean("enable")) { // If enabled
            Player player = event.getPlayer(); // Get player from event
            event.setJoinMessage( // Set join message to something nice
                    "Welcome to " + ChatColor.RED + "HELL " + ChatColor.RESET + player.getDisplayName() + "!"
            );
            player.setGameMode(GameMode.CREATIVE); // Set player's gamemode to creative

            BossBar boss = Bukkit.createBossBar( // Make fancy bossbar
                    "Welcome to " + ChatColor.STRIKETHROUGH + "RodzCraft" + ChatColor.RESET + " DeadCraft!",
                    BarColor.RED,
                    BarStyle.SOLID
            );
            boss.addPlayer(player); // Show bossbar to player
        }
    }
}
