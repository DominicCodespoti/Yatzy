import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;
import java.lang.Integer;

public class Dice {
    private int[] diceRollValues;
    private final int NUMBER_OF_SIDES = 6;
    private final int NUMBER_OF_DICES = 5;

    public Dice() {
        diceRollValues = getRandomNumbers(NUMBER_OF_DICES);
    }

    public Dice(int[] oldDiceValues) {
        Integer[] both = Stream.of(
                Arrays.stream(oldDiceValues).boxed().toArray(Integer[]::new),
                Arrays.stream(getRandomNumbers(NUMBER_OF_DICES - oldDiceValues.length)).boxed().toArray(Integer[]::new))
                .flatMap(Stream::of).toArray(Integer[]::new);
        diceRollValues = Arrays.stream(both).mapToInt(Integer::intValue).toArray();
    }

    public int getSpecificDiceRollsValue(int specificDice) {
        return diceRollValues[specificDice];
    }

    public int[] getAllDiceValues() {
        return diceRollValues;
    }

    private int[] getRandomNumbers(int howManyNumbersToGenerate) {
        return Arrays.stream(new int[howManyNumbersToGenerate])
                .map(number -> (new Random().nextInt(NUMBER_OF_SIDES) + 1))
                .toArray();
    }
}
