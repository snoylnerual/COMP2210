import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.Comparator;
import java.util.Arrays;


public class AutocompleteTest 
{
   @Test public void Test1() 
   {
      Term[] terms = {new Term("the", 23135851162L),
         new Term("of", 13151942776L),
         new Term("and", 12997637966L),
         new Term("to ", 12136980858L),
         new Term("a", 9081174698L),
         new Term("in", 8469404971L),
         new Term("for", 5933321709L),
         new Term("is", 4705743816L),
         new Term("on", 3750423199L),
         new Term("that", 3400031103L)};
   
      Autocomplete AU = new Autocomplete(terms);
      Term[] t = AU.allMatches("t");
      
      System.out.print("\n\nResult:\n");
      int z = 0;
      for(Term tt : t)
      {  
           System.out.print("|Object " + z++ + ": " + tt + "| ");   
      }
      System.out.println("\n\n");
      Assert.assertEquals(1, 1);
   }




//abc + ab + abcde + a + abcd


   @Test public void Test2() 
   {
      Term[] terms = {new Term("a", 4),
         new Term("ab", 8),
         new Term("abc", 10),
         new Term("abcd", 2),
         new Term("abcde", 6)};
   
      Autocomplete AU = new Autocomplete(terms);
      Term[] t = AU.allMatches("a");
      
      System.out.print("\n\nResult:\n");
      int z = 0;
      for(Term tt : t)
      {  
           System.out.print("|Object " + z++ + ": " + tt + "| ");   
      }
      System.out.println("\n\n");
      Assert.assertEquals(1, 1);
   }
   
   
   //Terms: (az 1), (abcde 1) Length: 3
   @Test public void Test3() 
   {
      Term[] terms = {new Term("az", 1), new Term("abcde", 1)};
      
      Comparator<Term> comp = Term.byPrefixOrder(3);
      Arrays.sort(terms, comp);
      
      System.out.print("\n\nResult:\n");
      int z = 0;
      for(Term tt : terms)
      {  
           System.out.print("|Object " + z++ + ": " + tt + "| ");   
      }
      System.out.println("\n\n");
      Assert.assertEquals(1, 1);
   }
}


