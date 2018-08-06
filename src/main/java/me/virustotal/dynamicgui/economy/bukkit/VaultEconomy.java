package me.virustotal.dynamicgui.economy.bukkit;

import java.math.BigDecimal;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;

import me.virustotal.dynamicgui.economy.Economy;
import me.virustotal.dynamicgui.entity.player.PlayerWrapper;

public class VaultEconomy implements Economy {

	private Object economy;
	
	@Override
	public boolean setup() 
	{
		Plugin vault = Bukkit.getServer().getPluginManager().getPlugin("Vault");
		if(vault == null)
		{
			return false;
		}
		
		Class<?> economyClass = null;
		try 
		{
			economyClass = Class.forName("net.milkbowl.vault.economy.Economy");
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
			return false;
		}
		
		if(economyClass == null)
		{
			return false;
		}
		
		this.economy = Bukkit.getServer().getServicesManager().getRegistration(economyClass).getProvider();
		return economy != null;
	}

	@Override
	public BigDecimal getBalance(PlayerWrapper<?> playerWrapper) 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean withdraw(PlayerWrapper<?> playerWrapper, BigDecimal amt) 
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deposit(PlayerWrapper<?> playerWrapper, BigDecimal amt) 
	{
		// TODO Auto-generated method stub
		return false;
	}




}