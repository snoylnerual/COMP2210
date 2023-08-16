import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class ArraySumTest {





   /** A test that always fails. **/
   @Test public void Test() 
   {
      int[] a = {1, 2, 3, 4, 5};
      int aleft = 1;
      int aright = 3;
      int aexpected = 9;
      int[] b = {1, 1, 1, 1, 1};
      int bleft = 1;
      int bright = 4;
      int bexpected = 4;
      int[] c = {0, 0, 0, 0, 0};
      int cleft = 0;
      int cright = 4;
      int cexpected = 0;
      int[] d = {1, 3, 5, 7, 9};
      int dleft = 0;
      int dright = 4;
      int dexpected = 25;
      
      System.out.print(ArraySum.sum(a, aleft, aright) + " ==  " + aexpected + "\n");
      
      System.out.print(ArraySum.sum(b, bleft, bright) + " ==  " + bexpected + "\n");
      
      System.out.print(ArraySum.sum(c, cleft, cright) + " ==  " + cexpected + "\n");
      
      System.out.print(ArraySum.sum(d, dleft, dright) + " ==  " + dexpected + "\n");
      
      
   }
}
