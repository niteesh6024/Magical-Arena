package org.magical_arena;

import org.junit.jupiter.api.Test;
import org.magical_arena.arena.Arena;
import org.magical_arena.arena.ArenaFactory;
import org.magical_arena.arena.RandomPlayerSelector;
import org.magical_arena.player.BasicPlayer;
import org.magical_arena.player.Player;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ArenaTest {

    @Test
    void testRandomPlayerSelector() {
        List<Player> players = Arrays.asList(
                new BasicPlayer("Player A", 50, 5, 10, "six-sided"),
                new BasicPlayer("Player B", 100, 10, 5, "six-sided")
        );
        RandomPlayerSelector selector = new RandomPlayerSelector();
        Player[] selectedPlayers = selector.selectPlayers(players);
        assertNotNull(selectedPlayers[0]);
        assertNotNull(selectedPlayers[1]);
        assertNotEquals(selectedPlayers[0], selectedPlayers[1], "Selected players should be different");
    }
    @Test
    void testFightMethod() {
        List<Player> players = Arrays.asList(
                new BasicPlayer("Player A", 50, 5, 10, "six-sided"),
                new BasicPlayer("Player B", 100, 10, 5, "six-sided")
        );
        Arena arena = ArenaFactory.createArena("MagicalArena", players);
        arena.startTournament();
    }

    @Test
    void testTournamentWithMorePlayers() {
        List<Player> players = Arrays.asList(
                new BasicPlayer("Player A", 50, 5, 10, "six-sided"),
                new BasicPlayer("Player B", 100, 10, 5, "six-sided"),
                new BasicPlayer("Player C", 75, 8, 7, "six-sided"),
                new BasicPlayer("Player D", 60, 6, 8, "six-sided")
        );
        Arena arena = ArenaFactory.createArena("MagicalArena", players);
        arena.startTournament();
    }
}

