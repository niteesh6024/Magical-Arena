package org.magical_arena.arena;

import org.magical_arena.player.Player;

import java.util.List;
import java.util.ArrayList;

public class MagicalArena implements Arena {
    private final List<Player> players;
    private final RandomPlayerSelector selector;

    public MagicalArena(List<Player> players, RandomPlayerSelector selector) {
        this.players = new ArrayList<>(players);
        this.selector = selector;
    }

    public void startTournament() {
        System.out.println("Tournament begins in the Magical Arena!");
        Player[] selectedPlayers = selector.selectPlayers(players);
        Player player1 = selectedPlayers[0];
        Player player2 = selectedPlayers[1];

        fight(player1, player2);

        if (player1.isAlive()) {
            System.out.println(player2.getName() + " has died. " + player1.getName() + " wins!");
        } else {
            System.out.println(player1.getName() + " has died. " + player2.getName() + " wins!");
        }
    }

    public void fight(Player player1, Player player2) {
        System.out.println("The battle begins between " + player1.getName() + " and " + player2.getName());
        Player attacker = (player1.getHealth() < player2.getHealth()) ? player1 : player2;
        Player defender = (attacker == player1) ? player2 : player1;
        while (attacker.isAlive() && defender.isAlive()) {

            int netDamage = calculateNetDamage(attacker, defender);
            defender.takeDamage(netDamage);

            System.out.println(attacker.getName() + " attacks " + defender.getName() + " for " + netDamage + " damage. " +
                    defender.getName() + "'s health is now " + defender.getHealth());

            Player temp = attacker;
            attacker = defender;
            defender = temp;

        }
    }
    private int calculateNetDamage(Player attacker, Player defender) {
        int attackDamage = attacker.calculateAttackValue();
        int defendDamage = defender.calculateDefenseValue();
        return Math.max(0, attackDamage - defendDamage);
    }
}

