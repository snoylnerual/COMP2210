/**
*Returns the amount of negative numbers in an array.
*Applies the linear scan strategy to counting the number of negative
*values in an array.
*
*Module One
*@author Lauren Lyons
*@version 8/24/2021
**/
public class HandsOnOne
{
   /**
   *Initializes an array and then prints the result of the
   *called method.
   *
   *@param args - not used
   **/
   public static void main(String[] args)
   {
      int[] array = {0, 1, 2, -1, -2, 5, -6};
      System.out.print(negativeCount(array));
   }
   
   /**
   *A counter keeps track of the amount of negative
   *numbers in the given array.
   *
   *@param array - the given array to check
   *@return int - the amount of negative numbers
   **/
   public static int negativeCount(int[] array)
   {
      int count = 0;
      for (int value : array)
      {
         if (value < 0)
         {
            count += 1;
         }
      }
      return count;
   }
}