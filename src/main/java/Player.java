public class Player
{
    private String playerName;
    private int playerScore;
    public GameBoard personalGameBoard;
    //private boolean isRobot = false;
/*
    public boolean getIsPlayerRobot()
    {
        return isRobot;
    }

    public void setIsPlayerRobot (boolean robot)
    {
        isRobot = robot;
    }
*/
    public Player(String playerName)
    {
        setPlayerScore(0);
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
}
