
import java.util.Random;
import java.util.ArrayList;

public class AISolitare extends AI
{
    /**
     * Constructor for objects of class AISolitare
     */
    public AISolitare(BoardSolitare b, RulesSolitare r, Player p)
    {
        super(b, r, p);
    }

    public void randomMove(boolean makeMove)
    {
        Random rand = new Random();
        int temp, rpos;
        do
        {
            temp = rand.nextInt(33);
            rpos = rand.nextInt(33);
        } while (!rules.isValid(temp, rpos));
        solutionArr.add(temp);
        solutionArr.add(rpos); 
        if (rules.isValid(temp, rpos) && makeMove)
        {   
            board.makeMove(temp, rpos);
        }
    }

    public void intelliMove()
    {
        Random rand = new Random();
        player.chooseSpace(rand.nextInt(33));
        
        while (!rules.isWinner())
        {
            randomMove(true);
            if (!rules.ableToMove() && board.numFilled() != 1)
            {
                grid.clearBoard();
                board.clearMoveList();
                int t = rand.nextInt(33);
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
    
    public int[] intelliHint(ArrayList<Integer> pMoveList)
    {
        int[] solution = new int[2];
        BoardSolitare boardtemp = new BoardSolitare();
        RulesSolitare rtemp = new RulesSolitare(boardtemp);
        Player ptemp = new Player(boardtemp);
        AISolitare comptemp = new AISolitare(boardtemp, rtemp, ptemp);
        GridSolitare gridtemp = new GridSolitare(boardtemp, ptemp, comptemp);
        comptemp.addGrid(gridtemp);
        boardtemp.addRules(rtemp);
        ptemp.chooseSpace(pMoveList.get(0));
        int breakC = 0;
        
        for (int i = 1; i < pMoveList.size()-1; i=i+2)
        {
            boardtemp.makeMove(pMoveList.get(i), pMoveList.get(i + 1));
        }
        
        while (!rtemp.isWinner())
        {
            comptemp.randomMove(true);
                        
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
            
            if (breakC > 300000)
            {
                solution[0] = -1;
                return solution;
            }
            
            /*if (debug && breakC > 100000) // FOR DEBUG USE
            {
                System.out.println();
                System.out.println("ERROR GENERATING SOLUTION");
                System.exit(1);
            }*/
            
            if (debug && rtemp.isWinner()) // FOR DEBUG USE
            {
                System.out.println("[ " + boardtemp.getMoveList().get(0) + " ]");
                for (int a = 1; a < boardtemp.getMoveList().size()-2; a=a+2)
                {
                    System.out.println("[ " + boardtemp.getMoveList().get(a) + "," + boardtemp.getMoveList().get(a+1) + " ]");
                }
            }
        }
        
        if (pMoveList.size() > 62)
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
}
