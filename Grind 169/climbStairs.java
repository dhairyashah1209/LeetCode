class Solution {
    public int climbStairs(int n) {
        if (n <= 3)
            return n;
        int last = 2, secondLast = 1;
        int cur = 0;
        for (int i = 3; i <= n; i++) {
            cur = last + secondLast;
            secondLast = last;
            last = cur;
        }
        return cur;
    }
}