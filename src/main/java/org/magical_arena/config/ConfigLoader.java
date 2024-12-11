package org.magical_arena.config;

import org.magical_arena.player.Player;
import org.magical_arena.player.PlayerFactory;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ConfigLoader {
    private final String filePath;

    public ConfigLoader(String filePath) {
        this.filePath = filePath;
    }

    public ConfigData load() throws IOException {
        List<Player> players = new ArrayList<>();
        String diceType = null;
        String playerType = null;
        String arenaType = null;
        int numPlayers = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line.trim();
                if (line.startsWith("diceType:")) {
                    diceType = line.split(":")[1].trim();
                } else if (line.startsWith("playerType:")) {
                    playerType = line.split(":")[1].trim();
                } else if (line.startsWith("arenaType:")) {
                    arenaType = line.split(":")[1].trim();
                } else if (line.startsWith("numPlayers:")) {
                    numPlayers = Integer.parseInt(line.split(":")[1].trim());
                } else if (line.startsWith("player:")) {
                    String[] details = line.split(":")[1].split(",");
                    String name = details[0].trim();
                    int health = Integer.parseInt(details[1].trim());
                    int strength = Integer.parseInt(details[2].trim());
                    int attack = Integer.parseInt(details[3].trim());
                    players.add(PlayerFactory.createPlayer(playerType, name, health, strength, attack, diceType));
                }
            }
        }

        if (players.size() != numPlayers) {
            throw new IllegalArgumentException("Number of players does not match the provided numPlayers value!");
        }

        return new ConfigData(arenaType, players);
    }
}
