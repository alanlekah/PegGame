import java.util.Arrays;
import java.util.List;

public class Alphabet
{
    private String[] alphab = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private List<String> alphabet;
    private String NEW_LINE = "\n";
    
    public Alphabet()
    {
        alphabet = Arrays.asList(alphab);   
    }
    
    public List<String> getAlphabet()
    {
        return alphabet;
    }
    
    public String printSpace()
    {
        return "  ";
    }

    public String[] convertToArray(String s)
    {
        String[] return_string = new String[5];
        int t, h;
        
        t = s.indexOf(NEW_LINE);
        return_string[0] = s.substring(0, t);
        s = s.substring(t+2);
        for (int i = 1; i < return_string.length; i++)
        {
            t = s.indexOf(NEW_LINE);
            h = s.indexOf(NEW_LINE, t+1);
            return_string[i] = s.substring(t+1, h-1);
            s = s.substring(t+2);
        }
        return return_string;
    }
    
    public String printA()
    {
        return "     ___      \n"
        +      "    /   \\     \n"
        +      "   /  ^  \\    \n"
        +      "  /  /_\\  \\  \n"
        +      " /  _____  \\  \n"
        +      "/__/     \\__\\ \n";
    }
    
    public String printB()
    {
        return ".______   \n|   _  \\  \n|  |_)  | \n|   _  <  \n|  |_)  | \n|______/  \n  ";
    }
    
    public String printC()
    {
        return "  ______ \n /      |\n|  ,----\'\n|  |     \n|  `----.\n \\______|";
    }
    
    public String printD()
    {
        return " _______  \n|       \\ \n|  .--.  |\n|  |  |  |\n|  \'--\'  |\n|_______/ \n    ";
    }
    
    public String printE()
    {
        return " _______ \n|   ____|\n|  |__   \n|   __|  \n|  |____ \n|_______|";
    }
    
    public String printF()
    {
        return " _______ \n|   ____|\n|  |__   \n|   __|  \n|  |     \n|__|     \n         ";
    }
    
    public String printG()
    {
        return "  _______ \n /  _____|\n|  |  __  \n|  | |_ | \n|  |__| | \n \\______| ";
    }
    
    public String printH()
    {
        return " __    __  \n|  |  |  | \n|  |__|  | \n|   __   | \n|  |  |  | \n|__|  |__| \n           ";
    }
    
    public String printI()
    {
        return " __  \n|  | \n|  | \n|  | \n|  | \n|__| \n     \n           ";
    }
    
    public String printJ()
    {
        return "       __  \n      |  | \n      |  | \n.--.  |  | \n|  `--\'  | \n \\______/  \n           ";
    }
    
    public String printK()
    {
        return " __  ___ \n|  |/  / \n|  \'  /  \n|    <   \n|  .  \\  \n|__|\\__\\ \n         ";
    }
    
    public String printL()
    {
        return " __      \n|  |     \n|  |     \n|  |     \n|  `----.\n|_______|\n         ";
    }
    
    public String printM()
    {
        return ".___  ___. \n|   \\/   | \n|  \\  /  | \n|  |\\/|  | \n|  |  |  | \n|__|  |__| \n           ";
    }
    
    public String printN()
    {
        return ".__   __. \n|  \\ |  | \n|   \\|  | \n|  . `  | \n|  |\\   | \n|__| \\__| \n          ";
    }
    
    public String printO()
    {
        return "  ______   \n /  __  \\  \n|  |  |  | \n|  |  |  | \n|  `--\'  | \n \\______/  \n           ";
    }
    
    public String printP()
    {
        return ".______   \n|   _  \\  \n|  |_)  | \n|   ___/  \n|  |      \n| _|      \n          ";
    }
    
    public String printQ()
    {
        return "  ______      \n /  __  \\     \n|  |  |  |    \n|  |  |  |    \n|  `--\'  \'--. \n \\_____\\_____\\\n              ";
    }
    
    public String printR()
    {
        return ".______      \n|   _  \\     \n|  |_)  |    \n|      /     \n|  |\\  \\----.\n| _| `._____|\n             ";
    }
    
    public String printS()
    {
        return "     _______.\n    /       |\n   |   (----`\n    \\   \\    \n.----)   |   \n|_______/    \n             ";
    }
    
    public String printT()
    {
        return ".___________.\n|           |\n`---|  |----`\n    |  |     \n    |  |     \n    |__|     \n             ";
    }
    
    public String printU()
    {
        return " __    __  \n|  |  |  | \n|  |  |  | \n|  |  |  | \n|  `--\'  | \n \\______/  \n           ";
    }
    
    public String printV()
    {
        return "____    ____ \n\\   \\  /   / \n \\   \\/   /  \n  \\      /   \n   \\    /    \n    \\__/     \n             ";
    }
    
    public String printW()
    {
        return "____    __    ____ \n\\   \\  /  \\  /   / \n \\   \\/    \\/   /  \n  \\            /   \n   \\    /\\    /    \n    \\__/  \\__/     \n                   ";
    }
    
    public String printX()
    {
        return "___   ___ \n\\  \\ /  / \n \\  V  /  \n  >   <   \n /  .  \\  \n/__/ \\__\\ \n          ";
    }
    
    public String printY()
    {
        return "____    ____ \n\\   \\  /   / \n \\   \\/   /  \n  \\_    _/   \n    |  |     \n    |__|     \n             ";
    }
    
    public String printZ()
    {
        return " ________  \n|       /  \n`---/  /   \n   /  /    \n  /  /----.\n /________|\n           ";
    }
}
