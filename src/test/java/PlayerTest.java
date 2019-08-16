import org.junit.Assert;
import org.junit.Test;

public class PlayerTest
{
    @Test
    public void newPlayerHasZeroScore ()
    {
        Player testPlayer = new Player("testName");
        Assert.assertEquals(testPlayer.getPlayerScore(), 0);
    }

    @Test
    public void canCreateNewRobot ()
    {
        Player testPlayer = new Player("testRobot");
        testPlayer.setIsPlayerRobot(true);
        Assert.assertTrue(testPlayer.getIsPlayerRobot());
    }

    @Test
    public void newPlayerHoldsCompletedBoard ()
    {
        Player testPlayer = new Player("testRobot");
        GameBoard testBoard = testPlayer.getPersonalGameBoard();
        Assert.assertFalse(testPlayer.getIsPlayerBoardEmpty());
        Assert.assertFalse(testBoard.isGameBoardEmpty());
    }

    @Test
    public void selectGameOptionWithEmptyArrayReturnsZero ()
    {
        Player testPlayer = new Player("testRobot");
        int[] emptyArray = {0,0,0,0,0};
        Assert.assertEquals(0, testPlayer.selectGameBoardOption("chance", emptyArray));
    }

    @Test
    public void selectHighestOptionReturnsHighestOption ()
    {
        Player testPlayer = new Player("testRobot");
        int[] diceArray = {5,5,6,6,6};
        testPlayer.getPersonalGameBoard().drawGameBoard(diceArray);
        Assert.assertEquals("chance", testPlayer.selectHighestOptionOnGameBoardOption(diceArray));
    }

    @Test
    public void selectHighestOptionReturnsHighestOptionWhenChanceIsMissing ()
    {
        Player testPlayer = new Player("testRobot");
        int[] diceArray = {5,5,6,6,6};
        testPlayer.getPersonalGameBoard().getSpecificOptionOnBoard("chance");
        testPlayer.getPersonalGameBoard().drawGameBoard(diceArray);
        Assert.assertEquals("full house", testPlayer.selectHighestOptionOnGameBoardOption(diceArray));
    }

    @Test
    public void testPlayerBeginsWithZeroScore ()
    {
        Player testPlayer = new Player("testRobot");
        testPlayer.getPersonalGameBoard().getSpecificOptionOnBoard("chance");
        testPlayer.addToPlayerScore(50);
        Assert.assertEquals(50,testPlayer.getPlayerScore());
    }
}
