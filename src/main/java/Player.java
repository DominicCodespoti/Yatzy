public class Player {
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

    public boolean getIsPlayerBoardEmpty() {
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

    public int selectGameBoardOption(String selectedOption, int[] givenDice) {
        return personalGameBoard.getSpecificOptionOnBoard(selectedOption).calculateScoreFromGivenDice(givenDice);
    }

    public String selectHighestOptionOnGameBoardOption(int[] givenDice) {
        return personalGameBoard.getHighestScoringOptionID(givenDice);
    }
}

