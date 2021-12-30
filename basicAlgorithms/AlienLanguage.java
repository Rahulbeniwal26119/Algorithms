public class AlienLanguage {
    public static boolean isAlienSorted(String[] words , String order)
    {
        for(int i=0; i<words.length-1; i++)
        {
            int hasBroken = 0;
            for(int j=0; j < words[i].length() && j < words[i+1].length(); j++)
            {
                if(words[i].charAt(j) != words[i+1].charAt(j))
                    {
                        if(order.indexOf(words[i].charAt(j)) >  order.indexOf(words[i+1].charAt(j)))
                             return false ;
                        else
                        {
                            hasBroken = 1;
                            break; 
                        }
                    }
            }
                if( words[i].length() >  words[i+1].length() && hasBroken == 0)  // check condition iff one string contain other and loop is unable to decide 
                    return false;
        }
        return true;
    } 
}
