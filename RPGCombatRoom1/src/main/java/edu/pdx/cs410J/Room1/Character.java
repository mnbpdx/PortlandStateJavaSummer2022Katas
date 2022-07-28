package edu.pdx.cs410J.Room1;

public class Character {
    private int health;
    private boolean isAlive;
    private int level;

    public Character() {
        health = 1000;
        isAlive = true;
        level = 1;
    }

    public int getHealth() {
        return health;
    }

    public boolean getIsAlive() {
        return isAlive;
    }

    public void receiveDamage(int damage) {
        this.health = this.health - damage;
        if(this.health <= 0)
        {
            this.health = 0;
            this.isAlive = false;
        }
    }
    public void dealDamage(Character a_character, int damage_dealt)
    {
        if(a_character != this)
            a_character.receiveDamage(damage_dealt);
    }

    public void recover(int to_recover)
    {
        this.health = this.health + to_recover;
        if(this.health > 1000)
        {
            this.health = 1000;
        }
    }

    public void heal(Character a_character, int to_recover) {
        if (a_character.isAlive) {
            a_character.recover(to_recover);
        }
    }
}
