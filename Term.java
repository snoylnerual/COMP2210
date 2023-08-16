import java.util.Comparator;

/**
 * Autocomplete term representing a (query, weight) pair.
 * 
 */
public class Term implements Comparable<Term>
{
    private String query;
    private long weight;
    
    
    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
    public Term(String iquery, long iweight) 
    {
         //throws a NullPointerException if query is null
         if (iquery == null)
         {
            throw new NullPointerException();
         }
         else
         {
            query = iquery;
         }
         
         //throws an IllegalArgumentException if weight is negative
         if (iweight < 0)
         {
            throw new IllegalArgumentException(); 
         }
         else
         {
             weight = iweight;
         }
    }

    /**
     * Compares the two terms in descending order of weight.
     */
    public static Comparator<Term> byDescendingWeightOrder() 
    {
         return new byDescendingWeightOrderComparator();
    }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
    public static Comparator<Term> byPrefixOrder(int length) 
    {
          //throws an IllegalArgumentException if length is less than or equal to zero
          if (length <= 0)
          {
            throw new IllegalArgumentException();
          } 
          return new byPrefixOrderComparator(length);
    }

   /**
   *Get method for query field. Returns query. Is mainly used in Autocomplete.java.
   */
    public String getQuery()
    {
         return query;
    }

    /**
    *Get method for weight field. Returns weight. Is mainly used in Autocomplete.java.
    */
    public long getWeight()
    { 
         return weight;
    }
   
    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
    @Override
    public int compareTo(Term other) 
    {
      //this instance's query compared to other instance's query
      return this.getQuery().compareTo(other.getQuery());
    }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
    @Override
    public String toString()
    {
         return query + "\t" + weight;
    }
    
    
    private static class byDescendingWeightOrderComparator implements Comparator<Term> 
    {
       public int compare(Term a, Term b)
       {
           if (a.weight > b.weight)
           {
               return -1;
           }
           else if (a.weight < b.weight)
           {
               return 1;
           }
           else 
           { 
               //(a.weigh == b.weight)
               return 0;
           }
       }
    }
    
    /**
    ** Correctness test results **
         testByPrefixOrder(TermTests): Testing Term byPrefixOrder().
         Terms: (az 1), (abcde 1) Length: 3
         java.lang.StringIndexOutOfBoundsException: begin 0, end 3, length 2
         testAllMatches(AutocompleteTests): begin 0, end 2, length 1
         Tests run: 21, Tests passed: 19, Tests failed: 2.
    */
    
    private static class byPrefixOrderComparator implements Comparator<Term> 
    {
       private int lengthC;
       
       public byPrefixOrderComparator(int lengthin)
       {
           lengthC = lengthin;
       }
       
       public int compare(Term a, Term b)
       {
           
           String aQ = a.query;
           String bQ = b.query;
           
           //compares substring of Term a and Term b. The length is that of the prefix
           if (aQ.length() < lengthC && bQ.length() < lengthC)
           {
               return aQ.compareTo(bQ);
           }
           else if (aQ.length() < lengthC)
           {
               return aQ.compareTo(bQ.substring(0, lengthC));

           }
           else if (bQ.length() < lengthC)
           {
               return aQ.substring(0, lengthC).compareTo(bQ);
           }
           else
           {
               return aQ.substring(0, lengthC).compareTo(bQ.substring(0, lengthC));
           }
       }
    }
}