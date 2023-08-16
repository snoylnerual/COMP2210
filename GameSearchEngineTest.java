import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.SortedSet;
import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.util.TreeSet;
import java.lang.Math;

public class GameSearchEngineTest 
{
   /**@Test public void ConstructorTest() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String b = test.getBoard();
      System.out.print("\nTest\n" + b);
      Assert.assertTrue(b.contains("E") && b.contains("P") && b.contains("Y"));
   }
   
   
   @Test public void SetBoardTest1() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String[] a = {"F", "E", "E", "T", "Z", "A", "E", "P", "W", "N", "B", "O", "Q", "S", "T", "Y"};
      test.setBoard(a);
      String b = test.getBoard();
      System.out.print("\nTest1\n" + b);
      Assert.assertTrue(b.contains("E") && b.contains("P") && b.contains("Z"));
   }
   
   @Test(expected = IllegalArgumentException.class) 
   public void SetBoardTest2() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String[] a = {"F", "E", "E", "T", "Z", "A", "E", "P", "W", "N", "B", "O", "Q", "S", "T", "Y", "U", "O", "P"};
      test.setBoard(a);
   }
   
   @Test(expected = IllegalArgumentException.class) 
   public void SetBoardTest3() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String[] a = {"F", "E", "E"};
      test.setBoard(a);
   }
   
   @Test public void SetBoardTest4() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String[] a = {"F", "E", "E", "T", "Z", "A", "E", "P", "W", "N", "B", "O", "Q", "S", "T", "Y", "U", "O", "P", "O", "J", "A", "S", "E", "I"};
      test.setBoard(a);
      String b = test.getBoard();
      System.out.print("\nTest3\n" + b);
      Assert.assertTrue(b.contains("Z") && b.contains("O") && b.contains("I"));
   }
   
   
   @Test public void IsOnBoardTest1() 
   {
      GameSearchEngine test = new GameSearchEngine();
      List<Integer> il = new ArrayList<Integer>();
      il.add(7);
      il.add(6);
      il.add(3);
      il.add(2);
      il.add(1);
      test.loadLexicon("CSW12.txt");
      
      Assert.assertEquals(test.isOnBoard("PEACE"), il);
   }
   
   @Test public void IsOnBoardTest2() 
   {
      GameSearchEngine test = new GameSearchEngine();
      List<Integer> il = new ArrayList<Integer>();
      test.loadLexicon("CSW12.txt");
      
      Assert.assertEquals(test.isOnBoard("PALE"), il);
   }
   
   @Test public void IsOnBoardTest3() 
   {
      GameSearchEngine test = new GameSearchEngine();
      List<Integer> il = new ArrayList<Integer>();
      il.add(14);
      il.add(11);
      il.add(6);
      il.add(2);
      il.add(3);
      il.add(7);
      test.loadLexicon("CSW12.txt");
      
      Assert.assertEquals(test.isOnBoard("TOECAP"), il);
   }
   
    @Test public void IsValidPrefixTest1() 
   {
      GameSearchEngine test = new GameSearchEngine();
      test.loadLexicon("CSW12.txt");
      
      Assert.assertTrue(test.isValidPrefix("A"));
   }
   
   @Test public void IsValidPrefixTest2() 
   {
      GameSearchEngine test = new GameSearchEngine();
      test.loadLexicon("CSW12.txt");
      
      Assert.assertTrue(test.isValidPrefix("Z"));
   }
   
   
   @Test public void IsValidPrefixTest3() 
   {
      GameSearchEngine test = new GameSearchEngine();
      test.loadLexicon("CSW12.txt");
      
      Assert.assertFalse(test.isValidPrefix("Qaaaa"));
   }
   
   
   @Test public void IsValidWordTest1() 
   {
      GameSearchEngine test = new GameSearchEngine();
      test.loadLexicon("CSW12.txt");
      
      Assert.assertTrue(test.isValidWord("APPLE"));
   }
   
   @Test public void IsValidWordTest2() 
   {
      GameSearchEngine test = new GameSearchEngine();
      test.loadLexicon("CSW12.txt");
      
      Assert.assertTrue(test.isValidWord("ZOO"));
   }
   
   
   @Test public void IsValidWordTest3() 
   {
      GameSearchEngine test = new GameSearchEngine();
      test.loadLexicon("CSW12.txt");
      
      Assert.assertFalse(test.isValidWord("Qaaaa"));
   }
   
   
   @Test public void getAllScoreableWordsTest1() 
   {
      GameSearchEngine test = new GameSearchEngine();
      
      SortedSet<String> ss = new TreeSet<String>();
      ss.add("ALEPOT");
      ss.add("BENTHAL");
      ss.add("PELEAN");
      ss.add("TOECAP");
      
      test.loadLexicon("words.txt");
      test.setBoard(new String[]{"E", "E", "C", "A", "A", "L", "E", "P", "H", 
                                 "N", "B", "O", "Q", "T", "T", "Y"});
      System.out.print("LENT is on the board at the following positions: ");
      System.out.println(test.isOnBoard("LENT"));
      System.out.print("POPE is not on the board: ");
      System.out.println(test.isOnBoard("POPE"));
      System.out.println("All words of length 6 or more: ");
      SortedSet<String> sss = test.getAllScorableWords(6);
      System.out.println(sss);
      Assert.assertEquals(sss, ss);
   }
   
   
   @Test public void getAllScoreableWordsTest2() 
   {
      GameSearchEngine test = new GameSearchEngine();
      
      test.loadLexicon("words.txt");
      SortedSet<String> wordSet = new TreeSet<String>();
      wordSet.add("BOY");
      
      wordSet.add("ALBEE");
      wordSet.add("ALCAE");
      wordSet.add("ALEPOT");
      wordSet.add("ANELE");
      wordSet.add("BECAP");
      
      wordSet.add("BELAH");
      wordSet.add("BELEE");
      wordSet.add("BENTHAL");
      wordSet.add("BENTY");
      wordSet.add("BLENT");

      wordSet.add("CAPEL");
      wordSet.add("CAPOT");
      wordSet.add("CENTO");
      wordSet.add("CLEAN");
      wordSet.add("ELEAN");
      
      wordSet.add("LEANT");
      wordSet.add("LENTH");
      wordSet.add("LENTO");
      wordSet.add("NEELE");
      wordSet.add("PEACE");
      
      wordSet.add("PEELE");
      wordSet.add("PELEAN");
      wordSet.add("PENAL");
      wordSet.add("THANE");
      wordSet.add("TOECAP");
      
      wordSet.add("TOPEE");
      
      
      SortedSet<String> sss = test.getAllScorableWords(6);
      System.out.println(sss);
      Assert.assertEquals(test.getScoreForWords(wordSet, 5), 31);
   }*/
   
   
   @Test public void Test() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String[] a = {"TIGER", };
      test.setBoard(a);
      test.loadLexicon("testing.txt");
      SortedSet<String> ss = test.getAllScorableWords(3);
      System.out.print(ss);
   }
   
   @Test public void Test2() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String[] a = {"CAT","X","XXXX","FISH",};
      test.setBoard(a);
      test.loadLexicon("testing.txt");
      int i = 0, j = 0;
      String[][] Board = {{"CAT", "X"},{"XXXX","FISH"}};
      String wordToCheck = "CATFISH";
      String check = wordToCheck.substring(0,Board[i][j].length());
      boolean t = Board[i][j].equals(check);
      
      SortedSet<String> ss = test.getAllScorableWords(7);
      System.out.print(ss);
   }
   
   @Test public void Test3() 
   {
      GameSearchEngine test = new GameSearchEngine();
      String[] a = {"E","S","P","O","L","I","W","A","D","O","M","O","D","L","V","A","S","T","L","P","H","E","I","R","E",};
      test.setBoard(a);
      test.loadLexicon("words_medium.txt");
      SortedSet<String> ss = test.getAllScorableWords(7);
      System.out.print(ss);
   }
}
