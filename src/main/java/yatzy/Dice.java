package yatzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class Dice {

  private static int NUMBER_OF_DICES = 5;
  private List<Integer> diceRollValues = new ArrayList<>();

  public Dice() {
    diceRollValues.addAll(getRandomNumbers(NUMBER_OF_DICES));
  }

  public Dice(List<Integer> oldDiceValues) {
    diceRollValues.addAll(oldDiceValues);
    while (diceRollValues.size() < NUMBER_OF_DICES) {
      diceRollValues.add(getRandomDiceValue());
    }
    diceRollValues.addAll(getRandomNumbers(NUMBER_OF_DICES - oldDiceValues.size()));
  }

  public long getNumberOfDiceWithValue(int value) {
    return diceRollValues.stream().filter(diceValue -> diceValue == value).count();
  }

  public Map<Integer, Integer> getDiceValueCounts() {
    return diceRollValues.stream().collect(Collectors
        .toMap(diceValue -> diceValue, diceValue -> 1, (oldValue, newValue) -> oldValue + 1));
  }

  public List<Integer> getDiceValuesWithMinimumOccurrences(int minimum) {
    return getDiceValueCounts().entrySet().stream().filter(entry -> entry.getValue() >= minimum)
        .map(Map.Entry::getKey).collect(Collectors.toList());
  }

  public int[] getSortedDiceValues() {
    return diceRollValues.stream().sorted().mapToInt(x -> x).toArray();
  }

  public int[] getAllDiceValues() {
    return diceRollValues.stream().mapToInt(x -> x).toArray();
  }

  private List<Integer> getRandomNumbers(int howManyNumbersToGenerate) {
    return Arrays.stream(new int[howManyNumbersToGenerate])
        .map(number -> getRandomDiceValue())
        .boxed()
        .collect(Collectors.toList());
  }

  private int getRandomDiceValue() {
    int numberOfSides = 6;
    return new Random().nextInt(numberOfSides) + 1;
  }
}
