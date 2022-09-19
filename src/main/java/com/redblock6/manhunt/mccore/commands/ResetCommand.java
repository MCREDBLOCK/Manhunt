package com.redblock6.manhunt.mccore.commands;

import com.redblock6.manhunt.Main;
import com.redblock6.manhunt.mccore.world.Generator;
import com.redblock6.manhunt.mccore.world.RandomTeleport;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.apache.commons.io.FileUtils;
import org.bukkit.*;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import static com.redblock6.manhunt.Main.translate;

public class ResetCommand implements Listener, CommandExecutor {
    public static ArrayList<Player> noDamage = new ArrayList<>();
    public static ArrayList<Player> hunters = new ArrayList<>();
    public static ArrayList<Player> speedrunners = new ArrayList<>();

    @Override
    public boolean onCommand(CommandSender sender, Command comd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            return true;
        }

        Player p = ((Player) sender).getPlayer();

        if (comd.getName().equalsIgnoreCase("reset")) {
            resetWorld("PRACTICE");

        } else if (comd.getName().equalsIgnoreCase("createloading")) {
            WorldCreator loading = new WorldCreator("loading");

            loading.generator(new Generator());
            Bukkit.createWorld(loading);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 100, 2);
            p.playSound(p.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 2);
            p.sendMessage(translate("&2&l> &fCreated a void loading world!"));
        }
        return false;
    }

    public static void resetWorld(String type){
        for (Player lp : Bukkit.getOnlinePlayers()) {
            lp.setInvisible(true);
            lp.getInventory().clear();
            lp.setHealth(20);
            lp.setFoodLevel(lp.getFoodLevel());
            lp.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000, 255));
            lp.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 100000, 255));
            lp.teleport(new Location(Bukkit.getWorld("loading"), 0, 31, 0));
            lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_DIDGERIDOO, 100, 2);
            lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 2);
            lp.sendMessage(translate("&2&l> &fThe world is being reset!"));
            Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "st stop");
            lp.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2§lLOADING..."));
        }
        // resetWorld(Bukkit.getWorld("world"), WorldType.NORMAL, World.Environment.NORMAL);
        // resetWorld(Bukkit.getWorld("world_nether"), WorldType.NORMAL, World.Environment.NETHER);
        // resetWorld(Bukkit.getWorld("world_the_end"), WorldType.NORMAL, World.Environment.THE_END);

        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mvregen actworld -s");
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mvconfirm");
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    lp.teleport(new Location(Bukkit.getWorld("loading"), 0, 31, 0));
                    lp.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2§lLOADING..."));
                }
            }
        }.runTaskLater(Main.getInstance(), 5);

        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mvregen actworld_nether -s");
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    lp.teleport(new Location(Bukkit.getWorld("loading"), 0, 31, 0));
                    lp.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2§lLOADING..."));
                }
            }
        }.runTaskLater(Main.getInstance(), 10);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mvconfirm");
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    lp.teleport(new Location(Bukkit.getWorld("loading"), 0, 31, 0));
                    lp.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2§lLOADING..."));
                }
            }
        }.runTaskLater(Main.getInstance(), 15);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mvregen actworld_the_end -s");
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    lp.teleport(new Location(Bukkit.getWorld("loading"), 0, 31, 0));
                    lp.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2§lLOADING..."));
                }
            }
        }.runTaskLater(Main.getInstance(), 20);
        new BukkitRunnable() {
            @Override
            public void run() {
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "mvconfirm");
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    lp.teleport(new Location(Bukkit.getWorld("loading"), 0, 31, 0));
                    lp.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText("§2§lLOADING..."));
                }
            }
        }.runTaskLater(Main.getInstance(), 25);

            /*
            Bukkit.unloadWorld("world", false);
            Bukkit.unloadWorld("world_nether", false);
            Bukkit.unloadWorld("world_the_end", false);


            try {
                if (Bukkit.getWorld("world").getWorldFolder() != null) {
                    FileUtils.deleteDirectory(Bukkit.getWorld("world").getWorldFolder());
                } if (Bukkit.getWorld("world_nether").getWorldFolder() != null) {
                    FileUtils.deleteDirectory(Bukkit.getWorld("world_nether").getWorldFolder());
                } if (Bukkit.getWorld("world_nether").getWorldFolder() != null) {
                    FileUtils.deleteDirectory(Bukkit.getWorld("world_the_end").getWorldFolder());
                }

                WorldCreator wc = new WorldCreator("world");
                wc.environment(World.Environment.NORMAL);
                wc.createWorld();

                WorldCreator wc2 = new WorldCreator("world_nether");
                wc2.environment(World.Environment.NETHER);
                wc2.createWorld();

                WorldCreator wc3 = new WorldCreator("world_the_end");
                wc3.environment(World.Environment.THE_END);
                wc3.createWorld();
            } catch (IOException e) {
                e.printStackTrace();
            }

             */

        new BukkitRunnable() {
            @Override
            public void run() {
                RandomTeleport.teleportAllPlayers(Bukkit.getWorld("actworld"));
                for (Player lp : Bukkit.getOnlinePlayers()) {
                    try  {
                        lp.setInvisible(false);
                        for (PotionEffect effect : lp.getActivePotionEffects()) {
                            lp.removePotionEffect(effect.getType());
                        }
                        lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_XYLOPHONE, 100, 2);
                        lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 2);

                        lp.sendMessage(translate("&2&l> &fSuccessfully reset the world!"));
                        lp.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacyText(""));
                        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "st start");
                    } catch (NullPointerException ex) {
                        ex.printStackTrace();
                        lp.playSound(lp.getLocation(), Sound.BLOCK_NOTE_BLOCK_BASS, 100, 1);
                        lp.sendMessage(translate("&4&l> &fError creating a world!"));
                    }
                }
            }
        }.runTaskLater(Main.getInstance(), 120);

        if (type.equals("MANHUNT")) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                Random rand = new Random();
                int job = rand.nextInt(2);
                if (job == 0) {
                    p.sendTitle(translate("&4&lHUNTER"), translate("&fYou are a hunter!"));
                    Bukkit.broadcastMessage(translate("&4&l> &c" + p.getName() + " &fis a hunter!"));
                    p.setDisplayName(translate("&4&lHUNTER &f" + p.getName()));
                    hunters.add(p);
                    Bukkit.dispatchCommand(p, "giveCompass");
                } else if (job == 1) {
                    p.sendTitle(translate("&2&lSPEEDRUNNER"), translate("&fYou are a speedrunner!"));
                    Bukkit.broadcastMessage(translate("&2&l> &a" + p.getName() + " &fis a speedrunner!"));
                    p.setDisplayName(translate("&2&lSPEEDRUNNER &f" + p.getName()));
                    speedrunners.add(p);
                    Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "addSpeedrunners" + p.getName());
                }
            }
        }
    }

    public Player getRandomPlayer()
    {
        List<Player> tempPlayers = (List<Player>) Bukkit.getOnlinePlayers();

        Collections.shuffle( tempPlayers );

        Player RandomPlayer = tempPlayers.get( 0 );

        tempPlayers = null;
        return RandomPlayer;
    }



}
