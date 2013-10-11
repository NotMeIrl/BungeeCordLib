package de.howaner.BungeeCordLib.listener;

import de.howaner.BungeeCordLib.BungeeCord;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitListener implements Listener {
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		BungeeCord.getManager().receivePlayerIp(event.getPlayer());
		if (BungeeCord.getManager().getServerName() == null || BungeeCord.getManager().getServerName().isEmpty())
			BungeeCord.getManager().receiveServerName();
		BungeeCord.getManager().receiveBungeeServers();
		BungeeCord.getManager().receiveServerPlayers();
	}
	
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent event) {
		BungeeCord.getManager().removePlayerIp(event.getPlayer());
	}
	
}
