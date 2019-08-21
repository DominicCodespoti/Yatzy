package yatzy.options;

import yatzy.Dice;
import yatzy.GameBoardOption;

public class SumOfDiceValue implements GameBoardOption {
    private String name;
    private int valueToSum;

    public SumOfDiceValue(String name, int valueToSum) {
        this.name = name;
        this.valueToSum = valueToSum;
    }

    @Override
    public String optionName() {
        return name;
    }

    @Override
    public int calculateScoreFromGivenDice(Dice dice) {
        return (int) dice.getNumberOfDiceWithValue(valueToSum) * valueToSum;
    }
}
