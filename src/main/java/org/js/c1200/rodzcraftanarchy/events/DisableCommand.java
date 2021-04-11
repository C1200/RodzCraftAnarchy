package org.js.c1200.rodzcraftanarchy.events;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.js.c1200.rodzcraftanarchy.Main;

public class DisableCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player) || sender.isOp()) {
            // Is console or player has op
            FileConfiguration config = Main.getPlugin(Main.class).getConfig(); // Get config from main class
            config.set("enable", false); // Set enable to true
            Main.getPlugin(Main.class).saveConfig(); // Save config

            ((Player) sender).getPlayer().sendRawMessage(
                    ChatColor.RED + "now exiting hell :("
            );
            ((Player) sender).getPlayer().sendTitle(
                    "See you soon!",
                    "Plugin made by the amazing C1200!",
                    5, 100, 5
            );
        } else {
            // No permission
            ((Player) sender).getPlayer().sendRawMessage(
                    ChatColor.RED + "You don't have permission to use this!"
            );
        }

        // Tell minecraft that the command executed correctly
        return true;
    }
}
