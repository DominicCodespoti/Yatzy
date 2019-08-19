import org.junit.Test;

public class OutputHandlerTest {
    @Test
    public void printBoardInOrderPrintsInCorrectOrder() {
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

    @Test
    public void printDicePrintsCorrectly() {
        Dice testDice = new Dice();
        OutputHandler.printAllDiceRollValues(testDice.getAllDiceValues());
        Dice testDice2 = new Dice(new int[]{2,3});
        OutputHandler.printAllDiceRollValues(testDice2.getAllDiceValues());
    }
}
