import com.sun.org.apache.bcel.internal.generic.PUSH;

import java.util.Scanner;

public class Game
{
    public static void main (String[] args)
    {
        startGame();
    }

    public static void startGame()
    {
        Scanner readPlayerInput = new Scanner(System.in);
        Dice gameDice = new Dice();
        String playerInput;

        System.out.println("Welcome to Yatzy! Would you like to play solo (0), against others (1), or against robots (2): ");

    }
}
