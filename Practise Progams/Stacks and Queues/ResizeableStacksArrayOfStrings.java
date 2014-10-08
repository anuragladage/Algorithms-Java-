public class ResizeableStacksArrayOfStrings
{
    private String s[];
    private int N = 0;
    
    public ResizeableStacksArrayOfStrings
    {
        s = new String[1];
       
    }
    
    public boolean isEmpty()
    {
        return N==0;
    }
    
    public void push(String item)
    {
        if(N==s.length) resize(2*s.length);
        s[N++] = item;
    }
    
    public String pop()
    {
        String item = s[--N];
        s[N] = null;
        if(N>0 && N = s.length/4)
        {
            resize(s.length/2)
        }
        return item;
    }
    
    private resize(int capacity)                //resizes the array to double length array.
    {
        String temp = new String[capacity];
        for(int i=0;i<s.length;i++)
        {
            temp[i] = s[i];
        }
        s = temp;
    }
}