package me.chickenstyle.pokemonplugin.pokemons;


import me.chickenstyle.pokemonplugin.utils.PokemonXPCalculator;
import org.bukkit.WeatherType;
import org.bukkit.block.Biome;

import java.util.Random;

public class PokemonStats{

    private static Random rnd = new Random();

    private int level;
    private int xp;
    private int xpNeeded;
    private int maxHp;
    private int currentHp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private int happiness;

    private final PokemonXPCalculator xpCalculator;

    private final PokemonNature nature;

    private PokemonGender gender;

    private boolean traded;

    private final int[] wildLevelRange;

    private final int catchRate;

    private final int genderRation;


    public PokemonStats(int level, int xp, int maxHp,int currentHp, int attack, int defense,int specialAttack,int specialDefense, int speed
            ,int wildLevelRange[], int catchRate,int genderRation,PokemonXPCalculator xpCalculator) {
        this(level,xp,maxHp,currentHp,attack,defense,specialAttack,specialDefense,speed,wildLevelRange,catchRate,genderRation,xpCalculator,
                PokemonNature.values()[rnd.nextInt(PokemonNature.values().length)],
                rnd.nextInt(100) < genderRation ? PokemonGender.MALE : PokemonGender.FEMALE);

        if (genderRation == -1) {this.gender = PokemonGender.GENDERLESS;}
    }





    public PokemonStats(int level, int xp, int maxHp,int currentHp, int attack, int defense,int specialAttack,int specialDefense, int speed
            ,int wildLevelRange[], int catchRate,int genderRation,PokemonXPCalculator xpCalculator, PokemonNature nature,PokemonGender gender) {
        this.level = level;
        this.xp = xp;
        this.xpCalculator = xpCalculator;
        this.xpNeeded = xpCalculator.calculateXPNeeded(level);
        this.maxHp = maxHp;
        this.currentHp = currentHp;
        this.attack = attack;
        this.defense = defense;
        this.specialAttack = specialAttack;
        this.specialDefense = specialDefense;
        this.speed = speed;
        this.nature = nature;
        happiness = 70;
        this.gender = gender;
        this.traded = false;
        this.wildLevelRange = wildLevelRange;
        this.catchRate = catchRate;
        this.genderRation = genderRation;


    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getXpNeeded() {
        return xpNeeded;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public PokemonNature getNature() {
        return nature;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public void setXpNeeded(int xpNeeded) {
        this.xpNeeded = xpNeeded;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        this.happiness = happiness;
    }

    public PokemonGender getGender() {
        return gender;
    }

    public boolean isTraded() {
        return traded;
    }

    public void setTraded(boolean traded) {
        this.traded = traded;
    }

    public int[] getWildLevelRange() {
        return wildLevelRange;
    }

    public int getCatchRate() {
        return catchRate;
    }

    public int getCurrentHp() { return currentHp; }

    public void setCurrentHp(int currentHp) { this.currentHp = currentHp; }

    public int getGenderRation() { return genderRation; }

    public PokemonXPCalculator getXpCalculator() { return xpCalculator; }

    public int getSpecialAttack() {
        return specialAttack;
    }

    public int getSpecialDefense() {
        return specialDefense;
    }

    public enum TimePeriod {
        DAWN(new Period(22500,24000),new Period(0,300)),
        MORNING(new Period(22500,24000),new Period(0,6000)),
        DAY(new Period(0,12000)),
        MIDDAY(new Period(5500,6500)),
        AFTERNOON(new Period(6000,12000)),
        DUSK(new Period(12000,13800)),
        NIGHT(new Period(13450,22550)),
        MIDNIGHT(new Period(17500,18500));

        private Period[] timePeriods;

        TimePeriod(Period... timePeriods) {
            this.timePeriods = timePeriods;

        }

        public boolean isInPeriod(long time) {
            for (Period period:timePeriods) {
                if (period.isInPeriod(time)) return true;
            }
            return false;
        }

        private static class Period {
            private int startPeriod;
            private int endPeriod;

            public Period(int startPeriod, int endPeriod) {
                this.startPeriod = startPeriod;
                this.endPeriod = endPeriod;
            }

            public int getStartPeriod() {
                return startPeriod;
            }

            public int getEndPeriod() {
                return endPeriod;
            }

            public boolean isInPeriod(long time) {
                return  endPeriod > time && time > startPeriod;
            }
        }
    }
}
