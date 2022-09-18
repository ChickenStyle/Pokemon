package me.chickenstyle.pokemonplugin.utils;

import me.chickenstyle.pokemonplugin.pokemons.*;
import me.chickenstyle.pokemonplugin.pokemons.enums.PokemonNature;
import me.chickenstyle.pokemonplugin.pokemons.stats.BaseStats;
import me.chickenstyle.pokemonplugin.pokemons.stats.EVStats;
import me.chickenstyle.pokemonplugin.pokemons.stats.IVStats;
import me.chickenstyle.pokemonplugin.pokemons.stats.PokemonStats;
import org.bukkit.ChatColor;
import org.json.simple.JSONObject;

public class Utils {

    public static PokemonStats calculateStats(Pokemon pokemon) {

        BaseStats base = pokemon.getBaseStats();
        PokemonStats stats = pokemon.getStats();
        PokemonNature nature = pokemon.getStats().getNature();
        EVStats ev = pokemon.getEvStats();
        IVStats iv = pokemon.getIvStats();


        int hp = (int) (Math.floor(0.01 * (2 * base.getHp() + iv.getIvHp() + Math.floor(0.25 * ev.getEvHp())) * pokemon.getLevel()) + pokemon.getLevel() + 10);

        int attack = (int) ((Math.floor(0.01 * (2 * base.getAttack() + iv.getIvAttack() + Math.floor(0.25 * ev.getEvAttack())) * pokemon.getLevel()) + 5) * nature.getAttackMultiplier());

        int defense = (int) ((Math.floor(0.01 * (2 * base.getDefense() + iv.getIvDefense() + Math.floor(0.25 * ev.getEvDefense())) * pokemon.getLevel()) + 5) * nature.getDefenseMultiplier());

        int specialAttack = (int) ((Math.floor(0.01 * (2 * base.getSpecialAttack() + iv.getIvSpecialAttack() + Math.floor(0.25 * ev.getEvSpecialAttack())) * pokemon.getLevel()) + 5) * nature.getSpecialAttackMultiplier());

        int specialDefense = (int) ((Math.floor(0.01 * (2 * base.getSpecialDefense() + iv.getIvSpecialDefense() + Math.floor(0.25 * ev.getEvSpecialDefense())) * pokemon.getLevel()) + 5) * nature.getSpecialDefenseMultiplier());

        int speed = (int) ((Math.floor(0.01 * (2 * base.getSpeed() + iv.getIvSpeed() + Math.floor(0.25 * ev.getEvSpeed())) * pokemon.getLevel()) + 5) * nature.getSpeedMultiplier());

        return new PokemonStats(pokemon.getLevel(),stats.getXp(),hp,(stats.getCurrentHp() > hp) ? hp : stats.getCurrentHp()
                ,attack,defense,specialAttack,specialDefense,speed,stats.getWildLevelRange()
                ,stats.getCatchRate(),stats.getGenderRation(),stats.getXpCalculator()
                ,stats.getNature(),stats.getGender());
    }

    public static BaseStats getBaseStatsFromJson(JSONObject json) {
        JSONObject stats = (JSONObject) json.get("stats");

        return new BaseStats(
                ((Long) stats.get("HP")).intValue(),
                ((Long)  stats.get("Attack")).intValue(),
                ((Long)  stats.get("Defence")).intValue(),
                ((Long)  stats.get("SpecialAttack")).intValue(),
                ((Long)  stats.get("SpecialDefence")).intValue(),
                ((Long)  stats.get("Speed")).intValue());

    }

    public static String color(String text) {
        return ChatColor.translateAlternateColorCodes('&',text);
    }
}
