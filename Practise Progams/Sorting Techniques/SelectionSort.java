public class SelectionSort
{
    public static void sort(Comparable a[])
    {
        int minimum = 0;
        for(int i=0; i<a.length;i++)
        {
            minimum = i;
            for(int j = i+1;j<a.length;j++)
            {
                minimum = i;
                if(less(a[j],a[minimum]))
                {
                    minimum = j;
                }
                   }
            exchange(a,i,minimum);
        }
//        
        for(int i = 0; i<a.length ; i++)
        {
            System.out.println(a[i]);
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
        SelectionSort ss = new SelectionSort();
        ss.sort(args);
        System.out.println();
        System.out.print("After Sorting : ");
//        for(int i = 0; i<args.length;i++)
//        {
//            System.out.print(args[i] + " ");
//        }
//        System.out.println();
    }
}