/**
 * A graphical class that prints out the grid of the PegGame
 * 
 * @author Alan Lekah
 * @version 1.0
 */
public class Grid
{
    protected Board b;
    protected Player p;
    protected AI c;
    protected boolean hintStatus;
    protected int[] hintArr;
    public static final int EMPTY_LINES = 30;

    /**
     * Constructor for objects of class Grid
     * @param  board   The board object
     * @param  player  The player object
     * @param  computer  The AI object
     */
    public Grid(Board board, Player player, AI computer)
    {
        b = board;
        p = player;
        c = computer;
        hintArr = new int[2];
    }
    
    /**
     * Prints the Grid to console
     */
    public void printBoard()
    {
        String[] arr = b.getArray();
        int score = p.getScore();
        
        System.out.println("+------------------------------------------------------------------------------+");
        System.out.println("                                      (0)                                       ");
        System.out.println("                                    |      |                                    ");
        System.out.println("                                    |  " + arr[0] + "   |                                    ");
        System.out.println("                                    |      |                                    ");
        System.out.println("                            (1)                 (2)                             ");
        System.out.println("                          |      |            |      |                                       +--------------+                        ");
        if (score < 10)
        {
            System.out.println("                          |  " + arr[1] + "   |            |  " + arr[2] + "   |                                       | SCORE: " + score + "     +");
        }
        else
        {
            System.out.println("                          |  " + arr[1] + "   |            |  " + arr[2] + "   |                                       | SCORE: " + score + "    +");
        }
        System.out.println("                          |      |            |      |                                       +--------------+                        ");
        System.out.println("                    (3)               (4)               (5)                     ");
        System.out.println("                  |      |          |      |          |      |                  ");
        System.out.print("                  |  " + arr[3] + "   |          |  " + arr[4] + "   |          |  " + arr[5] + "   |                  ");
        if (hintStatus && hintArr[0] != -1)
        {
            System.out.print("              HINT: ( " + hintArr[0] + "," + hintArr[1] + " )");
        }
        else if (hintStatus && hintArr[0] == -1)
        {
            System.out.print("              HINT: ( NONE )");
        }
        System.out.println();
        System.out.println("                  |      |          |      |          |      |                  ");
        System.out.println("          (6)                (7)               (8)               (9)            ");
        System.out.println("        |      |           |      |          |      |          |      |         ");
        System.out.println("        |  " + arr[6] + "   |           |  " + arr[7] + "   |          |  " + arr[8] + "   |          |  " + arr[9] + "   |         ");
        System.out.println("        |      |           |      |          |      |          |      |         ");
        System.out.println("  (10)              (11)              (12)              (13)              (14)  ");
        System.out.println("|      |          |      |          |      |          |      |          |      |");
        System.out.println("|  " + arr[10] + "   |          |  " + arr[11] + "   |          |  " + arr[12] + "   |          |  " + arr[13] + "   |          |  " + arr[14] + "   |");
        System.out.println("|      |          |      |          |      |          |      |          |      |");
        System.out.println("                                                                                ");
        System.out.println("+------------------------------------------------------------------------------+");
    }
    
    /**
     * Inserts Pegs into every peg space
     */
    public void clearBoard()
    {
        String[] arr = b.getArray();
        
        for (int i = 0; i < arr.length; i++)
        {
            arr[i] = Board.X;
        }
    }
    
    /**
     * Adds whitespace to the console window
     */
    public void emptySpace()
    {
        for (int i = 0; i < EMPTY_LINES; i++)
        {
            System.out.println();
        }
    }
    
    /**
     * Turn on the hintstatus that will show the Hint on the Grid
     * 
     * @param  hintS  a string with "y" if the user wants hints showing or "n" if not
     */
    public void enableHint(String hintS)
    {
        if (hintS.toLowerCase().equals("y"))
        {
            hintStatus = true;
        }
        else
        {
            hintStatus = false;
        }
    }
    
    /**
     * A method to set the hint in the Grid
     * 
     * @param  pos  an int array with the hint positions from AI
     */
    public void printHint(int[] pos)
    {
        hintArr = pos;
    }
    
    /**
     * Resets the Hint Array and disables hintStatus
     */
    public void resetHint()
    {
        for (int i = 0; i < hintArr.length; i++)
        {
            hintArr[i] = 0;
        }
        hintStatus = false;
    }
    
    /**
     * Returns the status of the hintEnabled variable
     * @return     a boolean true if the hint is enabled, false if not
     */
    public boolean getHintStatus()
    {
        return hintStatus;
    }
}
