public class RulesSolitare extends Rules
{
    private boolean lastMoveTwoAway;
    
    public RulesSolitare(BoardSolitare b)
    {
        super(b);
    }

    public boolean isTwoAway(int pos1, int pos2)
    {
        if (pos1 == 0)
        {
            if (pos2 == pos1 + 8 || pos2 == pos1 + 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 1)
        {
            if (pos2 == pos1 + 8)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 2)
        {
            if (pos2 == pos1 + 8 || pos2 == pos1 - 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 3)
        {
            if (pos2 == pos1 + 2 || pos2 == pos1 + 12)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 4)
        {
            if (pos2 == pos1 + 12)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 5)
        {
            if (pos2 == pos1 - 2 || pos2 == pos1 + 12)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 6 || pos1 == 7)
        {
            if (pos2 == pos1 + 14 || pos2 == pos1 + 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 8 || pos1 == 9 || pos1 == 10) // MIDDLE COLUMN START
        {
            if (pos2 == pos1 - 8 || pos2 == pos1 - 2 || pos2 == pos1 + 2 || pos2 == pos1 + 14)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 15 || pos1 == 16 || pos1 == 17) 
        {
            if (pos2 == pos1 - 12 || pos2 == pos1 - 2 || pos2 == pos1 + 2 || pos2 == pos1 + 14 || pos2 == pos1 + 12)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 22 || pos1 == 23 || pos1 == 24) // MIDDLE COLUMN END
        {
            if (pos2 == pos1 - 14 || pos2 == pos1 - 2 || pos2 == pos1 + 2 || pos2 == pos1 + 14)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 11 || pos1 == 12)
        {
            if (pos2 == pos1 + 14 || pos2 == pos1 - 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 13 || pos1 == 14)
        {
            if (pos2 == pos1 + 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 18 || pos1 == 19)
        {
            if (pos2 == pos1 - 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 20 || pos1 == 21)
        {
            if (pos2 == pos1 - 14 || pos2 == pos1 + 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 25 || pos1 == 26)
        {
            if (pos2 == pos1 - 14 || pos2 == pos1 - 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 27)
        {
            if (pos2 == pos1 + 2 || pos2 == pos1 - 12)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 28)
        {
            if (pos2 == pos1 - 12)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 29)
        {
            if (pos2 == pos1 - 2 || pos2 == pos1 - 12)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 30)
        {
            if (pos2 == pos1 - 8 || pos2 == pos1 + 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 31)
        {
            if (pos2 == pos1 - 8)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        else if (pos1 == 32)
        {
            if (pos2 == pos1 - 8 || pos2 == pos1 - 2)
            {
                lastMoveTwoAway = true;
                return true;
            }
        }
        lastMoveTwoAway = false;
        return false;
    }
    
    public boolean wasMoveTwoAway()
    {
        return lastMoveTwoAway;
    }
}
