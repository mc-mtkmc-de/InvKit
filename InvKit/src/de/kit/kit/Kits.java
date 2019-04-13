package de.kit.kit;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class Kits implements Listener {
	
	
	
	@EventHandler
	public void Inventory(InventoryClickEvent event) {
		Player p = (Player) event.getWhoClicked();
		
		ItemStack zauberfeuerwerk = new ItemStack(Material.FIREWORK, 1);
		zauberfeuerwerk.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 3);
		
		
		
		if(event.getInventory().getName().equalsIgnoreCase("Kits")) {
			event.setCancelled(true);
			
			
			//Feuerwerks Kit
			if(event.getCurrentItem().getType() == Material.FIREWORK){
				p.getInventory().addItem(zauberfeuerwerk);
				p.sendMessage("§aDu hast das §bFeuerwerks Kit §agewählt!");
				
				event.getView().close();
				
			}else if(event.getCurrentItem().getType() == Material.FIREWORK_CHARGE) {
				p.getInventory().addItem(new ItemStack(Material.FIREWORK_CHARGE));
				p.sendMessage("§aDu hast das §bFeuerwerkssternen Kit §agewählt");
				
				event.getView().close();
				
			}else if(event.getCurrentItem().getType() == Material.ELYTRA) {
				p.getInventory().addItem(new ItemStack(Material.ELYTRA));
				p.sendMessage("§aDu hast das §bFlügel Kit §agewählt");
				
				event.getView().close();
				
			}
		
		}
	}
}


