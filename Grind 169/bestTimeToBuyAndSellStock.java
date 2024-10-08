class Solution {
    public int maxProfit(int[] prices) {
        int minTillNow = Integer.MAX_VALUE;
        int len = prices.length;
        int ans = 0;
        for(int i=0;i<len;i++) {
            if (prices[i] < minTillNow) {
                minTillNow = prices[i];
            } else {
                ans = Math.max(ans, prices[i] - minTillNow);
            }
        }
        return ans;
    }
}