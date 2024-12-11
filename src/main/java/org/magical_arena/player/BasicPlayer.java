package org.magical_arena.player;

import org.magical_arena.dice.Dice;
import org.magical_arena.dice.DiceFactory;

import java.util.Random;

public class BasicPlayer implements Player {
    private final String name;
    private int health;
    private final int strength;
    private final int attack;
    private final Dice dice;

    public BasicPlayer(String name, int health, int strength, int attack, String diceType) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
        this.dice = DiceFactory.createDice(diceType);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getHealth() {
        return health;
    }

    @Override
    public boolean isAlive() {
        return health > 0;
    }

    public int rollDice() {
        Random random = new Random();
        return this.dice.roll(); // Returns a value between 1 and 6
    }

    @Override
    public int calculateAttackValue() {
        return attack * this.dice.roll();
    }

    @Override
    public int calculateDefenseValue() {
        return strength * this.dice.roll();
    }

    @Override
    public void takeDamage(int damage) {
        this.health = Math.max(0, this.health - damage);
    }
}

