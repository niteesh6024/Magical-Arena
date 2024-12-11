package org.magical_arena.arena;

import org.magical_arena.player.Player;
import java.util.List;

public class ArenaFactory {

    public static Arena createArena(String arenaType, List<Player> players) {
        RandomPlayerSelector selector = new RandomPlayerSelector();
        switch (arenaType) {
            case "MagicalArena":
                return new MagicalArena(players, selector);
            default:
                throw new IllegalArgumentException("Unknown arena type: " + arenaType);
        }
    }
}
