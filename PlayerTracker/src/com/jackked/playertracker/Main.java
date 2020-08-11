package com.jackked.playertracker;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	static ArrayList<Player> hunters = new ArrayList<Player>();

	@Override
	public void onEnable() {
		getServer().getPluginManager().registerEvents(new EventListener(), this);
		hunters.clear();
	}
	
	@Override
	public void onDisable() {
		
	}
	
	@Override
	public boolean onCommand(CommandSender sender,
							 Command command,
							 String label,
							 String[] args) {
		//Gives a player a compass
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
		//Allows you to add and remove players from the hunters list
		else if (command.getName().equalsIgnoreCase("hunter")) {
			Player player = getServer().getPlayer(args[1]);
			if (args[0]=="add") {
				hunters.add(player);
			}
			else if (args[0]=="remove") {
				hunters.remove(player);
			}
			else {
			}
		}
			
		return false;
	}
		
	public static void giveCompassRespawn(Player player) {
		if (hunters.contains(player)) {
			player.getInventory().addItem(new ItemStack(Material.COMPASS , 1));
		}
	}
		
		
}
