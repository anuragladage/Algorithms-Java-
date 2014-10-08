public class ThreeWayQuickSort
{
    private static void sort(Comparable a[],int low,int high)
    {
        int lt = low;
        int i = low;
        int gt = high;
        
        while(high>=i)
        {
            if(less(a[i],a[low])) exchange(a,i++,low++);
            else if(less(a[low],a[i])) exchange(a,i,high--);
            else i++;
        }
        
        sort(a,low,lt - 1)
        sort(a,gt+1,high)
    }
    
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) <0;
    }
}