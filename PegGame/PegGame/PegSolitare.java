import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

public class PegSolitare
{
    private static boolean gameActive;
    private static int gameMode;
    public static final int MAX_ITER = 100;
    private static int hintMode;
    private static int tp;
    private static String hintOn;

    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        BoardSolitare board = new BoardSolitare();
        RulesSolitare r = new RulesSolitare(board);
        Player p = new Player(board);
        AISolitare comp = new AISolitare(board, r, p);
        GridSolitare grid = new GridSolitare(board, p, comp);
        comp.addGrid(grid);
        board.addRules(r);
        gameActive = false;
        
        while (!gameActive)
        {
            System.out.println("---------------------------------------------------------");
            System.out.println("-----------WELCOME TO ALAN'S PEG SOLITARE GAME-----------");
            System.out.println("---------------------------------------------------------");
            System.out.println("____    __    ____  _______  __        ______   ______   .___  ___.  _______ ");
            System.out.println("\\   \\  /  \\  /   / |   ____||  |      /      | /  __  \\  |   \\/   | |   ____|");
            System.out.println(" \\   \\/    \\/   /  |  |__   |  |     |  ,----'|  |  |  | |  \\  /  | |  |__    ");
            System.out.println("  \\            /   |   __|  |  |     |  |     |  |  |  | |  |\\/|  | |   __|    ");
            System.out.println("   \\    /\\    /    |  |____ |  `----.|  `----.|  `--'  | |  |  |  | |  |____    ");
            System.out.println("    \\__/  \\__/     |_______||_______| \\______| \\______/  |__|  |__| |_______|    ");
            System.out.println();

            System.out.println("-PLEASE FULLSCREEN CONSOLE WINDOW NOW FOR BEST VIEWING-");
            System.out.println();
            System.out.println("Please Choose From the Following Game Modes");
            System.out.println("1 - AI Only (For Testing and Game Solutions)");
            System.out.println("2 - Player                                     +------------+");
            if (p.getScore() < 10)
            {
                System.out.println("3 - Quit                                       | SCORE: " + p.getScore() + "   " + "+");
            }
            else
            {
                System.out.println("3 - Quit                                       | SCORE: " + p.getScore() + "  " + "+");
            }
            System.out.println("                                               + -----------+");

            boolean valid;
            do
            {
                try
                {
                    System.out.println();
                    System.out.print("?: ");
                    gameMode = in.nextInt();
                    valid = true;
                } catch (InputMismatchException e)
                {
                    System.out.println("Invalid Entry.");
                    in = new Scanner(System.in);
                    valid = false;
                } 
            } while (!valid && !((gameMode > 0 && gameMode < 4)));

            if (gameMode == 3)
            {
                System.exit(0);
            }

            if (gameMode == 2) //PLAYER MODE
            {
                boolean valid1;
                do
                {
                    try
                    {
                        System.out.println();
                        System.out.print("Please choose the space you want to leave empty (0-32): ");
                        tp = in.nextInt();
                        p.chooseSpace(tp);
                        valid1 = true;
                    } catch (InputMismatchException e1)
                    {
                        System.out.println("Invalid Entry.");
                        in = new Scanner(System.in);
                        valid1 = false;
                    }
                } while (!valid1 && (tp < 33 && tp > -1));

                boolean valid2;
                do 
                {
                    try
                    {
                        System.out.println();
                        System.out.print("Hint Mode Enabled? (y/n): ");
                        hintOn = in.next().toLowerCase();
                        grid.enableHint(hintOn); 
                        valid2 = true;
                    } catch (InputMismatchException e2)
                    {
                        System.out.println("Invalid Entry.");
                        in = new Scanner(System.in);
                        valid2 = false;
                    }
                } while(!valid2 && !(hintOn.equals("y") || hintOn.equals("n")));

                if (hintOn.equalsIgnoreCase("y"))
                {
                    boolean valid3;
                    do
                    {
                        try
                        {
                            System.out.println();
                            System.out.print("Hint Mode (1-Smart, 2-Open Spaces): ");                            
                            hintMode = in.nextInt();
                            p.setHintMode(hintMode);
                            valid3 = true;
                        } catch(InputMismatchException e3)
                        {
                            System.out.println("Please enter a number between 1 through 2.");
                            in = new Scanner(System.in);
                            valid3 = false;
                        }
                    } while (!valid3 && (hintMode == 1 || hintMode == 2));
                }

                grid.emptySpace();
                if (hintMode == 1)
                {
                    System.out.println();
                    System.out.println("Please Wait...");
                    System.out.println("Solving Game, Generating Hints For You...");
                    grid.printHint(comp.intelliHint(board.getMoveList()));
                }
                else if (hintMode == 2)
                {
                    grid.printHint(comp.findHint());
                }

                grid.printBoard();

                if (r.getIter() < MAX_ITER) // FOR DEBUGGING
                {
                    gameActive = true;
                }
                else
                {
                    System.out.println("We're sorry, You Ran Out of Luck");
                }

                while (gameActive)
                {
                    int pos1, pos2;              
                    do
                    {
                        System.out.println();
                        System.out.print("What space would you like to move? (0-32): ");
                        pos1 = in.nextInt();
                        System.out.println();
                        System.out.print("Where would you like to move it to? (0-32): ");
                        pos2 = in.nextInt();
                    } while(!(pos1 > -1 && pos1 < 33 && pos2 > -1 && pos2 < 33));

                    if (r.isValid(pos1, pos2))
                    {
                        board.makeMove(pos1, pos2);
                        if (hintMode == 1)
                        {
                            System.out.println();
                            System.out.println("Generating Next Hint...");
                            grid.printHint(comp.intelliHint(board.getMoveList()));
                        }
                        else if (hintMode == 2)
                        {
                            grid.printHint(comp.findHint());
                        }
                        grid.emptySpace();
                        grid.printBoard();
                    }
                    else
                    {
                        System.out.println("Invalid Move.");
                    }

                    if (!r.ableToMove() && board.numFilled() != 1)
                    {
                        System.out.println("Work, work, work, shoot. You lost.");
                        gameActive = false;
                    }

                    if (r.isWinner())
                    {
                        System.out.println("Congratz you are the best, you passed the test!");
                        gameActive = false;
                    }
                }
                p.addScore(33 - board.numFilled());
                System.out.println();
                grid.clearBoard();
                grid.resetHint();
                r.resetWinner();
                r.iterate();
                board.clearMoveList();
                comp.clearSolutions();
            }

            if (gameMode == 1) //AI MODE
            {
                System.out.println();
                System.out.print("IntelliMoves(0) or RandomMoves(1): ");
                int AIMODE = in.nextInt();
                grid.emptySpace();
                Random rand = new Random();

                p.chooseSpace(rand.nextInt(33));
                grid.emptySpace();
                grid.printBoard();
                gameActive = true;

                while (gameActive)
                {
                    if (AIMODE == 1)
                    {
                        comp.randomMove(true);
                    }
                    else
                    {
                        System.out.println("Please wait while I find a solution...");
                        comp.intelliMove();
                    }
                    grid.emptySpace();
                    grid.printBoard();

                    if (!r.ableToMove() && board.numFilled() != 1)
                    {
                        System.out.println("Work, work, work, shoot. You lost.");
                        gameActive = false;
                    }

                    if (r.isWinner())
                    {
                        System.out.println("Congratz you are the best, you passed the test!");
                        gameActive = false;
                    }
                }
                System.out.println();
                grid.clearBoard();
                r.resetWinner();
                r.iterate();
            }
        }
    }
}