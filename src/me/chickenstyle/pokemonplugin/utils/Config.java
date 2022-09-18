package me.chickenstyle.pokemonplugin.utils;

import me.chickenstyle.pokemonplugin.PixelmonCore;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Config {

    private File file;
    private FileConfiguration config;

    public Config(String configName, boolean replace) {
        PixelmonCore.getInstance().saveResource(configName, replace);
        this.file = new File(PixelmonCore.getInstance().getDataFolder()+ "/" + configName);
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }

    public Config(String configName) {
        this(configName, false);
    }

    public void set(String path, Object data) {
        this.config.set(path, data);
    }

    public Object get(String path) {
        return config.get(path);
    }

    public String getString(String path) {
        return (String) get(path);
    }

    public int getInt(String path) {
        return (int) get(path);
    }

    public List<String> getStringList(String path) {
        return (List<String>) get(path);
    }

    public FileConfiguration getConfig() {
        return config;
    }

    public void save() {
        try {
            this.config.save(this.file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void reload() {
        this.config = YamlConfiguration.loadConfiguration(this.file);
    }
}