package me.chickenstyle.pokemonplugin.utils;

public enum LogType {
    INF0("&7[&fInfo&7] "),
    DEBUG("&7[&3Debug&7] "),
    WARNING("&7[&cWarning&7] "),
    ISSUE("&7[&4Issue&7] ");

    private String prefix;

    LogType(String prefix) {
        this.prefix = prefix;
    }

    public String getPrefix() {
        return prefix;
    }
}
