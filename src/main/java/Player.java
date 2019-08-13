public class Player {
    private String playerName;
    private int playerScore;
    private boolean isRobot = false;
    private GameBoard personalGameBoard;

    public Player(String playerName) {
        setPlayerScore(0);
        personalGameBoard = new GameBoard();
        this.playerName = playerName;
    }

    public boolean getIsPlayerRobot() {
        return isRobot;
    }

    public void setIsPlayerRobot(boolean robot) {
        isRobot = robot;
    }

    public int selectGameBoardOption(String selectedOption, int[] givenDice) {
        return personalGameBoard.getSpecificOptionOnBoard(selectedOption).calculateScoreFromGivenDice(givenDice);
    }

    public String selectHighestOptionOnGameBoardOption(int[] givenDice) {
        return personalGameBoard.getHighestScoringOptionID(givenDice);
    }

    public GameBoard getPersonalGameBoard() {
        return personalGameBoard;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public void addToPlayerScore(int playerScore) {
        this.playerScore += playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public boolean isPlayerBoardEmpty() {
        return personalGameBoard.isGameBoardEmpty();
    }
}

