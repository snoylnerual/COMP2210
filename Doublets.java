import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

import java.util.stream.Collectors;

/**
 * Provides an implementation of the WordLadderGame interface. 
 *
 * @author Your Name (you@auburn.edu)
 */
public class Doublets implements WordLadderGame 
{

    // The word list used to validate words.
    // Must be instantiated and populated in the constructor.
    /////////////////////////////////////////////////////////////////////////////
    // DECLARE A FIELD NAMED lexicon HERE. THIS FIELD IS USED TO STORE ALL THE //
    // WORDS IN THE WORD LIST. YOU CAN CREATE YOUR OWN COLLECTION FOR THIS     //
    // PURPOSE OF YOU CAN USE ONE OF THE JCF COLLECTIONS. SUGGESTED CHOICES    //
    // ARE TreeSet (a red-black tree) OR HashSet (a closed addressed hash      //
    // table with chaining).
    /////////////////////////////////////////////////////////////////////////////
    private RedBlackTree<String> lexicon;
    private ArrayList<RedBlackTree<String>> lexiconlist = new ArrayList<RedBlackTree<String>>();
    private Node beginning;
    
    
    
    
    
    

    /**
     * Instantiates a new instance of Doublets with the lexicon populated with
     * the strings in the provided InputStream. The InputStream can be formatted
     * in different ways as long as the first string on each line is a word to be
     * stored in the lexicon.
     */
    public Doublets(InputStream in) 
    {
        try {
            lexicon = new RedBlackTree<String>();
            Scanner s =
                new Scanner(new BufferedReader(new InputStreamReader(in)));
            while (s.hasNext()) {
                String str = s.next();
                lexicon.add(str.toLowerCase());
                //split up lexicon by lengths to minimize search time in return for memory in case he calls lexicon in a test case
                boolean added = false;
                Iterator<RedBlackTree<String>> itr = lexiconlist.iterator();
                RedBlackTree<String> curr;
                for(int i = 0; i < lexiconlist.size(); i++)
                {
                   curr = itr.next();
                   if(curr.root.element.length() == str.length())
                   {
                      curr.add(str.toLowerCase());
                      added = true;
                   }
                }     
                if (!added)
                {
                    RedBlackTree<String> addition = new RedBlackTree<String>();
                    addition.add(str.toLowerCase());
                    lexiconlist.add(addition);  
                }        
                
                if (s.hasNext())
                {
                    s.nextLine();
                }
            }
            in.close();
        }
        catch (java.io.IOException e) {
            System.err.println("Error reading from InputStream.");
            System.exit(1);
        }
    }

    private class Node 
    {
        private String word;
        private Node parent;

        public Node(String w, Node p) 
        {
            word = w;
            parent = p;
        }

        @Override
        public String toString() 
        {
            return word;
        }
    }

    //////////////////////////////////////////////////////////////
    // ADD IMPLEMENTATIONS FOR ALL WordLadderGame METHODS HERE  //
    //////////////////////////////////////////////////////////////
    
    
    /**
     * Returns the total number of words in the current lexicon.
     *
     * @return number of words in the lexicon
     */
    public int getWordCount()
    {
        return lexicon.size();
    }


    /**
     * Checks to see if the given string is a word.
     *
     * @param  str the string to check
     * @return     true if str is a word, false otherwise
     */
    public boolean isWord(String str)
    {
        if (str == null)
        {
           return false;
        }
        str = str.toLowerCase();
        
        Iterator<RedBlackTree<String>> itrRBT = lexiconlist.iterator();
        RedBlackTree<String> curr = new RedBlackTree<String>();
        for(int i = 0; i < lexiconlist.size(); i++)
        {
           curr = itrRBT.next();
           if(curr.root.element.length() == str.length())
           {
              break;
           }
        } 
        return curr.contains(str);
    }


    /**
     * Returns the Hamming distance between two strings, str1 and str2. The
     * Hamming distance between two strings of equal length is defined as the
     * number of positions at which the corresponding symbols are different. The
     * Hamming distance is undefined if the strings have different length, and
     * this method returns -1 in that case. See the following link for
     * reference: https://en.wikipedia.org/wiki/Hamming_distance
     *
     * @param  str1 the first string
     * @param  str2 the second string
     * @return      the Hamming distance between str1 and str2 if they are the
     *                  same length, -1 otherwise
     */
    public int getHammingDistance(String str1, String str2)
    {
        str1 = str1.toLowerCase();
        str2 = str2.toLowerCase();
        int count = 0;
        if (str1 == null || str2 == null || str1.length() != str2.length())
        {
           return -1;
        }
        
        for(int i = 0; i < str1.length(); i++)
        {
           if(str1.charAt(i) != str2.charAt(i))
           {
              count++;
           }
        }
        
        return count;
    }


    /**
     * Returns all the words that have a Hamming distance of one relative to the
     * given word.
     *
     * @param  word the given word
     * @return      the neighbors of the given word
     */
    public List<String> getNeighbors(String word)
    {
        word = word.toLowerCase();
        //i have trees of one length
        //gotta locate that tree
        List<String> output = new ArrayList<String>();
        
        Iterator<RedBlackTree<String>> itrRBT = lexiconlist.iterator();
        RedBlackTree<String> curr = new RedBlackTree<String>();;
        Iterator<String> itr = null;
        for(int i = 0; i < lexiconlist.size(); i++)
        {
           curr = itrRBT.next();
           if(curr.root.element.length() == word.length())
           {
               itr = curr.iterator();
               break;
           }
        }   
        if (itr == null)
        {
           return null;
        }
        String wor;
        
        for(int i = 0; i < curr.size(); i++)
        {
            wor = itr.next();
            if (getHammingDistance(wor, word) == 1)
            {
                output.add(wor);
            }
        }
        return output;
    }


    /**
     * Checks to see if the given sequence of strings is a valid word ladder.
     *
     * @param  sequence the given sequence of strings
     * @return          true if the given sequence is a valid word ladder,
     *                       false otherwise
     */
    public boolean isWordLadder(List<String> sequence)
    {
        if (sequence == null || sequence.size() == 0)
        {
           return false;
        }
        if (sequence.size() == 1)
        {
           return true;
        }
        
        
        Iterator<RedBlackTree<String>> itrRBT = lexiconlist.iterator();
        RedBlackTree<String> curr = new RedBlackTree<String>(), currentlexicon = new RedBlackTree<String>();
        
        Iterator<String> itr = sequence.iterator();
        String before = itr.next().toLowerCase();
        String next = itr.next().toLowerCase();
        
        for(int i = 0; i < lexiconlist.size(); i++)
        {
           curr = itrRBT.next();
           if(curr.root.element.length() == before.length() && curr.root.element.length() == next.length())
           {
              currentlexicon = curr;
              break;
           }
        } 
        
        if (!currentlexicon.contains(before))
        {
           return false;
        }
        if (sequence.size() == 2 && currentlexicon.contains(before) && currentlexicon.contains(next) && getHammingDistance(before, next) == 1)
        {
           return true;
        }
        
        while (itr.hasNext() && getHammingDistance(before, next) == 1 && currentlexicon.contains(next))
        {
           before = next;
           next = itr.next().toLowerCase();
           if (!itr.hasNext())
           {
              return true;
           }
        }
        return false;
    }


   /**
    * Returns a minimum-length word ladder from start to end. If multiple
    * minimum-length word ladders exist, no guarantee is made regarding which
    * one is returned. If no word ladder exists, this method returns an empty
    * list.
    *
    * Breadth-first search must be used in all implementing classes.
    *
    * @param  start  the starting word
    * @param  end    the ending word
    * @return        a minimum length word ladder from start to end
    */
    public List<String> getMinLadder(String start, String end)
    {
        start = start.toLowerCase();
        end = end.toLowerCase();
        
        Iterator<RedBlackTree<String>> itrRBT = lexiconlist.iterator();
        RedBlackTree<String> curr = new RedBlackTree<String>();
        Iterator<String> itr = null;
        for(int i = 0; i < lexiconlist.size(); i++)
        {
           curr = itrRBT.next();
           if(curr.root.element.length() == start.length() && curr.root.element.length() == end.length()) //tests that they are the same lenght
           {
               itr = curr.iterator();
               break;
           }
        }   
        if (itr == null || !curr.contains(start) || !curr.contains(end)) //not in lexicon
        {
           return new LinkedList<String>();
        }

        
        List<String> output = new ArrayList<String>();
        
        if(start.equals(end))
        {
            output.add(start);
            return output;
        }
        
        //geteneighborsofstart
        
        RedBlackTree<String> triedWords = new RedBlackTree<String>();
        triedWords.add(start);
        Deque<Node> wordLad = new LinkedList<Node>();
        LinkedList<String> wordLadReturn = new LinkedList<String>();
        wordLad.add(new Node(start, null));
        
        while (wordLad.size() != 0) 
        {
           Node currentNode = wordLad.remove();
           for (String currentS : getNeighbors(currentNode.word)) 
           {
              if (!triedWords.contains(currentS)) 
              {
                  triedWords.add(currentS);
                  if (currentS.equals(end)) 
                  {
                      wordLadReturn.add(end);
                      while (!currentNode.word.equals(start))
                      {
                          wordLadReturn.addFirst(currentNode.word);
                          currentNode = currentNode.parent;
                      }
                      wordLadReturn.addFirst(start);
                      return wordLadReturn;
                  }
                  wordLad.add(new Node(currentS, currentNode));
              }
           }
        }
        
        return new LinkedList<String>();
    }

   
   /**

Create a new (efficient!) data structure to hold words already tried
Add the start word to triedWords

Create a queue of Nodes
Add a new node with the start word to the queue

while (the queue is not empty) {
    currentNode = queue.dequeue()
    for (each neighbor of currentNode.word) {
        if (neighbor has not be tried yet) {
            add neighbor to triedWords
            if (neighbor is the end word) {
                return the word ladder
            }
            queue.enqueue(new Node(word, currentNode))
        }
    }
}

// if we ever get here, there is no ladder
return an empty ladder
```
   
   p

    }
    if (neighbor.equalsIgnoreCase(end)) {
            return sequenceFromStart(new Node(neighbor, current));
        }
    /// more stuff ..
    ...
}


Building the ladder to return*
private List<String> sequenceFromStart(Node n) {
    List<String> ladder = new LinkedList<>();
    // linear scan of the chain referenced by n using the
    // List.add(index, element) method
    return ladder;
}
*/

}
