import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;


public class SelectorTest 
{
   
   @Test public void kminTest() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(3, 7, 1, 9, 5));
      int k = 1;
      Integer expected = 1;
      Integer actual = Selector.kmin(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);

   }

   /** A test that tests the kmin method. **/
   @Test public void kminTest1() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(2, 8, 7, 3, 4));
      int k = 1;
      Integer expected = 2;
      Integer actual = Selector.kmin(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
   
   /** A test that tests the kmin method. **/
   @Test public void kminTest2() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(5, 9, 1, 7, 3));
      int k = 3;
      Integer expected = 5;
      Integer actual = Selector.kmin(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
   
   /** A test that tests the kmin method. **/
   @Test public void kminTest3() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 7, 6, 5, 4));
      int k = 5;
      Integer expected = 8;
      Integer actual = Selector.kmin(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
   
   /** A test that tests the kmin method. **/
   @Test public void kminTest4() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
      int k = 3;
      Integer expected = 4;
      Integer actual = Selector.kmin(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
   
   /** A test that tests the kmin method. **/
   @Test(expected = NoSuchElementException.class) 
   public void kminTest5() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of());
      int k = 3;
      Integer expected = 4;
      Integer actual = Selector.kmin(a, k, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }
   
   /** A test that tests the kmin method. **/
   @Test(expected = IllegalArgumentException.class) 
   public void kminTest6() 
   {
      List<Integer> a = null;
      int k = 3;
      Integer expected = 4;
      Integer actual = Selector.kmin(a, k, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }
   
   //////////////////////////////
   //////////// KMAX ////////////   
   //////////////////////////////
   
   @Test public void kmaxTest() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(3, 7, 1, 9, 5));
      int k = 1;
      Integer expected = 9;
      Integer actual = Selector.kmax(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);

   }
   
    /** A test that tests the kmax method. **/
   @Test public void kmaxTest1() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(2, 8, 7, 3, 4));
      int k = 1;
      Integer expected = 8;
      Integer actual = Selector.kmax(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);

   }
   
   /** A test that tests the kmax method. **/
   @Test public void kmaxTest2() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(5, 9, 1, 7, 3));
      int k = 3;
      Integer expected = 5;
      Integer actual = Selector.kmax(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);

   }
   
   /** A test that tests the kmax method. **/
   @Test public void kmaxTest3() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 7, 6, 5, 4));
      int k = 5;
      Integer expected = 4;
      Integer actual = Selector.kmax(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);

   }
   
   /** A test that tests the kmax method. **/
   @Test public void kmaxTest4() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
      int k = 3;
      Integer expected = 4;
      Integer actual = Selector.kmax(a, k, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);

   }
   
   /** A test that tests the kmax method. **/
   @Test(expected = NoSuchElementException.class) 
   public void kmaxTest5() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of());
      int k = 1;
      Integer expected = 2;
      Integer actual = Selector.kmax(a, k, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);

   }
   
   /** A test that tests the kmax method. **/
   @Test(expected = IllegalArgumentException.class) 
   public void kmaxTest6() 
   {
      List<Integer> a = null;
      int k = 1;
      Integer expected = 2;
      Integer actual = Selector.kmax(a, k, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);

   }
   
   //////////////////////////////
   //////////// RANGE ///////////   
   //////////////////////////////
   
   /** A test that tests the range method. **/
   @Test public void rangeTest1() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(2, 8, 7, 3, 4));
      Integer low = 1;
      Integer high = 5;
      Collection<Integer> expected = new ArrayList<Integer>(List.of(2, 3, 4));
      Collection<Integer> actual = Selector.range(a, low, high, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the range method. **/
   @Test public void rangeTest2() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(5, 9, 1, 7, 3));
      Integer low = 3;
      Integer high = 5;
      Collection<Integer> expected = new ArrayList<Integer>(List.of(5, 3));
      Collection<Integer> actual = Selector.range(a, low, high, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the range method. **/
   @Test public void rangeTest3() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 7, 6, 5, 4));
      Integer low = 4;
      Integer high = 8;
      Collection<Integer> expected = new ArrayList<Integer>(List.of(8, 7, 6, 5, 4));
      Collection<Integer> actual = Selector.range(a, low, high, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the range method. **/
   @Test public void rangeTest4() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
      Integer low = 3;
      Integer high = 7;
      Collection<Integer> expected = new ArrayList<Integer>(List.of(7, 3, 3, 4));
      Collection<Integer> actual = Selector.range(a, low, high, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
   
   /** A test that tests the range method. **/
   @Test(expected = NoSuchElementException.class) 
   public void rangeTest5() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of());
      Integer low = 1;
      Integer high = 1;
      Collection<Integer> expected = new ArrayList<Integer>(List.of());
      Collection<Integer> actual = Selector.range(a, low, high, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }
   
   /** A test that tests the eange method. **/
   @Test(expected = IllegalArgumentException.class) 
   public void rangeTest6() 
   {
     List<Integer> a = null;
      Integer low = 1;
      Integer high = 1;
      Collection<Integer> expected = new ArrayList<Integer>(List.of());
      Collection<Integer> actual = Selector.range(a, low, high, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }

   //////////////////////////////
   //////////// FLOOR ///////////   
   //////////////////////////////
   
   /** A test that tests the floor method. **/
   @Test public void floorTest1() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(2, 8, 7, 3, 4));
      Integer key = 6;
      Integer expected = 4;
      Integer actual = Selector.floor(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);

   }

   /** A test that tests the floor method. **/
   @Test public void floorTest2() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(5, 9, 1, 7, 3));
      Integer key = 1;
      Integer expected = 1;
      Integer actual = Selector.floor(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the floor method. **/
   @Test public void floorTest3() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 7, 6, 5, 4));
      Integer key = 9;
      Integer expected = 8;
      Integer actual = Selector.floor(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the floor method. **/
   @Test public void floorTest4() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
      Integer key = 5;
      Integer expected = 4;
      Integer actual = Selector.floor(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
   
   /** A test that tests the floor method. **/
   @Test(expected = NoSuchElementException.class) 
   public void floorTest5() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of());
      Integer key = 1;
      Integer expected = 1;
      Integer actual = Selector.floor(a, key, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }
   
   /** A test that tests the floor method. **/
   @Test(expected = IllegalArgumentException.class) 
   public void floorTest6() 
   {
      List<Integer> a = null;
      Integer key = 1;
      Integer expected = 1;
      Integer actual = Selector.floor(a, key, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }
   
   //////////////////////////////
   ////////// CEILING ///////////   
   //////////////////////////////
   
   /** A test that tests the ceiling method. **/
   @Test public void ceilingTest1() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(2, 8, 7, 3, 4));
      Integer key = 1;
      Integer expected = 2;
      Integer actual = Selector.ceiling(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the ceiling method. **/
   @Test public void ceilingTest2() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(5, 9, 1, 7, 3));
      Integer key = 7;
      Integer expected = 7;
      Integer actual = Selector.ceiling(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the ceiling method. **/
   @Test public void ceilingTest3() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 7, 6, 5, 4));
      Integer key = 0;
      Integer expected = 4;
      Integer actual = Selector.ceiling(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }

   /** A test that tests the ceiling method. **/
   @Test public void ceilingTest4() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(8, 2, 8, 7, 3, 3, 4));
      Integer key = 5;
      Integer expected = 7;
      Integer actual = Selector.ceiling(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
   
   /** A test that tests the ceiling method. **/
   @Test(expected = NoSuchElementException.class) 
   public void ceilingTest5() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of());
      Integer key = 1;
      Integer expected = 1;
      Integer actual = Selector.ceiling(a, key, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }
   
   /** A test that tests the ceiling method. **/
   @Test(expected = IllegalArgumentException.class) 
   public void ceilingTest6() 
   {
      List<Integer> a = null;
      Integer key = 1;
      Integer expected = 1;
      Integer actual = Selector.ceiling(a, key, Comparator.<Integer>naturalOrder());
      //assertEquals(actual, expected);
   }
   
   /** A test that tests the ceiling method. **/
   @Test public void ceilingTest7() 
   {
      List<Integer> a = new ArrayList<Integer>(List.of(9, 7));
      Integer key = 9;
      Integer expected = 9;
      Integer actual = Selector.ceiling(a, key, Comparator.<Integer>naturalOrder());
      assertEquals(actual, expected);
   }
}

