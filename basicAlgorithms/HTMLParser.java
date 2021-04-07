import java.util.Stack;

class HTMLParser
{
        public boolean htmlParser(String html) {
        Stack<String> stack  = new Stack<>();
        int j = html.indexOf('<');
        while(j != -1)
        {
                int k = html.indexOf(j+1 , '>');
                if(k == -1)
                        return false;
                String tag = html.substring(j+1 , k);
                if(!tag.startsWith("/"))
                        stack.push(tag);
                else 
                {
                        if(stack.isEmpty())
                                return false;
                        if(!tag.substring(1).equals(stack.pop()))
                                return false;
                }
                j = html.indexOf('<' , k+1);
        }
        return stack.isEmpty();
        }
}


