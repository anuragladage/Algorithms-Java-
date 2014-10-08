import java.util.Scanner;

public class IndexSearchAnurag
{
    public static void main(String args[])
    {
        int arr[];
        int n;
        if(args.length != Integer.parseInt(args[0]) + 1)
        {
            System.out.println("The length of the array should be equal to n");
            System.out.println("USAGE : java IndexSearchAnurag 5 1 2 3 4 5");
            System.exit(0);
        }
        
        if(args[0] == 1)
        {
            if(args[1]==args[0])
            {
                System.out.println("TRUE");
            }
            else if(args[0] = 2)
            {
                if(args[1] == 1 && args[2] = 2)
                {
                    System.out.println("TRUE");
                }
            }
            else
            {
                
            }
        }
        
    }
}