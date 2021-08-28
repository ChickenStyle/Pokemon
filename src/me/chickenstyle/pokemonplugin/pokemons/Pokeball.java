package me.chickenstyle.pokemonplugin.pokemons;

public enum Pokeball {

    POKE_BALL("d43d4b7ac24a1d650ddf73bd140f49fc12d2736fc14a8dc25c0f3f29d85f8f",1,'\uE000','\uE001'),
    GREAT_BALL("e5d5a12c9c687ec8abfaf787e6fbdc71e875f59c3d6195cba7811bbf94a10",1.5,'\uE002','\uE003'),
    ULTRA_BALL("51f1eacbbe376557f5d7d3ece594db1338f6663662982cfc658c7a7dc639d77",2.0,'\uE004','\uE005'),
    MASTER_BALL("8aa0d944642b8ab69f8b4d66873312e06c0d3ebf8c031ad4b8685f8aadb91d5",169.0,'\uE006','\uE007');

    private String texture;

    private double catchMultiplier;

    private char background;

    private char selectedBackground;

    Pokeball(String texture,double catchMultiplier, char background,char selectedBackground) {
        this.texture = texture;
        this.catchMultiplier = catchMultiplier;
        this.background = background;
        this.selectedBackground = selectedBackground;
    }

    public String getTexture() {
        return texture;
    }

    public double getCatchMultiplier() {
        return catchMultiplier;
    }

    public char getBackground() {
        return background;
    }

    public char getSelectedBackground() {
        return selectedBackground;
    }
}
