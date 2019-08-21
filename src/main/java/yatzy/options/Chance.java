package yatzy.options;

import yatzy.Dice;
import yatzy.GameBoardOption;

import java.util.Arrays;

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
