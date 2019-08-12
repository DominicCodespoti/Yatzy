import org.junit.Assert;
import org.junit.Test;

public class TestFramework
{
    @Test
    public void createFiveRandomDice ()
    {
        Dice firstSetOfRandomDice = new Dice();
        Dice secondSetOfRandomDice = new Dice();

        Assert.assertNotEquals(firstSetOfRandomDice.getAllDiceValues(), secondSetOfRandomDice.getAllDiceValues());
    }

    @Test
    public void rerollTwoSpecificDice ()
    {
        Dice fiveRandomDice = new Dice();
        int[] diceToKeepWhenRerolling = new int[1];
        fiveRandomDice.printAllDiceRollValues();

        for (int testIterator = 0; testIterator < 100; testIterator++)
        {
            diceToKeepWhenRerolling[0] = fiveRandomDice.getSpecificDiceRollsValue(0);

            fiveRandomDice.rerollDiceWithoutSpecificValues(diceToKeepWhenRerolling);

            Assert.assertTrue(fiveRandomDice.checkIfDiceRollMatchesValue(diceToKeepWhenRerolling[0], fiveRandomDice.getAllDiceValues()));

            fiveRandomDice.printAllDiceRollValues();
        }
    }

    @Test
    public void newPlayerAndNewRobotHaveZeroScore ()
    {
        Player testPlayer = new Player();
        Robot testRobot = new Robot();
        Assert.assertEquals(testPlayer.getPlayerScore(), 0);
        Assert.assertEquals(testRobot.getPlayerScore(), 0);
    }

    @Test
    public void printBoardWorks ()
    {
        Dice testDice = new Dice();
        GameBoard testBoard = new GameBoard();
        testDice.printAllDiceRollValues();
        testBoard.drawGameBoard(testDice.getAllDiceValues());
    }

    @Test
    public void yatzyCalculatesCorrectAmount ()
    {
        Dice testDice = new Dice();
        GameBoard testBoard = new GameBoard();
        testDice.printAllDiceRollValues();
        testBoard.drawGameBoard(testDice.getAllDiceValues());
    }
/*
    @Test
    public void chanceCalculatesCorrectAmount ()
    {
        GameBoard testBoard = new GameBoard();
        int[] testAmount = new int[5];
        testAmount[0] = 5;
        testAmount[1] = 5;
        testAmount[2] = 5;
        testAmount[3] = 5;
        testAmount[4] = 5;

        Assert.assertEquals(testBoard.optionsOnGameBoard);
    }
 */
}
