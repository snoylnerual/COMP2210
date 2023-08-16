/**
 * Count the number of even values in an array.
 *Complete the body of the countEvens method so that it returns the 
 *number of even values in the array parameter. Remember that you 
 *can test if an integer is evenly divisible by 2 by using %, the 
 *remainder ("mod") operator in Java. If x % y evaluates to 0, then
 *y divides into x evenly, that is, with no remainder.

The following table lists various examples of the array parameter (values) and the correct return value from the call countEvens(values).

values	Return Value
[1, 2, 3, 4, 5]	2
[2, 4, 6, 8, 10]	5
[0, 1, 2, 3, 4]	3
[1, 1, 1, 1, 1]	0
 */
public class CountEvens {

    //  C O M P L E T E   T H I S    M E T H O D 

    /**
     * Returns the number of even values in the paramter.
     */
    public static int countEvens(int[] values) 
    {
        int count = 0;
        for(int i = 0; i < values.length; i++)
        {
            if((values[i]%2) == 0)
            {
               count++;
            }
        
        }
        
        return count;
    }

}

