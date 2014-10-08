//This works only if both arrays are sorted before hand.

public class MergeSortedArray
{
    public static void merge(String a[])
    {
        
//        assert isSorted(a,0,a.length-1);  assert verifies if the expression is true otherwise throws an exception. Can be activated and deactivated. Eg: 'java ea FileName' for activation and 'java da filename' for deactivation.
        String[] aux = new String[a.length];
        for(int k = 0; k<a.length;k++)
        {
            aux[k]=a[k];
        }
        
        int i=0,j=aux.length/2;
        
        for(int k=0;k<aux.length;k++)
        {
            if(i > a.length/2) a[k] = aux[j++];
            else if(j >= a.length) a[k] = aux[i++];
            else if(less(aux[i],aux[j]))
            {
                a[k]=aux[i];
                i++;
            }
            else
            {
                a[k]=aux[j];
                j++;
            }
        }
        
        System.out.print("Array sorted by MergeSort : ");
        for(int g=0;g<a.length;g++)
        {
            System.out.print(a[g] + " ");
        }
        System.out.println();
    }
    
    private static boolean less(Comparable v, Comparable w)
    {
        return v.compareTo(w) <0;
    }
    
    public static void main(String args[])
    {
        merg(args);
    }
}