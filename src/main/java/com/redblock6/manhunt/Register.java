package com.redblock6.manhunt;

import com.redblock6.manhunt.mccore.commands.*;
import com.redblock6.manhunt.mccore.events.JoinLeaveEvent;
import com.redblock6.manhunt.mccore.events.PortalEnterEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

public class Register {
    private static final Main pl = Main.getInstance();

    public static void register() {
        PluginManager pm = Bukkit.getServer().getPluginManager();

        pm.registerEvents(new JoinLeaveEvent(), pl);
        pm.registerEvents(new PortalEnterEvent(), pl);

        pl.getCommand("streaming").setExecutor(new StreamingCommand());
        pl.getCommand("gmc").setExecutor(new Gamemode());
        pl.getCommand("gms").setExecutor(new Gamemode());
        pl.getCommand("gma").setExecutor(new Gamemode());
        pl.getCommand("gmsp").setExecutor(new Gamemode());
        pl.getCommand("warnreboot").setExecutor(new WarnReboot());
        pl.getCommand("reset").setExecutor(new ResetCommand());
        pl.getCommand("createloading").setExecutor(new ResetCommand());
        pl.getCommand("togglegame").setExecutor(new GameModeCommand());
    }
}
