import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author YOUR NAME (you@auburn.edu)
 *
 *
 *but you must create correct implementations of the methods in the 
 *LinkedSet class. In doing so you are allowed to add any number of 
 *private methods and nested classes that you need, but you may not 
 *create or use any other top-level class and you may not create any 
 *public method. You must also use without modification the existing 
 *fields of the LinkedSet class.
 *
 *it does make a restriction on the type variable: Any type bound by 
 *a client to T must be a class that implements the Comparable interface 
 *for that type. Thus, there is a natural order on the values stored in an 
 *LinkedSet, but not (necessarily) on those stored in another class that 
 *implements the Set interface. This is an important distinction, so 
 *pause here long enough to make sure you understand this point.
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> 
{

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
    Node front;
    Node rear;

    /** The number of nodes in the list. */
    int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
    public LinkedSet() {
        front = null;
        rear = null;
        size = 0;
    }
    

    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("[");
        for (T element : this) {
            result.append(element + ", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
    public int size() {
        return size;
    }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
    public boolean isEmpty() {
        return (size == 0);
    }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     *
     *
     *The add method ensures that this set contains the specified element.
     *Neither duplicates nor null values are allowed. The method returns true 
     *if this set was modified (i.e., the element was added) and false otherwise. 
     *Note that the constraint on the generic type parameter T of the LinkedSet 
     *class ensures that there is a natural order on the values stored in an 
     *LinkedSet. You must maintain the internal doubly-linked list in ascending 
     *natural order at all times. The time complexity of the add method must be 
     *O(N), where N is the number of elements in the set.
     *
     *Note that one element being a duplicate of another means that the two elements
     * are equal. Since duplicates are not allowed to be added to any implementing
     * class of the Set interface, this is an example of why it’s important for the 
     *equals method and the compareTo method of a class to be consistent.
     */
    public boolean add(T element) 
    {
        if (element != null) // null values are not allowed
        {
            Node addition = new Node(element), current = front, extra = new Node(); 
            int numafter, numbefore = 1;
            
            if (current == null || this.isEmpty())
            {
                front = addition;
                rear = front;
                size++;
                return true;
            }

            numafter = element.compareTo(current.element);
            for (int i = 0; i < size; i++)
            {
                if (element.equals(current.element)) // duplicatee values not allowed
                {
                     return false;
                }
                
                if (numbefore > 0 && numafter < 0) // ascending order would be the element before is less and the element after is more
                {
                     size++;
                     addition.next = current;
                     addition.prev = current.prev;
                     current.prev = addition;
                     if (i == 0)
                     {
                        front = addition;
                        return true;
                     }
                     addition.prev.next = addition;
                     return true;
                }
                
                numbefore = numafter;
                extra = current;
                current = current.next;
                if (current == null)
                {
                    numafter = -1;
                }
                else
                {
                    numafter = element.compareTo(current.element);
                }
            }
            extra.next = addition;
            addition.prev = extra;
            rear = addition;
            size++;
            return true;
        }  
        return false;
    }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     *
     *
     *The remove method ensures that this set does not contain the specified
     *element. The method returns true if this set was modified (i.e., an 
     *existing element was removed) and false otherwise. The remove method 
     *must maintain the ascending natural order of the doubly-linked list. 
     *The time complexity of the remove method must be O(N), where N is the 
     *number of elements in the set.
     */
    public boolean remove(T element) 
    {
        if (element == null)
        {
            return false;
        }
        
        Node current = front;
        for (int i = 0; i < size; i++)
        {
            if (element.equals(current.element))
            {
                if (size == 1)
                {
                   front.prev = null;
                   rear.next = null;
                   front = null;
                   rear = null;
                }
                else if (i == 0)
                {
                   front = front.next;
                   front.prev = null;
                }
                else if (i == size-1)
                {
                   rear = rear.prev;
                   rear.next = null;
                }
                else
                {
                   current.next.prev = current.prev;
                   current.prev.next = current.next;
                   current.prev = null;
                   current.next = null;
                }
                size--;
                return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     *
     *
     *The contains method searches for the specified element in this set, returning true 
     *if the element is in this set and false otherwise. The time complexity of the contains
     *method must be O(N), where N is the number of elements in the set.
     */
    public boolean contains(T element) 
    {
        if (element == null)
        {
            return false;
        }
        
        Node current = front;
        for (int i = 0; i < size; i++)
        {
            if (element.equals(current.element))
            {
               return true;
            }
            current = current.next;
        }
        return false;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     *
     *
     *Two sets are equal if and only if they contain exactly the same elements, 
     *regardless of order. If A = {1,2,3},B = {3,1,2}, and C = {1,2,3,4}, 
     *then A = B and A != C. The equals method returns true if this set is 
     *equal to the parameter set, and false otherwise. The time complexity 
     *of the equals method must be O(N^2) where N is the size of each set.
     */
    public boolean equals(Set<T> s) 
    {
        if ((s == null || s.isEmpty()) && (this == null || this.isEmpty()))
        {
           return true;
        }
        else if((s == null || s.isEmpty()) && (this != null || !this.isEmpty()))
        {
            return false;
        }
        else if((s != null || !s.isEmpty()) && (this == null || this.isEmpty()))
        {
            return false;
        }
        
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Node current = front;
        for (int i = 0; i < size; i++)
        {
           for (int j = 0; j < size; j++)
           {
              if(current.element.equals(sThing))
              {
                 T ss = sThing;
                 if (itr.hasNext())
                 {
                    sThing = itr.next();
                 }
                 s.remove(ss);
                 break;
              }
              if (itr.hasNext())
              {
                 sThing = itr.next();
              }
              else
              {
                 break;
              }
           }
           itr = s.iterator();
           current = current.next;
        }
        
        if (s.isEmpty())
        {
           return true;
        }
        return false;
    }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     *
     *
     *The external behavior of this overloaded method is identical to the 
     *equals method from the Set interface described above. However, since 
     *the parameter is typed as an LinkedSet, this method can directly access 
     *the doubly-linked list in this set as well as in the parameter set. 
     *Having access to the underlying representation of both sets allows a 
     *more efficient algorithm for this method. The time complexity of this 
     *equals method must be O(N) where N is the size of this set.
     */
    public boolean equals(LinkedSet<T> s) 
    {
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Node current = front;
        
        if ((s == null || s.isEmpty()) && (this == null || this.isEmpty()))
        {
           return true;
        }
        else if((s == null || s.isEmpty()) && (this != null || !this.isEmpty()))
        {
            return false;
        }
        else if((s != null || !s.isEmpty()) && (this == null || this.isEmpty()))
        {
            return false;
        }
        
        
        while(current.element.equals(sThing))
        {
           if (itr.hasNext())
           {
              sThing = itr.next();
           }
           else
           {
              break;
           }
           current = current.next;
           if (!itr.hasNext() && current.next == null)
           {
               return true;
           }
        }
        
        return false;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     *
     *
     *The union of set A with set B, denoted A U B, is defined as {x | x E A or x E B}. 
     *Note that A U B = B U A and A U /O/ = A. The union method returns a set that
     *is the union of this set and the parameter set. The result set must be in ascending natural
     *order. The time complexity of the union method must be O(N^2) where N is the size of the 
     *larger of the two sets involved.
     */
    public Set<T> union(Set<T> s)
    {
        if (s == null || s.isEmpty())
        {
           return this;
        }
        if (this == null || this.isEmpty())
        {
           return s;
        }
        
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Node current = front;
        Set<T> ret = new LinkedSet();
        for (int i = 0; i < s.size(); i++)
        {
           current = front;
           for (int j = 0; j < size; j++)
           {
              if(current.element.equals(sThing))
              {
                 s.remove(sThing);
                 break;
              }
              current = current.next;
           }
           if (itr.hasNext())
              {
                 sThing = itr.next();
              }
              else
              {
                 break;
              }
        }
        
        current = front;
        for (int i = 0; i < size; i++)
        {
            ret.add(current.element);
            current = current.next;
        }
        
        Iterator<T> itr2 = s.iterator();
        for (int i = 0; i < s.size(); i++)
        {
            sThing = itr2.next();
            ret.add(sThing);
        }
        
        return ret;
    }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     *
     *
     *The external behavior of this overloaded method is identical to the union method 
     *from the Set interface described above. However, since the parameter is typed as 
     *an LinkedSet, this method can directly access the doubly-linked list in this set 
     *as well as in the parameter set. Having access to the underlying representation 
     *of both sets allows a more efficient algorithm for this method. The time complexity 
     *of the union method must be O(N) where N is the size of the larger of the two sets involved.
     */
    public Set<T> union(LinkedSet<T> s)
    {
        if (s == null || s.isEmpty())
        {
           return this;
        }
        if (this == null || this.isEmpty())
        {
           return s;
        }
        
        LinkedSet<T> t = new LinkedSet();
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Iterator<T> thisItr = this.iterator();
        T tThing = thisItr.next();
        LinkedSet ret = new LinkedSet();
        
        
        while (itr.hasNext())
        {
            t.add(sThing);
            sThing = itr.next();
        }
        itr = t.iterator();
        sThing = itr.next();
        
        while(sThing != null && tThing != null && sThing.compareTo(tThing) < 0)
        {
            if (itr.hasNext())
            {
               sThing = itr.next();
            }
            else
            {
               break;
            }
        }
        
        
        
        
        
       
        while(thisItr.hasNext() || itr.hasNext())
        {
            if (sThing == null || tThing == null)
            {
               break;
            }
            
            if (sThing.compareTo(tThing) < 0)
            {
                if (itr.hasNext())
                {
                    sThing = itr.next();
                }
                else if (thisItr.hasNext())
                {
                    tThing = thisItr.next();
                }
            }
            if (sThing.compareTo(tThing) == 0)
            {
                t.remove(sThing);
                if (thisItr.hasNext()) //might put a ! and say break with another condition
                {
                    tThing = thisItr.next();
                }
                else if (itr.hasNext())
                {
                    sThing = itr.next();
                }
            }
            if (sThing.compareTo(tThing) > 0)
            {
                if (thisItr.hasNext())
                {
                    tThing = thisItr.next();
                }
                else if (itr.hasNext())
                {
                    sThing = itr.next();
                }
            }
        }
        
        Node current = front;
        for (int i = 0; i < size; i++)
        {
            ret.add(current.element);
            current = current.next;
        }
        
        Iterator<T> itr2 = s.iterator();
        for (int i = 0; i < s.size(); i++)
        {
            sThing = itr2.next();
            ret.add(sThing);
        }
       
        return ret;
    }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     *
     *
     *The intersection of set A with set B, denoted A n B, is defined as {x | x E A and x E B}. 
     *Note that A n B = B n A and A n /O/ = /O/ . The intersection method returns a set that is 
     *the intersection of this set and the parameter set. The result set must be in ascending natural 
     *order. The time complexity of the intersection method must be O(N^2) where N is the size of the 
     *larger of the two sets involved.
     */
    public Set<T> intersection(Set<T> s) 
    {
        if ((s == null || s.isEmpty()) || (this == null || this.isEmpty()))
        {
           return new LinkedSet();
        }
        
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Node current = front;
        Set<T> ret = new LinkedSet();
        for (int i = 0; i < s.size(); i++)
        {
           current = front;
           for (int j = 0; j < size; j++)
           {
              if(current.element.equals(sThing))
              {
                 ret.add(sThing);
                 break;
              }
              
              current = current.next;
           }
           if (itr.hasNext())
              {
                 sThing = itr.next();
              }
              else
              {
                 break;
              }
        }
        
        return ret;
    }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     *
     *
     *The external behavior of this overloaded method is identical 
     *to the intersection method from the Set interface described 
     *above. However, since the parameter is typed as an LinkedSet, 
     *this method can directly access the doubly-linked list in this 
     *set as well as in the parameter set. Having access to the underlying 
     *representation of both sets allows a more efficient algorithm for 
     *this method. The time complexity of the intersection method must be 
     *O(N) where N is the size of the larger of the two sets involved.
     */
    public Set<T> intersection(LinkedSet<T> s) 
    {
        if ((s == null || s.isEmpty()) || (this == null || this.isEmpty()))
        {
           return new LinkedSet();
        }
        
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Iterator<T> thisItr = this.iterator();
        T tThing = thisItr.next();
        LinkedSet ret = new LinkedSet();
        
        while(sThing.compareTo(tThing) < 0)
        {
            if (itr.hasNext())
            {
               sThing = itr.next();
            }
            else
            {
                return new LinkedSet();
            }
        }
        
       
        while(thisItr.hasNext() || itr.hasNext())
        {
            if (sThing.compareTo(tThing) < 0)
            {
                if (itr.hasNext())
                {
                    sThing = itr.next();
                }
                else if (thisItr.hasNext())
                {
                    tThing = thisItr.next();
                }
            }
            if (sThing.compareTo(tThing) == 0)
            {
                ret.add(tThing);
                if (thisItr.hasNext()) //might put a ! and say break with another condition
                {
                    tThing = thisItr.next();
                }
                else if (itr.hasNext())
                {
                    sThing = itr.next();
                }
            }
            if (sThing.compareTo(tThing) > 0)
            {
                if (thisItr.hasNext())
                {
                    tThing = thisItr.next();
                }
                else if (itr.hasNext())
                {
                    sThing = itr.next();
                }
            }
        }
       
        return ret;
    }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     *
     *
     *The relative complement of set B with respect to set A, denoted A \ B, is defined as {x | x E A and x E/ B}. 
     *Note that A \ B != B \ A, A \ /O/ = A, and /O/ \ A = /O/. The complement method returns a set that is the 
     *relative complement of the parameter set with respect to this set. The result set must be in ascending natural order. 
     *The time complexity of the complement method must be O(N^2) where N is the size of the larger of the two sets involved.
     */
    public Set<T> complement(Set<T> s)
    {
        if (s == null || s.isEmpty())
        {
           return this;
        }
        if (this == null || this.isEmpty())
        {
           return new LinkedSet(); //s
        }
        
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Iterator<T> itrT = this.iterator();
        T tThing = itrT.next();
        Node current = front;
        Set<T> ret = new LinkedSet();
        boolean check;
        
        
        
        for (int j = 0; j < size; j++)
        {
           check = ret.add(tThing);
           if (itrT.hasNext())
           {
           tThing = itrT.next();
           }
        }
        
        for (int i = 0; i < s.size(); i++)
        {
           check = ret.add(sThing);
           ret.remove(sThing);
           if (itr.hasNext())
           {
           sThing = itr.next();
           }
        }
           
        return ret;
    }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     *
     *
     *The external behavior of this overloaded method is identical to the complement
     *method from the Set interface described above. However, since the parameter is 
     *typed as an LinkedSet, this method can directly access the doubly-linked list 
     *in this set as well as in the parameter set. Having access to the underlying 
     *representation of both sets allows a more efficient algorithm for this method. 
     *The time complexity of the complement method must be O(N) where N is the size 
     *of the larger of the two sets involved.
     */
    public Set<T> complement(LinkedSet<T> s) 
    {
       if (s == null || s.isEmpty())
        {
           return this;
        }
        if (this == null || this.isEmpty())
        {
           return new LinkedSet();
        }
        
        Iterator<T> itr = s.iterator();
        T sThing = itr.next();
        Iterator<T> itrT = this.iterator();
        T tThing = itrT.next();
        Node current = front;
        Set<T> ret = new LinkedSet();
        boolean check;
        
        for (int j = 0; j < size; j++)
        {
           check = ret.add(tThing);
           tThing = itrT.next();
        }
        
        for (int i = 0; i < s.size(); i++)
        {
           check = ret.add(sThing);
           ret.remove(sThing);
           sThing = itr.next();
        }
           
        return ret;
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     *
     *
     *The iterator method returns an Iterator over the elements in this set. Although the interface
     *specifies that no particular order can be assumed (by a client), the LinkedSet implementation 
     *must ensure that the resulting iterator returns the elements in ascending natural order. 
     *The associated performance constraints are as follows: 
     *iterator(): O(1); hasNext(): O(1); next(): O(1); required space: O(1).
     */
    public Iterator<T> iterator() 
    {
        return new NormalIterator();
    }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     *
     *
     *The descendingIterator method returns an Iterator over the elements 
     *in this set in descending natural order. The associated performance 
     *constraints are as follows: descendingIterator(): O(1); hasNext(): O(1); next(): O(1); required space: O(1).
     */
    public Iterator<T> descendingIterator() 
    {
        return new DescendingIterator();
    }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     *
     *
     *The power set of a set S, denoted P(S), is defined as {T | T _E_ S}; that is, 
     *the set of all subsets of S. There are 2^N members of P(S) where N is the number 
     *of elements in S. For example, if S = {A,B,C}, then P(S) = 
     *{/O/, {A}, {B}, {C}, {A,B}, {B,C}, {A,C}, {A,B,C}}. 
     *(Note that the empty set /O/ is a member of every set.) The powersetIterator 
     *method returns an Iterator over the elements in the power set of this set. The 
     *iterator makes no guarantees regarding the order in which the elements of P(S) 
     *will be returned. The associated time complexities are as follows: powerSetIterator(): 
     *O(N); hasNext(): O(1); next(): O(N); required space: O(N), where N is the size of this set.
     */
    public Iterator<Set<T>> powerSetIterator() 
    {
        return new PowerSetIterator();
    }



    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.

    ////////////////////
    // Nested classes //
    ////////////////////
    
    private class NormalIterator implements Iterator<T> 
    {
       private Node nitem;
   
       public NormalIterator() 
       {
           this.nitem = front;
       }
   
       @Override
       public boolean hasNext() 
       {
           return !(nitem == null);
       }
   
       @Override
       public T next() 
       {
           if (!hasNext())
           {
              return null;
           }
           T num = nitem.element;
           nitem = nitem.next;
           return num;
       }
    }
    
    private class DescendingIterator implements Iterator<T> 
    {
       private Node nitem;
   
       public DescendingIterator() 
       {
           this.nitem = rear;
       }
   
       @Override
       public boolean hasNext() 
       {
           return !(nitem == null);
       }
   
       @Override
       public T next() 
       {
           if (!hasNext())
           {
              return null;
           }
           T num = nitem.element;
           nitem = nitem.prev;
           return num;
       }
    }

    // if S = {A,B,C}, then P(S) = 
    // *{/O/, {A}, {B}, {C}, {A,B}, {B,C}, {A,C}, {A,B,C}}.
    private class PowerSetIterator implements Iterator<Set<T>> 
    {
       private Node nitem;
       private Set<T> ret;
       private int current;
       private int[] binarynum;
   
       public PowerSetIterator() 
       {
           this.nitem = front;
           this.ret = new LinkedSet();
           this.binarynum = new int[size];
           this.current = 0;
       }
   
       @Override
       public boolean hasNext() 
       {
           return (current < java.lang.Math.pow(2,size));
       }
   
       @Override
       public Set<T> next() 
       {
           if (!hasNext())
           {
              return null;
           }
           
           ret = new LinkedSet();
           nitem = front;
           int ph = current;

           for (int i = 0; i < size; i++)
           {
               binarynum[i] = (int) (ph / java.lang.Math.pow(2, size-1-i));
               if (binarynum[i] == 1)
               {
                  ph = (int) (ph - java.lang.Math.pow(2, size-1-i));
               }
           }
           
           for (int j = 0; j < size; j++)
           {
               if (binarynum[j] == 1)
               {
                  ret.add(nitem.element);
               }
               nitem = nitem.next;
           }
          
           current++;
           return ret;
       }
    }

    

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
    class Node {
        /** the value stored in this node. */
        T element;
        /** a reference to the node after this node. */
        Node next;
        /** a reference to the node before this node. */
        Node prev;

        /**
         * Instantiate an empty node.
         */
        public Node() {
            element = null;
            next = null;
            prev = null;
        }

        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
        public Node(T e) {
            element = e;
            next = null;
            prev = null;
        }
    }

}
