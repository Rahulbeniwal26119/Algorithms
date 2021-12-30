//     *
//    ***
//   *****
//  *******
// *********
//  *******
//   *****
//    ***
//     *
// i hope it is most easy implementation 
public class Iterview {
        public static void main(String[] args) {
                int number = 5;
                int numberOfStars = 1;
                int factor = 1;
                for (int i = 1; i <= number; i++) {
                        int gap = number - numberOfStars;
                        for(int j=0; j<=gap/2; j++)
                        {
                                System.out.print(' ');
                        }
                        for(int k=1; k<=numberOfStars; k++)
                                System.out.print('*');
                        if(numberOfStars == number)
                        {
                                factor = -1;
                        }
                        numberOfStars+=factor*2;
                        System.out.println();
                        
                }
        }
}
