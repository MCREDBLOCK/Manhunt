package com.redblock6.manhunt.mccore.events;

import com.redblock6.manhunt.mccore.commands.ResetCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class DeathDamageEvent implements Listener {
    @EventHandler
    public void onDamage(EntityDamageEvent e) {
        if (!(e.getEntity() instanceof Player)) {
            return;
        }
        if (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) {
            e.setCancelled(true);
        }

        if (ResetCommand.noDamage.contains(e.getEntity())) {
            ResetCommand.noDamage.remove(e.getEntity());
            e.setCancelled(true);
        }
    }
}
