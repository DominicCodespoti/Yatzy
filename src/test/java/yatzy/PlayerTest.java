package yatzy;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class PlayerTest {

  private List<Integer> valuesForDice = new ArrayList<>();

  @Test
  public void newPlayerHasZeroScore() {
    Player testPlayer = new Player("testName");
    Assert.assertEquals(testPlayer.getPlayerScore(), 0);
  }

  @Test
  public void canCreateNewRobot() {
    Player testPlayer = new Player("testRobot");
    testPlayer.setIsPlayerRobot(true);
    Assert.assertTrue(testPlayer.getIsPlayerRobot());
  }

  @Test
  public void newPlayerHoldsCompletedBoard() {
    Player testPlayer = new Player("testRobot");
    GameBoard testBoard = testPlayer.getPersonalGameBoard();
    Assert.assertFalse(testPlayer.getPersonalGameBoard().isGameBoardEmpty());
    Assert.assertFalse(testBoard.isGameBoardEmpty());
  }

  @Test
  public void selectGameOptionWithEmptyArrayReturnsZero() {
    Player testPlayer = new Player("testRobot");
    valuesForDice.add(0);
    valuesForDice.add(0);
    valuesForDice.add(0);
    valuesForDice.add(0);
    valuesForDice.add(0);
    Assert.assertEquals(0, testPlayer.selectGameBoardOption("chance", new Dice(valuesForDice)));
  }

  @Test
  public void selectHighestOptionReturnsHighestOption() {
    Player testPlayer = new Player("testRobot");
    valuesForDice.add(4);
    valuesForDice.add(5);
    valuesForDice.add(6);
    valuesForDice.add(6);
    valuesForDice.add(6);
    OutputHandler.drawGameBoard(new Dice(valuesForDice), testPlayer.getPersonalGameBoard());
    Assert.assertEquals("Chance",
        testPlayer.selectHighestOptionOnGameBoardOption(new Dice(valuesForDice)));
  }

  @Test
  public void selectHighestOptionReturnsHighestOptionWhenFullHouseIsMissing() {
    Player testPlayer = new Player("testRobot");
    valuesForDice.add(5);
    valuesForDice.add(5);
    valuesForDice.add(6);
    valuesForDice.add(6);
    valuesForDice.add(6);
    testPlayer.getPersonalGameBoard().getSpecificOptionOnBoard("Full House");
    OutputHandler.drawGameBoard(new Dice(valuesForDice), testPlayer.getPersonalGameBoard());
    Assert.assertEquals("Chance",
        testPlayer.selectHighestOptionOnGameBoardOption(new Dice(valuesForDice)));
  }

  @Test
  public void testPlayerBeginsWithZeroScore() {
    Player testPlayer = new Player("testRobot");
    testPlayer.getPersonalGameBoard().getSpecificOptionOnBoard("chance");
    testPlayer.addToPlayerScore(50);
    Assert.assertEquals(50, testPlayer.getPlayerScore());
  }
}

