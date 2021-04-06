// new approach match the poped value with adjecent value through the opening and closing delimiter
public class MatchingDelimiter
{
        public static boolean isMatched(String expression)
        {
                String opening = "({[";
                String closing = ")}]";
                LinkedStack<Character> stack = new LinkedStack<>();
                for(char c : expression.toCharArray())
                {
                        if(opening.indexOf(c) != -1)
                                stack.push(c);
                        if(closing.indexOf(c) != -1)
                        {
                                if(closing.isEmpty())
                                        return false;
                                else if(closing.indexOf(c) != opening.indexOf(stack.pop()))
                                        return false;
                        }
                }
                return stack.isEmpty();
        }

        public static void main(String []args)
        {
                String s = "(({{[]}}))";
                System.out.println(isMatched(s));
        }
}

