import java.io.InputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

final public class InputHandler {

    public static String validateAndReturnUserInputForGameBoardOptions(GameBoard gameBoardReference, InputStream inputStream)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        String userInput = initialInputReader.nextLine();
        if (gameBoardReference.getSpecificOptionOnBoard(userInput) != null) {
            return userInput;
        } else {
            System.out.println("Error: Input is not one of the possible board options, try again:");
            validateAndReturnUserInputForGameBoardOptions(gameBoardReference, inputStream);
        }
        return "Error";
    }

    public static String validateAndReturnUserInputForNumbers(InputStream inputStream)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        String userInput = initialInputReader.nextLine();
        if ((Pattern.compile("[0-9]*").matcher(userInput).find())) {
            return userInput;
        } else {
            System.out.println("Error: Input does not match pattern of 'number' (5) or 'number comma number repeat' (5,4) pattern, try again:");
            validateAndReturnUserInputForNumbers(inputStream);
        }
        return "Error";
    }

    public static String validateAndReturnUserInputForNames(InputStream inputStream)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        return initialInputReader.nextLine();
    }

    public static String validateAndReturnUserInputForDiceReroll(InputStream inputStream)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        String userInput = initialInputReader.next();
        if (userInput.matches("^(\\d(,?)){1,5}")) {
            return userInput;
        } else {
            System.out.println("Error: Input does not match pattern of 'number' (5) or 'number comma number repeat' (5,4) pattern, try again:");
            validateAndReturnUserInputForDiceReroll(inputStream);
        }
        return "Error";
    }

    public static String validateAndReturnUserInputForChoices(InputStream inputStream, Integer boundaryInput)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        String userInput = initialInputReader.nextLine();
        if (userInput.matches("^[0-" + boundaryInput + "]")) {
            return userInput;
        } else {
            System.out.println("Error: Please input a value between 0 and " + boundaryInput + " :");
            validateAndReturnUserInputForDiceReroll(inputStream);
        }
        return "Error";
    }
}
