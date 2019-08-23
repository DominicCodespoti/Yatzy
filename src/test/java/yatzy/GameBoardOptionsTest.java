package yatzy;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import yatzy.options.Chance;
import yatzy.options.LargeStraight;
import yatzy.options.NumberOfAKind;
import yatzy.options.SmallStraight;
import yatzy.options.SumOfDiceValue;
import yatzy.options.Yatzy;

public class GameBoardOptionsTest {

  private List<Integer> valuesForDice = new ArrayList<>();

  @Test
  public void onesTwosFoursAllCalculateCorrectWhenOccuringTogether() {
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(2);
    valuesForDice.add(4);
    valuesForDice.add(4);
    Dice testDice = new Dice(valuesForDice);
    SumOfDiceValue optionOne = new SumOfDiceValue("Ones", 1);
    SumOfDiceValue optionTwo = new SumOfDiceValue("Twos", 2);
    SumOfDiceValue optionFour = new SumOfDiceValue("Fours", 4);
    Assert.assertEquals(2, optionOne.calculateScoreFromGivenDice(testDice));
    Assert.assertEquals(2, optionTwo.calculateScoreFromGivenDice(testDice));
    Assert.assertEquals(8, optionFour.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void onePairCalculatesTheSumOfTheSinglePair() {
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(2);
    valuesForDice.add(4);
    valuesForDice.add(4);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind onePair = new NumberOfAKind("One Pair", 2);
    Assert.assertEquals(8, onePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void onePairCalculatesWhenThreeOfAKindIsPresent() {
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(4);
    valuesForDice.add(4);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind onePair = new NumberOfAKind("One Pair", 2);
    Assert.assertEquals(8, onePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void onePairCalculatesTheSumOfTheLargestPairWhereTheLargerAppearsSecond() {
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(4);
    valuesForDice.add(4);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind onePair = new NumberOfAKind("One Pair", 2);
    Assert.assertEquals(8, onePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void onePairCalculatesTheSumOfTheLargestPairWhereTheLargerAppearsFirst() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(4);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind onePair = new NumberOfAKind("One Pair", 2);
    Assert.assertEquals(6, onePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void onePairCalculatesTheSumOfTwoOfTheDiceWhenThereAreThree() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(1);
    valuesForDice.add(4);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind onePair = new NumberOfAKind("One Pair", 2);
    Assert.assertEquals(6, onePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void twoPairCalculatesTheSumCorrectly() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(4);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind twoPair = new NumberOfAKind("Two Pair", 2, 2);
    Assert.assertEquals(8, twoPair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void twoPairCalculatesTheSumCorrectlyWhenFullhouseIsPresent() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(1);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind twoPair = new NumberOfAKind("Two Pair", 2, 2);
    Assert.assertEquals(8, twoPair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void threeOfAKindCalculatesTheSumCorrectly() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(1);
    valuesForDice.add(1);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind threePair = new NumberOfAKind("Three Of A Kind", 3);
    Assert.assertEquals(9, threePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void threeOfAKindCalculatesZeroWhenApplicable() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(2);
    valuesForDice.add(1);
    valuesForDice.add(1);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind threePair = new NumberOfAKind("Three Of A Kind", 3);
    Assert.assertEquals(0, threePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void threeOfAKindCalculatesTheSumCorrectlyWithPairPrior() {
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind threePair = new NumberOfAKind("Three Of A Kind", 3);
    Assert.assertEquals(9, threePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void fourOfAKindCalculatesTheSumCorrectly() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(1);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind threePair = new NumberOfAKind("Four Of A Kind", 4);
    Assert.assertEquals(12, threePair.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void smallStraightCalculatesTheSumCorrectly() {
    valuesForDice.add(1);
    valuesForDice.add(2);
    valuesForDice.add(3);
    valuesForDice.add(4);
    valuesForDice.add(5);
    Dice testDice = new Dice(valuesForDice);
    SmallStraight option = new SmallStraight("Small Straight");
    Assert.assertEquals(15, option.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void largeStraightCalculatesTheSumCorrectly() {
    valuesForDice.add(2);
    valuesForDice.add(3);
    valuesForDice.add(4);
    valuesForDice.add(5);
    valuesForDice.add(6);
    Dice testDice = new Dice(valuesForDice);
    LargeStraight option = new LargeStraight("Large Straight");
    Assert.assertEquals(20, option.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void chanceCalculatesCorrectAmountWithRandomCaseInput() {
    valuesForDice.add(4);
    valuesForDice.add(4);
    valuesForDice.add(5);
    valuesForDice.add(6);
    valuesForDice.add(1);
    Dice testDice = new Dice(valuesForDice);
    Chance option = new Chance("Chance");
    Assert.assertEquals(20, option.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void fullhouseCalculatesTheSumCorrectly() {
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind option = new NumberOfAKind("Full House", 3, 2);
    Assert.assertEquals(11, option.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void fullhouseOutputsZeroWhenPairAndThreeOfAKindAreSameNumber() {
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    valuesForDice.add(3);
    Dice testDice = new Dice(valuesForDice);
    NumberOfAKind option = new NumberOfAKind("Full House", 3, 2);
    Assert.assertEquals(15, option.calculateScoreFromGivenDice(testDice));
  }

  @Test
  public void yatzyCalculatesCorrectAmountInUpperCase() {
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(1);
    valuesForDice.add(1);
    Dice testDice = new Dice(valuesForDice);
    Yatzy option = new Yatzy("Yatzy");
    Assert.assertEquals(50, option.calculateScoreFromGivenDice(testDice));
  }
}
