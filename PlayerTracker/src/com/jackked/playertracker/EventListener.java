package com.jackked.playertracker;

import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerRespawnEvent;

public class EventListener implements Listener {

	public void onPlayerRespawn(PlayerRespawnEvent event) {
		Player player = event.getPlayer();
		Main.giveCompassRespawn(player);
	}
}
