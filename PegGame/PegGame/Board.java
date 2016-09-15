import java.util.ArrayList;

/**
 * A class that changes the Grid and holds the variables that will be shown on the Grid
 * 
 * @author Alan Lekah
 * @version 1.0
 */
public class Board
{
    private String[] dataValues;
    public static final String X = "X";
    public static final String EMPTY = " ";
    protected ArrayList<Integer> moveList = new ArrayList<Integer>();

    /**
     * Constructor for objects of class Board
     */
    public Board()
    {
        dataValues = new String[15];
        for (int i = 0; i < dataValues.length; i++)
        {
            dataValues[i] = X;
        }
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  pos1  An int of the position on the Grid to move from.
     * @param  pos2  An int of the position on the Grid to move to.
     */
    public void makeMove(int pos1,int pos2)
    {
        removeFromGrid(pos1);
        removeFromGrid(inBetween(pos1, pos2));
        removeFromGrid(pos2);
        addToGrid(pos2);
        record(pos1, pos2);
    }
    
    /**
     * Finds the position number of the space in between two positions on the Grid
     * 
     * @param  pos1  An int of the position on the Grid to move from.
     * @param  pos2  An int of the position on the Grid to move to.
     * @return     the average of pos1 and pos2
     */
    public int inBetween(int pos1, int pos2)
    {
        return (pos1 + pos2)/2;
    }
    
    /**
     * Removes a peg from the Grid
     * 
     * @param  pos  The position number of the position to remove.
     */
    public void removeFromGrid(int pos)
    {
        dataValues[pos] = EMPTY;
    }
    
    /**
     * Adds a peg to the Grid
     */
    public void addToGrid(int pos)
    {
        dataValues[pos] = X;
    }
    
    /**
     * Return a string array of the spaces filled on the Grid.
     * 
     * @return     A string array of the Pegs on the board.
     */
    public String[] getArray()
    {
        return dataValues;
    }

    /**
     * Return the value in the position of the dataValues array.
     * 
     * @param  pos   The position in the array
     * @return     An "X" if the position is filled or "" if the position is empty.
     */
    public String getValue(int pos)
    {
        return dataValues[pos];
    }
    
    /**
     * Picks a random space thats open in the Grid/dataValues array
     * 
     * @return     an int of the space thats empty
     */
    public int getRandomFilledPos()
    {
        for (int i = 0; i < dataValues.length; i++)
        {
            if (dataValues[i] == X)
            {
                return i;
            }
        }
        return -1;
    }
    
    /**
     * Returns an int of spaces filled with "X"'s on the Grid
     * 
     * @return     number of filled spaces
     */
    public int numFilled()
    {
        int num = 0;
        
        for (String s : dataValues)
        {
            if (s == Board.X)
            {
                num++;
            }
        }
        return num;
    }
    
    /**
     * Record the player's moves in the moveList arraylist
     * 
     * @param  pos1  The position the player moved from.
     * @param  pos2  The position the player moved to.
     */
    public void record(int pos1, int pos2)
    {
        moveList.add(pos1);
        moveList.add(pos2);
    }
    
    /**
     * Record the player's moves in the moveList arraylist
     * 
     * @param  pos  The position the player chose as the first empty space.
     */
    public void record(int pos)
    {
        moveList.add(pos);
    }
    
    /**
     * Returns the player's moveList
     * 
     * @return     returns the arraylist moveList
     */
    public ArrayList<Integer> getMoveList()
    {
        return moveList;
    }
    
    /**
     * Clears the arraylist moveList
     */
    public void clearMoveList()
    {
        moveList.clear();
    }
}
