package dev.odionwolf.sittablechairs.events;

import dev.odionwolf.sittablechairs.SittableChairs;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.spigotmc.event.entity.EntityDismountEvent;

import java.util.ArrayList;
import java.util.UUID;

public class ClickListener implements Listener {

    public ArrayList<String> mobID = new ArrayList<>();
    public ClickListener(SittableChairs sittableChairs) {
        Bukkit.getPluginManager().registerEvents(this, sittableChairs);
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        Block block = event.getClickedBlock();
        World world = player.getWorld();
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
                    double x = block.getX() + 0.5;
                    double y = block.getY() - 0.7;
                    double z = block.getZ() + 0.2;
                    Location location = new Location(world, x,y,z);
                    location.setYaw(-180);
                    LivingEntity entity = (LivingEntity) world.spawnEntity(location, EntityType.SHEEP);
                    entity.addPassenger(player);
                    entity.setAI(false);
                    entity.setInvulnerable(true);
                    entity.setInvisible(true);
                    entity.setSilent(true);
                    mobID.add(entity.getUniqueId().toString());
            }
        }
    }

    @EventHandler
    public void onDismount(EntityDismountEvent event) {// Doesn't fire
        Entity en = event.getDismounted();
        if (mobID.contains(en.getUniqueId().toString())) {
            mobID.remove(en.getUniqueId().toString());
            en.remove();
        }
    }
}