package yatzy;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Player {
    private static final int MAX_REROLL_COUNT = 3;

    private String playerName;
    private int playerScore;
    private boolean isRobot = false;
    private GameBoard personalGameBoard;

    public Player(String playerName) {
        personalGameBoard = new GameBoard();
        this.playerName = playerName;
    }

    public GameBoard getPersonalGameBoard() {
        return personalGameBoard;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isFinished() {
        return personalGameBoard.isGameBoardEmpty();
    }

    public boolean getIsPlayerRobot() {
        return isRobot;
    }

    public void setIsPlayerRobot(boolean robot) {
        isRobot = robot;
    }

    public void addToPlayerScore(int playerScore) {
        this.playerScore += playerScore;
    }

    public int selectGameBoardOption(String selectedOption, Dice dice) {
        return personalGameBoard.getSpecificOptionOnBoard(selectedOption).calculateScoreFromGivenDice(dice);
    }

    public String selectHighestOptionOnGameBoardOption(Dice dice) {
        return personalGameBoard.getHighestScoringOptionID(dice);
    }

    public void takeTurn() {
        Dice diceRoll = rollDice();
        selectGameOption(diceRoll);
        printCurrentPlayerScore(this);
    }

    public Dice rollDice() {
        int rerollCount = 1;
        String playerInput = "1";

        Dice gameDice = null;
        while (Integer.parseInt(playerInput) != 0 && rerollCount != 3) {
            gameDice = new Dice();
            OutputHandler.printAllDiceRollValues(gameDice);
            boolean invalidReroll = false;

            System.out.println(getPlayerName() + ", are you happy with these values (0), or would you like to reroll (1): ");

            if (!getIsPlayerRobot())
                playerInput = String.valueOf(InputHandler.validateAndReturnUserInputForChoices(System.in, 1));
            else {
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
                        gameDice = new Dice(Arrays.stream(numbersToKeepWhenRerolling).boxed().collect(Collectors.toList()));
                        OutputHandler.printAllDiceRollValues(gameDice);
                        invalidReroll = true;
                    }
                }
                rerollCount++;
                System.out.println("You have " + (MAX_REROLL_COUNT - rerollCount) + " rerolls left. Are you happy with these values (0), or would you like to reroll (1): ");
                playerInput = String.valueOf(InputHandler.validateAndReturnUserInputForChoices(System.in, 1));
                if (playerInput.equals("1")) {
                    OutputHandler.printAllDiceRollValues(gameDice);
                    invalidReroll = false;
                }
            }
        }
        return gameDice;
    }

    public void selectGameOption(Dice gameDice) {
        System.out.println("Here are the possible options on your scoreboard, please enter the name of the option you would like to pick: ");
        String playerInput;
        OutputHandler.drawGameBoard(gameDice, getPersonalGameBoard());
        if (!getIsPlayerRobot()) {
            playerInput = InputHandler.validateAndReturnUserInputForGameBoardOptions(getPersonalGameBoard(), System.in);
        } else {
            playerInput = selectHighestOptionOnGameBoardOption(gameDice);
        }
        int currentScore = selectGameBoardOption(playerInput, gameDice);
        addToPlayerScore(currentScore);
    }

    private void printCurrentPlayerScore(Player listOfPlayer) {
        System.out.println(listOfPlayer.getPlayerName() + ", your score is now:  " + listOfPlayer.getPlayerScore());
    }
}
