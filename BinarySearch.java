import java.util.Arrays;
import java.util.Comparator;

/**
 * Binary search.
 */
public class BinarySearch 
{

    /**
     * Returns the index of the first key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) 
    {
          if (a == null || key == null || comparator == null)
          {
               throw new NullPointerException("Null value passed");
          }
          
          int left = 0;
          int right = a.length - 1;
          int value = -1;
          
          while (left <= right)
          {
             int middle = left + (right - left) / 2;

             if (comparator.compare(a[middle], key) == 0) //a[middle] == key
             {
                value = middle;
             }
             
             if (comparator.compare(a[middle], key) < 0) //a[middle] < key
             {
                left = middle + 1;
             }
             else                                        //a[middle] > key
             {
                //To account for looking for the first index, we want to move to the left naturally
                right = middle - 1;
             }
          }

          return value;
    }

    /**
     * Returns the index of the last key in a[] that equals the search key, 
     * or -1 if no such key exists. This method throws a NullPointerException
     * if any parameter is null.
     */
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) 
    {     
          if (a == null || key == null || comparator == null)
          {
               throw new NullPointerException("Null value passed");
          }
          
          int left = 0;
          int right = a.length - 1;
          int value = -1;
          
          while (left <= right)
          {
             int middle = left + (right - left) / 2;

             if (comparator.compare(a[middle], key) == 0) //a[middle] == key
             {
                value = middle;
             }
             
             if (comparator.compare(a[middle], key) > 0) //a[middle] > key
             {
                right = middle - 1;
             }
             else                                        //a[middle] < key
             {
                //To account for looking for the first index, we want to move to the right naturally
                left = middle + 1;
             }
          }

          return value;          
    }
}

