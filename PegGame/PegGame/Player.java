
/**
 * Holds the player's score, hintmode, and empty space in the beginning of the game
 * 
 * @author Alan Lekah
 * @version 1.0
 */
public class Player
{
    private String[] arr;
    private int score;
    private int hintMode;
    private Board board;
    
    /**
     * Constructor for objects of class Player
     */
    public Player(Board b)
    {
        board = b;
        arr = b.getArray();
    }

    /**
     * Chooses a space in the beginning of the game
     * 
     * @param  pos   The position of the space the user wants to leave empty 
     */
    public void chooseSpace(int pos)
    {
        arr[pos] = Board.EMPTY;
        board.record(pos);
    }
    
    public void setHintMode(int mode)
    {
        hintMode = mode;
    }
    
    public int getScore()
    {
        return score;
    }
    
    public void addScore(int points)
    {
        score = score + points;
    }
    
    public int hintMode()
    {
        return hintMode;
    }
}
