package yatzy;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class DiceTest {

  private List<Integer> valuesForDice = new ArrayList<>();

  @Test
  public void createFiveRandomDice() {
    Dice firstSetOfRandomDice = new Dice();
    Dice secondSetOfRandomDice = new Dice();

    Assert.assertNotEquals(firstSetOfRandomDice.getAllDiceValues(),
        secondSetOfRandomDice.getAllDiceValues());
  }

  @Test
  public void rerollTwoSpecificDice() {
    Dice fiveRandomDice = new Dice();

    valuesForDice.add(fiveRandomDice.getAllDiceValues()[0]);
    valuesForDice.add(fiveRandomDice.getAllDiceValues()[1]);
    fiveRandomDice = new Dice(valuesForDice);

    Assert.assertEquals(valuesForDice.get(0), (Integer) fiveRandomDice.getAllDiceValues()[0]);
    Assert.assertEquals(valuesForDice.get(1), (Integer) fiveRandomDice.getAllDiceValues()[1]);
  }

  @Test
  public void keepAllDiceOnReroll() {
    Dice fiveRandomDice = new Dice();

    valuesForDice.add(fiveRandomDice.getAllDiceValues()[0]);
    valuesForDice.add(fiveRandomDice.getAllDiceValues()[1]);
    valuesForDice.add(fiveRandomDice.getAllDiceValues()[2]);
    valuesForDice.add(fiveRandomDice.getAllDiceValues()[3]);
    valuesForDice.add(fiveRandomDice.getAllDiceValues()[4]);
    fiveRandomDice = new Dice(valuesForDice);

    Assert.assertEquals(valuesForDice.get(0), (Integer) fiveRandomDice.getAllDiceValues()[0]);
    Assert.assertEquals(valuesForDice.get(1), (Integer) fiveRandomDice.getAllDiceValues()[1]);
    Assert.assertEquals(valuesForDice.get(2), (Integer) fiveRandomDice.getAllDiceValues()[2]);
    Assert.assertEquals(valuesForDice.get(3), (Integer) fiveRandomDice.getAllDiceValues()[3]);
    Assert.assertEquals(valuesForDice.get(4), (Integer) fiveRandomDice.getAllDiceValues()[4]);
  }
}

