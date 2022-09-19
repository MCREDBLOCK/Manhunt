package com.redblock6.manhunt.mccore.events;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPortalEnterEvent;

public class PortalEnterEvent implements Listener {
    @EventHandler
    public void onNetherEnter(EntityPortalEnterEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        Player p = (Player) e.getEntity();

        if (p.getLocation().getWorld().getName().equals("world_nether")) {
            p.getLocation().setWorld(Bukkit.getWorld("actworld_nether"));
        } else if (p.getLocation().getWorld().getName().equals("world_the_end")) {
            p.getLocation().setWorld(Bukkit.getWorld("actworld_the_end"));
        }
    }
}
