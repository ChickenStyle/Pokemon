package me.chickenstyle.pokemonplugin.requirements;

import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import org.bukkit.entity.Player;

public class HappinessRequirement extends Requirement{

    private int happinessNeeded;

    public HappinessRequirement(int happinessNeeded) {
        this.happinessNeeded = happinessNeeded;
    }


    @Override
    public boolean hasRequirement(Trainer trainer, Pokemon pokemon) {
        return pokemon.getStats().getHappiness() >= happinessNeeded;
    }
}
