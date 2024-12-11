package org.magical_arena.config;

import org.magical_arena.player.Player;

import java.util.List;

public class ConfigData {
    private final String arenaType;
    private final List<Player> players;

    public ConfigData(String  arenaType, List<Player> players) {

        this.players = players;
        this.arenaType = arenaType;
    }

    public String getArenaType() {
        return arenaType;
    }
    public List<Player> getPlayers() {
        return players;
    }
}
