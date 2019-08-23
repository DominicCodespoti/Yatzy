package yatzy;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;
import org.junit.Assert;
import org.junit.Test;

public class InputHandlerTest {

  @Test
  public void testDiceRerollAllowsWithCommas() {
    ByteArrayInputStream in = new ByteArrayInputStream("2,3".getBytes());
    System.setIn(in);

    Assert.assertEquals(new int[] {2, 3}[1],
        InputHandler.validateAndReturnUserInputForDiceReroll(in)[1]);
  }

  @Test
  public void testDiceRerollCatchesWithoutCommas() {
    ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
    System.setIn(in);

    int[] test = InputHandler.validateAndReturnUserInputForDiceReroll(in);

    Assert.assertEquals(new int[] {2}[0], test[0]);
  }

  @Test(expected = NoSuchElementException.class)
  public void testDiceRerollCatchesWhenCommaBehind() {
    ByteArrayInputStream in = new ByteArrayInputStream(",2".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForDiceReroll(in);
  }

  @Test
  public void testGameBoardChoiceInput() {
    GameBoard testBoard = new GameBoard();

    ByteArrayInputStream in = new ByteArrayInputStream("chance".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForGameBoardOptions(testBoard, in);
  }

  @Test(expected = NoSuchElementException.class)
  public void testGameBoardChoiceInputCatchesIncorrectOption() {
    GameBoard testBoard = new GameBoard();

    ByteArrayInputStream in = new ByteArrayInputStream("potato".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForGameBoardOptions(testBoard, in);
  }

  @Test(expected = NoSuchElementException.class)
  public void testGameBoardChoiceInputCatchesRemovedOption() {
    GameBoard testBoard = new GameBoard();
    testBoard.getSpecificOptionOnBoard("chance");

    ByteArrayInputStream in = new ByteArrayInputStream("chance".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForGameBoardOptions(testBoard, in);
  }

  @Test(expected = NoSuchElementException.class)
  public void testNumberInputCatchesString() {
    ByteArrayInputStream in = new ByteArrayInputStream("test".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForNumbers(in);
  }

  @Test
  public void testNumberInputAllowsInteger() {
    ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForNumbers(in);
  }

  @Test
  public void testBoundaryAllowsInputInBoundary() {
    ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForChoices(in, 3);
  }

  @Test
  public void testBoundaryAllowsInputOnBoundary() {
    ByteArrayInputStream in = new ByteArrayInputStream("3".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForChoices(in, 3);
  }

  @Test(expected = NoSuchElementException.class)
  public void testBoundaryCatchesInputOverBoundary() {
    ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForChoices(in, 3);
  }

  @Test(expected = NoSuchElementException.class)
  public void testBoundaryCatchesInputBelowBoundary() {
    ByteArrayInputStream in = new ByteArrayInputStream("-2".getBytes());
    System.setIn(in);

    InputHandler.validateAndReturnUserInputForChoices(in, 3);
  }
}
