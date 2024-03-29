public class InsertionSort
{
    public static void sort(Comparable a[])
    {
        int N = a.length;
        for(int i = 0;i<N;i++)
        {
            for(int j=i;j>0;j--)
            {
                if(less(a[j],a[j-1]))
                {
                    exchange(a,j,j-1);
                }
                else
                    break;
            }
        }
    }
    
    private static void exchange(Comparable a[],int i,int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) <0;
    }
    
    
    public static void main(String args[])
    {
        System.out.print("Before Sorting : ");
        for(int i=0;i<args.length;i++)
        {
            System.out.print(args[i]);
        }
        System.out.println();
        System.out.print("After Sorting : ");
        sort(args);
        for(int i=0;i<args.length;i++)
        {
            System.out.print(args[i]);
        }
        System.out.println();
    }
}