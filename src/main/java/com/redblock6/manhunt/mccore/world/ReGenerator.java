package com.redblock6.manhunt.mccore.world;

import org.bukkit.Chunk;
import org.bukkit.World;
import org.bukkit.WorldCreator;

import java.util.Random;

public class ReGenerator {

    public static void regenerateWorld(World world) {
        int chunks = 0;

        for(Chunk chunk : world.getLoadedChunks()){
            world.regenerateChunk(chunk.getX(), chunk.getZ());
            chunks+=1;
        }

        WorldCreator wo = new WorldCreator(world.getName());

        Long see = (new Random()).nextLong();

        wo.seed(see);
        wo.createWorld();
    }
}
