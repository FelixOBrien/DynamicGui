package com.clubobsidian.dynamicgui.function.impl;

import com.clubobsidian.dynamicgui.DynamicGui2;
import com.clubobsidian.dynamicgui.entity.PlayerWrapper;
import com.clubobsidian.dynamicgui.function.Function;
import com.clubobsidian.dynamicgui.manager.dynamicgui.ReplacerManager;

public class ConsoleCmdFunction extends Function {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4802600274176592465L;

	public ConsoleCmdFunction(String name) 
	{
		super(name);
	}

	@Override
	public boolean function(final PlayerWrapper<?> playerWrapper)
	{
		DynamicGui2.get().getServer().dispatchServerCommand(ReplacerManager.get().replace(this.getData(), playerWrapper));
		return true;
	}
}