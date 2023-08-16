import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * Return the elements in a collection that are strictly less than a specified
 * value.
 *Complete the body of the lessThanSubset method so that it returns a Collection 
 containing only the elements in the parameter collection that are strictly less
  than the parameter value, with respect to the natural order defined for type T
  . An instance of ArrayList has been declared for you to use to assemble the 
  correct subset of values and return.

The following table lists various examples of the parameters collection and value 
along with the correct return value from the call lessThanSubset(collection, value). 
The order of values in the returned collection is not important. If there are no 
qualifying values, the method should return an empty collection.

collection	value	Return Value
[9, 1, 5, 3, 7]	7	[1, 5, 3]
[9, 1, 5, 3, 7]	10	[9, 1, 5, 3, 7]
[9, 1, 5, 3, 7]	1	[]
 */
public class LessThanSubset {

    // C O M P L E T E   T H I S   M E T H O D 

    /**
     * Returns the elements in collection strictly less than value.
     */
    public static <T extends Comparable<T>> 
            Collection<T> lessThanSubset(Collection<T> collection, T value) 
   {
        ArrayList<T> result = new ArrayList<>();
        Iterator<T> itr = collection.iterator();
        
        for(int i = 0; i < collection.size(); i++)
        {
            result.add(itr.next());
        }
        
        for(int i = 0; i < result.size(); i++)
        {
            if(result.get(i).compareTo(value) >= 0)
            {
               result.remove(i);
               i--;
            }
            
        }
        return result;
    }

}

