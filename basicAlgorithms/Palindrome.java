import java.util.*;

class Palindrome{
    static boolean isPalindrome(String str, int low, int high){
        while(low < high){
            if(str.charAt(low) != str.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }

    static int possiblePalindrome(String str){
        int low = 0, high = str.length()-1;
        while(low < high){
            if(str.charAt(low) == str.charAt(high)){
                low++;
                high--;
            }
            else{
                if(isPalindrome(str, low +1, high))
                    return low;
                if(isPalindrome(str, low, high - 1))
                    return high;
                return -1;
            }
        }
        return -2;
    }

    public static void main(String []args){
        String str = "dalpad";
        int idx = possiblePalindrome(str);
        if(idx == -1)
            System.out.println("Not Possible");
        else if(idx == -2)
            System.out.println("Palindrome");
        else 
            System.out.println("Possible by removing " + " Character " + str.charAt(idx));
    }
}
