package dev.odionwolf.sittablechairs;

import dev.odionwolf.sittablechairs.events.ClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class SittableChairs extends JavaPlugin {

    @Override
    public void onEnable() {
        new ClickListener(this);

    }

    @Override
    public void onDisable() {
    }
}
