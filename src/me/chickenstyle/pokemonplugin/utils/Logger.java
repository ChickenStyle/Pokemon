package me.chickenstyle.pokemonplugin.utils;

import org.bukkit.Bukkit;

public class Logger {

    private static final String prefix = "&7[&6Pixelmon&7] &7>>> ";

    public static void log(String text) {
        log(LogType.INF0, text);
    }

    public static void log(LogType type, String text) {
        Bukkit.getConsoleSender().sendMessage(Utils.color(type.getPrefix() + prefix + text));
    }

    public static void debug(String text) {
        log(LogType.DEBUG, text);
    }

}