package org.magical_arena;

import org.junit.jupiter.api.Test;
import org.magical_arena.player.BasicPlayer;
import org.magical_arena.player.PlayerFactory;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testCalculateAttackValue() {
        BasicPlayer player = new BasicPlayer("Player A", 100, 10, 5, "six-sided");
        int attackValue = player.calculateAttackValue();
        assertTrue(attackValue >= 5 && attackValue <= 30, "Attack value should be within the expected range");
    }

    @Test
    void testCalculateDefenseValue() {
        BasicPlayer player = new BasicPlayer("Player A", 100, 10, 5, "six-sided");
        int defenseValue = player.calculateDefenseValue();
        assertTrue(defenseValue >= 10 && defenseValue <= 60, "Defense value should be within the expected range");
    }

    @Test
    void testTakeDamage() {
        BasicPlayer player = new BasicPlayer("Player A", 50, 5, 10, "six-sided");
        player.takeDamage(20);
        assertEquals(30, player.getHealth(), "Health should reduce correctly after taking damage");
        player.takeDamage(50); // Damage greater than current health
        assertEquals(0, player.getHealth(), "Health should not go below zero");
    }

    @Test
    void testIsAlive() {
        BasicPlayer player = new BasicPlayer("Player A", 50, 5, 10, "six-sided");
        assertTrue(player.isAlive(), "Player should be alive when health is greater than zero");
        player.takeDamage(50);
        assertFalse(player.isAlive(), "Player should not be alive when health is zero");
    }

    @Test
    void testPlayerFactoryThrowsExceptionForInvalidOPlayerType() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            PlayerFactory.createPlayer("unknown-player","Player A", 50, 5, 10, "six-sided");
        });
        assertEquals("Unknown player type: unknown-player", exception.getMessage());
    }
}

