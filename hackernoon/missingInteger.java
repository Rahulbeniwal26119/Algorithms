import java.util.Arrays;
import java.util.BitSet;
import java.util.Formatter;

public class missingInteger{
  public static void main(String []args)
  {
    printMissingNumber(new int[]{1,2,3,4,6} , 6);
    printMissingNumber(new int[]{1, 2, 3, 4, 6, 7, 9, 8, 10}, 10);
    printMissingNumber(new int[]{1, 2, 3, 4, 9, 8}, 10);
    int[] iArray = new int[]{1,2,3,5};
    int missing = getMissingNumber(iArray , 5);
    Formatter f = new Formatter();
    System.out.println(f.format("Missing number in array %s is %d" , Arrays.toString(iArray) ,missing));
  }

  private static void printMissingNumber(int [] numbers , int count)
  {
    int missingCount = count - numbers.length;
    BitSet bitSet = new BitSet(count);  // BitSet is a datatype that holds bit values similar to array in some ways
    for(int number : numbers)
    {
      bitSet.set(number - 1);  // starting to set the value from the 0 position otherwise 0 will be return first
    }
    Formatter f = new Formatter();
    System.out.println(f.format("Missing number in integer array %s , with total %d" , Arrays.toString(numbers), count));

    // use to find the missing or clear bit in a BitSet after with including lastMissingIndex
    int lastMissingIndex = 0;
    f = new Formatter();
    for(int i=0; i<missingCount; i++)
    {
      lastMissingIndex = bitSet.nextClearBit(lastMissingIndex);
      System.out.println(++lastMissingIndex); // increase the lastMissingIndex to search beyond the one element
    }
  }

  // if there is only one term which is missing then substract the value of all integer in
  // current array from origional array
  private static int getMissingNumber(int[] numbers ,int count)
  {
    int expectedSum = count * (count + 1) / 2;
    int actualSum = 0;
    for(int i  : numbers)
    {
      actualSum+=i;
    }
    return expectedSum - actualSum;
  }
}
