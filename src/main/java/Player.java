public class Player
{
    private String playerName;
    private int playerScore;
    public GameBoard personalGameBoard;
    private boolean isRobot = false;

    public boolean getIsPlayerRobot()
    {
        return isRobot;
    }

    public void setIsPlayerRobot (boolean robot)
    {
        isRobot = robot;
    }

    public int selectGameBoardOption(String selectedOption, int[] givenDice)
    {
        return personalGameBoard.getSpecificOptionOnBoard(selectedOption).calculateScoreFromGivenDice(givenDice);
    }

    public Player(String playerName)
    {
        setPlayerScore(0);
        personalGameBoard = new GameBoard();
        this.playerName = playerName;
    }

    public int getPlayerScore ()
    {
        return playerScore;
    }
    public void setPlayerScore (int playerScore)
    {
        this.playerScore = playerScore;
    }

    public void addToPlayerScore (int playerScore)
    {
        this.playerScore += playerScore;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}

