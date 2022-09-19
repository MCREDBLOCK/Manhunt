package com.redblock6.manhunt.mccore.events;

import com.redblock6.manhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import static com.redblock6.manhunt.Main.streaming;

public class JoinLeaveEvent implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        if (streaming) {
            if (!Bukkit.getWhitelistedPlayers().contains(p)) {
                p.setGameMode(GameMode.SPECTATOR);
                p.sendTitle(Main.translate("&2&lSPECTATING"), Main.translate("&fYou are a spectator!"), 10, 20, 10);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 100, 2);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 2);
                e.setJoinMessage(Main.translate("&2&l> &a" + p.getDisplayName() + " &fis now spectating."));
            } else {
                p.sendTitle(Main.translate("&2&lSOMEONE IS STREAMING"), Main.translate("&fStreamer mode is enabled."), 10, 20, 10);
                p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 2);
            }
        } else {
            if (!Bukkit.getWhitelistedPlayers().contains(p)) {
                p.kickPlayer("You are not whitelisted on this server!");
            }
        }
    }
}
