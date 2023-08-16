/**
 * Implements shift-right behavior in an array.
 *
 *
Call:	shiftRight(a, 2)
Before:	a = [1, 3, 5, 7, 9, null, null, null, null, null]
After:	a = [1, 3, null, 5, 7, 9, null, null, null, null]
Call:	shiftRight(a, 0)
Before:	a = [1, 3, 5, 7, 9, null, null, null, null, null]
After:	a = [null, 1, 3, 5, 7, 9, null, null, null, null]
Call:	shiftRight(a, 4)
Before:	a = [1, 3, 5, 7, 9, null, null, null, null, null]
After:	a = [1, 3, 5, 7, null, 9, null, null, null, null]
Call:	shiftRight(a, 5)
Before:	a = [1, 3, 5, 7, 9, null, null, null, null, null]
After:	a = [1, 3, 5, 7, 9, null, null, null, null, null]
 */

public class ShiftRight {


    /**
     * Shifts the elements at a[index] through a[a.length - 2] one
     * position to the right. 
     */
    public static void shiftRight(Object[] array, int index) 
    {

        // FILL IN THE BODY OF THIS METHOD
        //check that no duplicates
        //just adds a null space
        
        for(int i = array.length-2 ; i >= index; i--)
        {
           array[i+1] = array[i];
        }
        array[index] = null;
    }

}
