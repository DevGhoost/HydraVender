package hydra.vender;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.scheduler.BukkitScheduler;


public class Vender {

	@SuppressWarnings("deprecation")
	public static void sell(Player p) {
		if (getAmount(p, Material.NETHER_STAR) > 1) {
			BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
			scheduler.scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	            @Override
	            public void run() {
	            	p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.NETHER_STAR, getAmount(p, Material.NETHER_STAR)) });
	            }
	        }, 2L);
			double price = getAmount(p, Material.NETHER_STAR) * 1215;
			Main.getEconomy().depositPlayer(p.getName(), price);
			p.sendMessage("§eVocê vendeu §6" + getAmount(p, Material.NETHER_STAR) + "§e Estrelas do Nether por §6" + price + "§e coins.");
			
		}
		if (getAmount(p, Material.EYE_OF_ENDER) > 1) {
			BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
			scheduler.scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	            @Override
	            public void run() {
	            	p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.EYE_OF_ENDER, getAmount(p, Material.EYE_OF_ENDER)) });
	            }
	        }, 2L);
			double price = getAmount(p, Material.EYE_OF_ENDER) * 870;
			Main.getEconomy().depositPlayer(p.getName(), price);
			p.sendMessage("§eVocê vendeu §6" + getAmount(p, Material.EYE_OF_ENDER) + "§e Olhos do Fim por §6" + price + "§e coins.");
			
			
		}
		if (getAmount(p, Material.SULPHUR) > 1) {
			BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
			scheduler.scheduleSyncDelayedTask(Main.getInstance(), new Runnable() {
	            @Override
	            public void run() {
	            	p.getInventory().removeItem(new ItemStack[] { new ItemStack(Material.SULPHUR, getAmount(p, Material.SULPHUR)) });
	            }
	        }, 2L);
			double price = getAmount(p, Material.SULPHUR) * 607;
			Main.getEconomy().depositPlayer(p.getName(), price);
			p.sendMessage("§eVocê vendeu §6" + getAmount(p, Material.SULPHUR) + "§e Polvóras por §6" + price + "§e coins.");
		}
	}
	
	public static int getAmount(Player p, Material m) {
        int amount = 0;
        for (ItemStack item : p.getInventory().getContents()) {
         if ((item != null) && (item.getType() == m) && (item.getAmount() > 0)) {
          amount += item.getAmount();
         }
        }
        return amount;
    }
	

}
