import java.util.Random;

public class Dice {
    private int[] diceRollValues;

    public Dice() {
        diceRollValues = new int[5];
        simulateFiveDiceRolls();
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

    private void setSpecificDiceValue(int specificDice, int newDiceValue) {
        diceRollValues[specificDice] = newDiceValue;
    }

    private void simulateFiveDiceRolls() {
        int randomInt = new Random().nextInt(6);
        for (int diceIterator = 0; diceIterator < 5; diceIterator++) {
            randomInt++;
            setSpecificDiceValue(diceIterator, randomInt);
            randomInt = new Random().nextInt(6);
        }
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
