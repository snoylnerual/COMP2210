import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Defines a library of selection methods on Collections.
 *
 * @author  Lauren Lyons (lnl0017@auburn.edu)
 * @version 9/14/2021
 */
public final class Selector {

/**
 * Can't instantiate this class.
 *
 * D O   N O T   C H A N G E   T H I S   C O N S T R U C T O R
 *
 */
    private Selector() { }


    /**
     * Returns the minimum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the minimum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T min(Collection<T> coll, Comparator<T> comp) 
    {
        //If either coll or comp is null, this method throws an IllegalArgumentException.
        if (coll == null || comp == null)
        {
            throw new IllegalArgumentException("Provided object doesn't exist");
        }
        //If coll is empty, this method throws a NoSuchElementException.
        if (coll.size() == 0)
        {
            throw new NoSuchElementException("Provided array has length zero");
        }
        
        //Must have an iterator object for coll so that we may iterate through it
        Iterator<T> itr = coll.iterator();
        
        //initialize minThing as the first element of the Collection
        T minThing = itr.next();
        //Prevents the error if coll is only of size 1 && so does int i = 1; i < coll.size() - kind of redundant
        while (itr.hasNext())
        {
           for (int i = 1; i < coll.size(); i++)
           {
               T thing = itr.next();
               //if the current element is less than our minThing, it is our new minThing
               //results in minThing being the lowest element of the collection because of the for loop
               if (comp.compare(thing, minThing) == -1)
               {
                  minThing = thing;
               }
           }
        }
        return minThing;
    }


    /**
     * Selects the maximum value in the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty, this method throws a
     * NoSuchElementException. This method will not change coll in any way.
     *
     * @param coll    the Collection from which the maximum is selected
     * @param comp    the Comparator that defines the total order on T
     * @return        the maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T max(Collection<T> coll, Comparator<T> comp) 
    {
        //If either coll or comp is null, this method throws an IllegalArgumentException.
        if (coll == null || comp == null)
        {
            throw new IllegalArgumentException("Provided object doesn't exist");
        }
        //If coll is empty, this method throws a NoSuchElementException.
        if (coll.size() == 0)
        {
            throw new NoSuchElementException("Provided array has length zero");
        }
        
        //Must have an iterator object for coll so that we may iterate through it
        Iterator<T> itr = coll.iterator();
        
        //initialize maxThing as the first element of the Collection
        T maxThing = itr.next();
        //Prevents the error if coll is only of size 1 && so does int i = 1; i < coll.size() - kind of redundant
        while (itr.hasNext())
        {
           for (int i = 1; i < coll.size(); i++)
           {
               T thing = itr.next();
               //if the current element is greater than our maxThing, it is our new maxThing
               //results in minThing being the highest element of the collection because of the for loop
               if (comp.compare(thing, maxThing) == 1)
               {
                  maxThing = thing;
               }
           }
        }
        return maxThing;
    }


    /**
     * Selects the kth minimum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth minimum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth minimum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth minimum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmin(Collection<T> coll, int k, Comparator<T> comp) 
    {
        //If either coll or comp is null, this method throws an IllegalArgumentException.
        if (coll == null || comp == null)
        {
            throw new IllegalArgumentException("Provided object doesn't exist");
        }
        //If coll is empty or if there is no kth minimum value, this method throws a NoSuchElementException.
        else if (k < 1 || k > coll.size() || coll.size() == 0)
        {
            throw new NoSuchElementException("Provided array has length zero");
        }
        
        //This iterator object is used just to copy over coll to copyColl
        Iterator<T> itr2 = coll.iterator();
        
        //copyColl's purpose is to be a copy of coll that we can manipulate
        ArrayList<T> copyColl = new ArrayList<T>();
        //Copies coll into copyColl
        for (int i = 0; i < coll.size(); i++)
        {
            T element = itr2.next();
            copyColl.add(element);
        }
        
        //organizedColl is a list of sorted distinct numbers from coll
        ArrayList<T> organizedColl = new ArrayList<T>();
        //sorting copyColl to make comparisons simpler
        copyColl.sort(comp);
        //This is iterator object of copyColl is used for removing duplicates
        Iterator<T> itr = copyColl.iterator();
        
        //thing is initialized as the first element of copyColl
        T thing = itr.next();
        //nextThing is null in the case that copyColl is of size 1
        T nextThing = null;
        //Removes duplicates, goes through whole Collection
        for (int i = 0; i < coll.size(); i++)
        {
            if (itr.hasNext())
            {
                nextThing = itr.next();   
            }
            else
            {
               //for every case, the last number of a will be distinct so we add it to organizedColl
                organizedColl.add(thing);
            }
            
            //using nextThing as equated above, this for loop will compare and see if these are the same
            //If they are the same, nothing is added to the distinct Collection
            //If the loop makes it all the way through, that means this is a distinct value and is added to the distinct Collection
            for (int j = i + 1; j < coll.size(); j++)
            {
                if (comp.compare(thing, nextThing) == 0)
                {
                   break;
                }
                else if (j == (coll.size() - 1))
                {
                   organizedColl.add(thing);
                }
            }
            //nextThing shifts to thing and then thing becomes the next element in the collection, iterating through the whole Collection
            if (nextThing != null)
            {
                thing = nextThing;
            }
        }
        
        //If there is no kth minimum value, this method throws a NoSuchElementException.
        if (k > organizedColl.size())
        {
            throw new NoSuchElementException("k has a higher value than the amount of distinct numbers in the array");
        }
        
        //Of the distinct values list, we return the element that has k elements higher than it
        return organizedColl.get(k - 1);
    }


    /**
     * Selects the kth maximum value from the Collection coll as defined by the
     * Comparator comp. If either coll or comp is null, this method throws an
     * IllegalArgumentException. If coll is empty or if there is no kth maximum
     * value, this method throws a NoSuchElementException. This method will not
     * change coll in any way.
     *
     * @param coll    the Collection from which the kth maximum is selected
     * @param k       the k-selection value
     * @param comp    the Comparator that defines the total order on T
     * @return        the kth maximum value in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T kmax(Collection<T> coll, int k, Comparator<T> comp) 
    {
        //If either coll or comp is null, this method throws an IllegalArgumentException.     
        if (coll == null || comp == null)
        {
            throw new IllegalArgumentException("Provided object doesn't exist");
        }
        //If coll is empty or if there is no kth minimum value, this method throws a NoSuchElementException.
        else if (k < 1 || k > coll.size() || coll.size() == 0)
        {
            throw new NoSuchElementException("Provided array has length zero");
        }
        
        //This iterator object is used just to copy over coll to copyColl
        Iterator<T> itr2 = coll.iterator();
        
        //copyColl's purpose is to be a copy of coll that we can manipulate
        ArrayList<T> copyColl = new ArrayList<T>();
        //Copies coll into copyColl
        for (int i = 0; i < coll.size(); i++)
        {
            T element = itr2.next();
            copyColl.add(element);
        }
        
        //organizedColl is a list of sorted distinct numbers from coll
        ArrayList<T> organizedColl = new ArrayList<T>();
        //sorting copyColl to make comparisons simpler
        copyColl.sort(comp);
        //This is iterator object of copyColl is used for removing duplicates
        Iterator<T> itr = copyColl.iterator();

        
        //thing is initialized as the first element of copyColl
        T thing = itr.next();
        //nextThing is null in the case that copyColl is of size 1
        T nextThing = null;
        //Removes duplicates, goes through whole Collection
        for (int i = 0; i < coll.size(); i++)
        {
            if (itr.hasNext())
            {
                nextThing = itr.next();
            }
            else
            {
            //for every case, the last number of a will be distinct
                organizedColl.add(thing);
            }
            
            //using nextThing as equated above, this for loop will compare and see if these are the same
            //If they are the same, nothing is added to the distinct Collection
            //If the loop makes it all the way through, that means this is a distinct value and is added to the distinct Collection           
            for (int j = i + 1; j < coll.size(); j++)
            {
                if (comp.compare(thing, nextThing) == 0)
                {
                   break;
                }
                else if (j == (coll.size() - 1))
                {
                   
                   organizedColl.add(thing);
                }
            }
            //nextThing shifts to thing and then thing becomes the next element in the collection, iterating through the whole Collection
            if (nextThing != null)
            {
                thing = nextThing;
            }
        }
        
        //If there is no kth minimum value, this method throws a NoSuchElementException.
        if (k > organizedColl.size())
        {
            throw new NoSuchElementException("k has a higher value than the amount of distinct numbers in the array");
        }
        
        //Of the distinct values list, we return the element that has k elements lower than it
        return organizedColl.get(organizedColl.size() - k);
    }


    /**
     * Returns a new Collection containing all the values in the Collection coll
     * that are greater than or equal to low and less than or equal to high, as
     * defined by the Comparator comp. The returned collection must contain only
     * these values and no others. The values low and high themselves do not have
     * to be in coll. Any duplicate values that are in coll must also be in the
     * returned Collection. If no values in coll fall into the specified range or
     * if coll is empty, this method throws a NoSuchElementException. If either
     * coll or comp is null, this method throws an IllegalArgumentException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the range values are selected
     * @param low     the lower bound of the range
     * @param high    the upper bound of the range
     * @param comp    the Comparator that defines the total order on T
     * @return        a Collection of values between low and high
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> Collection<T> range(Collection<T> coll, T low, T high,
                                                      Comparator<T> comp) 
    {
        //If either coll or comp is null, this method throws an IllegalArgumentException.
        if (coll == null || comp == null)
        {
            throw new IllegalArgumentException("Provided object doesn't exist");
        }
        //If coll is empty, this method throws a NoSuchElementException.
        if (coll.size() == 0)
        {
            throw new NoSuchElementException("Provided array has length zero");
        }
        
        //rangec is the Collection that will hold our elements that fit the requirements
        Collection<T> rangec = new ArrayList<T>();
        //An iterator to iterate through the collection in order to compare values
        Iterator<T> itr = coll.iterator();
        
        //for loop goes through collection and checks if each value is greater than or equal to the low
        //and is less than or equal to the high. Element is added to rangec if true.
        for(int i = 0; i < coll.size(); i++)
        {
            T thing = itr.next();
            if ((comp.compare(thing, low) == 1 || comp.compare(thing, low) == 0) && (comp.compare(thing, high) == -1 || comp.compare(thing, high) == 0))
            { 
               rangec.add(thing);
            }
        }
        //If no values in coll fall into the specified range, this method throws a NoSuchElementException.
        if (rangec.size() == 0)
        {
            throw new NoSuchElementException("No values match");
        }
        
        //ending collection of the range
        return rangec;
    }


    /**
     * Returns the smallest value in the Collection coll that is greater than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the ceiling value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the ceiling value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T ceiling(Collection<T> coll, T key, Comparator<T> comp) 
    {
        //If coll or comp is null, this method throws an IllegalArgumentException.
        if (coll == null || comp == null)
        {
            throw new IllegalArgumentException("Provided object doesn't exist");
        }
        //If coll is empty, this method throws a NoSuchElementException.
        if (coll.size() == 0)
        {
            throw new NoSuchElementException("Provided array has length zero");
        }
        
        //ceilT is = null because it must be instantiated to be used
        T ceilT = null;
        
        //itrH is just used to get the first value of coll so that we may begin looking for the highest value
        //which we store in the variable high
        Iterator<T> itrH = coll.iterator();
        T high = itrH.next();
        
        //itrT is used just to grab the first qualifying value of the rquirements so that we can use it to check 
        //for better answers
        Iterator<T> itrT = coll.iterator();
        int i = 0;
        //we only we want the first value that fits the conditions of
        //being greater than or equal to the key
        while (itrT.hasNext() && i < 1)
        {
           T compT = itrT.next();
           if (comp.compare(compT, key) == 1 || comp.compare(compT, key) == 0)
           {
               ceilT = compT;
               i++;
           }
        }
        
        //If there is no qualifying value, this method throws a NoSuchElementException.
        if (ceilT == null)
        {
            throw new NoSuchElementException("No qualifying value");
        }
           
        //itr is used to go through the coll to look for the final ceilT
        Iterator<T> itr = coll.iterator();
        //Using this, we can move past the first ceilT value and find one that
        //fits both the conditions of being greater than or equal to the key
        //and is the smallest value
        for(int j = 0; j < coll.size(); j++)
        {
            T thing = itr.next();
            if ((comp.compare(thing, key) == 1 || comp.compare(thing, key) == 0) && comp.compare(thing, ceilT) == -1)
            {
               ceilT = thing;
            }
            //we also use this for loop to find the highest value
            //honestly could remove this and the following NoSuchElementException throw
            //bc of the ceilT NoSuchElementException throw
            if (comp.compare(thing, high) == 1)
            {
               high = thing;
            }
        }
        
        //If key is higher than the highest value, meaning no quantifying value, this method throws a NoSuchElementException.
        if (comp.compare(key, high) == 1)
        {
            throw new NoSuchElementException("Key is smaller than smallest array value");
        }
        
        return ceilT;
    }


    /**
     * Returns the largest value in the Collection coll that is less than
     * or equal to key, as defined by the Comparator comp. The value of key
     * does not have to be in coll. If coll or comp is null, this method throws
     * an IllegalArgumentException. If coll is empty or if there is no
     * qualifying value, this method throws a NoSuchElementException. This
     * method will not change coll in any way.
     *
     * @param coll    the Collection from which the floor value is selected
     * @param key     the reference value
     * @param comp    the Comparator that defines the total order on T
     * @return        the floor value of key in coll
     * @throws        IllegalArgumentException as per above
     * @throws        NoSuchElementException as per above
     */
    public static <T> T floor(Collection<T> coll, T key, Comparator<T> comp) 
    {   
        //If coll or comp is null, this method throws an IllegalArgumentException.
        if (coll == null || comp == null)
        {
            throw new IllegalArgumentException("Provided object doesn't exist");
        }
        //If coll is empty, this method throws a NoSuchElementException.
        if (coll.size() == 0)
        {
            throw new NoSuchElementException("Provided array has length zero");
        }
        
         //floorT is = null because it must be instantiated to be used
         T floorT = null;
        
         //itrL is just used to get the first value of coll so that we may begin looking for the lowest value
         //which we store in the variable low
         Iterator<T> itrL = coll.iterator();
         T low = itrL.next();
         
         //itrT is used just to grab the first qualifying value of the rquirements so that we can use it to check 
         //for better answers
         Iterator<T> itrT = coll.iterator();
         int i = 0;
         //we only we want the first value that fits the conditions of
         //being less than or equal to the key
         while (itrT.hasNext() && i < 1)
         {
            T compT = itrT.next();
            if (comp.compare(compT, key) == -1 || comp.compare(compT, key) == 0)
            {
                floorT = compT;
                i++;
            }
         }
         
         //If there is no qualifying value, this method throws a NoSuchElementException.
         if (floorT == null)
         {
             throw new NoSuchElementException("No qualifying value");
         }
            
         //itr is used to go through the coll to look for the final floorT
         Iterator<T> itr = coll.iterator();
         //Using this, we can move past the first floorT value and find one that
         //fits both the conditions of being less than or equal to the key
         //and is the greatest value
         for(int j = 0; j < coll.size(); j++)
         {
             T thing = itr.next();
             if ((comp.compare(thing, key) == -1 || comp.compare(thing, key) == 0) && comp.compare(thing, floorT) == 1)
             {
                floorT = thing;
             }
             //we also use this for loop to find the lowest value
             //honestly could remove this and the following NoSuchElementException throw
             //bc of the floorT NoSuchElementException throw
             if (comp.compare(thing, low) == -1)
             {
                low = thing;
             }
         }
        
        //If key is higher than the highest value, meaning no quantifying value, this method throws a NoSuchElementException.
         if (comp.compare(key, low) == -1)
         {
             throw new IllegalArgumentException("Key is smaller than smallest array value");
         }
         return floorT;
     }
}
 