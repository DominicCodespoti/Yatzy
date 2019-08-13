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
        fiveRandomDice.printAllDiceRollValues();

        for (int testIterator = 0; testIterator < 100; testIterator++)
        {
            diceToKeepWhenRerolling[0] = fiveRandomDice.getSpecificDiceRollsValue(0);

            fiveRandomDice.rerollDiceWithoutSpecificValues(diceToKeepWhenRerolling);

            Assert.assertTrue(fiveRandomDice.checkIfDiceRollMatchesValue(diceToKeepWhenRerolling[0], fiveRandomDice.getAllDiceValues()));

            fiveRandomDice.printAllDiceRollValues();
        }
    }
}