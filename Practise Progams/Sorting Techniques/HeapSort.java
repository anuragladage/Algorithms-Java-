public class HeapSort
{
    public static void sort(Comparable pq[])
    {
        int N = pq.length;      //because we start inserting keys in priority heaps from index 1 and leave 0 index key equal to null.
        for(int k =N/2; k>=1;k--)
        {
            sink(pq,k,N);
        }
        
        while(N>1)
        {
            exchange(pq,1,N);
            sink(pq,1,--N);
        }
    }
    
    private static void sink(Comparable pq[],int index,int N)
    {
        Comparable PQ = pq;
        while(2*index<=N)
        {
            int j = 2*index;
            if(j< N && less(PQ[j],PQ[j+1])) j++;
            if(less(PQ[index],PQ[j]))exchange(PQ[index],PQ[j]);
            index = j;
        }
    }
    
    private static boolean less(Comparable pq[],int a,int b)
    {
        Comparable PQ = pq;
        return PQ[a].compareTo(PQ[b])<0;
    }
    
    
}