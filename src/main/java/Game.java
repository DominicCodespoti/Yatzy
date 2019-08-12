import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.Scanner;

public class Game
{
    public static void main (String[] args)
    {
        startGame();
    }

    public static void turnInstance()
    {

    }

    public static void startGame()
    {
        Scanner readPlayerInput = new Scanner(System.in);
        Dice gameDice = new Dice();
        String playerInput;
        Player[] listOfPlayers;

        System.out.println("Welcome to Yatzy! Would you like to play solo (0), against others (1), or against robots (2): ");
        playerInput = readPlayerInput.nextLine();

        if (playerInput.equals("0"))
        {
            System.out.println("Great! You are playing solo, lets start! ");
            playerInput = readPlayerInput.nextLine();
        }

        if (playerInput.equals("1"))
        {
            System.out.println("Great! How many other people are playing: ");
            playerInput = readPlayerInput.nextLine();
            listOfPlayers = new Player[Integer.parseInt(playerInput)];
            for (int playerIterator = 0; playerIterator < listOfPlayers.length; playerIterator++)
            {
                System.out.println("What is the name of Player " + playerIterator + ": ");
                playerInput = readPlayerInput.nextLine();
                listOfPlayers[playerIterator] = new Player(playerInput);
            }
        }

        if (playerInput.equals("2"))
        {
            System.out.println("Great! How many robots would you like to play against: ");
            playerInput = readPlayerInput.nextLine();
            listOfPlayers = new Player[Integer.parseInt(playerInput)];
            for (int playerIterator = 1; playerIterator < listOfPlayers.length; playerIterator++)
            {
                System.out.println("What is the name of Robot " + playerIterator + ": ");
                playerInput = readPlayerInput.nextLine();
                listOfPlayers[playerIterator] = new Player(playerInput);
                //listOfPlayers[playerIterator].setIsPlayerRobot(true);
            }
        }
        while (!readPlayerInput.nextLine().equals("end turn"))
        {

        }
    }
}
