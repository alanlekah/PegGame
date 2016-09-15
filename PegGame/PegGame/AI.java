import java.util.Random;
import java.util.ArrayList;
/**
 * A computational solving class that finds hints and finds solutions for PegGame
 * 
 * @author Alan Lekah
 * @version 3/19/2013 1.0
 */
public class AI
{
    protected Board board;
    protected Rules rules;
    protected Player player;
    protected Grid grid;
    protected String[] arr;
    protected ArrayList<Integer> solutionArr = new ArrayList<Integer>();
    protected boolean debug = false;

    /**
     * Constructor for objects of class AI
     * @param  b   a Board object
     * @param  r   a Rules object
     * @param  p   a Player object
     */
    public AI(Board b, Rules r, Player p)
    {
        board = b;
        rules = r;
        player = p;
        arr = b.getArray();
    }

    /** 
     * Adds a grid object for the AI class to use
     * @param  g   a Grid object
     */ 
    public void addGrid(Grid g)
    {
        grid = g;
    }

    /**
     * Finds a valid space on the board and makes the random move
     * 
     * @param  makeMove   a boolean to indicate whether to actually make the move or generate a space to move
     */
    public void randomMove(boolean makeMove)
    {
        Random rand = new Random();
        int temp, rpos;
        do
        {
            temp = rand.nextInt(15);
            rpos = rand.nextInt(15);
        } while (!rules.isValid(temp, rpos));
        solutionArr.add(temp);
        solutionArr.add(rpos); 
        if (rules.isValid(temp, rpos) && makeMove)
        {   
            board.makeMove(temp, rpos);
        }
    }

    /**
     * Finds a valid space and returns an array of ints that has a suggestion on where to move.
     * 
     * @return     int array with the coordinates of the hint
     */
    public int[] findHint()
    {
        String[] arr = board.getArray();
        int[] filledSpaces = new int[arr.length];
        int[] hintPosition = new int[2];

        for(int i = 0; i < arr.length; i++)
        {
            if (rules.isFilled(i))
            {
                filledSpaces[i] = Rules.ONE;
            }
        }

        for (int j = 0; j < filledSpaces.length; j++)
        {
            if (filledSpaces[j] == Rules.ONE)
            {
                for (int h = 0; h < filledSpaces.length; h++)
                {
                    if (rules.isValid(j, h))
                    {
                        hintPosition[0] = j;
                        hintPosition[1] = h;
                        return hintPosition;
                    }
                }
            }
        }
        hintPosition[0] = -1;
        return hintPosition;
    }

    /**
     * Makes random moves and finds a winning game solution. Once it finds a solution, makes the moves until the computer wins the game.
     * 
     */
    public void intelliMove()
    {
        Random rand = new Random();
        player.chooseSpace(rand.nextInt(15));

        while (!rules.isWinner())
        {
            randomMove(true);
            if (!rules.ableToMove() && board.numFilled() != 1)
            {
                grid.clearBoard();
                board.clearMoveList();
                int t = rand.nextInt(15);
                player.chooseSpace(t);
                rules.resetWinner();
                solutionArr.clear();
                solutionArr.add(t);
            }

            if (debug && rules.isWinner())
            {
                System.out.println("[ " + board.getMoveList().get(0) + " ]");
                for (int a = 1; a < board.getMoveList().size()-1; a=a+2)
                {
                    System.out.println("[ " + board.getMoveList().get(a) + "," + board.getMoveList().get(a+1) + " ]");
                }
            }
        }
        grid.clearBoard();
        player.chooseSpace(solutionArr.get(0));
        rules.resetWinner();
        for (int i = 1; i < solutionArr.size()-1; i=i+2)
        {
            board.makeMove(solutionArr.get(i), solutionArr.get(i + 1));
            grid.printBoard();
        }
    }

    /**
     * Creates a set of objects where it plays random games until it finds winning solutions.
     * 
     * @param  pMoveList the player's moves up until intelliHint is called. An ArrayList of moves that the player has made.
     * @return     int array of the winning solution given the players current moves.
     */
    public int[] intelliHint(ArrayList<Integer> pMoveList)
    {
        int[] solution = new int[2];
        Board boardtemp = new Board();
        Rules rtemp = new Rules(boardtemp);
        Player ptemp = new Player(boardtemp);
        AI comptemp = new AI(boardtemp, rtemp, ptemp);
        Grid gridtemp = new Grid(boardtemp, ptemp, comptemp);
        comptemp.addGrid(gridtemp);
        ptemp.chooseSpace(pMoveList.get(0));
        int breakC = 0;

        for (int i = 1; i < pMoveList.size()-1; i=i+2)
        {
            boardtemp.makeMove(pMoveList.get(i), pMoveList.get(i + 1));
        }

        while (!rtemp.isWinner())
        {
            comptemp.randomMove(true);

            if (debug && !comptemp.isLastMoveValid(boardtemp, rtemp)) // FOR DEBUG USE
            {
                int a = boardtemp.getMoveList().get(boardtemp.getMoveList().size()-2);
                int b = boardtemp.getMoveList().get(boardtemp.getMoveList().size()-1);
                int c = 0;
            }

            if (!rtemp.ableToMove() && boardtemp.numFilled() != 1)
            {
                gridtemp.clearBoard();
                boardtemp.clearMoveList();
                comptemp.clearSolutions();

                rtemp.resetWinner();
                ptemp.chooseSpace(pMoveList.get(0));
                for (int j = 1; j < pMoveList.size()-1; j=j+2)
                {
                    boardtemp.makeMove(pMoveList.get(j), pMoveList.get(j + 1));
                }
                breakC++;
            }

            if (breakC > 10000)
            {
                solution[0] = -1;
                return solution;
            }

            if (debug && breakC > 1000) // FOR DEBUG USE
            {
                System.out.println();
                System.out.println("ERROR GENERATING SOLUTION");
                System.exit(1);
            }

            if (debug && rtemp.isWinner()) // FOR DEBUG USE
            {
                System.out.println("[ " + boardtemp.getMoveList().get(0) + " ]");
                for (int a = 1; a < boardtemp.getMoveList().size()-2; a=a+2)
                {
                    System.out.println("[ " + boardtemp.getMoveList().get(a) + "," + boardtemp.getMoveList().get(a+1) + " ]");
                }
            }
        }

        if (pMoveList.size() > 26)
        {
            solution[0] = -1;
        }
        else
        {
            solution[0] = boardtemp.getMoveList().get(pMoveList.size());
            solution[1] = boardtemp.getMoveList().get(pMoveList.size()+1);
        }

        return solution;
    }

    /**
     * Clears the ArrayList solutionArr
     */
    public void clearSolutions()
    {
        solutionArr.clear();
    }

    /**
     * Return the array solutionArr
     * 
     * @return     returns the solution Array
     */
    public ArrayList<Integer> getSolutionArr()
    {
        return solutionArr;
    }

    /**
     * A debug method to make sure that the computer made a valid move.
     * 
     * @param  b  the Board object
     * @param  r1  a Rules object
     * @return     a boolean if the last move was valid.
     */
    public boolean isLastMoveValid(Board b, Rules r1)
    {
        int a = b.getMoveList().get(b.getMoveList().size()-2);
        int c = b.getMoveList().get(b.getMoveList().size()-1);

        if (b.getMoveList().size() >= 2 && r1.isValid(a,c))
        {
            return true;
        }
        else if (b.getMoveList().size() < 2)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
