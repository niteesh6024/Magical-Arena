package org.magical_arena.arena;

import org.magical_arena.player.Player;

import java.util.List;
import java.util.Random;

public class RandomPlayerSelector{
    private final Random random = new Random();

    public Player[] selectPlayers(List<Player> players) {
        if (players.size() < 2) {
            throw new IllegalArgumentException("At least two players are required.");
        }

        int index1 = random.nextInt(players.size());
        int index2;
        do {
            index2 = random.nextInt(players.size());
        } while (index1 == index2);

        return new Player[]{players.get(index1), players.get(index2)};
    }
}
