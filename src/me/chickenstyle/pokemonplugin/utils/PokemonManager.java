package me.chickenstyle.pokemonplugin.utils;

import me.chickenstyle.pokemonplugin.Pixelmon;
import me.chickenstyle.pokemonplugin.pokemons.Pokeball;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;

import java.io.File;
import java.util.Random;

public class PokemonManager {

    private static Random rnd = new Random();

    public static Pokemon getPokemonById(int id,int level) {
        return getPokemonById(id,level, (rnd.nextInt(4098) + 1) == 69);
    }

    public static Pokemon getPokemonById(int id,int level,boolean isShiny) {
        return getPokemonById(id,level,isShiny,Pokeball.POKE_BALL);
    }

    public static Pokemon getPokemonById(int id,int level, boolean isShiny, Pokeball pokeball) {

        id = id < 0 || id > 151 ? 1 : id;

        String strId = "" + id;

        strId = id > 0 && id < 10 ? "00" + id: strId;
        strId = id >= 10 && id < 100 ? "0" + id: strId;
        strId = id >= 100 ? id + "" : strId;

        return new Pokemon(
                new File(Pixelmon.getInstance().getDataFolder().getPath() + "/stats/" + strId +  ".json"),
                isShiny,level,pokeball);


    }

}
