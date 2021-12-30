 private static class StackNode 
    {
        int val;
        int curMax;
        
        public StackNode(int val, int curMax)
        {
            this.val = val;
            this.curMax = curMax;
        }
        
        public String toString()
        {
            return val + " [" + curMax + " ]"; 
        }
    }


    public static List<Integer> getMax(List<String> operations) {
    // Write your code here
    int max = Integer.MIN_VALUE;
    Stack<StackNode> stack = new Stack<StackNode>();
    Iterator<String> it = operations.iterator();
    ArrayList<Integer> result = new ArrayList<>();            
    while(it.hasNext())
    {
        String query;
        int value = 0;
        String queryString = it.next();
        if(queryString.length() > 1)
        {
            query = Character.toString(queryString.charAt(0));
            value = Integer.parseInt(queryString.substring(2));
        }
        else 
        {
            query = queryString;
        }
        switch(query)
        {
            case "1":
                max = Math.max(value, max);
                stack.push(new StackNode(value, max));
                break;
            case "2":
                if(!stack.isEmpty())
                    stack.pop();
                if(stack.isEmpty())
                    max = Integer.MIN_VALUE;
                else 
                    max = stack.peek().curMax;
                break;
            case "3":
                if(!stack.isEmpty())
                result.add(stack.peek().curMax);
                break;
        }
    }
    return result;
    }

}
