import org.junit.Test;

public class OutputHandlerTest {
    @Test
    public void onesTwosFoursAllCalculateCorrectWhenOccuringTogether() {
        Player[] testPlayerArray = new Player[5];
        testPlayerArray[0] = new Player("Todd");
        testPlayerArray[1] = new Player("Mitch");
        testPlayerArray[2] = new Player("Jack");
        testPlayerArray[3] = new Player("Lemon");
        testPlayerArray[4] = new Player("Dicky");

        testPlayerArray[0].addToPlayerScore(25);
        testPlayerArray[1].addToPlayerScore(50);
        testPlayerArray[2].addToPlayerScore(30);
        testPlayerArray[3].addToPlayerScore(45);
        testPlayerArray[4].addToPlayerScore(45);

        OutputHandler.drawGameResults(testPlayerArray);
    }
}
