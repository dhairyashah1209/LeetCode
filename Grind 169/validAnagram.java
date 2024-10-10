class Solution {
    public boolean isAnagram(String s, String t) {
        int[] freq = new int[26];
        int s_length = s.length();
        int t_length = t.length();

        if (s_length != t_length)
            return false;

        for(int i=0;i<s_length;i++) {
            freq[s.charAt(i)-'a']++;
        }

        for(int i=0;i<t_length;i++) {
            freq[t.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++) {
            if(freq[i]!=0)
                return false;
        }

        return true;

    }
}