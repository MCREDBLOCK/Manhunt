package com.redblock6.manhunt.mccore.world;

import org.bukkit.World;
import org.bukkit.generator.ChunkGenerator;

import javax.annotation.Nonnull;
import java.util.Random;

public class Generator extends ChunkGenerator {

    @Override
    @Nonnull
    public ChunkGenerator.ChunkData generateChunkData(@Nonnull World world, @Nonnull Random random, int x, int z, @Nonnull BiomeGrid biome) {
        return createChunkData(world);
    }

}
