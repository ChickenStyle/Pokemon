package me.chickenstyle.pokemonplugin.pokemons.stats;

import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import me.chickenstyle.pokemonplugin.pokemons.stats.EVStats;

public class PokemonEVYield {

    private final int hp;
    private final int attack;
    private final int defense;
    private final int specialAttack;
    private final int specialDefense;
    private final int speed;


    public PokemonEVYield(int hp, int attack, int defense,int specialAttack,int specialDefense, int speed) {
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
    }

    public void applyEV(Pokemon pokemon) {
        EVStats evStats = pokemon.getEvStats();
        evStats.addEvHp(this.hp);
        evStats.addEvAttack(this.attack);
        evStats.addEvDefense(this.defense);
        evStats.addEvSpecialAttack(specialAttack);
        evStats.addEvSpecialDefense(specialDefense);
        evStats.addEvSpeed(this.speed);
    }
}
