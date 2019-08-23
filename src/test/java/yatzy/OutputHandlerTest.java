package yatzy;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class OutputHandlerTest {

  private List<Integer> valuesForDice = new ArrayList<>();

  @Test
  public void printBoardInOrderPrintsInCorrectOrder() {
    List<Player> testPlayerList = new ArrayList<>();
    testPlayerList.add(new Player("Todd"));
    testPlayerList.add(new Player("Mitch"));
    testPlayerList.add(new Player("Jack"));
    testPlayerList.add(new Player("Lemon"));
    testPlayerList.add(new Player("Dicky"));

    testPlayerList.get(0).addToPlayerScore(25);
    testPlayerList.get(1).addToPlayerScore(50);
    testPlayerList.get(2).addToPlayerScore(30);
    testPlayerList.get(3).addToPlayerScore(45);
    testPlayerList.get(4).addToPlayerScore(45);

    OutputHandler.drawGameResults(testPlayerList);
  }

  @Test
  public void printDicePrintsCorrectly() {
    Dice testDice = new Dice();
    OutputHandler.printAllDiceRollValues(testDice);
    valuesForDice.add(2);
    valuesForDice.add(3);
    Dice testDice2 = new Dice(valuesForDice);
    OutputHandler.printAllDiceRollValues(testDice2);
  }
}

