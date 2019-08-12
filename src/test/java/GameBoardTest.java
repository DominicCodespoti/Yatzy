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
}
