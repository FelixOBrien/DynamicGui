package com.clubobsidian.dynamicgui.manager.inventory.sponge;

import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.property.InventoryDimension;
import org.spongepowered.api.item.inventory.property.InventoryTitle;
import org.spongepowered.api.text.Text;

import com.clubobsidian.dynamicgui.DynamicGui2;
import com.clubobsidian.dynamicgui.inventory.InventoryWrapper;
import com.clubobsidian.dynamicgui.inventory.sponge.SpongeInventoryWrapper;
import com.clubobsidian.dynamicgui.manager.inventory.InventoryManager;

public class SpongeInventoryManager extends InventoryManager {

	@Override
	public Object createInventory(int size, String title) 
	{
		return Inventory.builder()
				.property(InventoryTitle.PROPERTY_NAME, InventoryTitle.of(Text.of(title)))
				.property(InventoryDimension.PROPERTY_NAME, new InventoryDimension(9, size / 9))
				.build(DynamicGui2.get().getPlugin());
	}

	@Override
	public InventoryWrapper<?> createInventoryWrapper(Object inventory) 
	{
		return new SpongeInventoryWrapper<Inventory>((Inventory) inventory);
	}
}