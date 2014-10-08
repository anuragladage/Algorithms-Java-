
public class BruteSorting implements Comparable
{
    public static void bruteSort(Comparable[] a)
    {
        int n = Integer.parsetInt(a.length);
        for(i=0;i <n;i++)
            for(j=i;j<n;j++)
            {
                if(less(a[j],a[j-1]))
                {
                    exhchange(a,j,j-1);
                }
            }
    }
    
    private static void exchange(Comparable obj[],int i,int j)
    {
        Comparable swap = a[i];
        a[i] = a[j];
        a[j] = a[i];
    }
    
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) <0;
    }
}