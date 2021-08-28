package me.chickenstyle.pokemonplugin.pokemons;

import me.chickenstyle.pokemonplugin.Trainer;
import me.chickenstyle.pokemonplugin.requirements.Requirement;

public interface IEvolvable {

    Evolution[] getEvolutions();


    class Evolution {

        private Pokemon evolution;

        private Requirement[] requirements;

        public Evolution(Pokemon evolution,Requirement... requirements) {
            this.evolution = evolution;
            this.requirements = requirements;
        }

        public Pokemon getEvolution() { return evolution; }

        public Requirement[] getRequirements() { return requirements; }

        public boolean canEvolve(Trainer trainer,Pokemon pokemon) {
            for (Requirement requirement:requirements) {
                if (!requirement.hasRequirement(trainer,pokemon)) return false;
            }
            return true;
        }
    }
}

