import java.util.Random;


public class QuickSort
{
    
    public static void sort(Comparable a[])
    {
        StdRandom.shuffle(a);
        sort(a,0,a.length-1);
    }
    
    private static void sort(Comparable a[],int low, int high)
    {
        if(high <=low) return;
        int j = partition(a,low,high);
        sort(a,low,j-1);
        sort(a,j+1,high);
    }
    
    private static int partition(Comparable a[],int low, int high)
    {
        int i = low;
        int j = high+1;
        
        while(true)
        {
            while(less(a[++i],a[low]))
            {
                if(i==high) break;
            }
            while(less(a[low], a[--j]))
            {
                if(j==low) break;
            }
            
            if(i>=j) break;
            exchange(a,i,j);
        }
        
        exchange(a,low,j);
        return j;
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
        sort(args);
    }
}