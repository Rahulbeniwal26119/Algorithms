public class Strcmp {
    public static int strcmp(String a, String b)
    {
        for(int i=0; i<a.length() && i<b.length(); i++)  // check for string which are of unequal length and one contains other 
        {
            if(a.charAt(i) != b.charAt(i)) 
                return a.charAt(i) < b.charAt(i) ? -1 : 1; 
        }
        return a.length() < b.length() ? -1 : a.length() == b.length() ? 0 : 1;
    } 
   // space for main 
}
