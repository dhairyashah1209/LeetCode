class Solution {
    public int longestPalindrome(String s) {
        int n = s.length();
        int[] freq = new int[58];

        for (char c : s.toCharArray()) {
            freq[c - 'A']++;
        }
        int odd = 0;
        for (int i = 0; i < 58; i++) {
            if (freq[i] % 2 == 1)
                odd++;
        }
        if (odd == 0)
            return n;
        return n - odd + 1;
    }
}