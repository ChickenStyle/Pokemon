package me.chickenstyle.pokemonplugin.requirements;

import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import org.bukkit.block.Biome;
import org.bukkit.entity.Player;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

public class BiomeRequirement extends Requirement{

    private Biome biomeNeeded;

    public BiomeRequirement(Biome biomeNeeded) {
        this.biomeNeeded = biomeNeeded;
    }

    @Override
    public boolean hasRequirement(Trainer trainer, Pokemon pokemon) {
        return trainer.getBukkitPlayer().getLocation().getBlock().getBiome() == biomeNeeded;
    }

}
