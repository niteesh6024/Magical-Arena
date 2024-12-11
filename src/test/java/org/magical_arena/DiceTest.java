package org.magical_arena;

import org.junit.jupiter.api.Test;
import org.magical_arena.dice.Dice;
import org.magical_arena.dice.DiceFactory;
import org.magical_arena.dice.SixSidedDice;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void testSixSidedDiceRoll() {
        Dice dice = new SixSidedDice();
        for (int i = 0; i < 100; i++) { // Roll multiple times to ensure correctness
            int roll = dice.roll();
            assertTrue(roll >= 1 && roll <= 6, "Dice roll should be between 1 and 6");
        }
    }

    @Test
    void testDiceFactoryCreatesSixSidedDice() {
        Dice dice = DiceFactory.createDice("six-sided");
        assertNotNull(dice, "Dice should not be null");
        assertTrue(dice instanceof SixSidedDice, "Dice should be of type SixSidedDice");
    }

    @Test
    void testDiceFactoryThrowsExceptionForInvalidDiceType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            DiceFactory.createDice("unknown-dice");
        });
        assertEquals("Unknown dice type: unknown-dice", exception.getMessage());
    }
}
