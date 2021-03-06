// this technique uses memoization and reduce the complexity from O(2**n) to O(2n+1) or O(n)
public class fibMemoization 
{
        static long  fib(int   n, long[]memo)
        {
                if(memo[n] != 0)
                        return memo[n];
                if(n==1 || n==2) 
                {
                        memo[n] = 1;
                        return 1;
                }
                else 
                {
                        memo[n] = fib(n-1 , memo) + fib(n-2, memo);
                        return memo[n];
                }
        }

        public static void main(String [] args)
        {
                int  n=100;
                long memo[] = new long[n+1];
                System.out.println(fib(n , memo));
        }
}

