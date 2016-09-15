import java.util.Scanner;
import java.lang.reflect.Method;

public class AlphaTester
{
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException
    {
        Scanner in = new Scanner(System.in);
        System.out.print("Please type your name: ");
        String name = in.next();
        
        Alphabet a = new Alphabet();
        Class<?> c;
        try
        {
            c = Class.forName("Alphabet");
        } catch(Exception e)
        {
            throw new NoSuchMethodException();
        }

        /*
        for (int i = 0; i < a.getAlphabet().size(); i++)
        {
            String letter = a.getAlphabet().get(i);         
            String println = "print" + letter.toUpperCase();
            Method method = c.getDeclaredMethod(println);
            try
            {
                System.out.println(method.invoke(a));
            } catch(Exception e)
            {
                throw new IllegalAccessException();
            }
        }
        */
        
        for (String j : a.convertToArray(a.printA()))
        {
            System.out.println(j);
        }
        System.out.println(a.printA());
        
    }
}
