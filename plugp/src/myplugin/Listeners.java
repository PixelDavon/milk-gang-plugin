package myplugin;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Listeners implements Listener {
	private Plugin plugin;
	
	public Listeners(Plugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
	public void onDrink(PlayerInteractEvent event) {
	    if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
	        if(event.getPlayer().getInventory().getItemInMainHand().getType() == Material.MILK_BUCKET) {
	            event.setCancelled(true);
	            event.getPlayer().getInventory().setItemInMainHand(new ItemStack(Material.BUCKET));
	            // Add Effects for milk gang hehe bway                   hint   :              seconds * tick, amplifier, hidden particles
	            event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 180 * 20, 6, true));
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 180 * 20, 5, true));
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 30 * 20, 255, true));
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 120 * 20, 255, true));
                event.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.ABSORPTION, 120 * 20, 5, true));
	        }
	    }
	}
	}