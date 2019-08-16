public class GameBoard {
    private GameBoardOptions[] optionsOnGameBoard;

    private static GameBoardOptions[] removeOptionFromGameBoardAtIndex(GameBoardOptions[] originalArray, int index) {
        if (originalArray == null || index < 0 || index >= originalArray.length) {
            return originalArray;
        }
        GameBoardOptions[] copyOfOriginalArrayWithOptionRemoved = new GameBoardOptions[originalArray.length - 1];
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

    public GameBoardOptions getSpecificOptionOnBoard(String userInput) {
        for (int boardOptionIterator = 0; boardOptionIterator < optionsOnGameBoard.length; boardOptionIterator++) {
            if (optionsOnGameBoard[boardOptionIterator].calculateBoardOptionID().equals(userInput.toLowerCase())) {
                GameBoardOptions copyOfSelectedOption = optionsOnGameBoard[boardOptionIterator];
                optionsOnGameBoard = removeOptionFromGameBoardAtIndex(optionsOnGameBoard, boardOptionIterator);
                return copyOfSelectedOption;
            }
        }
        return null;
    }

    public GameBoard() {
        optionsOnGameBoard = new GameBoardOptions[15];
        optionsOnGameBoard[0] = new GameBoardOptions.Ones();
        optionsOnGameBoard[1] = new GameBoardOptions.Twos();
        optionsOnGameBoard[2] = new GameBoardOptions.Threes();
        optionsOnGameBoard[3] = new GameBoardOptions.Fours();
        optionsOnGameBoard[4] = new GameBoardOptions.Fives();
        optionsOnGameBoard[5] = new GameBoardOptions.Sixes();
        optionsOnGameBoard[6] = new GameBoardOptions.OnePair();
        optionsOnGameBoard[7] = new GameBoardOptions.TwoPair();
        optionsOnGameBoard[8] = new GameBoardOptions.ThreeOfAKind();
        optionsOnGameBoard[9] = new GameBoardOptions.FourOfAKind();
        optionsOnGameBoard[10] = new GameBoardOptions.SmallStraight();
        optionsOnGameBoard[11] = new GameBoardOptions.LargeStraight();
        optionsOnGameBoard[12] = new GameBoardOptions.Chance();
        optionsOnGameBoard[13] = new GameBoardOptions.FullHouse();
        optionsOnGameBoard[14] = new GameBoardOptions.Yatzy();
    }

    public String getHighestScoringOptionID(int[] givenDice) {
        int highestScoringOptionValue = 0;
        int highestScoringOptionIndex = 0;

        for (int boardOptionIterator = 0; boardOptionIterator < optionsOnGameBoard.length; boardOptionIterator++) {
            for (int boardOptionIteratorAhead = 0; boardOptionIteratorAhead < optionsOnGameBoard.length; boardOptionIteratorAhead++)
                if (optionsOnGameBoard[boardOptionIteratorAhead].calculateScoreFromGivenDice(givenDice) > highestScoringOptionValue) {
                    highestScoringOptionIndex = boardOptionIteratorAhead;
                    highestScoringOptionValue = optionsOnGameBoard[boardOptionIteratorAhead].calculateScoreFromGivenDice(givenDice);
                }
        }
        return optionsOnGameBoard[highestScoringOptionIndex].calculateBoardOptionID();
    }

    public void drawGameBoard(int[] givenDice) {
        System.out.println("---------------------------------");
        for (GameBoardOptions gameBoardOptions : optionsOnGameBoard) {
            System.out.println(gameBoardOptions.calculateStringForScoreBoard(givenDice));
        }
        System.out.println("---------------------------------");
    }
}
