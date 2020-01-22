
/**
 * Write a description of class Craps here.
 *
 * @author Trent Steele
 * @version (a version number or a date)
 */
import java.util.Scanner;

public class Craps
{
    public static void giveInstructions(Scanner in)
    {
        System.out.println("Would like instructions on how to play?(y/n)");
        String play = in.nextLine();
        if (play.equals("") || play.substring(0,1).equalsIgnoreCase("y"))
        {
            System.out.println("1. Roll tow dice and add them together");
            System.out.println("2. If you get a 7 or 11 on the first roll you win, ");
            System.out.println(" but if you get a 2, 3, or 12, you lose.");
            System.out.println(" Any other number you roll becomes your point...");
            System.out.println("3.  If you didnt win or lose on the first roll, keep rolling until: ");
            System.out.println("    a. you roll your point again, and win!");
            System.out.println("    b. you roll a 7, and lose. :(");
        }
    }

    public static int rollTheDice(Scanner in, Die d1)
    {
        System.out.println("Press <Enter> to roll...");
        in.nextLine(); //Don't need to save their input
        int result1 = d1.roll();
        int result2 = d1.roll();
        int total = result1 + result2;
        System.out.println("You rolled a " + result1 + " and a " + result2 + " for a total of " + total +".");
        return total;
    }

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        Die d = new Die();
        System.out.println("Game of Craps");
        giveInstructions(in);
        String playStatus = "y";
        while(playStatus.equals("y"))
        {
            System.out.println("DEBUG: We're playing Craps..."); 
            int result = rollTheDice(in, d);
            if(result == 7 || result == 11)
            {
                System.out.println("You win!");
            }
            else if(result == 2 || result == 3 || result == 12)
            {
                System.out.println("You lose :(");
            }
            else
            {
                int point = result;
                System.out.println("Your point is "+ point + ". Try to roll it again");
                result = rollTheDice(in, d);
                while(result != 7 && result != point)
                {
                    System.out.println("Roll again");
                    result = rollTheDice(in, d);
                }
                if(result == point)
                {
                    System.out.println("You win!");
                }
                else
                {
                    System.out.println("You lose :(");
                }
                System.out.println("Would you like to play again (y/n)?");
                playStatus = in.nextLine();
            }
            if(playStatus.equals(""))
            {
                playStatus = "y";
            }
            System.out.println("Thanks for playing our game! Come again.");
        }
    }
}