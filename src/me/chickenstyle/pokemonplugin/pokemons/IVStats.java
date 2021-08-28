package me.chickenstyle.pokemonplugin.pokemons;

import java.util.Random;

public class IVStats {

    private static Random rnd = new Random();

    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public IVStats() {
        hp = rnd.nextInt(32);
        attack = rnd.nextInt(32);
        defense = rnd.nextInt(32);
        specialAttack = rnd.nextInt(32);
        specialDefense = rnd.nextInt(32);
        speed = rnd.nextInt(32);
    }

    public int getIvHp() {
        return hp;
    }

    public int getIvAttack() {
        return attack;
    }

    public int getIvDefense() {
        return defense;
    }

    public int getIvSpeed() {
        return speed;
    }

    public int getIvSpecialAttack() {return specialAttack;}

    public int getIvSpecialDefense() {return specialDefense;}
}
