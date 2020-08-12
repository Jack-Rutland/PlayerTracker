package com.jackked.playertracker;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerPortalEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.inventory.ItemStack;

public class EventListener implements Listener {

	Player runner;
	Location portal_location;
	
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		if (!(player.equals(runner))) {
			player.getInventory().addItem(new ItemStack(Material.COMPASS , 1));
		}
	}
	
	@EventHandler(priority=EventPriority.HIGH)
	public void onPlayerUse(PlayerInteractEvent event) {
		Player player = event.getPlayer();
		
		if (player.getInventory().getItemInMainHand().getType() == Material.DRAGON_EGG) {
			runner = player;
		}
		
		else if (player.getInventory().getItemInMainHand().getType() == Material.COMPASS) {
			if (player.getLocation().getWorld().equals(runner.getLocation().getWorld())) {
				player.setCompassTarget(runner.getLocation());
			}
			else {
				player.setCompassTarget(portal_location);
			}
		}
	}
	
	@EventHandler
	public void onDimensionChange(PlayerPortalEvent event) {
		Player player = event.getPlayer();
		
		if (player.equals(runner)) {
			portal_location = event.getFrom();
		}
	}
	
}
