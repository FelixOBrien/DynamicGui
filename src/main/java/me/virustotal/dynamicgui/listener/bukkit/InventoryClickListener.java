package me.virustotal.dynamicgui.listener.bukkit;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import com.clubobsidian.trident.EventHandler;
import com.clubobsidian.trident.Listener;

import me.virustotal.dynamicgui.DynamicGUI;
import me.virustotal.dynamicgui.entity.player.PlayerWrapper;
import me.virustotal.dynamicgui.entity.player.bukkit.BukkitPlayerWrapper;
import me.virustotal.dynamicgui.event.inventory.Click;
import me.virustotal.dynamicgui.inventory.InventoryWrapper;
import me.virustotal.dynamicgui.inventory.bukkit.BukkitInventoryWrapper;

public class InventoryClickListener implements Listener {

	@EventHandler
	public void onInventoryClick(InventoryClickEvent e)
	{
		if(e.getWhoClicked() instanceof Player)
		{
			if(e.getClick() == ClickType.LEFT || e.getClick() == ClickType.RIGHT || e.getClick() == ClickType.MIDDLE)
			{
				Player player = (Player) e.getWhoClicked();
				InventoryWrapper<?> inventoryWrapper = new BukkitInventoryWrapper<Inventory>(e.getInventory());
				int slot = e.getSlot();
				PlayerWrapper<?> playerWrapper = new BukkitPlayerWrapper<Player>(player);
				Click clickType = Click.valueOf(e.getClick().toString());
				me.virustotal.dynamicgui.event.inventory.InventoryClickEvent clickEvent = new me.virustotal.dynamicgui.event.inventory.InventoryClickEvent(playerWrapper, inventoryWrapper, slot, clickType);
				DynamicGUI.getInstance().getEventManager().callEvent(clickEvent);
				if(clickEvent.isCancelled())
				{
					e.setCancelled(true);
				}
			}
		}
	}	
}