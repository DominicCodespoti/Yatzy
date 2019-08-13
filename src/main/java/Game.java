import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.Scanner;

public class Game {
    private static final int MAX_REROLL_COUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        startGame();
    }

    private static int[] convertStringArrayToIntArray(String[] strings) {
        int[] intarray = new int[strings.length];
        int i = 0;
        for (String str : strings) {
            intarray[i] = Integer.parseInt(str.trim());
            i++;
        }
        return intarray;
    }

    private static boolean checkIfWinConditionIsMet(Player[] playerList) {
        int playersWithEmptyBoard = 0;
        for (int playerListIterator = 0; playerListIterator < playerList.length; playerListIterator++) {
            if (playerList[playerListIterator].getPersonalGameBoard().isGameBoardEmpty())
                playersWithEmptyBoard++;
        }
        if (playersWithEmptyBoard == playerList.length)
            return true;
        return false;
    }

    public static void startGame() throws InterruptedException {
        Scanner readPlayerInput = new Scanner(System.in);
        int[] numbersToKeepWhenRerolling;
        Dice gameDice = new Dice();
        String playerInput;
        Player[] listOfPlayers = new Player[1];
        int currentPlayerIterator = 0;
        int rerollCount = 0;

        System.out.println("Welcome to Yatzy! Would you like to play solo (0), against others (1), or against robots (2): ");
        playerInput = readPlayerInput.nextLine();

        if (playerInput.equals("0")) {
            System.out.println("Great! You are playing solo, what is your name: ");
            playerInput = readPlayerInput.nextLine();
            listOfPlayers[0] = new Player(playerInput);
        }

        if (playerInput.equals("1")) {
            System.out.println("Great! How many other people are playing: ");
            playerInput = readPlayerInput.nextLine();
            listOfPlayers = new Player[Integer.parseInt(playerInput)];
            for (int playerIterator = 0; playerIterator < listOfPlayers.length; playerIterator++) {
                System.out.println("What is the name of Player " + playerIterator + ": ");
                playerInput = readPlayerInput.nextLine();
                listOfPlayers[playerIterator] = new Player(playerInput);
            }
        }

        if (playerInput.equals("2")) {
            System.out.println("Great! How many robots would you like to play against: ");
            playerInput = String.valueOf(Integer.parseInt(readPlayerInput.nextLine()) + 1);
            listOfPlayers = new Player[Integer.parseInt(playerInput)];
            System.out.println("What is, what is your name: ");
            playerInput = readPlayerInput.nextLine();
            listOfPlayers[0] = new Player(playerInput);
            for (int playerIterator = 1; playerIterator < listOfPlayers.length; playerIterator++) {
                System.out.println("What is the name of Robot " + playerIterator + ": ");
                playerInput = readPlayerInput.nextLine();
                listOfPlayers[playerIterator] = new Player(playerInput);
                listOfPlayers[playerIterator].setIsPlayerRobot(true);
            }
        }

        while (!checkIfWinConditionIsMet(listOfPlayers)) //TODO: create win condition for loop
        {
            playerInput = "1";
            while (Integer.parseInt(playerInput) != 0) {
                gameDice.simulateFiveDiceRolls();
                gameDice.printAllDiceRollValues();

                System.out.println(listOfPlayers[currentPlayerIterator].getPlayerName() + ", are you happy with these values (0), or would you like to reroll (1): ");
                if (!listOfPlayers[currentPlayerIterator].getIsPlayerRobot())
                    playerInput = readPlayerInput.nextLine();
                else {
                    Thread.sleep(2000);
                    playerInput = "0";
                }

                while (Integer.parseInt(playerInput) == 1 && rerollCount < MAX_REROLL_COUNT) {
                    System.out.println("Please enter the numbers you would like to keep (Example: 2,3,1): ");
                    playerInput = readPlayerInput.nextLine();

                    String[] rawNumbersToKeepWhenRerolling = playerInput.split(",");
                    numbersToKeepWhenRerolling = convertStringArrayToIntArray(rawNumbersToKeepWhenRerolling);

                    gameDice.rerollDiceWithoutSpecificValues(numbersToKeepWhenRerolling);
                    gameDice.printAllDiceRollValues();

                    rerollCount++;
                    System.out.println("You have " + (MAX_REROLL_COUNT - rerollCount - 1) + " rerolls left. Are you happy with these values (0), or would you like to reroll (1): ");
                    playerInput = readPlayerInput.nextLine();
                }
            }

            System.out.println("Here are the possible options on your scoreboard, please enter the name of the option you would like to pick: ");
            listOfPlayers[currentPlayerIterator].getPersonalGameBoard().drawGameBoard(gameDice.getAllDiceValues());
            if (!listOfPlayers[currentPlayerIterator].getIsPlayerRobot())
                playerInput = readPlayerInput.nextLine();
            else {
                Thread.sleep(2000);
                playerInput = listOfPlayers[currentPlayerIterator].selectHighestOptionOnGameBoardOption(gameDice.getAllDiceValues());
            }

            int currentScore = listOfPlayers[currentPlayerIterator].selectGameBoardOption(playerInput, gameDice.getAllDiceValues());
            listOfPlayers[currentPlayerIterator].addToPlayerScore(currentScore);

            System.out.println(listOfPlayers[currentPlayerIterator].getPlayerName() + ", your score is now:  " + listOfPlayers[currentPlayerIterator].getPlayerScore());

            rerollCount = 0;
            if (currentPlayerIterator < listOfPlayers.length - 1) {
                System.out.println("It is now " + listOfPlayers[currentPlayerIterator + 1].getPlayerName() + "'s turn!");
                currentPlayerIterator++;
            } else {
                System.out.println("It is now " + listOfPlayers[0].getPlayerName() + "'s turn!");
                currentPlayerIterator = 0;
            }
        }
        System.out.println("Game over!");
    }
}
