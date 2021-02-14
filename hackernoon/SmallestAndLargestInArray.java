import java.util.Arrays;

public class SmallestAndLargestInArray
{
  private static int [] minAndMax(int []array)
  {
    int largest = Integer.MIN_VALUE;
    int minimum = Integer.MAX_VALUE;

    for(int number : array)
    {
      if(number > largest)
            largest = number;
      if(number < minimum)
            minimum = number;
    }
    return (new int[]{largest , minimum});

  }
  public static void main(String[] args) {
    System.out.println(Arrays.toString(minAndMax(new int[]{5,4,2,3,2,1,4,34,5,-1})));
    System.out.println(Arrays.toString(minAndMax(new int[]{10, Integer.MIN_VALUE, -2})));
    System.out.println(Arrays.toString(minAndMax(new int[]{Integer.MAX_VALUE, 40,Integer.MAX_VALUE})));
  }
}
