class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for(int i=0;i<nums.length;i++) {
            if(hashMap.get(target - nums[i]) != null) {
                int[] solution = {hashMap.get(target - nums[i]), i};
                return solution;
            } else {
                hashMap.put(nums[i], i);
            }
        }
        return new int[] {};
    }
}