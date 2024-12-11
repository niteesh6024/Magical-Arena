package org.magical_arena.dice;

import java.util.Random;

public class SixSidedDice implements Dice {
    private final Random random = new Random();
    private static final int side = 6;

    @Override
    public int roll() {
        return random.nextInt(side) + 1; // Returns a value between 1 and 6
    }
}

