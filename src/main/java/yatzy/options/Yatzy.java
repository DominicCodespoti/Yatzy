package yatzy.options;

import yatzy.Dice;
import yatzy.GameBoardOption;

public class Yatzy implements GameBoardOption {

  private String name;

  public Yatzy(String name) {
    this.name = name;
  }

  public String optionName() {
    return name;
  }

  public int calculateScoreFromGivenDice(Dice dice) {
    return dice.getDiceValuesWithMinimumOccurrences(5).size() != 0 ? 50 : 0;
  }
}
