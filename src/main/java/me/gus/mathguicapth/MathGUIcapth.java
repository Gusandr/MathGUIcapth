package me.gus.mathguicapth;

import me.gus.mathguicapth.command.OpenMenuCMD;
import me.gus.mathguicapth.events.Event;
import org.bukkit.plugin.java.JavaPlugin;

public final class MathGUIcapth extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("GUI Captcha plugin by Gus!");
        getLogger().info("Version " + getDescription().getVersion());

        getServer().getPluginManager().registerEvents(new Event(), this);
        getCommand("gcap").setExecutor(new OpenMenuCMD());

    }

    @Override
    public void onDisable() {
        // Don't needed. Could delete or unregister commands
    }
}
