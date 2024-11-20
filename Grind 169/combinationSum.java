class Solution {

    private void backtrack(List<List<Integer>> combinations, List<Integer> tempList, int[] candidates, int remainingSum,
            int start) {
        if (remainingSum < 0)
            return;
        if (remainingSum == 0) {
            combinations.add(new ArrayList<>(tempList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                tempList.add(candidates[i]);
                backtrack(combinations, tempList, candidates, remainingSum - candidates[i], i);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> combinations = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(combinations, new ArrayList<>(), candidates, target, 0);
        return combinations;
    }
}