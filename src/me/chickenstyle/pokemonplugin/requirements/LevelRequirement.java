package me.chickenstyle.pokemonplugin.requirements;

import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import org.bukkit.entity.Player;

public class LevelRequirement extends Requirement{

    private final int neededLevel;

    public LevelRequirement(int neededLevel) {
        this.neededLevel = neededLevel;
    }

    @Override
    public boolean hasRequirement(Trainer trainer, Pokemon pokemon) {
        return pokemon.getLevel() >= neededLevel;
    }
}
