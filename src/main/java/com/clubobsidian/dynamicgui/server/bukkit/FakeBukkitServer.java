package com.clubobsidian.dynamicgui.server.bukkit;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import com.clubobsidian.dynamicgui.DynamicGUI;
import com.clubobsidian.dynamicgui.entity.player.PlayerWrapper;
import com.clubobsidian.dynamicgui.entity.player.bukkit.BukkitPlayerWrapper;
import com.clubobsidian.dynamicgui.plugin.DynamicGUIPlugin;
import com.clubobsidian.dynamicgui.scheduler.bukkit.BukkitScheduler;
import com.clubobsidian.dynamicgui.server.FakeServer;
import com.clubobsidian.dynamicgui.server.ServerType;

public class FakeBukkitServer extends FakeServer {

	public FakeBukkitServer() 
	{
		super(new BukkitScheduler());
	}

	@Override
	public void broadcastMessage(String message) 
	{
		Bukkit.getServer().broadcastMessage(message);
	}
	
	@Override
	public void dispatchServerCommand(String command)
	{
		Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command);
	}

	@Override
	public PlayerWrapper<?> getPlayer(UUID uuid) 
	{
		return new BukkitPlayerWrapper<Player>(Bukkit.getServer().getPlayer(uuid));
	}

	@SuppressWarnings("deprecation")
	@Override
	public PlayerWrapper<?> getPlayer(String name) 
	{
		return new BukkitPlayerWrapper<Player>(Bukkit.getServer().getPlayer(name));
	}

	@Override
	public Collection<PlayerWrapper<?>> getOnlinePlayers() 
	{
		List<PlayerWrapper<?>> onlinePlayers = new ArrayList<>();
		Bukkit.getServer().getOnlinePlayers().forEach(player -> onlinePlayers.add(new BukkitPlayerWrapper<Player>(player)));
		return onlinePlayers;
	}

	@Override
	public int getGlobalPlayerCount() 
	{
		if(DynamicGUI.get().getRedisBungee() || DynamicGUI.get().getBungeeCord())
		{
			return DynamicGUI.get().getGlobalServerPlayerCount();
		}
		return Bukkit.getServer().getOnlinePlayers().size();
	}

	@Override
	public ServerType getType() 
	{
		return ServerType.SPIGOT;
	}

	@Override
	public void registerOutgoingPluginChannel(DynamicGUIPlugin plugin, String channel) 
	{
		Bukkit.getServer().getMessenger().registerOutgoingPluginChannel((Plugin) plugin, channel);
	}

	@Override
	public void registerIncomingPluginChannel(DynamicGUIPlugin plugin, String channel) 
	{
		// TODO Auto-generated method stub
		
	}
}