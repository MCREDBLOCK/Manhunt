package com.redblock6.manhunt.mccore.commands;

import com.redblock6.manhunt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GameModeCommand implements Listener, CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command comd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = ((Player) sender).getPlayer();

        if (comd.getName().equalsIgnoreCase("togglegame")) {
            if (Main.manhunt) {
                Main.manhunt = false;
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 100, 2);
                    lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 2);
                    lp.sendMessage(Main.translate("&2&l> &fThis server is now hosting &aPractice"));
                    lp.sendTitle(Main.translate("&2&lPRACTICE"), Main.translate("&fThis server is now hosting &aPractice"));
                }
                ResetCommand.resetWorld("PRACTICE");
            } else {
                Main.manhunt = true;
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 100, 2);
                    lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 2);
                    lp.sendMessage(Main.translate("&2&l> &fThis server is now hosting &aManhunt"));
                    lp.sendTitle(Main.translate("&2&lMANHUNT"), Main.translate("&fThis server is now hosting &aManhunt"));
                }
                ResetCommand.resetWorld("MANHUNT");
            }
        } else if (comd.getName().equalsIgnoreCase("reasignteams")) {
            ResetCommand.resetWorld("MANHUNT");
        }
        return false;
    }
}
