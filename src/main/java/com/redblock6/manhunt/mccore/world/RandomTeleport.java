package com.redblock6.manhunt.mccore.world;

import com.redblock6.manhunt.Main;
import jdk.jfr.internal.LogTag;
import jdk.jfr.internal.Logger;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.Console;
import java.util.Random;

import static com.redblock6.manhunt.mccore.commands.ResetCommand.hunters;

public class RandomTeleport {

    public static Location actloc;
    public static int y = 255;

    public static void startCountdown() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            new BukkitRunnable() {
                int i = 60;
                @Override
                public void run() {
                    if (i == 60) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l60"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 30) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l30"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 10) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l10"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 9) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l9"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 8) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l8"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 7) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l7"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 6) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l6"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 5) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l5"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 4) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l4"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 3) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l3"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 2) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l2"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 1) {
                        p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_HAT, 1, 1);
                        p.sendTitle(Main.translate("&4&l1"), Main.translate("&fThe hunter will be released soon."), 20, 40, 20);
                    } else if (i == 0) {
                        p.playSound(p.getLocation(), Sound.ENTITY_ENDER_DRAGON_GROWL, 1, 1);
                        p.sendTitle(Main.translate("&4&lRUN"), Main.translate("&fThe hunter has been released!"), 20, 40, 20);
                        //p.teleport(loc);
                        this.cancel();
                    }
                    System.out.println(i);

                    i--;
                }
            }.runTaskTimer(Main.getInstance(), 20, 20);
            if(!hunters.contains(p)) {
                if (actloc.getBlock().getType() != Material.WATER) {
                    actloc.setY(y + 2);
                    p.teleport(actloc);
                    p.setHealth(20);
                    p.setFoodLevel(20);
                } else {
                    teleportAllPlayers(actloc.getWorld());
                    return;
                }
            }

        }
        for(Player p : hunters){
            p.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100000, 255));
            p.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100000, 255));
            p.teleport(new Location(Bukkit.getWorld("loading"), 0, 31, 0));
            new BukkitRunnable() {
                @Override
                public void run() {
                    p.teleport(actloc);
                    p.setGameMode(GameMode.SURVIVAL);
                    p.getInventory().clear();
                    p.setInvisible(false);
                    for (PotionEffect effect : p.getActivePotionEffects()) {
                        p.removePotionEffect(effect.getType());
                    }
                }
            }.runTaskLater(Main.getInstance(), 1200);
        }
    }


    public static void teleportAllPlayers(World world) {
        WorldBorder wb = world.getWorldBorder();
        wb.setCenter(0, 0);
        wb.setSize(200);
        int i = (int) (world.getWorldBorder().getSize());
        Random rand = new Random();
        // Random number between 0 and world border * 2 for x coordinate
        int i2 = rand.nextInt(i) - ((int) (world.getWorldBorder().getSize()) / 2);
        int x = (int) ((world.getWorldBorder().getCenter().getX()) + i2);
        Random rand2 = new Random();
        // Random number between 0 and world border * 2 for z coordinate
        int i3 = rand2.nextInt(i) - ((int) (world.getWorldBorder().getSize()) / 2);
        int z = (int) ((world.getWorldBorder().getCenter().getZ()) + i3);
        y = 255;
        Location loc = new Location(world, x, y, z);
        Block b = loc.getBlock();

        // Check for highest block that is not air and teleport player to that location
        while (b.getType() == Material.AIR) {
            y--;
            loc.setY(y);
            b = loc.getBlock();
        }
        actloc = loc;
        startCountdown();
        for (Player p : Bukkit.getOnlinePlayers()) {
            if(!hunters.contains(p)) {
                p.teleport(actloc);
            }
        }
        wb.reset();
    }
}
