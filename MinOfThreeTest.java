import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest 
{

   //////////////////////
   ///////  min1  ///////
   //////////////////////
   
   /** A test that always fails. **/
   @Test public void test1() 
   {
      int a = 0;
      int b = 1;
      int c = 2;
      int expected = 0;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** A test that always fails. **/
   @Test public void test2() 
   {
      int a = 1;
      int b = 0;
      int c = 2;
      int expected = 0;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** A test that always fails. **/
   @Test public void test3() 
   {
      int a = 1;
      int b = 2;
      int c = 0;
      int expected = 0;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial1() {
        int a = 2;
        int b = 2;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }
   
   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial2() {
        int a = 3;
        int b = 2;
        int c = 3;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial3() {
        int a = 2;
        int b = 3;
        int c = 3;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

    /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial4() {
        int a = 3;
        int b = 3;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial5() {
        int a = 2;
        int b = 2;
        int c = 3;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial6() {
        int a = 3;
        int b = 2;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }

   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial7() {
        int a = 2;
        int b = 3;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min1(a, b, c);
        assertEquals(expected, actual);
    }
   
   //////////////////////
   ///////  min2  ///////
   //////////////////////
   
   /** A test that always fails. **/
   @Test public void test12() 
   {
      int a = 0;
      int b = 1;
      int c = 2;
      int expected = 0;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** A test that always fails. **/
   @Test public void test22() 
   {
      int a = 1;
      int b = 0;
      int c = 2;
      int expected = 0;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** A test that always fails. **/
   @Test public void test32() 
   {
      int a = 1;
      int b = 2;
      int c = 0;
      int expected = 0;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial12() {
        int a = 2;
        int b = 2;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }
   
   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial22() {
        int a = 3;
        int b = 2;
        int c = 3;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial32() {
        int a = 2;
        int b = 3;
        int c = 3;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

    /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial42() {
        int a = 3;
        int b = 3;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }
    
    /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial52() {
        int a = 2;
        int b = 2;
        int c = 3;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial62() {
        int a = 3;
        int b = 2;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }

   /** Test with a.length = 2, duplicates, target not found */
    @Test
    public void testSpecial72() {
        int a = 2;
        int b = 3;
        int c = 2;
        int expected = 2;
        int actual = MinOfThree.min2(a, b, c);
        assertEquals(expected, actual);
    }
}
