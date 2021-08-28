package me.chickenstyle.pokemonplugin.items;

import me.chickenstyle.pokemonplugin.Trainer;
import org.bukkit.Material;

public class PreviousPokemonItem extends SpecialItem{


    public PreviousPokemonItem() {
        super(Material.LEATHER,2,"&7Click to move to the previous slot!",null);
    }

    @Override
    public void onLeftClick(Trainer trainer) {

    }

    @Override
    public void onRightClick(Trainer trainer) {
        trainer.previousPokemon();
        trainer.getBukkitPlayer().getInventory().setItem(1,
                trainer.getSelectedPokemon() != null ? new PokemonIconItem(trainer.getSelectedPokemon()).getItem() : new PokemonIconItem().getItem());
    }
}
