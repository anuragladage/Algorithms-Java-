import java.util.Random;

public class QuickSelect
{
    public static Comparable select(Comparable a[],int k)
    {
        StdRandom.shuffle(a);
        int low = 0;
        int high = a.length - 1;
        
        while(high >low)
        {
            partition(a,low,high);
            if(j<k) low = j+1;
            if(j>k) high = j-1;
            else return a[k];
        }
        return a[k];
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
}