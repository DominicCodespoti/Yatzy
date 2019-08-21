package yatzy.options;

import yatzy.Dice;
import yatzy.GameBoardOption;

public class SmallStraight implements GameBoardOption {
    private String name;

    public SmallStraight(String name) {
        this.name = name;
    }

    public String optionName() {
        return name;
    }

    public int calculateScoreFromGivenDice(Dice dice) {
        int[] givenDice = dice.getSortedDiceValues();
        return givenDice[0] == 1 && givenDice[1] == 2 && givenDice[2] == 3 && givenDice[3] == 4 && givenDice[4] == 5 ? 15 : 0;
    }
}
