class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int longestPalindromeLength = 1, startIdx = 0;

        for (int i = 0; i < n; i++)
            dp[i][i] = true;

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = true;
                startIdx = i;
                longestPalindromeLength = 2;
            }
        }

        for (int k = 3; k <= n; k++) {
            for (int i = 0; i < n - k + 1; i++) {
                int j = i + k - 1;
                if (dp[i + 1][j - 1] == true && s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = true;
                    if (k > longestPalindromeLength) {
                        longestPalindromeLength = k;
                        startIdx = i;
                    }
                }
            }
        }
        return s.substring(startIdx, startIdx + longestPalindromeLength);
    }
}