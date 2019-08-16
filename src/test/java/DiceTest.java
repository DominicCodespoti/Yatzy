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
        int[] diceToKeepWhenRerolling = new int[1];

        for (int testIterator = 0; testIterator < 100; testIterator++)
        {
            diceToKeepWhenRerolling[0] = fiveRandomDice.getSpecificDiceRollsValue(0);

            fiveRandomDice.rerollDiceWithoutSpecificValues(diceToKeepWhenRerolling);

            Assert.assertTrue(fiveRandomDice.checkIfDiceRollMatchesValue(diceToKeepWhenRerolling[0], fiveRandomDice.getAllDiceValues()));

        }
    }

    @Test
    public void rerollTwoSpecificDiceThatDontExist ()
    {
        Dice testDice;
        int[] diceArray = {1,2,3,4,5};
        int[] diceToKeepWhenRerolling = new int[1];
        diceToKeepWhenRerolling[0] = 6;

        for (int testIterator = 0; testIterator < 100; testIterator++)
        {
            testDice = new Dice();
            testDice.rerollDiceWithoutSpecificValues(diceToKeepWhenRerolling);
        }
    }
}
