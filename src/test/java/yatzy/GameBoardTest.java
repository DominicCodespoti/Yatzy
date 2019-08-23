package yatzy;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class GameBoardTest {

  private List<Integer> valuesForDice = new ArrayList<>();

  @Test
  public void testCalculateHighestScore() {
    valuesForDice.add(6);
    valuesForDice.add(6);
    valuesForDice.add(6);
    valuesForDice.add(6);
    valuesForDice.add(6);
    Dice testDice = new Dice(valuesForDice);
    GameBoard testBoard = new GameBoard();
    String highestID = testBoard.getHighestScoringOptionID(testDice);
    Assert.assertEquals(50,
        testBoard.getSpecificOptionOnBoard(highestID).calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void testGradualBoardDeletion() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(5);
    valuesForDice.add(5);
    valuesForDice.add(5);
    Dice testDice = new Dice(valuesForDice);
    GameBoard testBoard = new GameBoard();
    while (!testBoard.isGameBoardEmpty()) {
      testBoard.getSpecificOptionOnBoard(testBoard.getHighestScoringOptionID(testDice));
    }
    Assert.assertTrue(testBoard.isGameBoardEmpty());
  }
}