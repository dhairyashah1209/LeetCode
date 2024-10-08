class Solution {
    public boolean isValid(String s) {
        Stack<Integer> st = new Stack<>();
        int len = s.length();
        for(int i=0;i<len;i++) {
            if(st.isEmpty()) {
                st.push(i);
            } else {
                int curChar = s.charAt(i);
                if (curChar=='(' || curChar=='[' || curChar=='{') {
                    st.push(i);
                }
                else {
                    int stackChar = s.charAt(st.peek());
                    if (curChar==')') {
                        if (stackChar != '(') {
                            return false;    
                        }
                    } else if (curChar==']') {
                        if (stackChar != '[') {
                            return false;
                        }
                    } else if (curChar=='}') {
                        if (stackChar != '{') {
                            return false;   
                        }
                    }
                    st.pop();
                }    
            }
        }
        if (st.isEmpty())
            return true;
        return false;    
    }
}