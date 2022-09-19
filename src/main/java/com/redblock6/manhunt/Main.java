package com.redblock6.manhunt;

import com.redblock6.manhunt.mccore.world.Generator;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    private static Main instance;
    public static boolean streaming;
    public static boolean manhunt;

    @Override
    public void onEnable() {
        instance = this;

        streaming = false;
        manhunt = false;

        Register.register();

        if (Bukkit.getWorld("loading") == null) {
            WorldCreator loading = new WorldCreator("loading");

            loading.generator(new Generator());
            loading.createWorld();
        }
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance() {
        return instance;
    }

    public static String translate(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
}
