package com.redblock6.manhunt.mccore.events;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

public class SpawnEvent implements Listener {

    @EventHandler
    public void onSpawn(EntitySpawnEvent e) {
        Entity entity = e.getEntity();
        Location loc = e.getLocation();
        if(entity instanceof Player) {
            Player p = (Player) entity;
            while(loc.getBlock().getType().equals(Material.AIR)) {
                loc.add(0, -1, 0);
                p.setHealth(20);
                p.setFoodLevel(20);
                p.teleport(loc);
            }
        }
    }
}
