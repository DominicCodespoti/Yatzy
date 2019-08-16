import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Dice {
    private int[] diceRollValues;
    private final int NUMBER_OF_DICE = 5;
    private final int NUMBER_OF_SIDES = 6;

    public Dice() {
        diceRollValues = new int[NUMBER_OF_DICE];
        diceRollValues = simulateFiveDiceRolls();
    }

    public boolean checkIfDiceRollMatchesValue(int valueBeingSearchedFor, int[] diceArrayToCheck) {
        for (int element : diceArrayToCheck) {
            if (element == valueBeingSearchedFor) {
                return true;
            }
        }
        return false;
    }

    public int getSpecificDiceRollsValue(int specificDice) {
        return diceRollValues[specificDice];
    }

    public int[] getAllDiceValues() {
        return diceRollValues;
    }

    private int[] simulateFiveDiceRolls() {
        return Arrays.stream(new int[5])
                .map(number -> (new Random().nextInt(NUMBER_OF_SIDES) + 1))
                .toArray();
    }

    public void rerollDiceWithoutSpecificValues(int[] arrayOfDiceToKeep) // 1,2
    {
        int[] copyOfCurrentDiceRollValues = diceRollValues.clone();
        simulateFiveDiceRolls();
        for (int diceIterator = 0; diceIterator < arrayOfDiceToKeep.length; diceIterator++)
            if (checkIfDiceRollMatchesValue(arrayOfDiceToKeep[diceIterator], copyOfCurrentDiceRollValues)) {
                diceRollValues[diceIterator] = arrayOfDiceToKeep[diceIterator];
            }
    }
}
