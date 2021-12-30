public class BinarySearch
{
public static int  binarySearch(int[] data, int target, int low , int high)
{
        if(low > high)
                return -1;
        else 
        {
                int mid = (low + high) / 2;
                if(target == data[mid])
                        return mid;
                else if(target > data[mid])
                        return binarySearch(data , target , mid + 1, high);
                else
                        return binarySearch(data , target , low , mid - 1);
        }
}
public static void main(String [] args)
{
        System.out.println(binarySearch(new int[]{10 , 11 , 90 , 900 , 1000} , 1000 , 0 , 4));
                }
}
