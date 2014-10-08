public class GenericStackArray<Item>
{
    private Item s[];
    private int N = 0;
    
    public ResizeableStacksArrayOfStrings
    {
        s = (Item[]) new Object[1];                      //Java doesnt allow generic array creation.
        
    }
    
    public boolean isEmpty()
    {
        return N==0;
    }
    
    public void push(Item item)
    {
        if(N==s.length) resize(2*s.length);
        s[N++] = item;
    }
    
    public Item pop()
    {
        Item item = s[--N];
        s[N] = null;
        if(N>0 && N = s.length/4)
        {
            resize(s.length/2)
        }
        return item;
    }
    
    private resize(int capacity)                //resizes the array to double length array.
    {
        Item temp = new Item[capacity];
        for(int i=0;i<s.length;i++)
        {
            temp[i] = s[i];
        }
        s = temp;
    }
}