public class LinkedQueueOfStrings
{
    private Node first, last;
    
    private Node
    {
        String first;
        Node next;
    }
    
    public boolean isEmpty()
    {
        return first==0;
    }
    
    public void enqueue(String item)
    {
        Node oldlast = last;
        last.item = item;
        last.next = null;
        oldlast.next = last;
        if(isEmpty()) first = last;
        else
            oldlast.next = last;
    }
    
    public String dequeue()
    {
        String item = first.item;
        first = first.next;
        if(isEmpty()) last = null;
        return item;
        
    }
}