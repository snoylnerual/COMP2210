/**
 * Provides a sum function on arrays.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 */
public class ArraySum {

	/** Returns the sum of values in the given array. */
	public static int sum(int[] a, int left, int right) 
    {
		
        if(left == right)
        {
            return a[right];
        }
        
        int sumNum = sum(a, left+1, right);    
          
        return sumNum + a[left];
	}
}