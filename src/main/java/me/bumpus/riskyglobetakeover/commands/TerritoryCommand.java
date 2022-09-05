package me.bumpus.riskyglobetakeover.commands;

import me.bumpus.riskyglobetakeover.Continent;
import me.bumpus.riskyglobetakeover.RiskyGlobeTakeover;
import me.bumpus.riskyglobetakeover.Territory;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class TerritoryCommand implements CommandExecutor {

    RiskyGlobeTakeover plugin;
    public TerritoryCommand(RiskyGlobeTakeover plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if(!(sender instanceof Player)){
            plugin.getLogger().warning("Must be a player to execute command!");
            return true;
        }

        Player p = (Player) sender;
        Location location = p.getLocation();

        if(args.length == 4){
            if(args[0].equalsIgnoreCase("add")){
                plugin.getMaps().get(args[1]).getContinents().get(args[2]).addTerritory(new Territory(args[3], location.getBlockX(), location.getBlockY(), location.getBlockZ(), args[1] + "." + args[2]));
                plugin.getLogger().warning("Territory \"" + args[1] + "." + args[2] + "." + args[3] + "\" created!");
            }else if(args[0].equalsIgnoreCase("delete")){
                plugin.getMaps().get(args[1]).getContinents().get(args[2]).removeTerritory(args[3]);
            }
            return true;
        }

        return false;
    }
}
