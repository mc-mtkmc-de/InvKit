package de.kit.main;



import java.util.HashMap;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;

import de.kit.kit.Kits;


public class Main extends JavaPlugin {
	
	private Inventory inv = null;
	
	HashMap<String, Long> zeit = new HashMap<String, Long>();
	int Cooldown = 0;
	
	public void onDisable() {
		
	
	System.out.println("Plugin gestartet!");
	}
	
	public void onEnable() {
	
		System.out.println("Plugin gestoppt!");
		getServer().getPluginManager().registerEvents(new Kits(), this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	
	
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		Player p = (Player) sender;
		if(cmd.getName().equalsIgnoreCase("invkit")) {
			if(p.hasPermission("invkit.use")) {
				if ( this.zeit.containsKey(p.getName())) {
					long diff = (System.currentTimeMillis() - ((Long)this.zeit.get(p.getName())).longValue()) / 1000L / 60L;
					this.Cooldown = getConfig().getInt("Config.Cooldown");
					if (diff < this.Cooldown) {
						p.sendMessage("§cBitte warte " + (this.Cooldown - diff) + " §cMinute/n um wieder ein Kit zu holen!");
						return true;
					}
				}
			}
			
			inv = p.getPlayer().getServer().createInventory(null, 9*3, "Kits");
			
			
			ItemStack istack = new ItemStack(Material.FIREWORK);
			ItemMeta istackMeta = istack.getItemMeta();
			istackMeta.setDisplayName("§a§lFeuerwerk");
			istack.setItemMeta(istackMeta);
			
			
			ItemStack istack2 = new ItemStack(Material.FIREWORK_CHARGE);
			ItemMeta istackMeta2 = istack2.getItemMeta();
			istackMeta2.setDisplayName("§c§lFeuerwerksstern");
			istack2.setItemMeta(istackMeta2);
			
			ItemStack istack3 = new ItemStack(Material.ELYTRA);
			ItemMeta istackMeta3 = istack3.getItemMeta();
			istackMeta3.setDisplayName("§b§lFlügel");
			istack3.setItemMeta(istackMeta3);
			
			inv.setItem(1, istack);
			inv.setItem(4, istack2);
			inv.setItem(7, istack3);
			
			p.getPlayer().openInventory(inv);
			this.zeit.put(p.getName(), Long.valueOf(System.currentTimeMillis()));
		}
		
		return false;
	}
	
}
