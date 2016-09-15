import java.util.Scanner;
import java.util.ArrayList;
/**
 * A class that checks if moves are valid, if the player has won, or if they are unable to move and lost.
 * 
 * @author Alan Lekah
 * @version 1.0
 */
public class Rules
{
    private boolean winner;
    private Board board;
    public static final int ONE = 1;
    public static final int ZERO = 0;
    private int iter;
    
    /**
     * Constructor for objects of class Rules
     * @param  b   the Board object
     */
    public Rules(Board b)
    {
        winner = false;
        board = b;
    }

    /**
     * Checks to make sure that the move the player is trying to make is a valid move.
     * 
     * @param  pos1  The position the player is trying to move from.
     * @param  pos2  The position the player is trying to move to.
     * @return     boolean is the move is valid, false if not.
     */
    public boolean isValid(int pos1, int pos2)
    {
        if (isFilled(pos2))
        {
            return false;
        }
        else if (!isFilled(pos1))
        {
            return false;
        }
        else if (!isFilled(board.inBetween(pos1, pos2)))
        {
            return false;
        }
        if (!isTwoAway(pos1, pos2))
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    /**
     * A method to check if a space is filled with a Peg
     * 
     * @param  pos   the int position of the peg
     * @return     a boolean true if the position is filled with a Peg false if empty
     */
    public boolean isFilled(int pos)
    {
        if (board.getValue(pos) == Board.X)
        {
            return true;
        }
        return false;
    }

    /**
     * A method that checks to see if any of the pegs on the board can move anywhere valid
     * 
     * @return     a boolean true if any of the Pegs on the board can move, false if none can move
     */
    public boolean ableToMove()
    {
        String[] arr = board.getArray();
        int[] filledSpaces = new int[arr.length];

        for(int i = 0; i < arr.length; i++)
        {
            if (isFilled(i))
            {
                filledSpaces[i] = ONE;
            }
        }

        for (int j = 0; j < filledSpaces.length; j++)
        {
            if (filledSpaces[j] == ONE)
            {
                for (int h = 0; h < filledSpaces.length; h++)
                {
                    if (isValid(j, h))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * Checks the board to see if the player has won
     * @return     a boolean true if the player has won, false if not
     */
    public boolean isWinner()
    {
        if (board.numFilled() == 1)
        {
            winner = true;
        }
        return winner;
    }

    /**
     * Reset the winner boolean once the player has won (allows the game to be played again)
     */
    public void resetWinner()
    {
        winner = false;
    }

    /**
     * Gets the iteration count
     * @return     int of the iteration count
     */
    public int getIter()
    {
        return iter;
    }

    /**
     * Adds 1 to the iteration count
     */
    public void iterate()
    {
        iter++;
    }
    
    /**
     * Checks to see if the two Pegs are two away from each other on the Board
     * 
     * @param  pos1   The peg trying to move
     * @param  pos2   The space the pos1 peg is trying to move to.
     * @return     a boolean true if the positions are two away from each other
     */
    public boolean isTwoAway(int pos1, int pos2)
    {
        if (pos1 == 0)
        {
            if (pos2 == pos1 + 3 || pos2 == pos1 + 5)
            {
                return true;
            }
        }
        else if (pos1 == 1 || pos1 == 2)
        {
            if (pos2 == pos1 + 5 || pos2 == pos1 + 7)
            {
                return true;
            }
        }
        else if (pos1 == 3)
        {
            if (pos2 == pos1 + 7 || pos2 == pos1 + 9 || pos2 == pos1 + 2 || pos2 == pos1 - 3)
            {
                return true;
            }
        }
        else if (pos1 == 4)
        {
            if (pos2 == pos1 + 7 || pos2 == pos1 + 9)
            {
                return true;
            }
        }
        else if (pos1 == 5)
        {
            if (pos2 == pos1 + 7 || pos2 == pos1 + 9 || pos2 == pos1 - 2 || pos2 == pos1 - 5)
            {
                return true;
            }
        }
        else if (pos1 == 6 || pos1 == 7)
        {
            if (pos2 == pos1 - 5 || pos2 == pos1 + 2)
            {
                return true;
            }
        }
        else if (pos1 == 8 || pos1 == 9)
        {
            if (pos2 == pos1 - 7 || pos2 == pos1 - 2)
            {
                return true;
            }
        }
        else if (pos1 == 10 || pos1 == 11)
        {
            if (pos2 == pos1 - 7 || pos2 == pos1 + 2)
            {
                return true;
            }
        }
        else if (pos1 == 12)
        {
            if (pos2 == pos1 - 9 || pos2 == pos1 - 7 || pos2 == pos1 - 2)
            {
                return true;
            }
        }
        else if (pos1 == 13 || pos1 == 14)
        {
            if (pos2 == pos1 - 9 || pos2 == pos1 - 2)
            {
                return true;
            }
        }

        return false;
    }
}
