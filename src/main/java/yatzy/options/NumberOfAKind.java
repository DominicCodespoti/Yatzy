package yatzy.options;

import java.util.ArrayList;
import java.util.List;
import yatzy.Dice;
import yatzy.GameBoardOption;

public class NumberOfAKind implements GameBoardOption {

  private String name;
  private List<Integer> counts = new ArrayList<>();

  public NumberOfAKind(String name, int count) {
    this.name = name;
    this.counts.add(count);
  }

  public NumberOfAKind(String name, int firstCount, int secondCount) {
    this.name = name;
    if (firstCount > secondCount) {
      this.counts.add(firstCount);
      this.counts.add(secondCount);
    } else {
      this.counts.add(secondCount);
      this.counts.add(firstCount);
    }
  }

  @Override
  public String optionName() {
    return name;
  }

  @Override
  public int calculateScoreFromGivenDice(Dice dice) {
    int totalCount = this.counts.stream().mapToInt(it -> it).sum();
    List<Integer> diceValues = dice.getDiceValuesWithMinimumOccurrences(totalCount);
    if (!diceValues.isEmpty()) {
      return totalCount * diceValues.stream().reduce(0, Math::max);
    }

    List<Integer> matchedValues = new ArrayList<>();
    int cumulativeScore = 0;
    for (int count : counts) {
      int matchedValue = dice.getDiceValuesWithMinimumOccurrences(count).stream()
          .filter(it -> !matchedValues.contains(it)).reduce(0, Math::max);
      if (matchedValue == 0) {
        return 0;
      }
      matchedValues.add(matchedValue);
      cumulativeScore += count * matchedValue;
    }

    return cumulativeScore;
  }
}
