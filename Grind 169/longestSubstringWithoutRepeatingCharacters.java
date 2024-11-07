class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = 0;
        int[] map = new int[256];
        Arrays.fill(map, -1);
        int st = 0;

        for (int i = 0; i < n; i++) {
            int curIdx = map[s.charAt(i)];
            if (curIdx >= st) {
                st = curIdx + 1;
            }
            map[s.charAt(i)] = i;
            maxLength = Math.max(maxLength, i - st + 1);
        }
        return maxLength;
    }
}