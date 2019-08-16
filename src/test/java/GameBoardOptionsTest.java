import org.junit.Assert;
import org.junit.Test;

public class GameBoardOptionsTest
{
    @Test
    public void onesTwosFoursAllCalculateCorrectWhenOccuringTogether()
    {
        int[] dice = { 1, 1, 2, 4, 4 };
        GameBoardOptions.Ones optionOne = new GameBoardOptions.Ones();
        GameBoardOptions.Twos optionTwo = new GameBoardOptions.Twos();
        GameBoardOptions.Fours optionFour = new GameBoardOptions.Fours();
        Assert.assertEquals(2, optionOne.calculateScoreFromGivenDice(dice));
        Assert.assertEquals(2, optionTwo.calculateScoreFromGivenDice(dice));
        Assert.assertEquals(8, optionFour.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void onePairCalculatesTheSumOfTheSinglePair()
    {
        int[] dice = { 1, 1, 2, 3, 4 };
        GameBoardOptions.OnePair option = new GameBoardOptions.OnePair();
        Assert.assertEquals(2, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void onePairCalculatesWhenThreeOfAKindIsPresent()
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

    @Test
    public void onePairCalculatesTheSumOfTwoOfTheDiceWhenThereAreThree()
    {
        int[] dice = { 3, 3, 3, 1, 4 };
        GameBoardOptions.OnePair option = new GameBoardOptions.OnePair();
        Assert.assertEquals(6, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void twoPairCalculatesTheSumCorrectly()
    {
        int[] dice = { 3, 3, 1, 1, 4 };
        GameBoardOptions.TwoPair option = new GameBoardOptions.TwoPair();
        Assert.assertEquals(8, option.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void twoPairCalculatesTheSumCorrectlyWhenFullhouseIsPresent()
    {
        int[] dice = { 3, 3, 1, 1, 1 };
        GameBoardOptions.TwoPair option = new GameBoardOptions.TwoPair();
        Assert.assertEquals(8, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void threeOfAKindCalculatesTheSumCorrectly()
    {
        int[] dice = { 3, 3, 3, 1, 1 };
        GameBoardOptions.ThreeOfAKind option = new GameBoardOptions.ThreeOfAKind();
        Assert.assertEquals(9, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void threeOfAKindCalculatesZeroWhenApplicable()
    {
        int[] dice = { 3, 3, 2, 1, 1 };
        GameBoardOptions.ThreeOfAKind option = new GameBoardOptions.ThreeOfAKind();
        Assert.assertEquals(0, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void threeOfAKindCalculatesTheSumCorrectlyWithPairPrior()
    {
        int[] dice = { 1, 1, 3, 3, 3};
        GameBoardOptions.ThreeOfAKind option = new GameBoardOptions.ThreeOfAKind();
        Assert.assertEquals(9, option.calculateScoreFromGivenDice(dice));
    }

    @Test
    public void fourOfAKindCalculatesTheSumCorrectly()
    {
        int[] dice = { 1, 3, 3, 3, 3};
        GameBoardOptions.FourOfAKind option = new GameBoardOptions.FourOfAKind();
        Assert.assertEquals(12, option.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void smallStraightCalculatesTheSumCorrectly()
    {
        int[] dice = { 1, 2, 3, 4, 5};
        GameBoardOptions.SmallStraight option = new GameBoardOptions.SmallStraight();
        Assert.assertEquals(15, option.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void largeStraightCalculatesTheSumCorrectly()
    {
        int[] dice = { 2, 3, 4, 5, 6};
        GameBoardOptions.LargeStraight option = new GameBoardOptions.LargeStraight();
        Assert.assertEquals(20, option.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void chanceCalculatesCorrectAmountWithRandomCaseInput ()
    {
        int[] dice = { 4, 5, 5, 6, 1 };
        GameBoardOptions.Chance option = new GameBoardOptions.Chance();
        Assert.assertEquals(21, option.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void fullhouseCalculatesTheSumCorrectly()
    {
        int[] dice = { 1, 1, 3, 3, 3};
        GameBoardOptions.FullHouse option = new GameBoardOptions.FullHouse();
        Assert.assertEquals(11, option.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void fullhouseOutputsZeroWhenPairAndThreeOfAKindAreSameNumber()
    {
        int[] dice = { 3, 3, 3, 3, 3};
        GameBoardOptions.FullHouse option = new GameBoardOptions.FullHouse();
        Assert.assertEquals(0, option.calculateScoreFromGivenDice(dice));
    }
    @Test
    public void yatzyCalculatesCorrectAmountInUpperCase ()
    {
        int[] dice = { 1, 1, 1, 1, 1};
        GameBoardOptions.Yatzy option = new GameBoardOptions.Yatzy();
        Assert.assertEquals(50, option.calculateScoreFromGivenDice(dice));
    }
}
