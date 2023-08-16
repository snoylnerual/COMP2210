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
import java.util.Arrays;
import java.util.Iterator;


public class GameSearchEngine implements WordSearchGame
{
     private String[][] Board;
     private boolean[][] PBoard;
     private int N;
     private boolean lexiconState;
     TreeSet<String> lexicon;
     
     /*
     default board = a = ["E", "E", "C", "A", "A", "L", "E", "P", "H", "N", "B", "O", "Q", "T", "T", "Y"]
     */
     public GameSearchEngine()
     {
         String[] a = {"E", "E", "C", "A", "A", "L", "E", "P", "H", "N", "B", "O", "Q", "T", "T", "Y"};
         setBoard(a);
         N = 4;
         lexiconState = false;
         PBoard = new boolean[N][N];
         for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                PBoard[i][j] = false;
            }
        }
     }
     
    /**
     * Loads the lexicon into a data structure for later use. 
     * 
     * @param fileName A string containing the name of the file to be opened.
     * @throws IllegalArgumentException if fileName is null
     * @throws IllegalArgumentException if fileName cannot be opened.
     */
    public void loadLexicon(String fileName) {
        String str = "";
        if (fileName == null) {
            throw new IllegalArgumentException();
        }
        lexicon = new TreeSet<String>();
        try {
            Scanner s = 
                new Scanner(new BufferedReader(new FileReader(new File(fileName))));
            while (s.hasNext()) {
                str = s.next();
                boolean added = lexicon.add(str.toUpperCase());
                if (s.hasNext())
                {
                   s.nextLine();
                }
            }
            lexiconState = true;
        }
        catch (Exception e) {
            throw new IllegalArgumentException("Error loading word list: " + fileName + ": " + e + "    " + str);
        }
    }
    
    
    /**
     * Stores the incoming array of Strings in a data structure that will make
     * it convenient to find words.
     * 
     * @param letterArray This array of length N^2 stores the contents of the
     *     game board in row-major order. Thus, index 0 stores the contents of board
     *     position (0,0) and index length-1 stores the contents of board position
     *     (N-1,N-1). Note that the board must be square and that the strings inside
     *     may be longer than one character.
     * @throws IllegalArgumentException if letterArray is null, or is  not
     *     square.
     */
    public void setBoard(String[] letterArray)
    {
        if (letterArray == null) {
            throw new IllegalArgumentException("Null Array");
        }
        
        int n = (int) java.lang.Math.sqrt(letterArray.length);
        if ((letterArray.length - (n*n)) != 0)
        {
            throw new IllegalArgumentException("Array  is not square");
        }
        N = n;
        int c = 0;
        Board = new String[N][N];
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                Board[i][j] = letterArray[c];
                c++;
            }
        }
         PBoard = new boolean[N][N];
         for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                PBoard[i][j] = false;
            }
        }

        
    }
    
    /**
     * Creates a String representation of the board, suitable for printing to
     *   standard out. Note that this method can always be called since
     *   implementing classes should have a default board.
     */
    public String getBoard()
    {
       String output = "";
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                output += " " + Board[i][j] + " ";
            }
            output += "\n";
        }
        return output;
    }
    
    /**
     * Retrieves all scorable words on the game board, according to the stated game
     * rules.
     * 
     * @param minimumWordLength The minimum allowed length (i.e., number of
     *     characters) for any word found on the board.
     * @return java.util.SortedSet which contains all the words of minimum length
     *     found on the game board and in the lexicon.
     * @throws IllegalArgumentException if minimumWordLength < 1
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public SortedSet<String> getAllScorableWords(int minimumWordLength)
    {
        if (minimumWordLength < 1) 
        {
            throw new IllegalArgumentException("Too small minimum word length");
        }
        if (!lexiconState)
        {
            throw new IllegalStateException("Lexicon not loaded");
        }
        
        SortedSet<String> foundWords = new TreeSet<String>();
        Iterator<String> itr = lexicon.iterator();
        for (int i = 0; i < lexicon.size(); i++)
        {
           String word = itr.next();
           if (word.length() >= minimumWordLength && !isOnBoard(word).equals(new ArrayList<Integer>()))
           {
               foundWords.add(word);
           }
        }
        
        
        return foundWords;
    }
    
    /**
    public SortedSet<String> getAllScorableWords(in minimumWordLength) {
    // do some error-checking first and then:
    SortedSet<String> foundWords = new TreeSet<String>();
    for (each word in the lexicon) {
        if (this word meets the minimum length requirement and
            it is on the board) {
            foundWords.add(word);
        }
    }
    return foundWords;
}
    
    */
    
  /**
    * Computes the cummulative score for the scorable words in the given set.
    * To be scorable, a word must (1) have at least the minimum number of characters,
    * (2) be in the lexicon, and (3) be on the board. Each scorable word is
    * awarded one point for the minimum number of characters, and one point for 
    * each character beyond the minimum number.
    *
    * @param words The set of words that are to be scored.
    * @param minimumWordLength The minimum number of characters required per word
    * @return the cummulative score of all scorable words in the set
    * @throws IllegalArgumentException if minimumWordLength < 1
    * @throws IllegalStateException if loadLexicon has not been called.
    */  
    public int getScoreForWords(SortedSet<String> words, int minimumWordLength)
    {
        if (minimumWordLength < 1) 
        {
            throw new IllegalArgumentException("Null String");
        }
        if (!lexiconState)
        {
            throw new IllegalStateException("Lexicon not loaded");
        }
        int total = 0;
        
        //so seeing if these words are the minimum, in the lexicon, and ontheboard
        SortedSet<String> correct = new TreeSet<String>();
        for (String thing : words)
        {
            if (thing.length() < minimumWordLength)
            {
                continue;
            }
            if (!isValidWord(thing))
            {
                continue;
            }
            List<Integer> path = isOnBoard(thing);
            if (path.equals(new ArrayList<Integer>()))
            {
                continue;
            }
            total += 1 + (thing.length() - minimumWordLength);
        
        }
        
        return total;
    }
    
    /**
     * Determines if the given word is in the lexicon.
     * 
     * @param wordToCheck The word to validate
     * @return true if wordToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public boolean isValidWord(String wordToCheck)
    {
        if (wordToCheck == null) 
        {
            throw new IllegalArgumentException("Null String");
        }
        if (!lexiconState)
        {
            throw new IllegalStateException("Lexicon not loaded");
        }
        
        if (lexicon.contains(wordToCheck))
        {
           return true;
        }
        
        return false;
    }
    
    /**
     * Determines if there is at least one word in the lexicon with the 
     * given prefix.
     * 
     * @param prefixToCheck The prefix to validate
     * @return true if prefixToCheck appears in lexicon, false otherwise.
     * @throws IllegalArgumentException if prefixToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public boolean isValidPrefix(String prefixToCheck)
    {
        if (prefixToCheck == null) 
        {
            throw new IllegalArgumentException("Null String");
        }
        if (!lexiconState)
        {
            throw new IllegalStateException("Lexicon not loaded");
        }
        
        String word = lexicon.ceiling(prefixToCheck);
        
        if (word != null && word.contains(prefixToCheck))
        {
           return true;
        }
        
        return false;
    }
        
    /**
     * Determines if the given word is in on the game board. If so, it returns
     * the path that makes up the word.
     * @param wordToCheck The word to validate
     * @return java.util.List containing java.lang.Integer objects with  the path
     *     that makes up the word on the game board. If word is not on the game
     *     board, return an empty list. Positions on the board are numbered from zero
     *     top to bottom, left to right (i.e., in row-major order). Thus, on an NxN
     *     board, the upper left position is numbered 0 and the lower right position
     *     is numbered N^2 - 1.
     * @throws IllegalArgumentException if wordToCheck is null.
     * @throws IllegalStateException if loadLexicon has not been called.
     */
    public List<Integer> isOnBoard(String wordToCheck)
    {
        if (wordToCheck == null) 
        {
            throw new IllegalArgumentException("Null String");
        }
        if (!lexiconState)
        {
            throw new IllegalStateException("Lexicon not loaded");
        }
        
        List<Integer> locations = new ArrayList<Integer>();
        StringBuilder word = new StringBuilder();
        
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
            {
                if (Board[i][j].equals(wordToCheck.substring(0,0)) || Board[i][j].equals(wordToCheck) || 
                   (Board[i][j].length() < wordToCheck.length() && Board[i][j].equals(wordToCheck.substring(0,Board[i][j].length()))))
                {
                     word = new StringBuilder();
                     locations = new ArrayList<Integer>();
                     if (dfs(i, j, word, wordToCheck, locations))
                     {
                         for (int k = 0; k < N; k++)
                         {
                             for (int m = 0; m < N; m++)
                             {
                                 PBoard[k][m] = false;
                             }
                         }

                         return locations;
                    }
                }
            }
        }
        
        return new ArrayList<Integer>();
    }
    
    
    private boolean dfs(int positionx, int positiony, StringBuilder wordSoFar,
                        String wordToCheck, List<Integer> path) 
    {
          if (positionx >= N || positiony >= N || positionx < 0 || positiony < 0) 
          {
              return false;
          }
      
          if (PBoard[positionx][positiony]) 
          {
              return false;
          }
          
          PBoard[positionx][positiony] = true;
          //mark position as visited
          wordSoFar.append(Board[positionx][positiony]);
          //add the contents of this position on the board to wordSoFar
          path.add(positionx * N + positiony);
          //add the row-major number of this position to path
          
          
          if (wordToCheck.length() > wordSoFar.length() && !wordSoFar.toString().equals(wordToCheck.substring(0, wordSoFar.length())))
          {
              PBoard[positionx][positiony] = false;
              for (int l = Board[positionx][positiony].length(); l > 0 ; l--)
              {
                  wordSoFar.deleteCharAt(wordSoFar.length()-1);
              }
              Integer num = (Integer) positionx * N + positiony;
              path.remove(num);
              return false;
          }
          if (wordToCheck.length() == wordSoFar.length())
          {
              if (!wordSoFar.toString().equals(wordToCheck)) 
              {
                  PBoard[positionx][positiony] = false;
                  for (int l = Board[positionx][positiony].length(); l > 0 ; l--)
                  {
                      wordSoFar.deleteCharAt(wordSoFar.length()-1);
                  }
                  Integer num = (Integer) positionx * N + positiony;
                  path.remove(num);
                  return false;
              }

          }
      
          if (wordSoFar.toString().equals(wordToCheck)) 
          {
              return true;
          }
          
          List<Integer[]> nbrs = neighbors(positionx, positiony);
          
          for (Integer[] n : nbrs) 
          {
              if (dfs(n[0], n[1], wordSoFar, wordToCheck, path)) 
              {
                  return true;
              }
          }
          
          PBoard[positionx][positiony] = false;
          for (int l = Board[positionx][positiony].length(); l > 0 ; l--)
          {
              wordSoFar.deleteCharAt(wordSoFar.length()-1);
          }
          Integer num = (Integer) positionx * N + positiony;
          path.remove(num);
          return false;
    }
    
    private List<Integer[]> neighbors(int px, int py)
    {
         List<Integer[]> neighborA = new ArrayList<Integer[]>();
         int count = 0, pxx, pyy;
         Integer[] p = new Integer[2], p2 = new Integer[2];
         // generate all eight neighbor positions
         // add to return value if valid
         for (int i = px-1; i <= px+1; i++) 
         {
             for (int j = py-1; j <= py+1; j++) 
             {
                  pxx = i;
                  pyy = j;
                  if (!(pxx >= N || pyy >= N || pxx < 0 || pyy < 0) && (pxx != px || pyy != py)) 
                  {
                      p[0] = pxx;
                      p[1] = pyy;
                      p2 = Arrays.copyOf(p, p.length);
                      neighborA.add(p2);
                  }
             }
         }
         return neighborA;
    }
    
    
}



