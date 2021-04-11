// permutation is the example of multiple recursion
public class Permutation {
    public static void permutation(String  str,String originalStr )
    {
            if(originalStr.length() == 0)
            {
                    System.out.println(str);
                    return ;
            }
            else 
            {
                    for(int i=0; i<originalStr.length(); i++)
                    {
                             char c = originalStr.charAt(i);
                             String modified = originalStr.substring(0 , i) + originalStr.substring(i+1); 
                            permutation(str + c, modified);
                    }
            }
    }
}
