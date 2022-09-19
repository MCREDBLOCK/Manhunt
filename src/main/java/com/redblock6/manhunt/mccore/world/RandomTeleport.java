package com.redblock6.manhunt.mccore.world;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class RandomTeleport {

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
        int y = 255;
        Location loc = new Location(world, x, y, z);
        Block b = loc.getBlock();
        // Check for highest block that is not air and teleport player to that location
        while (b.getType() == Material.AIR) {
            y--;
            loc.setY(y);
            b = loc.getBlock();
        }
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (b.getType() != Material.WATER) {
                loc.setY(y + 2);
                p.teleport(loc);
            } else {
                loc.setY(y + 1);
                loc.setY(y + 3);
                p.teleport(loc);
            }
        }
        wb.reset();
    }
}
