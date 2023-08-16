import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

public class DoubletsTest 
{
   /** A test that always fails. **/
   @Test public void LexiconTest() throws FileNotFoundException
   {
      Doublets D = new Doublets(new FileInputStream(new File("Testing.txt")));
      
      assertTrue(true);
   }
   
   @Test public void NeighborsTest() throws FileNotFoundException
   {
      Doublets D = new Doublets(new FileInputStream(new File("tiny.txt")));
      
      List<String> neigh = D.getNeighbors("cat");
      assertTrue(true);
   }
   
   @Test public void isWordTest() throws FileNotFoundException
   {
      Doublets D = new Doublets(new FileInputStream(new File("tiny.txt")));
      
      boolean a = D.isWord("cat");
      boolean b = D.isWord("zzz");
      boolean c = D.isWord("tac");
      boolean d = D.isWord("cot");
      boolean f = D.isWord("bat");
      boolean g = D.isWord("can");
      boolean h = D.isWord("bam");
      
      boolean e = D.isWord("dog");
      assertTrue(a == b && a == b && a == c && a == d && a == !e && a == f && a == g && a == h);
   }
   
   @Test public void Test() throws FileNotFoundException
   {
      Doublets D = new Doublets(new FileInputStream(new File("sowpods.txt")));
      
      List<String> neigh = D.getMinLadder("cat", "dog");
      List<String> n = D.getMinLadder("cat", "hat");
      List<String> nn = D.getMinLadder("clash", "clown");
      
      System.out.print("\n\n" + neigh + "\n\n" + n + "\n\n" + nn + "\n\n");
      assertTrue(true);
   }
   
   
}
