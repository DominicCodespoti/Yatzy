import org.junit.Assert;
import org.junit.Test;

public class DiceTest
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
        int[] diceToKeepWhenRerolling = new int[2];

        for (int testIterator = 0; testIterator < 100; testIterator++)
        {
            diceToKeepWhenRerolling[0] = fiveRandomDice.getSpecificDiceRollsValue(0);
            diceToKeepWhenRerolling[1] = fiveRandomDice.getSpecificDiceRollsValue(1);
            fiveRandomDice = new Dice(diceToKeepWhenRerolling);
        }
        Assert.assertEquals(diceToKeepWhenRerolling[0], fiveRandomDice.getAllDiceValues()[0]);
        Assert.assertEquals(diceToKeepWhenRerolling[1], fiveRandomDice.getAllDiceValues()[1]);
    }

    @Test
    public void keepAllDiceOnReroll ()
    {
        Dice fiveRandomDice = new Dice();
        int[] diceToKeepWhenRerolling = new int[5];

        for (int testIterator = 0; testIterator < 100; testIterator++)
        {
            diceToKeepWhenRerolling[0] = fiveRandomDice.getSpecificDiceRollsValue(0);
            diceToKeepWhenRerolling[1] = fiveRandomDice.getSpecificDiceRollsValue(1);
            diceToKeepWhenRerolling[2] = fiveRandomDice.getSpecificDiceRollsValue(2);
            diceToKeepWhenRerolling[3] = fiveRandomDice.getSpecificDiceRollsValue(3);
            diceToKeepWhenRerolling[4] = fiveRandomDice.getSpecificDiceRollsValue(4);
            fiveRandomDice = new Dice(diceToKeepWhenRerolling);
        }
        Assert.assertEquals(diceToKeepWhenRerolling[0], fiveRandomDice.getAllDiceValues()[0]);
        Assert.assertEquals(diceToKeepWhenRerolling[1], fiveRandomDice.getAllDiceValues()[1]);
        Assert.assertEquals(diceToKeepWhenRerolling[2], fiveRandomDice.getAllDiceValues()[2]);
        Assert.assertEquals(diceToKeepWhenRerolling[3], fiveRandomDice.getAllDiceValues()[3]);
        Assert.assertEquals(diceToKeepWhenRerolling[4], fiveRandomDice.getAllDiceValues()[4]);
    }
}
