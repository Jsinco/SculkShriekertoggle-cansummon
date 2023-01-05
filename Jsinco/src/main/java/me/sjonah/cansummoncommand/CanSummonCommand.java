package me.sjonah.cansummoncommand;

import org.bukkit.plugin.java.JavaPlugin;


public final class CanSummonCommand extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("wardensummon").setExecutor(new CommandClass());
        getLogger().info("CanSummonWardens command enabled");
    }
//add config file

    @Override
    public void onDisable() {
        getLogger().info("CanSummonWardens command disabled");

    }

}