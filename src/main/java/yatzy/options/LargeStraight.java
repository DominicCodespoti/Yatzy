package yatzy.options;

import yatzy.Dice;
import yatzy.GameBoardOption;

public class LargeStraight implements GameBoardOption {
    private String name;

    public LargeStraight(String name) {
        this.name = name;
    }

    public String optionName() {
        return name;
    }

    public int calculateScoreFromGivenDice(Dice dice) {
        int[] givenDice = dice.getSortedDiceValues();
        return givenDice[0] == 2 && givenDice[1] == 3 && givenDice[2] == 4 && givenDice[3] == 5 && givenDice[4] == 6 ? 20 : 0;
    }
}
