// this technique remove the recursion O(n)
public class fibBottomUp
{
        static int fib(int n)
        {
                if(n == 1 || n==2)
                        return 1;
                int []bottomUp = new int[n+1];
                bottomUp[1] = bottomUp[2] = 1;
                for(int i=3; i<=n; i++)
                {
                        bottomUp[i] = bottomUp[i-1] + bottomUp[i-2];
                }
                return bottomUp[n];
        }
        public static void main(String [] args)
        {
                System.out.println(fib(8));
        }
}


