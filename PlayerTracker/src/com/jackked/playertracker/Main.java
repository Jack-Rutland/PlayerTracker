package com.jackked.playertracker;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender,
							 Command command,
							 String label,
							 String[] args) {
		if (command.getName().equalsIgnoreCase("givecompass")) {
			Player player;
			if (args.length > 0) {
				player = getServer().getPlayer(args[0]);
			}
			else {
				player = (Player) sender;
			}
			player.getInventory().addItem(new ItemStack(Material.COMPASS , 1));
		}
		
		return false;
	}
}
