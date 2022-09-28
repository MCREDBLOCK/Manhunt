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

        if (Bukkit.getWorld("actworld") == null) {
            WorldCreator actworld = new WorldCreator("actworld");
            actworld.environment(World.Environment.NORMAL);
            actworld.createWorld();
            WorldCreator actworld_nether = new WorldCreator("actworld_nether");
            actworld_nether.environment(World.Environment.NETHER);
            actworld_nether.createWorld();
            WorldCreator actworld_the_end = new WorldCreator("actworld_the_end");
            actworld_the_end.environment(World.Environment.THE_END);
            actworld_the_end.createWorld();
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
