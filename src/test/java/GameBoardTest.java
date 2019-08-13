import org.junit.Assert;
import org.junit.Test;

public class GameBoardTest
{
    @Test
    public void printBoardWorks ()
    {
        Dice testDice = new Dice();
        GameBoard testBoard = new GameBoard();
        testDice.printAllDiceRollValues();
        testBoard.drawGameBoard(testDice.getAllDiceValues());
    }

    @Test
    public void testCalculateHighestScore ()
    {
        int[] testDice = { 3, 3, 5 ,5 ,5};
        GameBoard testBoard = new GameBoard();
        String highestID = testBoard.getHighestScoringOptionID(testDice);
        Assert.assertEquals(21, testBoard.getSpecificOptionOnBoard(highestID).calculateScoreFromGivenDice(testDice));
    }
}
