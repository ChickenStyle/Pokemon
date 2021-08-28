package me.chickenstyle.pokemonplugin.items;

import me.chickenstyle.pokemonplugin.Trainer;
import org.bukkit.Material;

public class NextPokemonItem extends SpecialItem{

    public NextPokemonItem() {
        super(Material.LEATHER,1,"&7Click to move to the next slot!",null);
    }

    @Override
    public void onLeftClick(Trainer trainer) {

    }

    @Override
    public void onRightClick(Trainer trainer) {
        trainer.nextPokemon();

        trainer.getBukkitPlayer().getInventory().setItem(1,
                trainer.getSelectedPokemon() != null ? new PokemonIconItem(trainer.getSelectedPokemon()).getItem() : new PokemonIconItem().getItem());



    }
}
