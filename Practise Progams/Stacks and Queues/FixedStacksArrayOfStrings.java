public class FixedStacksArrayOfStrings
{
    String s[];
    int N = 0;
    
    public StacksArrayOfStrings(int Capacity)   //If the client knows the capacity beforehand.
    {
        s = new String[Capacity];
    }
    
    
    public boolean isEmpty()
    {
        return N==0;
    }
    
    public void push(String item)
    {
        s[N++] = item;      //First assign item at N then increment.
    }
    
//    public String pop()
//    {
//        return s[--N];      //First decrement and then pop.
//    }
// Above function facilitates loitering that is there still exists a pointer pointing a N.
    
    public String pop()
    {
        String item = s[--N];
        s[N] = null;            //Lets the garbage collector collect the pointer thus avoids loitering.
        return item;
    }
}