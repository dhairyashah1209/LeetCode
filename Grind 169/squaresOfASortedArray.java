class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        int st = 0, ed = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            if (Math.abs(nums[st]) >= Math.abs(nums[ed])) {
                ans[i] = nums[st] * nums[st];
                st++;
            } else {
                ans[i] = nums[ed] * nums[ed];
                ed--;
            }
        }
        return ans;
    }
}