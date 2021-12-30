public class TowerOfHanoi
{
        public static void toh(int n , char s , char m, char d)
        {
                if(n == 1)
                        System.out.println("Move disk " + " from " + s + " to " + d);
                else 
                {
                        toh(n-1, s , d , m );
                        toh(1 , s , m , d);
                        toh(n-1 , m , s , d);
                }
        }

        public static void main(String []args)
        {
                toh(2 , 'S' ,  'M' , 'D');
        }
}
