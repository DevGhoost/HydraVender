package hydra.vender;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

import net.milkbowl.vault.economy.Economy;

public class Main extends JavaPlugin{
	public static Main instance;
	public void onEnable() {
		setupEconomy();
		instance = this;
	}
	
	public static Main getInstance() {
		return instance;
	}
	private static Economy economy;
	private boolean setupEconomy() {
	        RegisteredServiceProvider<Economy> economyProvider = getServer().getServicesManager().getRegistration(Economy.class);
	        if(economyProvider != null) {
	            economy = economyProvider.getProvider();
	        }
	        return (economy != null);
	    }
	public static Economy getEconomy() {
	        return economy;
	    }
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("vender")) {
			Vender.sell((Player)sender);
		}
		return false;
	}
	
}
