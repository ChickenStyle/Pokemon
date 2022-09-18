package me.chickenstyle.pokemonplugin.moves;

import me.chickenstyle.pokemonplugin.pokemons.enums.PokemonType;

public class Move {

    private final PokemonType type;

    private final MoveType moveType;

    private final  int power;

    private final int accuracy;

    private int ppLeft;

    private final int pp;

    private final int priority;

    protected Move(MoveType moveType,PokemonType type,int power,int accuracy,int pp,int priority) {
        this.moveType = moveType;
        this.type = type;
        this.power = power;
        this.accuracy = accuracy;
        this.pp = pp;
        this.ppLeft = pp;
        this.priority = priority;
    }


    protected Move(MoveType moveType,PokemonType type,int power,int accuracy,int pp) {
        this(moveType,type,power,accuracy,pp,0);
    }

    public PokemonType getType() {
        return type;
    }

    public MoveType getMoveType() {
        return moveType;
    }

    public int getPower() {
        return power;
    }

    public int getAccuracy() {
        return accuracy;
    }

    public int getPPLeft() {
        return ppLeft;
    }

    public void setPPLeft(int ppLeft) {
        this.ppLeft = ppLeft;
    }

    public int getPP() {
        return pp;
    }

}
