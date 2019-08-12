import org.junit.Assert;
import org.junit.Test;

public class GameBoardOptionsTest
{
    @Test
    public void yatzyCalculatesCorrectAmountInUpperCase ()
    {
        int[] pseudoDice = { 1, 1, 1, 1, 1};
        GameBoard testBoard = new GameBoard();
        //TODO: should be 50
        Assert.assertEquals(5, testBoard.getSpecificOptionOnBoard("ONES").calculateScoreFromGivenDice(pseudoDice));
    }

    @Test
    public void chanceCalculatesCorrectAmountWithRandomCaseInput ()
    {
        int[] pseudoDice = { 1, 4, 2, 6, 1 };
        GameBoard testBoard = new GameBoard();
        Assert.assertEquals(14, testBoard.getSpecificOptionOnBoard("cHaNcE").calculateScoreFromGivenDice(pseudoDice));
    }

    @Test
    public void onePairCalculatesTheSumOfTheSinglePair()
    {
        int[] dice = { 1, 1, 2, 3, 4 };
        GameBoardOptions.OnePair option = new GameBoardOptions.OnePair();
        Assert.assertEquals(2, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void onePairCalculatesTheSumOfTheLargestPairWhereTheLargerAppearsSecond()
    {
        int[] dice = { 1, 1, 3, 3, 4 };
        GameBoardOptions.OnePair option = new GameBoardOptions.OnePair();
        Assert.assertEquals(6, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void onePairCalculatesTheSumOfTheLargestPairWhereTheLargerAppearsFirst()
    {
        int[] dice = { 3, 3, 1, 1, 4 };
        GameBoardOptions.OnePair option = new GameBoardOptions.OnePair();
        Assert.assertEquals(6, option.calculateScoreFromGivenDice(dice));
    }
}
