public class PreviousNumberSum
{
        public static void sumArray(int array[], int length, int index)
        {
                if(length == index)
                        return ;
                else 
                {
                        array[index] = array[index] + array[index-1];
                        sumArray(array, length , index+1);
                }
        }
        public static void main(String[] args)
        {
                int array[] = {1,2,3,4,5,6};
                sumArray(array , array.length, 1);
                for(int i: array)
                        System.out.println(i);
        }

}

