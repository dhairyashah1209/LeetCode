class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int n : nums) {
            if (map.containsKey(n))
                return true;
            map.put(n, true);
        }
        return false;
    }
}