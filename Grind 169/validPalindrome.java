class Solution {

    private boolean isAlphaNumeric(char c) {
        if((c>='0' && c<='9' || (c>='a' && c<='z')))
            return true;
        return false;    
    }

    public boolean isPalindrome(String s) {
        int len = s.length();
        StringBuilder lowercase = new StringBuilder();
        for(int i=0;i<len;i++) {
            char currentChar = s.charAt(i);
            if(currentChar>='A' && currentChar<='Z') {
                currentChar = (char) (currentChar + 32);
            }
            lowercase.append(currentChar);
        }
        
        int i=0,j=len-1;
        while(i<j) {
            while(i<len && !isAlphaNumeric(lowercase.charAt(i)))
                i++;
            while(j>=0 && !isAlphaNumeric(lowercase.charAt(j)))
                j--;
            if (i>j)
                return true;
            if(lowercase.charAt(i) != lowercase.charAt(j))
                return false;
            i++;
            j--;        
        }
        return true;
    }
}