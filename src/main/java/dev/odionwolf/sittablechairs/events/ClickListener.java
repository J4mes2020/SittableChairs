package dev.odionwolf.sittablechairs.events;

import dev.odionwolf.sittablechairs.SittableChairs;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class ClickListener implements Listener {

    public ClickListener(SittableChairs sittableChairs) {
        Bukkit.getPluginManager().registerEvents(this, sittableChairs);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        if (event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            assert block != null;
            switch (block.getType()) {
                case SANDSTONE_STAIRS:
                case SMOOTH_QUARTZ_STAIRS:
                case SMOOTH_RED_SANDSTONE_STAIRS:
                case SMOOTH_SANDSTONE_STAIRS:
                case SPRUCE_STAIRS:
                case STONE_BRICK_STAIRS:
                case STONE_STAIRS:
                case ACACIA_STAIRS:
                case ANDESITE_STAIRS:
                case BIRCH_STAIRS:
                case BLACKSTONE_STAIRS:
                case BRICK_STAIRS:
                case COBBLESTONE_STAIRS:
                case CRIMSON_STAIRS:
                case DARK_OAK_STAIRS:
                case DARK_PRISMARINE_STAIRS:
                case DIORITE_STAIRS:
                case END_STONE_BRICK_STAIRS:
                case GRANITE_STAIRS:
                case JUNGLE_STAIRS:
                case MOSSY_COBBLESTONE_STAIRS:
                case MOSSY_STONE_BRICK_STAIRS:
                case NETHER_BRICK_STAIRS:
                case OAK_STAIRS:
                case POLISHED_ANDESITE_STAIRS:
                case POLISHED_BLACKSTONE_BRICK_STAIRS:
                case POLISHED_BLACKSTONE_STAIRS:
                case POLISHED_DIORITE_STAIRS:
                case POLISHED_GRANITE_STAIRS:
                case PRISMARINE_BRICK_STAIRS:
                case PRISMARINE_STAIRS:
                case PURPUR_STAIRS:
                case QUARTZ_STAIRS:
                case RED_NETHER_BRICK_STAIRS:
                case RED_SANDSTONE_STAIRS:
                case WARPED_STAIRS:
                    player.sendMessage("You clicked on" + block);
            }
        }
    }
}