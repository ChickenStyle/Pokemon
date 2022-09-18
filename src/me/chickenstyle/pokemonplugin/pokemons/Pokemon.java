package me.chickenstyle.pokemonplugin.pokemons;

import me.chickenstyle.pokemonplugin.pokemons.enums.Pokeball;
import me.chickenstyle.pokemonplugin.pokemons.enums.PokemonType;
import me.chickenstyle.pokemonplugin.pokemons.stats.*;
import me.chickenstyle.pokemonplugin.utils.PokemonXPCalculator;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import me.chickenstyle.pokemonplugin.moves.Move;
import me.chickenstyle.pokemonplugin.utils.Utils;
import org.bukkit.Location;
import org.json.simple.JSONObject;


import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Pokemon {

    private static JSONParser parser = new JSONParser();

    private int id;

    private final String pokemonType;

    private final char icon;

    private final boolean isShiny;

    private PokemonStats statistics;

    private final BaseStats baseStats;

    protected Move[] moves;

    private HashMap<Integer,Move[]> unlockableMoves;

    private final PokemonEVYield evYield;

    private final EVStats evStats;

    private final IVStats ivStats;

    private final PokemonType[] types;

    protected final Pokeball pokeball;


    public Pokemon(File file, boolean isShiny,int level,Pokeball pokeball) {
        JSONObject json = null;
        try {
            if (file.exists()) {
                Object obj = parser.parse(new FileReader(file));

                json = (JSONObject) obj;

            }
        } catch (Exception sus) { }


        this.id = Integer.valueOf(file.getName().substring(0,3));

        this.pokemonType = (String) json.get("pokemon");
        this.isShiny = isShiny;
        this.icon = isShiny? (char)('\uE0FB' + id): (char) ('\uE064' + id);
        this.baseStats = Utils.getBaseStatsFromJson(json);

        moves = new Move[4];

        JSONObject yield = (JSONObject) json.get("evYields");
        this.evYield = new PokemonEVYield(
                yield.get("HP") != null ? ((Long)  yield.get("HP")).intValue() : 0,
                yield.get("Attack") != null ? ((Long)  yield.get("Attack")).intValue() : 0,
                yield.get("Defence") != null ? ((Long)  yield.get("Defence")).intValue() : 0,
                yield.get("SpecialAttack") != null ? ((Long)  yield.get("SpecialAttack")).intValue() : 0,
                yield.get("SpecialDefence") != null ? ((Long)  yield.get("SpecialDefence")).intValue() : 0,
                yield.get("Speed") != null ? ((Long)  yield.get("Speed")).intValue() : 0
        );

        this.evStats = new EVStats();
        this.ivStats = new IVStats();

        JSONArray array = (JSONArray) json.get("types");

        PokemonType[] types = new PokemonType[array.size()];

        for (int i = 0; i < types.length;i++) { types[i] = PokemonType.valueOf((String) array.get(i)); }
        this.types = types;

        this.pokeball = pokeball;

        statistics = new PokemonStats(level,0,0,69420,0,0,0,0,0,
                new int[]{((Long) json.get("spawnLevel")).intValue(),((Long)  json.get("spawnLevel")).intValue() + ((Long)  json.get("spawnLevelRange")).intValue()},
                ((Long)  json.get("catchRate")).intValue(),
                ((Long)  json.get("malePercent")).intValue(),
                PokemonXPCalculator.valueOf(((String) json.get("experienceGroup")).toUpperCase())
        );

        statistics = Utils.calculateStats(this);


    }





    public String getPokemonType() {return pokemonType;}

    public PokemonStats getStats() {
        return statistics;
    }

    public PokemonType[] getTypes() {
        return types.clone();
    }

    public void spawn(Location loc) {

    }

    public BaseStats getBaseStats() {
        return baseStats;
    }

    public HashMap<Integer,Move[]> getUnlockableMoves() {
        return (HashMap<Integer, Move[]>) unlockableMoves.clone();
    }

    public boolean canLevelUp() {
        return statistics.getXp() >= statistics.getXpNeeded();
    }

    public void levelUp() {
        if (getStats().getLevel() <= 100) {
            getStats().setLevel(getStats().getLevel() + 1);
            statistics = Utils.calculateStats(this);
        }
    }

    public int getLevel() {
        return statistics.getLevel();
    }

    public Move[] getMoves() {
        return moves.clone();
    }

    public PokemonEVYield getEvYield() { return evYield; }

    public EVStats getEvStats() { return evStats; }

    public IVStats getIvStats() { return ivStats; }

    public char getIcon() { return icon; }

    public Pokeball getPokeball() { return pokeball; }

    public int getID() {
        return id;
    }


    public boolean isShiny() {
        return isShiny;
    }
}
