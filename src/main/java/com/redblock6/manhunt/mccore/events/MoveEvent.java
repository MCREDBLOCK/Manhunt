package com.redblock6.manhunt.mccore.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class MoveEvent implements Listener {

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        if (e.getPlayer().getWorld().getName().equals("loading")) {
            e.setCancelled(true);
        }
    }
}
