import java.util.Scanner;

public class KnapsackScanner
{
    static int[] w;
    static int[] v;
    
    public static int Objective(int k, int j)
    {
        if(j==0) return 0;
        else if(w[j-1] <= k) return max(Objective(k,j-1),v[j-1]+ Objective(k-w[j-1],j-1));
        else return Objective(k,j-1);
    }
    
    public static int max(int i,int j)
    {
        if(i>j) return i;
        else return j;
    }
    
    public static void main(String args[])
    {
        int Max_Value;
        
        
        
        System.out.println("Input the number of items");
        Scanner inputFromUser = new Scanner(System.in);
        int items = inputFromUser.nextInt();
        w = new int[items];
        v = new int[items];
        System.out.println("Input the total capacity of the bag");
        int capacity = inputFromUser.nextInt();
        System.out.println("Input the weights of all " + items + " items");
        for(int i=0; i<items;i++)
        {
            w[i] = inputFromUser.nextInt();
        }
        System.out.println("Enter the values of all " + items + " items");
        for(int i=0;i<items;i++)
        {
            v[i] = inputFromUser.nextInt();
        }
        inputFromUser.close();
        
        
        Max_Value = Objective(capacity,items);
        System.out.println(Max_Value);
    }
}