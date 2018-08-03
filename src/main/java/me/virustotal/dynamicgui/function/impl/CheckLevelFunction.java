package me.virustotal.dynamicgui.function.impl;

import me.virustotal.dynamicgui.entity.player.PlayerWrapper;
import me.virustotal.dynamicgui.function.Function;

public class CheckLevelFunction extends Function {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4927665292013293816L;

	public CheckLevelFunction(String name) 
	{
		super(name);
	}

	@Override
	public boolean function(PlayerWrapper<?> player)
	{
		int level = -1;
		try
		{
			level = Integer.parseInt(this.getData());
		}
		catch(NumberFormatException ex)
		{
			ex.printStackTrace();
			return false;
		}
		
		return player.getLevel() >= level;
	}
}