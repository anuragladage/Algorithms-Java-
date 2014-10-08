public class UnorderedMaxPQ<Key extends Comparable<Key>>
{
    private int N=0;
    private Key[] pq;
    
    
    public UnorderedMaxPQ(int capacity)                 //cheat version where capacity if pre specified. But can be adjusted by using resizing arrays.
    {
        pq = (Key[]) new Comparable[capacity];
    }
    
    public boolean isEmpty()
    {
        return N==0;
    }
    
    public void insert(Key x)
    {
        pq[N++] = x;
    }
    
    public Key delMax()
    {
        int max=0;
        for(int i =1;i<=N;i++)
        {
            if(less(pq[max],pq[i])) max = i;
        }
        exchange(pq,max,N-1);
        return pq[--N];
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
    
    
    public static void main(String args[])
    {
        UnorderedMaxPQ demo;
        demo = new UnorderedMaxPQ(100);
        demo.isEmpty();
        demo.insert("A");
        demo.insert("B");
        demo.insert("E");
        demo.insert("G");
        demo.insert("C");
        demo.delMax();
        
    }
}