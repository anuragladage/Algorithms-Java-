public class MaxPQBinaryHeap<Key extends Comparable<Key>>
{
    Key[] pq;
    int N = 0;
    
    public MaxPQBinaryHeap(int Capacity)
    {
        pq = (Key[]) new Comparable[Capacity+1];    //Generic arrays not allowed.
    }
    
    public void insert(Key x)
    {
        pq[++N] = x;
        swim(x);
    }
    
    public boolean isEmpty()
    {
        return N==0;
    }
    
    public Key delMax()
    {
        int max = 1;
        exchange(N--,1);
        sink(1);
        pq[N+1] = null;
        return pq[max];
    }
    
    private static swim(int index)
    {
        while(index > 1 && !less(index,index/2))
        {
            exchange(index,index/2);
            index = index/2;
        }
    }
    
    private static void sink(int index)
    {
        while(2*index<=N)
        {
            int j = 2*index;
            if(j< N && less(j,j+1)) j++;
            if(less(index,j))exchange(index,j);
            index = j;
        }
    }
    
    private static boolean less(int a,int b)
    {
        return pq[a].compareTo(pq[b])<0;
    }
    
    exchange(int i,int j)
    {
        Key t = pq[i];
        pq[i]=pq[j];
        pq[j] = swap;
    }
    
}