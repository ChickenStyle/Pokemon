package me.chickenstyle.pokemonplugin.pokemons.enums;

public enum PokemonGender {

    MALE("&b","Male","♂"),
    FEMALE("&d","Female","♀"),
    GENDERLESS("&7","Genderless","○");

    private String stringName;
    private String unicode;
    private String color;

    PokemonGender(String color,String stringName,String unicode) {
        this.color = color;
        this.stringName = stringName;
        this.unicode = unicode;
    }

    public String getStringName() {
        return stringName;
    }

    public String getUnicode() {
        return unicode;
    }

    public String getColor() {
        return color;
    }
}
