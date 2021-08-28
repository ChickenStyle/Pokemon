package me.chickenstyle.pokemonplugin.pokemons;

public class EVStats {


    private int totalEV;

    private int hp;
    private int attack;
    private int defense;
    private int specialAttack;
    private int specialDefense;
    private int speed;

    public EVStats() {
        this.hp = 0;
        this.attack = 0;
        this.defense = 0;
        this.specialAttack = 0;
        this.specialDefense = 0;
        this.speed = 0;
        this.totalEV = 0;
    }

    public int getEvHp() {
        return hp;
    }

    public void addEvHp(int hp) {
        if ((totalEV + hp) <= 510) {
            int evNumber = (this.hp + hp) <= 252 ? hp: (252 - this.hp);
            this.hp += evNumber;
            totalEV += evNumber;
        } else {
            int evLeft = 510-totalEV;
            this.hp += evLeft;
            totalEV = 510;
        }
    }

    public int getEvAttack() {
        return attack;
    }

    public void addEvAttack(int attack) {
        if ((totalEV + attack) <= 510) {
            int evNumber = (this.attack + attack) <= 252 ? attack: (252 - this.attack);
            this.attack += evNumber;
            totalEV += evNumber;
        } else {
            int evLeft = 510-totalEV;
            this.attack += evLeft;
            totalEV = 510;
        }
    }


    public int getEvDefense() {
        return defense;
    }

    public void addEvDefense(int defense) {
        if ((totalEV + defense) <= 510) {
            int evNumber = (this.defense + defense) <= 252 ? defense: (252 - this.defense);
            this.defense += evNumber;
            totalEV += evNumber;
        } else {
            int evLeft = 510-totalEV;
            this.defense += evLeft;
            totalEV = 510;
        }
    }


    public int getEvSpeed() {
        return speed;
    }

    public void addEvSpeed(int speed) {
        if ((totalEV + speed) <= 510) {
            int evNumber = (this.speed + speed) <= 252 ? speed: (252 - this.speed);
            this.speed += evNumber;
            totalEV += evNumber;
        } else {
            int evLeft = 510-totalEV;
            this.speed += evLeft;
            totalEV = 510;
        }
    }

    public int getEvSpecialAttack() {return specialAttack;}

    public void addEvSpecialAttack(int specialAttack) {
        if ((totalEV + specialAttack) <= 510) {
            int evNumber = (this.specialAttack + specialAttack) <= 252 ? specialAttack: (252 - this.specialAttack);
            this.specialAttack += evNumber;
            totalEV += evNumber;
        } else {
            int evLeft = 510-totalEV;
            this.specialAttack += evLeft;
            totalEV = 510;
        }
    }

    public int getEvSpecialDefense() {return specialDefense;}

    public void addEvSpecialDefense(int specialDefense) {
        if ((totalEV + specialDefense) <= 510) {
            int evNumber = (this.specialDefense + specialDefense) <= 252 ? specialDefense: (252 - this.specialDefense);
            this.specialDefense += evNumber;
            totalEV += evNumber;
        } else {
            int evLeft = 510-totalEV;
            this.specialDefense += evLeft;
            totalEV = 510;
        }
    }

    public int getTotalEV() {
        return totalEV;
    }

}
