package yatzy;

import yatzy.options.*;

public class GameBoard {
    private GameBoardOption[] optionsOnGameBoard;

    public GameBoard() {
        optionsOnGameBoard = new GameBoardOption[]{
                new SumOfDiceValue("Ones", 1),
                new SumOfDiceValue("Twos", 2),
                new SumOfDiceValue("Threes", 3),
                new SumOfDiceValue("Fives", 5),
                new SumOfDiceValue("Fours", 4),
                new SumOfDiceValue("Sixes", 6),
                new NumberOfAKind("One Pair", 2),
                new NumberOfAKind("Three Of A Kind", 3),
                new NumberOfAKind("Four Of A Kind", 4),
                new NumberOfAKind("Two Pair", 2, 2),
                new NumberOfAKind("Full House", 3, 2),

                new SmallStraight("Small Straight"),
                new LargeStraight("Large Straight"),
                new Chance("Chance"),
                new Yatzy("Yatzy")
        };
    }

    public GameBoard(GameBoard anotherGameBoard) {
        this.optionsOnGameBoard = anotherGameBoard.optionsOnGameBoard;
    }

    private static GameBoardOption[] removeOptionFromGameBoardAtIndex(GameBoardOption[] originalArray, int index) {
        if (originalArray == null || index < 0 || index >= originalArray.length) {
            return originalArray;
        }
        GameBoardOption[] copyOfOriginalArrayWithOptionRemoved = new GameBoardOption[originalArray.length - 1];
        for (int arrayIterator = 0, arrayIteratorPlusOne = 0; arrayIterator < originalArray.length; arrayIterator++) {
            if (arrayIterator == index) {
                continue;
            }
            copyOfOriginalArrayWithOptionRemoved[arrayIteratorPlusOne++] = originalArray[arrayIterator];
        }
        return copyOfOriginalArrayWithOptionRemoved;
    }

    public boolean isGameBoardEmpty() {
        return optionsOnGameBoard.length == 0;
    }

    public GameBoardOption getSpecificOptionOnBoard(String userInput) {
        for (int boardOptionIterator = 0; boardOptionIterator < optionsOnGameBoard.length; boardOptionIterator++) {
            if (optionsOnGameBoard[boardOptionIterator].optionName().toLowerCase().equals(userInput.toLowerCase())) {
                GameBoardOption copyOfSelectedOption = optionsOnGameBoard[boardOptionIterator];
                optionsOnGameBoard = removeOptionFromGameBoardAtIndex(optionsOnGameBoard, boardOptionIterator);
                return copyOfSelectedOption;
            }
        }
        return null;
    }

    public String getHighestScoringOptionID(Dice givenDice) {
        int highestScoringOptionValue = 0;
        int highestScoringOptionIndex = 0;

        for (int boardOptionIterator = 0; boardOptionIterator < optionsOnGameBoard.length; boardOptionIterator++) {
            for (int boardOptionIteratorAhead = 0; boardOptionIteratorAhead < optionsOnGameBoard.length; boardOptionIteratorAhead++)
                if (optionsOnGameBoard[boardOptionIteratorAhead].calculateScoreFromGivenDice(givenDice) > highestScoringOptionValue) {
                    highestScoringOptionIndex = boardOptionIteratorAhead;
                    highestScoringOptionValue = optionsOnGameBoard[boardOptionIteratorAhead].calculateScoreFromGivenDice(givenDice);
                }
        }
        return optionsOnGameBoard[highestScoringOptionIndex].optionName();
    }

    GameBoardOption[] getOptionsOnGameBoard() {
        return optionsOnGameBoard;
    }
}
