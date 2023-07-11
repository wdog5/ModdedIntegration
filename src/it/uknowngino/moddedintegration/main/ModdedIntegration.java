package it.uknowngino.moddedintegration.main;

import com.earth2me.essentials.Essentials;
import it.uknowngino.moddedintegration.commands.ModdedIntegrationCommand;
import it.uknowngino.moddedintegration.config.Config;
import it.uknowngino.moddedintegration.enums.ServerVersion;
import it.uknowngino.moddedintegration.utils.IntegrationUtils;
import it.uknowngino.moddedintegration.utils.LogUtils;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Level;

public class ModdedIntegration extends JavaPlugin {

	public static final ServerVersion SERVER_VERSION = ServerVersion.getCurrentServerVersion();

	private static ModdedIntegration plugin;
	private static Essentials essentials;

	public void onEnable() {
		
		plugin = this;
		essentials = (Essentials) Bukkit.getPluginManager().getPlugin("Essentials");
		Config.reload();
		IntegrationUtils.populateItemsFile();
		getCommand("moddedintegration").setExecutor(new ModdedIntegrationCommand());
		LogUtils.log(Level.INFO, "The plugin has been enabled successfully with Implementation " + SERVER_VERSION + ".");
	}
	
	public void onDisable() {

		LogUtils.log(Level.INFO, "The plugin has been disabled.");
		
	}

	public static ModdedIntegration getInstance() {
		
		return plugin;
		
	}

	public static Essentials getEssentials() {

		return essentials;

	}

}
