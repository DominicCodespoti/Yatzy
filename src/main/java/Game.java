import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
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

    public static void startGame() {
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
            for (int playerIterator = 1; playerIterator < listOfPlayers.length; playerIterator++) {
                System.out.println("What is the name of Robot " + playerIterator + ": ");
                playerInput = readPlayerInput.nextLine();
                listOfPlayers[playerIterator] = new Player(playerInput);
                listOfPlayers[playerIterator].setIsPlayerRobot(true);
            }
        }
        while (!playerInput.equals("end turn")) //TODO: create win condition for loop
        {
            playerInput = "1";
            while (Integer.parseInt(playerInput) != 0) {
                gameDice.simulateFiveDiceRolls();
                gameDice.printAllDiceRollValues();

                System.out.println(listOfPlayers[currentPlayerIterator].getPlayerName() +  ", are you happy with these values (0), or would you like to reroll (1): ");
                playerInput = readPlayerInput.nextLine();

                while (Integer.parseInt(playerInput) == 1 && rerollCount < 4) {
                    System.out.println("Please enter the numbers you would like to keep (Example: 2,3,1): ");
                    playerInput = readPlayerInput.nextLine();

                    String[] rawNumbersToKeepWhenRerolling = playerInput.split(",");
                    numbersToKeepWhenRerolling = convertStringArrayToIntArray(rawNumbersToKeepWhenRerolling);

                    gameDice.rerollDiceWithoutSpecificValues(numbersToKeepWhenRerolling);
                    gameDice.printAllDiceRollValues();

                    System.out.println("Are you happy with these values (0), or would you like to reroll (1): ");
                    playerInput = readPlayerInput.nextLine();
                    rerollCount++;
                }
            }

            System.out.println("Here are the possible options on your scoreboard, please enter the name of the option you would like to pick: ");
            listOfPlayers[currentPlayerIterator].personalGameBoard.drawGameBoard(gameDice.getAllDiceValues());
            playerInput = readPlayerInput.nextLine();
            int currentScore = listOfPlayers[currentPlayerIterator].selectGameBoardOption(playerInput, gameDice.getAllDiceValues());
            listOfPlayers[currentPlayerIterator].addToPlayerScore(currentScore);

            System.out.println(listOfPlayers[currentPlayerIterator].getPlayerName() + ", your score is now:  " + listOfPlayers[currentPlayerIterator].getPlayerScore());
            System.out.println("It is now " + listOfPlayers[currentPlayerIterator].getPlayerName() + "'s turn!");

            rerollCount = 0;
            if (currentPlayerIterator < listOfPlayers.length - 1)
                currentPlayerIterator++;
            else
                currentPlayerIterator = 0;
        }
    }
}
