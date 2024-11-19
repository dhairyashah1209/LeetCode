class Solution {

    private boolean isOperator(String s) {
        if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/"))
            return true;
        return false;
    }

    public int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            String token = tokens[i];
            if (!isOperator(token))
                stack.push(token);
            else {
                int ans = 0;
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                if (token.equals("+"))
                    ans = val1 + val2;
                else if (token.equals("-"))
                    ans = val2 - val1;
                else if (token.equals("*"))
                    ans = val1 * val2;
                else if (token.equals("/"))
                    ans = val2 / val1;
                stack.push(Integer.toString(ans));
            }
        }
        return Integer.parseInt(stack.peek());
    }
}