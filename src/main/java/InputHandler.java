import java.io.InputStream;
import java.util.Scanner;

final public class InputHandler {

    public static String validateAndReturnUserInputForGameBoardOptions(GameBoard gameBoardReference, InputStream inputStream)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        String userInput = initialInputReader.nextLine();
        GameBoard copyOfPlayerBoard = new GameBoard(gameBoardReference);
        if (copyOfPlayerBoard.getSpecificOptionOnBoard(userInput) != null) {
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
        if (userInput.matches("[0-9]*"))
            return userInput;
        else {
            System.out.println("Error: Input is not entirely made up of integers, try again:");
            validateAndReturnUserInputForNumbers(inputStream);
        }
        return "Error";
    }

    public static String validateAndReturnUserInputForNames(InputStream inputStream)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        return initialInputReader.nextLine();
    }

    public static int[] validateAndReturnUserInputForDiceReroll(InputStream inputStream)
    {
        Scanner initialInputReader = new Scanner(inputStream);
        String userInput = initialInputReader.next();
        if (userInput.matches("^(\\d(,?)){1,5}")) {
            String[] rawNumbersToKeepWhenRerolling = userInput.split(",");
            int[] arrayOfIntsBasedOnStringArray = new int[rawNumbersToKeepWhenRerolling.length];
            int i = 0;
            for (String str : rawNumbersToKeepWhenRerolling) {
                arrayOfIntsBasedOnStringArray[i] = Integer.parseInt(str.trim());
                i++;
            }
            return arrayOfIntsBasedOnStringArray;
        } else {
            System.out.println("Error: Input does not match pattern of 'number' (5) or 'number comma number repeat' (5,4) pattern, try again:");
            return validateAndReturnUserInputForDiceReroll(inputStream);
        }
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
