class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int l = i + 1, r = n - 1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) {
                    l++;
                } else if (sum > 0) {
                    r--;
                } else {
                    ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l + 1 < r && nums[l] == nums[l + 1])
                        l++;
                    while (r - 1 > l && nums[r - 1] == nums[r])
                        r--;
                    l++;
                    r--;
                }
            }
        }
        return ans;
    }
}