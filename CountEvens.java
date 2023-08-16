/**
 * Count the number of even values in a chain of linked nodes.
 *
 *Complete the body of the countEvens method so that it returns the number of even values in the chain of nodes accessible from the parameter firstNode. Remember that you can test if an integer is evenly divisible by 2 by using %, the remainder ("mod") operator in Java. If x % y evaluates to 0, then y divides into x evenly, that is, with no remainder.

The following table lists various examples of the parameter firstNode and the correct return value from the call countEvens(firstNode).

Chain of Nodes	Return Value
firstNode  [1]  [2]  [3]  [4]  [5]	2
firstNode  [2]  [4]  [6]  [8]  [10]	5
firstNode  [0]  [1]  [2]  [3]  [4]	3
firstNode  [1]  [1]  [1]  [1]  [1]	0
 */
public class CountEvens {

    //  C O M P L E T E   T H I S    M E T H O D 

    /**
     * Returns the number of even values in the paramter.
     */
    public int countEvens(Node firstNode) 
    {
       Node n = firstNode;
       int evencount = 0;
       while (n != null)
       {
          if (n.value % 2 == 0)
          {
              evencount++;
          }
          n = n.next;
       }
       return evencount;
    }

    class Node 
    {
        int value;
        Node prev;
        Node next;

        public Node(int val) {
            value = val;
            prev = null;
            next = null;
        }
    }

}