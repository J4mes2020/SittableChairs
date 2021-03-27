package dev.odionwolf.sittablechairs;

import dev.odionwolf.sittablechairs.events.ClickListener;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;

public final class SittableChairs extends JavaPlugin {

    private File customConfigDataFile;
    private FileConfiguration customConfigData;
    private ClickListener clickListener;

    @Override
    public void onEnable() {
        clickListener = new ClickListener(this);
        createConfigData();
        clickListener.mobID.addAll(getConfigData().getStringList("List"));
        System.out.println(clickListener.mobID);

    }
    public FileConfiguration getConfigData() {
        return this.customConfigData;
    }


    private void createConfigData() {
        customConfigDataFile = new File(getDataFolder(), "data.yml");
        if (!customConfigDataFile.exists()) {
            customConfigDataFile.getParentFile().mkdirs();
            saveResource("data.yml", false);
        }

        customConfigData = new YamlConfiguration();
        try {
            customConfigData.load(customConfigDataFile);
        } catch (IOException | InvalidConfigurationException e) {
            e.printStackTrace();
        }
    }
    public void saveConfigData() throws IOException {
        customConfigData.save(customConfigDataFile);
    }

    @Override
    public void onDisable() {
            try {
                saveConfigData();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
