import java.util.List;
import java.util.Arrays;

public class BoardSolitare extends Board
{
    private String[] dataV;
    private RulesSolitare rules;
    private List<Integer> goDown = Arrays.asList(8, 9, 10, 15, 16, 17);
    private List<Integer> goUp = Arrays.asList(27, 28, 29, 30, 31, 32);
    private List<Integer> middle = Arrays.asList(15, 16, 17);

    /**
     * Constructor for objects of class BoardSolitare
     */
    public BoardSolitare()
    {
        dataV = new String[33];
        for (int i = 0; i < dataV.length; i++)
        {
            dataV[i] = X;
        }
    }
    
    public String[] getArray()
    {
        return dataV;
    }
    
    public void removeFromGrid(int pos)
    {
        dataV[pos] = EMPTY;
    }
    
    public void addToGrid(int pos)
    {
        dataV[pos] = X;
    }

    public String getValue(int pos)
    {
        return dataV[pos];
    }
    
    public int getRandomFilledPos()
    {
        for (int i = 0; i < dataV.length; i++)
        {
            if (dataV[i] == X)
            {
                return i;
            }
        }
        return -1;
    }
    
    public int numFilled()
    {
        int num = 0;
        
        for (String s : dataV)
        {
            if (s == Board.X)
            {
                num++;
            }
        }
        return num;
    }
    
    public int inBetween(int pos1, int pos2)
    {
        int betweenTemp = (pos1 + pos2)/2;
        
        if (((pos2 == pos1 - 2 || pos2 == pos1 + 2) || middle.contains(betweenTemp)))
        {
            return betweenTemp;
        }
        else if (((goDown.contains(pos1) && goUp.contains(pos2)) || (goDown.contains(pos2) && goUp.contains(pos1))) || (goUp.contains(pos1) || goUp.contains(pos2)))
        {
            betweenTemp++;
            return betweenTemp;
        }
        else if ((goDown.contains(pos1) || goDown.contains(pos2)))
        {
            betweenTemp--;
            return betweenTemp;
        }
        
        return betweenTemp;
    }
    
    public void addRules(RulesSolitare r)
    {
        rules = r;
    }
}
