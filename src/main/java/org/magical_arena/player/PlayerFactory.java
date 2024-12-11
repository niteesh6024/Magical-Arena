package org.magical_arena.player;

public class PlayerFactory {
    public static Player createPlayer(String playerType, String name, int health, int strength, int attack, String diceType) {
        switch (playerType.toLowerCase()) {
            case "basic":
                return new BasicPlayer(name, health, strength, attack, diceType);
            default:
                throw new IllegalArgumentException("Unknown player type: " + playerType);
        }
    }
}
