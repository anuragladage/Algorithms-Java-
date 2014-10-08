public class ShellSort          //3 sorting.
{
    public static void sort(Comparable a[])
    {
        int h = 1;
        while(h <a.length/3)
        {
            h = 3*h + 1;
        }
        while(h>=1)
        {
        for(int i = h;i<a.length;i++)
        {
            for(int j=i;j>=h && less(a[j],a[j-h]);j=j-h)
            {
                exchange(a,j,j-h);
            }
        }
            h = h/3;
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
            System.out.print(args[i] + " ");
        }
        System.out.println();
        System.out.print("After Sorting : ");
        sort(args);
        for(int i=0;i<args.length;i++)
        {
            System.out.print(args[i] + " ");
        }
        System.out.println();
    }
}