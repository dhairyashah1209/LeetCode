class Solution {

    private void getAllPermutations(int[] nums, List<List<Integer>> permutations, List<Integer> tempList) {
        if (tempList.size() == nums.length)
            permutations.add(new ArrayList<>(tempList));
        else {
            for (int i = 0; i < nums.length; i++) {
                System.out.println("i: " + i);
                if (tempList.contains(nums[i]))
                    continue;
                tempList.add(nums[i]);
                System.out.println("tempList: " + tempList);
                getAllPermutations(nums, permutations, tempList);
                tempList.remove(tempList.size() - 1);
                System.out.println("tempList 2 : " + tempList);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> permutations = new ArrayList<>();
        getAllPermutations(nums, permutations, new ArrayList<>());
        return permutations;
    }
}