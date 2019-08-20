import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

final public class OutputHandler {
    public static void drawGameResults(Player[] listOfPlayers) {
        System.out.println("Congratulations, you have reached the end of the game! Here are your scores: ");
        List<Player> sortedUsers = Arrays.stream(listOfPlayers).sorted(Comparator.comparing(Player::getPlayerScore).reversed()).collect(Collectors.toList());
        sortedUsers.forEach(currentPlayer -> System.out.println(currentPlayer.getPlayerName() + ": " + currentPlayer.getPlayerScore()));
    }

    public static void printAllDiceRollValues(Dice gameDice) {
        int[] diceRollValues = gameDice.getAllDiceValues();
        for (int diceIterator = 0; diceIterator < 5; diceIterator++)
            if (diceIterator < 4)
                System.out.print(diceRollValues[diceIterator] + ", ");
            else
                System.out.print(diceRollValues[diceIterator] + "\n");
    }

    public static void drawGameBoard(Dice gameDice, GameBoard givenGameBoard) {
        int[] givenDice = gameDice.getAllDiceValues();
        System.out.println("---------------------------------");
        for (GameBoardOptions gameBoardOptions : givenGameBoard.getOptionsOnGameBoard())
            System.out.println(gameBoardOptions.calculateStringForScoreBoard(givenDice));
        System.out.println("---------------------------------");
    }
}
