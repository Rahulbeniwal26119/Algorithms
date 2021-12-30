public class FibMemoization
{
        public static int fibM1(int n , int []memo)
        {
        if(n <=1 ) return 1;
        else if(memo[n]>0) return memo[n];
        memo[n] = fibM1(n-1,memo) + fibM1(n-2,memo);
        return memo[n];
        }
        public static long[] fibM2(int n)
        {
                if(n <=1 ) 
                {
                        return (new long[]{n , 0});
                }
                else 
                {
                        long  temp[] = fibM2(n-1);
                        long result[] = {temp[0] + temp[1] , temp[0]};
                        return result;
                }
        }
        public static void main(String []args)
        {
                System.out.println(fibM1(5 , new int[6]));
        }

}

