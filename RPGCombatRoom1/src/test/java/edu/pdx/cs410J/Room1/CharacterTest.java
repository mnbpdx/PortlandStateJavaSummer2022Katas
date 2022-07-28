package edu.pdx.cs410J.Room1;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CharacterTest {
    private Character character;

    @BeforeEach
    void setup() {
        this.character = new Character();
    }

    @Test
    void test1CharacterCreatedIsNotNull() {
        assertNotNull(this.character);
    }

    @Test
    void test2CharacterCreatedHasHealth1000() {
        assertEquals(this.character.getHealth(), 1000);
    }

    @Test
    void test3CharacterCreatedIsAlive() {
        assertTrue(this.character.getIsAlive());
    }

    @Test
    void test4CharacterCanReceiveDamage() {
        int currentHealth = this.character.getHealth();
        int damage = 10;

        this.character.receiveDamage(damage);
        assertEquals(this.character.getHealth(), currentHealth - damage);
    }

    @Test
    void test5IsDead(){
        int damage = 1001;

        this.character.receiveDamage(damage);
        assertFalse(this.character.getIsAlive());
    }

    @Test
    void test6CharacterCanDealDamage() {
        Character otherCharacter = new Character();
        int damage = 100;

        this.character.dealDamage(otherCharacter, damage);
        assertEquals(otherCharacter.getHealth(), 900);
    }

    @Test
    void test7CharacterCannotDamageSelf() {
        int damage = 100;

        this.character.dealDamage(this.character, damage);
        assertEquals(this.character.getHealth(), 1000);
    }

    @Test
    void test8CharacterCanHealOthers() {
        Character otherCharacter = new Character();
        int damage = 500;
        int health = 100;
        otherCharacter.dealDamage(this.character, damage);
        otherCharacter.heal(this.character, health);
        assertEquals(this.character.getHealth(), 600);
    }

    @Test
    void test9CharacterCanHealSelf() {
        Character otherCharacter = new Character();
        int damage = 500;
        int health = 100;
        otherCharacter.dealDamage(this.character, damage);
        this.character.heal(this.character, health);
        assertEquals(this.character.getHealth(), 600);
    }
}

