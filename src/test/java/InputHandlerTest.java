import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

public class InputHandlerTest {
    @Test
    public void testDiceRerollAllowsWithCommas() {
        ByteArrayInputStream in = new ByteArrayInputStream("2,3".getBytes());
        System.setIn(in);

        Assert.assertEquals("2,3" , InputHandler.validateAndReturnUserInputForDiceReroll(in));
    }

    @Test
    public void testDiceRerollCatchesWithoutCommas() {
        ByteArrayInputStream in = new ByteArrayInputStream("2".getBytes());
        System.setIn(in);

        String test = InputHandler.validateAndReturnUserInputForDiceReroll(in);

        Assert.assertEquals("2" , test);
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
