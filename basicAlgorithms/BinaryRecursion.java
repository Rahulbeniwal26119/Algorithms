public class BinaryRecursion
{
        public static int binarySum(int [] array , int low , int high)
        {
                if(low > high)
                        return 0;
                else if(low == high)
                        return array[low];
                else 
                {
                        int mid  = (low + high)/2;
                        return binarySum(array, low, mid) + binarySum(array , mid+1 , high);
                }
        }

}

