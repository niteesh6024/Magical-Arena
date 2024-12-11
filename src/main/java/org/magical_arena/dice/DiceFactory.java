package org.magical_arena.dice;

public class DiceFactory {
    public static Dice createDice(String diceType) {
        switch (diceType.toLowerCase()) {
            case "six-sided":
                return new SixSidedDice();
            default:
                throw new IllegalArgumentException("Unknown dice type: " + diceType);
        }
    }
}
