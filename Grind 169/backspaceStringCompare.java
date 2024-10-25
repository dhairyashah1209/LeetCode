class Solution {
    public String updateString(String s) {
        int i = s.length() - 1;
        String updatedString = "";
        while (i >= 0) {
            int countHash = 0;
            while (i >= 0 && s.charAt(i) == '#') {
                countHash++;
                i--;
            }
            while (i >= 0 && countHash > 0) {
                if (s.charAt(i) == '#')
                    countHash++;
                else
                    countHash--;
                i--;
            }
            while (i >= 0 && s.charAt(i) != '#') {
                updatedString += s.charAt(i);
                i--;
            }
        }
        return updatedString;
    }

    public boolean backspaceCompare(String s, String t) {
        return (updateString(s).equals(updateString(t)));
    }
}