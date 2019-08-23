package yatzy.options;

import java.util.Arrays;
import yatzy.Dice;
import yatzy.GameBoardOption;

public class Chance implements GameBoardOption {

  private String name;

  public Chance(String name) {
    this.name = name;
  }

  public String optionName() {
    return name;
  }

  public int calculateScoreFromGivenDice(Dice dice) {
    return Arrays.stream(dice.getAllDiceValues()).sum();
  }
}
