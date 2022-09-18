package me.chickenstyle.pokemonplugin.pokemons.enums;

public enum PokemonStatus {

    NORMAL(1),
    PARALYZED(1.5),
    BURNED(1.5),
    POISONED(1.5),
    SLEEPING(2.5),
    FROZEN(2.5);


    private double catchRateMultiplier;

    PokemonStatus(double catchRateMultiplier) {
        this.catchRateMultiplier = catchRateMultiplier;
    }

}
