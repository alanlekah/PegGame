
/**
 * Write a description of class GridSolitare here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GridSolitare extends Grid
{

    /**
     * Constructor for objects of class GridSolitare
     */
    public GridSolitare(BoardSolitare board, Player player, AISolitare computer)
    {
        super(board, player, computer);
    }

    public void printBoard()
    {
        String[] arr = b.getArray();
        int score = p.getScore();
        
        System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
        System.out.println("                                        (0)               (1)               (2)                     ");
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.print("                                      |  " + arr[0] + "   |          |  " + arr[1] + "   |          |  " + arr[2] + "   |");
        if (hintStatus && hintArr[0] != -1)
        {
            System.out.print("                                            HINT: ( " + hintArr[0] + "," + hintArr[1] + " )");
        }
        else if (hintStatus && hintArr[0] == -1)
        {
            System.out.print("                                            HINT: ( NONE )");
        }
        System.out.println();
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.println("                                        (3)               (4)               (5)                     ");
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.println("                                      |  " + arr[3] + "   |          |  " + arr[4] + "   |          |  " + arr[5] + "   |");
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.println("    (6)                (7)              (8)               (9)               (10)              (11)              (12)");
        System.out.println("  |      |          |      |          |      |          |      |          |      |          |      |          |      |");
        System.out.println("  |  " + arr[6] + "   |          |  " + arr[7] + "   |          |  " + arr[8] + "   |          |  " + arr[9] + "   |          |  " + arr[10] + "   |          |  " + arr[11] + "   |          |  " + arr[12] + "   |");
        System.out.println("  |      |          |      |          |      |          |      |          |      |");
        System.out.println("    (13)              (14)              (15)              (16)              (17)              (18)              (19)                                                                                                ");
        System.out.println("  |      |          |      |          |      |          |      |          |      |          |      |          |      |");
        System.out.println("  |  " + arr[13] + "   |          |  " + arr[14] + "   |          |  " + arr[15] + "   |          |  " + arr[16] + "   |          |  " + arr[17] + "   |          |  " + arr[18] + "   |          |  " + arr[19] + "   |");
        System.out.println("  |      |          |      |          |      |          |      |          |      |");
        System.out.println("    (20)              (21)              (22)              (23)              (24)              (25)              (26)");
        System.out.println("  |      |          |      |          |      |          |      |          |      |          |      |          |      |");
        System.out.println("  |  " + arr[20] + "   |          |  " + arr[21] + "   |          |  " + arr[22] + "   |          |  " + arr[23] + "   |          |  " + arr[24] + "   |          |  " + arr[25] + "   |          |  " + arr[26] + "   |");
        System.out.println("  |      |          |      |          |      |          |      |          |      |          |      |          |      |");
        System.out.println("                                        (27)              (28)              (29)                     ");
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.println("                                      |  " + arr[27] + "   |          |  " + arr[28] + "   |          |  " + arr[29] + "   |");
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.println("                                        (30)              (31)              (32)                     ");
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.println("                                      |  " + arr[30] + "   |          |  " + arr[31] + "   |          |  " + arr[32] + "   |");
        System.out.println("                                      |      |          |      |          |      |                  ");
        System.out.println("+-------------------------------------------------------------------------------------------------------------------+");
    }
}
