package org.magical_arena.player;

public interface Player {
    String getName();
    int getHealth();
    boolean isAlive();
    int calculateAttackValue();
    int calculateDefenseValue();
    void takeDamage(int damage);
}

