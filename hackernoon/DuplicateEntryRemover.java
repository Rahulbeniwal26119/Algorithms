import java.util.Arrays;

public class DuplicateEntryRemover
{
  // private static final Logger logger =
  //  LoggerFactory.getLogger(DuplicateEntryRemover.class);

   public static void main(String[] args) {
     int [][]test = new int[][]{
       {1 , 1 , 2 ,2 , 3 ,4 ,5},
       {1 , 1 , 1 , 1 , 1, 1 ,5},
       {1,2,3,4,5,6,7},
       {1,2,1,1,1,1,1}
     };
     for(int []input : test)
     {
       System.out.println("Array with duplicates     : " + Arrays.toString(input));
       System.out.println("After removing duplicates : " + Arrays.toString(removeDuplicate(input)));
     }
   }
   public static int[] removeDuplicate(int []numberWithDuplicates)
   {
     Arrays.sort(numberWithDuplicates); // sort all the number so we can check repeatation by
      // comparing to previous character

     int []result = new int[numberWithDuplicates.length];
     int previous = numberWithDuplicates[0];  // set first character as previous
     result[0] = previous; // first character has been stored in result
     for(int i=1; i < numberWithDuplicates.length; i++)
     {
       int ch = numberWithDuplicates[i];
       if(ch != previous)
        {
          result[i] = ch;
          previous = ch;  // update previous
        }
     }
      return result;
   }
}
