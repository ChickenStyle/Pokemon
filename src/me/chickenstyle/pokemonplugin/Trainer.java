package me.chickenstyle.pokemonplugin;

import me.chickenstyle.pokemonplugin.items.NextPokemonItem;
import me.chickenstyle.pokemonplugin.items.PokemonIconItem;
import me.chickenstyle.pokemonplugin.items.PreviousPokemonItem;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;
import me.chickenstyle.pokemonplugin.utils.PokeScoreboard;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.HashSet;
import java.util.Set;

public class Trainer {

    private final Player player;

    private Pokemon[] pokemons;

    private final Set<Integer> pokemonsEncountered;

    private int selectedSlot;

    private final PokeScoreboard scoreboard;

    private ItemStack[] savedItems;

    private boolean inTrainerMode;


    public Trainer(Player player) {
        this(player, 0, new Pokemon[6]);
    }

    public Trainer(Player player, Pokemon... pokemons) {
        this(player, 0, pokemons);
    }

    public Trainer(Player player, int selectedSlot, Pokemon... pokemons) {
        this.player = player;
        this.selectedSlot = selectedSlot;
        this.pokemons = new Pokemon[6];
        this.inTrainerMode = false;
        try {
            for (int i = 0; i < 6; i++) this.pokemons[i] = pokemons[i];
        } catch (Exception ignored) {
        }

        scoreboard = new PokeScoreboard(this);

        this.savedItems = new ItemStack[3];
        this.pokemonsEncountered = new HashSet<>();
    }

    public Pokemon getSelectedPokemon() {
        return pokemons[selectedSlot];
    }

    public Pokemon getPokemonAtSlot(int slot) {
        try {
            return pokemons[slot];
        } catch (IndexOutOfBoundsException ex) {
            return null;
        }
    }

    public void setPokemonAtSlot(int slot, Pokemon pokemon) {
        pokemons[slot % 6] = pokemon;
        updateScoreboard();
    }

    public Pokemon[] getPokemon() {
        return pokemons.clone();
    }

    public void setPokemon(Pokemon... pokemons) {
        try {
            for (int i = 0; i < 6; i++) this.pokemons[i] = pokemons[i];
        } catch (Exception ex) {
        }
        updateScoreboard();
    }

    public void nextPokemon() {
        selectedSlot += selectedSlot == 5 ? -5 : 1;
        updateScoreboard();
    }

    public void previousPokemon() {
        selectedSlot -= selectedSlot == 0 ? -5 : 1;
        updateScoreboard();
    }


    public Player getBukkitPlayer() {
        return player;
    }

    public int getSelectedSlot() {
        return selectedSlot;
    }

    public void closeScoreboard() {
        scoreboard.close();
    }

    public void updateScoreboard() {
        scoreboard.send();
    }

    public ItemStack[] getSavedItems() {
        return savedItems;
    }

    public boolean isInTrainerMode() {
        return inTrainerMode;
    }

    public void changeMode() {

        for (int i = 0; i < 3; i++) {
            if (inTrainerMode) {
                player.getInventory().setItem(i, savedItems[i]);
            } else {
                savedItems[i] = player.getInventory().getItem(i);
                player.getInventory().setItem(i, new ItemStack(Material.AIR));
            }
        }
        if (!inTrainerMode) {

            player.getInventory().setItem(0, new PreviousPokemonItem().getItem());


            player.getInventory().setItem(1, getSelectedPokemon() != null ? new PokemonIconItem(getSelectedPokemon()).getItem() : new PokemonIconItem().getItem());

            player.getInventory().setItem(2, new NextPokemonItem().getItem());

        }
        if (inTrainerMode) {
            savedItems = new ItemStack[3];
        }

        this.inTrainerMode = !this.inTrainerMode;

    }

    public Set<Integer> getPokemonsEncountered() {
        return pokemonsEncountered;
    }

    public void addPokemonEncountered(int id) {
        pokemonsEncountered.add(id < 1 || id > 151 ? 1 : id);
    }

}
