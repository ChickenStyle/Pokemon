package me.chickenstyle.pokemonplugin.pokemons;

public enum PokemonNature {

    Adamant(1.1,1,0.9,1,1),
    Bashful(1,1,1,1,1),
    Bold(0.9,1.1,1,1,1),
    Brave(1.1,1,1,1,0.9),
    Calm(0.9,1,1,1.1,1),
    Careful(1,1,0.9,1.1,1),
    Docile(1,1,1,1,1),
    Gentle(1,0.9,1,1.1,1),
    Hardy(1,1,1,1,1),
    Hasty(1,0.9,1,1,1.1),
    Impish(1,1.1,0.9,1,1),
    Jolly(1,1,0.9,1,1.1),
    Lax(1,1.1,1,0.9,1),
    Lonely(1.1,0.9,1,1,1),
    Mild(1,0.9,1.1,1,1),
    Modest(0.9,1,1.1,1,1),
    Naive(1,1,1,0.9,1.1),
    Naughty(1.1,1,1,0.9,1),
    Quiet(1,1,1.1,1,0.9),
    Quirky(1,1,1,1,1),
    Rash(1,1,1.1,1,0.9),
    Relaxed(1,1.1,1,1,0.9),
    Sassy(1,1,1,1.1,0.9),
    Seroius(1,1,1,1,1),
    Timid(0.9,1,1,1,1.1);


    private double attackMultiplier;
    private double defenseMultiplier;
    private double specialAttackMultiplier;
    private double specialDefenseMultiplier;
    private double speedMultiplier;

    PokemonNature(double attackMultiplier, double defenseMultiplier,double specialAttackMultiplier,double specialDefenseMultiplier, double speedMultiplier) {
        this.attackMultiplier = attackMultiplier;
        this.defenseMultiplier = defenseMultiplier;
        this.specialAttackMultiplier = specialAttackMultiplier;
        this.specialDefenseMultiplier = specialDefenseMultiplier;
        this.speedMultiplier = speedMultiplier;
    }

    public double getAttackMultiplier() {
        return attackMultiplier;
    }

    public double getDefenseMultiplier() {
        return defenseMultiplier;
    }

    public double getSpeedMultiplier() {
        return speedMultiplier;
    }

    public double getSpecialAttackMultiplier() {
        return specialAttackMultiplier;
    }

    public double getSpecialDefenseMultiplier() {
        return specialDefenseMultiplier;
    }
}
