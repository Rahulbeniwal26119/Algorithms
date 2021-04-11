public class LinearRecursion
{
        public static int  sumArray(int []array , int size)
        {
                if(size == 0)
                        return 0;
                else 
                        return array[size-1] + sumArray(array , size-1);
        }

        public static void reverseArray(int []array , int low , int high)
        {
                if(low >= high)
                        return ;
                else 
                {
                        int temp = array[low];
                        array[low] = array[high];
                        array[high] = temp;
                        reverseArray(array , low + 1, high-1);
                }
        }
        public static double power(double x , int n)
        {
                if(n==0)
                        return 1;
                else 
                {
                        return x * power(x , n-1);
                }
        }

        public static double powerByHalfMethod(double x , int n)
        {
                if(n==0)
                        return 1;
                else 
                {
                        double  partial = powerByHalfMethod(x , n/2);
                        double result = partial * partial;
                        if(n % 2 == 1)
                        {
                                result *= x;
                        }
                        return result;
                }
        }
        public static void main(String [] args)
        {
                System.out.println(powerByHalfMethod(10 , 3));
                System.out.println(power(10 , 3));
                int []array = { 1,2,3,4,5,6,7,8,9,10};
                int sum = sumArray(array, array.length);
                System.out.println(sumArray(array , 10));
                reverseArray(array, 0 , array.length-1);
                for(int i: array)
                        System.out.println(i);
        }
}


