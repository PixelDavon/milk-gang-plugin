package myplugin;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Cow;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.plugin.java.JavaPlugin;

import myplugin.Plugin;

public class Plugin extends JavaPlugin {
    
    @Override
    public void onEnable() {
        this.getServer().getPluginManager().registerEvents(new Listeners(this), this);
    }
    
    public void onDisable() {
    }
    
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (command.getName().equalsIgnoreCase("explode")) {
			Player player = (Player)sender;
			
			TNTPrimed tnt = (TNTPrimed)player.getWorld().spawnEntity(player.getLocation(), EntityType.PRIMED_TNT);
			tnt.setFuseTicks(0);
			return true;
		}
		
		if (command.getName().equalsIgnoreCase("cow")) {
			Player player = (Player)sender;
			Cow cow = (Cow)player.getWorld().spawnEntity(player.getLocation(), EntityType.COW);
			cow.getLocation();
			player.sendMessage("Cow summoned by " + player.getName());
			return true;
		}
		return super.onCommand(sender, command, label, args);
	}
}