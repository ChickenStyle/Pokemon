package me.chickenstyle.pokemonplugin.utils;

public enum PokemonXPCalculator {

    FAST {
        @Override
        public int calculateXPNeeded(int level) {
            return (int) ((4 * Math.pow(level,3))/5);
        }
    },
    MEDIUMFAST {
        @Override
        public int calculateXPNeeded(int level) {
            return (int) (Math.pow(level,3));
        }
    },
    MEDIUMSLOW {
        @Override
        public int calculateXPNeeded(int level) {
            return (int) ((6/5)*Math.pow(level,3) + 15 * Math.pow(level,2) + 100 * level - 140);
        }
    },
    SLOW {
        @Override
        public int calculateXPNeeded(int level) {
            return (int) ((5*Math.pow(level,3))/4);
        }
    };

    public abstract int calculateXPNeeded(int level);

}
