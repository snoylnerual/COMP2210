import java.util.Arrays;
import java.util.Comparator;


/**
 * Autocomplete.
 *
 *The constructor must store the contents of terms 
 *in its own internal array and then sort this array 
 *in natural order (lexicographic order of query). The 
 *allMatches method must use the binary search methods 
 *to identify the range of methods that begin with the 
 *given prefix and return these elements in an array 
 *sorted in descending order of weight. This returned 
 *array represents the predicted completions for the given prefix.
 */
public class Autocomplete 
{

	private Term[] terms;

	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
	public Autocomplete(Term[] interms) 
   {
      if (interms == null)
      {
         throw new NullPointerException("Terms is null");
      }//throws a NullPointerException if terms is null.
      
      //initialize terms as the parameter interms
      terms = interms;
      //this sorts using the natural order defined in Term
      Arrays.sort(terms);
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
    *
    *The allMatches method must use the binary search methods to identify 
    *the range of methods that begin with the given prefix and return these 
    *elements in an array sorted in descending order of weight. This returned 
    *array represents the predicted completions for the given prefix.
	 */
	public Term[] allMatches(String prefix) 
   {
      //throws a NullPointerException if prefix is null
      if (prefix == null)
      {
         throw new NullPointerException();
      }
      
      //This is so that prefix fits into type Term, the weight is irrelevant bc it will not be checked in our search methods
      Term prefixT = new Term(prefix, 0);
      
      //find the first and last using the firstIndexOf and LastIndexOf
      int first = BinarySearch.<Term>firstIndexOf(terms, prefixT, Term.byPrefixOrder(prefix.length()));
      int last = BinarySearch.<Term>lastIndexOf(terms, prefixT, Term.byPrefixOrder(prefix.length()));
      
      //iterate through to fill in new array of size last-first+1 that we created
      int lengthA = (last - first) + 1;      //adds one because if you have 3 terms and it goes from indexes 7 to 9, 9-7=2
      Term[] termArray = new Term[lengthA];  
      int j = 0; //use this to independently iterate through termArray as we add the range from terms
      for (int i = first; i <= last; i++)
      {
         termArray[j++] = terms[i];
      }
      
      //take that array, put it in descending order and return that
      Arrays.sort(termArray, Term.byDescendingWeightOrder());
      
      //-------------------------------------------------------------------------------------------------------
      //Just trying to expose why have the errors that I do
      int z = 0;
      for(Term t : terms)
      {  
           System.out.print("|Object " + z++ + ": " + t + "| ");   
      }
      System.out.print("\nPrefix(Looking For): " + prefix + "\n\nTerms Length: " + terms.length   
                  + "\nLengthofMatchingArray: " + lengthA +"\nFirstIndex: " + first + "\nLastIndex: " + last);
      //--------------------------------------------------------------------------------------------------------

      return termArray;
   }
}