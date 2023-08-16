import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.TreeSet;
import java.util.Iterator;


public class LinkedSetTest 
{
   /** tests constructor with parameters **/
   @Test public void ConstructorTest() 
   {
      LinkedSet links = new LinkedSet();
      LinkedSet.Node n = links.new Node(5);
      
      
         
      //Assert.assertEquals(n, links.front);
   }


   /**  **/
   @Test public void AddTest1() 
   {
      LinkedSet linked = new LinkedSet();
      linked.front = linked.new Node(5);
      linked.front.prev = null;
      linked.front.next = linked.new Node(7);
      linked.front.next.prev = linked.front;
      linked.size = 2;
      
      linked.add(6);
      Assert.assertEquals(linked.front.next.element, 6);
   }
   
   /**  **/
   @Test public void AddTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      Assert.assertEquals(linked.front.element, 6);
      Assert.assertEquals(linked.rear.element, 6);
   }
   
   /**  **/
   @Test public void AddTest3() 
   {
      LinkedSet linked = new LinkedSet();
      linked.front = linked.new Node(5);
      linked.front.prev = null;
      linked.front.next = linked.new Node(7);
      linked.front.next.prev = linked.front;
      linked.size = 2;
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      Assert.assertEquals(linked.front.next.element, 5);
      Assert.assertEquals(linked.front.element, 4);
      Assert.assertEquals(linked.rear.element, 8);
   }
   
   
   
   
   
   
   
   @Test public void RemoveTest1() 
   {
      LinkedSet linked = new LinkedSet();
      linked.front = linked.new Node(5);
      linked.front.prev = null;
      linked.front.next = linked.new Node(7);
      linked.front.next.prev = linked.front;
      linked.size = 2;
      
      linked.add(6);
      linked.remove(5);
      Assert.assertEquals(linked.front.element, 6);
   }
   
    @Test public void RemoveTest2() 
   {
      LinkedSet linked = new LinkedSet();
      linked.front = linked.new Node(5);
      linked.front.prev = null;
      linked.front.next = linked.new Node(7);
      linked.front.next.prev = linked.front;
      linked.size = 2;
      linked.rear = linked.front.next;
      
      linked.add(6);
      linked.remove(7);
      Assert.assertEquals(linked.rear.element, 6);
   }
   
   
   @Test public void RemoveTest3() 
   {
      LinkedSet linked = new LinkedSet();
       
      linked.add(6);
      linked.remove(6);
      Assert.assertEquals(linked.rear, null);
      Assert.assertEquals(linked.front, null);
   }
   
   @Test public void RemoveTest4() 
   {
      LinkedSet linked = new LinkedSet();
      linked.front = linked.new Node(5);
      linked.front.prev = null;
      linked.front.next = linked.new Node(7);
      linked.front.next.prev = linked.front;
      linked.size = 2;
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Assert.assertEquals(false, linked.add(5));
      Assert.assertEquals(linked.rear.element, 9);      
      Assert.assertEquals(linked.front.element, 5);
      Assert.assertEquals(linked.front.next.element, 6);
      Assert.assertEquals(linked.front.next.next.element, 7);
      Assert.assertEquals(linked.rear.prev.element, 7);
   }
   
   
   
   @Test public void ContainsTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Assert.assertFalse(linked.contains(7));
      Assert.assertTrue(linked.contains(9));
      Assert.assertFalse(linked.contains(null));
   }
   
   @Test public void ContainsTest2() 
   {
      LinkedSet linked = new LinkedSet();

      Assert.assertFalse(linked.contains(7));
      Assert.assertFalse(linked.contains(9));
      Assert.assertFalse(linked.contains(null));
   }
   
   
   
   
   /**@Test public void EqualsTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Set<Integer> test = new LinkedSet();//TreeMap<String, Set<Integer>>();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Assert.assertFalse(linked.equals(test));
   }*/
   
   
   @Test public void LEqualsTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();//TreeMap<String, Set<Integer>>();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Assert.assertFalse(linked.equals(test));
   }
   
   @Test public void LEqualsTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      
      LinkedSet test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Assert.assertFalse(linked.equals(test));
   }
   
   @Test public void LEqualsTest4() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Assert.assertFalse(linked.equals(test));
   }
   
   @Test public void LEqualsTest5() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Assert.assertTrue(linked.equals(test));
   }
   
   @Test public void LEqualsTest6() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();
      test.add(8);
      test.add(4);
      test.add(6);
      test.add(9);
      
      Assert.assertTrue(linked.equals(test));
   }
   
   @Test public void LEqualsTest7() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Assert.assertFalse(linked.equals(test));
   }
   
   
   
   
   
   @Test public void IntersectionTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      
      Set test = new LinkedSet();      
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void IntersectionTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();      
      test.add(6);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void IntersectionTest3() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Set test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void IntersectionTest4() 
   {
      LinkedSet linked = new LinkedSet();
      
      
      Set test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void IntersectionTest5() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Set test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void IntersectionTest6() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      exp.add(4);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void IntersectionTest7() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();
      test.add(8);
      test.add(4);
      test.add(6);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(8);
      exp.add(6);
      exp.add(9);
      exp.add(4);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   
   
   @Test public void LIntersectionTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      
      LinkedSet test = new LinkedSet();      
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LIntersectionTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();      
      test.add(6);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LIntersectionTest3() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LIntersectionTest4() 
   {
      LinkedSet linked = new LinkedSet();
      
      
      LinkedSet test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LIntersectionTest5() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LIntersectionTest6() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      exp.add(4);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LIntersectionTest7() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();
      test.add(8);
      test.add(4);
      test.add(6);
      test.add(9);
      
      Set ans = linked.intersection(test);
      LinkedSet exp = new LinkedSet();
      exp.add(8);
      exp.add(6);
      exp.add(9);
      exp.add(4);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   
   
   
   
   
   @Test public void UnionTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      
      Set test = new LinkedSet();      
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(6);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void UnionTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();      
      test.add(6);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(6);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void UnionTest3() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Set test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(3);
      exp.add(4);
      exp.add(5);
      exp.add(6);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void UnionTest4() 
   {
      LinkedSet linked = new LinkedSet();
      
      
      Set test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(5);
      exp.add(3);
      exp.add(4);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void UnionTest5() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Set test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      exp.add(4);
      exp.add(9);
      exp.add(8);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void UnionTest6() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();
      test.add(1);
      test.add(2);
      test.add(3);
      test.add(7);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(1);
      exp.add(2);
      exp.add(3);
      exp.add(4);
      exp.add(6);
      exp.add(7);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void UnionTest7() 
   {
      LinkedSet linked = new LinkedSet();
      
      Set test = new LinkedSet();
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   
   @Test public void LUnionTest() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(1);
      linked.add(2);
      linked.add(3);
      
      LinkedSet test = new LinkedSet();      
      test.add(1);
      test.add(2);
      test.add(3); 
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(1);
      exp.add(2);
      exp.add(3); 
      
      Assert.assertTrue(exp.equals(ans));
   }

   
   @Test public void LUnionTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      
      LinkedSet test = new LinkedSet();      
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(6);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LUnionTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();      
      test.add(6);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(6);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LUnionTest3() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(3);
      exp.add(4);
      exp.add(5);
      exp.add(6);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LUnionTest4() 
   {
      LinkedSet linked = new LinkedSet();
      
      
      LinkedSet test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(5);
      exp.add(3);
      exp.add(4);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LUnionTest5() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(6);
      exp.add(4);
      exp.add(9);
      exp.add(8);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LUnionTest6() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();
      test.add(1);
      test.add(2);
      test.add(3);
      test.add(7);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(1);
      exp.add(2);
      exp.add(3);
      exp.add(4);
      exp.add(6);
      exp.add(7);
      exp.add(8);
      exp.add(9);
   }
   
   @Test public void LUnionTest7() 
   {
      LinkedSet linked = new LinkedSet();
      
      LinkedSet test = new LinkedSet();
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LUnionTest8() 
   {
      LinkedSet linked = new LinkedSet();
      linked.add(1);
      linked.add(2);
      linked.add(3);
      
      LinkedSet test = new LinkedSet();
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(1);
      exp.add(2);
      exp.add(3);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LUnionTest9() 
   {
      LinkedSet linked = new LinkedSet();
      linked.add(1);
      linked.add(2);
      linked.add(3);
      
      LinkedSet test = new LinkedSet();
      test.add(1);
      test.add(2);
      test.add(3);
      
      Set ans = linked.union(test);
      LinkedSet exp = new LinkedSet();
      exp.add(1);
      exp.add(2);
      exp.add(3);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
    @Test public void ComplementTest() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(1);
      linked.add(2);
      linked.add(3);
      
      Set test = new LinkedSet();      
      test.add(2);
      test.add(3);
      test.add(1);
      
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }   
   
   @Test public void ComplementTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      
      Set test = new LinkedSet();      
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void ComplementTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();      
      test.add(6);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void ComplementTest3() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Set test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(3);
      exp.add(4);
      exp.add(5);
      exp.add(6);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void ComplementTest4() 
   {
      LinkedSet linked = new LinkedSet();
      
      
      Set test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(5);
      exp.add(3);
      exp.add(4);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void ComplementTest5() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      Set test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(8);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void ComplementTest6() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void ComplementTest7() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      Set test = new LinkedSet();
      test.add(8);
      test.add(4);
      test.add(6);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   
   
   @Test public void LComplementTest1() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      
      LinkedSet test = new LinkedSet();      
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LComplementTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();      
      test.add(6);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(8);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LComplementTest3() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(3);
      exp.add(4);
      exp.add(5);
      exp.add(6);
      exp.add(9);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LComplementTest4() 
   {
      LinkedSet linked = new LinkedSet();
      
      
      LinkedSet test = new LinkedSet();
      test.add(5);
      test.add(3);
      test.add(4);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(5);
      exp.add(3);
      exp.add(4);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LComplementTest5() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      linked.remove(8);
      linked.remove(4);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      exp.add(4);
      exp.add(8);
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LComplementTest6() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();
      test.add(6);
      test.add(4);
      test.add(8);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   @Test public void LComplementTest7() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(9);
      
      LinkedSet test = new LinkedSet();
      test.add(8);
      test.add(4);
      test.add(6);
      test.add(9);
      
      Set ans = linked.complement(test);
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(ans));
   }
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   
   @Test public void RemovalTest() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(6);
      linked.add(2);
      linked.add(5);
      linked.add(4);
      linked.add(3);
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(24);
      linked.add(0);
      linked.add(11);
      linked.add(2);
      
      linked.remove(6);
      linked.remove(2);
      linked.remove(5);
      linked.remove(4);
      linked.remove(3);
      linked.remove(6);
      linked.remove(4);
      linked.remove(8);
      linked.remove(24);
      linked.remove(0);
      linked.remove(11);
      linked.remove(2);
      
      linked.add(6);
      linked.add(2);
      linked.add(5);
      linked.add(4);
      linked.add(3);
      linked.add(6);
      linked.add(4);
      linked.add(8);
      linked.add(24);
      linked.add(0);
      linked.add(11);
      linked.add(2);
      
      LinkedSet exp = new LinkedSet();
      
      Assert.assertTrue(exp.equals(linked));
   }
   
   @Test public void RemovalTest2() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(1);
      
      linked.remove(2);
      linked.remove(1);
   }



   @Test public void IteratorTest() 
   {
      LinkedSet linked = new LinkedSet();
      
      linked.add(1);
      linked.add(2);
      linked.add(3);
      //linked.add(4);
      //linked.add(5);
      
      Iterator<Set<Integer>> itr = linked.powerSetIterator();
      Set<Integer> k;
      
      for (int i = 0; i < 32; i++)
      {
      k = itr.next();
      System.out.print(k);
      }
      
   }
}

