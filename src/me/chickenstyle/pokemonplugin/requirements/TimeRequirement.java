package me.chickenstyle.pokemonplugin.requirements;

import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.pokemons.Pokemon;

public class TimeRequirement extends Requirement{

    private int[] timePeriod = new int[2];

    public TimeRequirement(int firstTime,int secondTime) {
        timePeriod[0] = firstTime;
        timePeriod[1] = secondTime;
    }


    @Override
    public boolean hasRequirement(Trainer trainer, Pokemon pokemon) {
        long currentTime = trainer.getBukkitPlayer().getWorld().getTime();
        return timePeriod[0] <= currentTime && timePeriod[1] >= currentTime;

    }
}
