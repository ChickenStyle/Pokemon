package me.chickenstyle.pokemonplugin.pokemons;


public enum PokemonType {

    Normal("&f",""),
    Fire("&c","\uD83D\uDD25"),
    Water("&9","\uD83C\uDF0A"),
    Electric("&e","⚡"),
    Grass("&2","\uD83C\uDF31"),
    Ice("&b",""),
    Fighting("&4",""),
    Poison("&5",""),
    Ground("&6",""),
    Flying("&7",""),
    Psychic("&d",""),
    Bug("&a",""),
    Rock("&e",""),
    Ghost("&8",""),
    Dragon("&5","\uD83D\uDC32"),
    Dark("&0",""),
    Steel("&f",""),
    Fairy("&d","");

    static {
        Normal.weaknesses = new PokemonType[] {};
        Normal.strengths = new PokemonType[] {};

        Fire.weaknesses = new PokemonType[] {Fire,Water,Dragon};
        Fire.strengths = new PokemonType[] {Grass};

        Water.weaknesses = new PokemonType[] {Water,Grass,Dragon};
        Water.strengths = new PokemonType[] {Fire};

        Electric.weaknesses = new PokemonType[] {Electric,Grass,Dragon};
        Electric.strengths = new PokemonType[] {Water};

        Grass.weaknesses = new PokemonType[] {Fire,Grass,Dragon};
        Grass.strengths = new PokemonType[] {Water};

        Dragon.weaknesses = new PokemonType[]{};
        Dragon.strengths = new PokemonType[]{Dragon};
    }

    private PokemonType[] weaknesses;
    private PokemonType[] strengths;

    private String color;
    private String icon;

    PokemonType(String color,String icon) {
        this.color = color;
        this.icon = icon;
    }

    public PokemonType[] getWeaknesses() {
        return weaknesses;
    }

    public PokemonType[] getStrengths() {
        return strengths;
    }

    public static boolean isWeakAgainst(PokemonType firstType, PokemonType secondType) {
        for (PokemonType weaknesses: firstType.getWeaknesses()) {
            if (weaknesses.equals(secondType)) return true;
        }
        return false;
    }

    public static boolean isStrengthAgainst(PokemonType firstType, PokemonType secondType) {
        for (PokemonType strengths: firstType.getStrengths()) {
            if (strengths.equals(secondType)) return true;
        }
        return false;
    }

    public String getColor() {
        return color;
    }

    public String getIcon() {
        return icon;
    }


    public String toString(PokemonType type) {
        String name = type.toString().toLowerCase();

        return name.substring(0,1).toUpperCase() + name.substring(1);
    }
}
