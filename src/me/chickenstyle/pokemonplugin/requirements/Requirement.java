package me.chickenstyle.pokemonplugin.requirements;

import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import org.bukkit.entity.Player;

public abstract class Requirement {

    public abstract boolean hasRequirement(Trainer trainer, Pokemon pokemon);

}
