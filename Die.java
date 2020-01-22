
/**
 * Write a description of class Die here.
 *
 * @author Trent Steele
 * @version (a version number or a date)
 */
public class Die
{
    private int result;

    /**
     * Constructor for objects of class Die
     */
    public Die()
    {
        
    }

    /**
     * This method rolls the dice
     *
     * @return the result of the rolled dice
     */
    public int roll()
    {
        // put your code here
        int result = (int)(Math.random() * 6 + 1);
        return result;
    }
    
    /**
     * this method returns the result of the rolled die
     * @return result of rolled die
     */
    public int getResult()
    {
        int r1 = roll();
        int r2 = roll();
        int totR = r1 + r2;
        return totR; 
    }
}
