package org.magical_arena;

import org.magical_arena.arena.Arena;
import org.magical_arena.arena.ArenaFactory;
import org.magical_arena.config.ConfigData;
import org.magical_arena.config.ConfigLoader;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        String configFilePath = Main.class.getClassLoader().getResource("arena_config.txt").getPath();
        System.out.println(configFilePath);
        try {
            ConfigLoader configLoader = new ConfigLoader(configFilePath);
            ConfigData configData = configLoader.load();
            Arena arena = ArenaFactory.createArena(configData.getArenaType(), configData.getPlayers());
            arena.startTournament();
        } catch (IOException e) {
            System.err.println("Error reading configuration file: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.err.println("Invalid configuration: " + e.getMessage());
        }
    }
}
