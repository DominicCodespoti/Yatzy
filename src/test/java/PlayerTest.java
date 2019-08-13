import org.junit.Assert;
import org.junit.Test;

public class PlayerTest
{
    @Test
    public void newPlayerHasZeroScore ()
    {
        Player testPlayer = new Player("testName");
        Assert.assertEquals(testPlayer.getPlayerScore(), 0);
    }

    @Test
    public void canCreateNewRobot ()
    {
        Player testPlayer = new Player("testRobot");
        testPlayer.setIsPlayerRobot(true);
        Assert.assertTrue(testPlayer.getIsPlayerRobot());
    }
}
