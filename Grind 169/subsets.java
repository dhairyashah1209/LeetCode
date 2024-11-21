class Solution {

    private void backtrack(int[] nums, List<List<Integer>> subsets, int start, List<Integer> tempList) {
        subsets.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, subsets, i + 1, tempList);
            tempList.remove(tempList.size() - 1);
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        backtrack(nums, subsets, 0, new ArrayList<>());
        return subsets;
    }
}