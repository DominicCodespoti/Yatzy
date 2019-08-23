package yatzy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public final class OutputHandler {

  public static void drawGameResults(List<Player> listOfPlayers) {
    System.out
        .println("Congratulations, you have reached the end of the game! Here are your scores: ");
    List<Player> sortedUsers = listOfPlayers.stream()
        .sorted(Comparator.comparing(Player::getPlayerScore).reversed())
        .collect(Collectors.toList());
    sortedUsers.forEach(currentPlayer -> System.out
        .println(currentPlayer.getPlayerName() + ": " + currentPlayer.getPlayerScore()));
  }

  public static void printAllDiceRollValues(Dice gameDice) {
    int[] diceRollValues = gameDice.getAllDiceValues();
    for (int diceIterator = 0; diceIterator < 5; diceIterator++) {
      if (diceIterator < 4) {
        System.out.print(diceRollValues[diceIterator] + ", ");
      } else {
        System.out.print(diceRollValues[diceIterator] + "\n");
      }
    }
  }

  public static void drawGameBoard(Dice gameDice, GameBoard givenGameBoard) {
    System.out.println(String.format("%030d", 0).replace("0", "-"));
    for (GameBoardOption gameBoardOption : givenGameBoard.getOptionsOnGameBoard()) {
      int score = gameBoardOption.calculateScoreFromGivenDice(gameDice);
      System.out.println(String.format("| %-20s | %3d |", gameBoardOption.optionName(), score));
    }
    System.out.println(String.format("%030d", 0).replace("0", "-"));
  }
}
