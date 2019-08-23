package yatzy;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Game {

  public Game() {
  }

  public void play() {
    Queue<Player> activePlayers = new ArrayDeque<>(initializePlayersBasedOnInput());
    List<Player> finishedPlayers = new ArrayList<>();

    while (!activePlayers.isEmpty()) {
      Player player = activePlayers.poll();
      System.out.println("It is now " + player.getPlayerName() + "'s turn!");

      player.takeTurn();
      if (player.isFinished()) {
        finishedPlayers.add(player);
      } else {
        activePlayers.add(player);
      }
    }

    OutputHandler.drawGameResults(finishedPlayers);
  }

  private List<Player> initializePlayersBasedOnInput() {
    List<Player> players = new ArrayList<>();

    System.out.println("Welcome to Yatzy!");

    while (true) {
      System.out.println("Add a bot (0), add a player (1) or done (2) ?");
      int choice = InputHandler.validateAndReturnUserInputForChoices(System.in, 2);

      if (choice == 2) {
        break;
      }

      boolean isBot = choice == 0;

      String label = isBot ? "bot" : "player";
      System.out.println("Name of " + label + " ?");
      String name = InputHandler.validateAndReturnUserInputForNames(System.in);

      Player player = new Player(name);
      player.setIsPlayerRobot(isBot);
      players.add(player);
    }

    return players;
  }
}
