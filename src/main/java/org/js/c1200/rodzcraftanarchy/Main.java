package org.js.c1200.rodzcraftanarchy;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.js.c1200.rodzcraftanarchy.events.DisableCommand;
import org.js.c1200.rodzcraftanarchy.events.EnableCommand;
import org.js.c1200.rodzcraftanarchy.events.PlayerJoin;

public final class Main extends JavaPlugin {
    FileConfiguration config = this.getConfig(); // Get configuration

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("Welcome to RodzCraft Anarchy!"); // Say hello to the console user

        config.addDefault("enable", false); // Disable by default
        config.options().copyDefaults(true); // Copy defaults (IDK what this does)
        saveConfig(); // Save the config

        getServer().getPluginManager().registerEvents(new PlayerJoin(), this); // Register player join event
        this.getCommand("enable").setExecutor(new EnableCommand()); // Reg enable command
        this.getCommand("disable").setExecutor(new DisableCommand()); // Reg disable command
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("DeadCraft is now officially dead."); // Say goodbye to console user
    }
}
