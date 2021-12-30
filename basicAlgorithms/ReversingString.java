import java.lang.StringBuffer;
public class ReversingString
{
        static String reverseString(String str)
        {
                LinkedStack<Character> charStack = new LinkedStack<>();
                for(char c : str.toCharArray())
                        charStack.push(c);
                StringBuffer result = new StringBuffer("");
                while(!charStack.isEmpty())
                {
                        result.append(charStack.pop());
                }
                return new String(result);
        }
        public static void main(String []args)
        {
                System.out.println(reverseString("Rahul"));
        }
}
