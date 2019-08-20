public class Game {
    private static final int MAX_REROLL_COUNT = 3;

    public static void main(String[] args) throws InterruptedException {
        startGame();
    }

    private static void startGame() throws InterruptedException {
        Player[] listOfPlayers = new Player[1];
        listOfPlayers = initializePlayersBasedOnInput(listOfPlayers);
        listOfPlayers = gameLoop(listOfPlayers);
        OutputHandler.drawGameResults(listOfPlayers);
    }

    private static boolean checkIfWinConditionIsMet(Player[] playerList) {
        int playersWithEmptyBoard = 0;
        for (Player player : playerList) {
            if (player.getIsPlayerBoardEmpty())
                playersWithEmptyBoard++;
        }
        return playersWithEmptyBoard == playerList.length;
    }

    private static Player[] initializePlayersBasedOnInput(Player[] listOfPlayers) {
        String playerInput;
        System.out.println("Welcome to Yatzy! Would you like to play solo (0), against others (1), or against robots (2): ");
        playerInput = InputHandler.validateAndReturnUserInputForChoices(System.in, 2);

        switch (playerInput) {
            case "0":
                System.out.println("Great! You are playing solo, what is your name: ");
                playerInput = InputHandler.validateAndReturnUserInputForNames(System.in);
                listOfPlayers[0] = new Player(playerInput);
                System.out.println("Would you like to flag yourself as a robot (0) or a normal player (1): ");
                playerInput = InputHandler.validateAndReturnUserInputForChoices(System.in, 1);
                if (playerInput.equals("0"))
                    listOfPlayers[0].setIsPlayerRobot(true);
                return listOfPlayers;
            case "1":
                System.out.println("Great! How many other people are playing: ");
                playerInput = InputHandler.validateAndReturnUserInputForNumbers(System.in);
                listOfPlayers = new Player[Integer.parseInt(playerInput)];
                for (int playerIterator = 0; playerIterator < listOfPlayers.length; playerIterator++) {
                    System.out.println("What is the name of Player " + playerIterator + ": ");
                    playerInput = InputHandler.validateAndReturnUserInputForNames(System.in);
                    listOfPlayers[playerIterator] = new Player(playerInput);
                }
                return listOfPlayers;
            case "2":
                System.out.println("Great! How many robots would you like to play against: ");
                playerInput = String.valueOf(Integer.parseInt(InputHandler.validateAndReturnUserInputForNumbers(System.in)) + 1);
                listOfPlayers = new Player[Integer.parseInt(playerInput)];
                System.out.println("What is, what is your name: ");
                playerInput = InputHandler.validateAndReturnUserInputForNames(System.in);
                listOfPlayers[0] = new Player(playerInput);
                System.out.println("Would you like to flag yourself as a robot (0) or a normal player (1): ");
                playerInput = InputHandler.validateAndReturnUserInputForChoices(System.in, 1);
                if (playerInput.equals("0"))
                    listOfPlayers[0].setIsPlayerRobot(true);
                for (int playerIterator = 1; playerIterator < listOfPlayers.length; playerIterator++) {
                    System.out.println("What is the name of Robot " + playerIterator + ": ");
                    playerInput = InputHandler.validateAndReturnUserInputForNames(System.in);
                    listOfPlayers[playerIterator] = new Player(playerInput);
                    listOfPlayers[playerIterator].setIsPlayerRobot(true);
                }
                return listOfPlayers;
        }
        return listOfPlayers;
    }

    private static int changeCurrentPlayerTurn(int currentPlayerIterator, Player[] listOfPlayers) {
        System.out.println(listOfPlayers[currentPlayerIterator].getPlayerName() + ", your score is now:  " + listOfPlayers[currentPlayerIterator].getPlayerScore());
        if (currentPlayerIterator < listOfPlayers.length - 1) {
            System.out.println("It is now " + listOfPlayers[currentPlayerIterator + 1].getPlayerName() + "'s turn!");
            currentPlayerIterator++;
            return currentPlayerIterator;
        } else {
            System.out.println("It is now " + listOfPlayers[0].getPlayerName() + "'s turn!");
            currentPlayerIterator = 0;
            return currentPlayerIterator;
        }
    }

    private static Dice diceRollLoop(int currentPlayerIterator, Player[] listOfPlayers) throws InterruptedException {
        int rerollCount = 1;
        String playerInput = "1";

        Dice gameDice = null;
        while (Integer.parseInt(playerInput) != 0 && rerollCount != 3) {
            gameDice = new Dice();
            OutputHandler.printAllDiceRollValues(gameDice);
            boolean invalidReroll = false;

            System.out.println(listOfPlayers[currentPlayerIterator].getPlayerName() + ", are you happy with these values (0), or would you like to reroll (1): ");

            if (!listOfPlayers[currentPlayerIterator].getIsPlayerRobot())
                playerInput = InputHandler.validateAndReturnUserInputForChoices(System.in, 1);
            else {
                Thread.sleep(2000);
                playerInput = "0";
            }

            while (Integer.parseInt(playerInput) == 1 && rerollCount < MAX_REROLL_COUNT) {
                int amountOfDiceToRerollMatchGameDice;
                System.out.println("Please enter the numbers you would like to keep (Example: 2,3,1): "); //TODO: print dice
                int[] numbersToKeepWhenRerolling = InputHandler.validateAndReturnUserInputForDiceReroll(System.in);

                while (!invalidReroll) { //TODO: Fix bug where correct reroll fails
                    amountOfDiceToRerollMatchGameDice = 0;
                    for (int i : numbersToKeepWhenRerolling)
                        for (int diceIterator2 = 0; diceIterator2 < gameDice.getAllDiceValues().length; diceIterator2++)
                            if (i == gameDice.getAllDiceValues()[diceIterator2])
                                if (amountOfDiceToRerollMatchGameDice < numbersToKeepWhenRerolling.length)
                                    amountOfDiceToRerollMatchGameDice++;

                    if (amountOfDiceToRerollMatchGameDice != numbersToKeepWhenRerolling.length) {
                        System.out.println("Error: The dice you attempted to reroll do not match the below dice, try again: ");
                        OutputHandler.printAllDiceRollValues(gameDice);
                        numbersToKeepWhenRerolling = InputHandler.validateAndReturnUserInputForDiceReroll(System.in);
                    } else {
                        gameDice = new Dice(numbersToKeepWhenRerolling);
                        OutputHandler.printAllDiceRollValues(gameDice);
                        invalidReroll = true;
                    }
                }
                rerollCount++;
                System.out.println("You have " + (MAX_REROLL_COUNT - rerollCount) + " rerolls left. Are you happy with these values (0), or would you like to reroll (1): ");
                playerInput = InputHandler.validateAndReturnUserInputForChoices(System.in, 1);
                if (playerInput.equals("1")) {
                    OutputHandler.printAllDiceRollValues(gameDice);
                    invalidReroll = false;
                }
            }
        }
        return gameDice;
    }

    private static Player[] playerSelectGameOption(Dice gameDice, int currentPlayerIterator, Player[] listOfPlayers) throws InterruptedException {
        System.out.println("Here are the possible options on your scoreboard, please enter the name of the option you would like to pick: ");
        String playerInput;
        OutputHandler.drawGameBoard(gameDice, listOfPlayers[currentPlayerIterator].getPersonalGameBoard());
        if (!listOfPlayers[currentPlayerIterator].getIsPlayerRobot()) {
            playerInput = InputHandler.validateAndReturnUserInputForGameBoardOptions(listOfPlayers[currentPlayerIterator].getPersonalGameBoard(), System.in);
        } else {
            Thread.sleep(2000);
            playerInput = listOfPlayers[currentPlayerIterator].selectHighestOptionOnGameBoardOption(gameDice.getAllDiceValues());
        }
        int currentScore = listOfPlayers[currentPlayerIterator].selectGameBoardOption(playerInput, gameDice.getAllDiceValues());
        listOfPlayers[currentPlayerIterator].addToPlayerScore(currentScore);
        return listOfPlayers;
    }

    private static Player[] gameLoop(Player[] listOfPlayers) throws InterruptedException {
        int currentPlayerIterator = 0;
        while (!checkIfWinConditionIsMet(listOfPlayers)) {
            listOfPlayers = playerSelectGameOption(diceRollLoop(currentPlayerIterator, listOfPlayers), currentPlayerIterator, listOfPlayers);
            currentPlayerIterator = changeCurrentPlayerTurn(currentPlayerIterator, listOfPlayers);
        }
        return listOfPlayers;
    }
}

