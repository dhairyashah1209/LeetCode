class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int m = intervals.length;
        List<int[]> mergedIntervals = new ArrayList<>();
        int[] prevInterval = intervals[0];
        for (int i = 1; i < m; i++) {
            int[] interval = intervals[i];
            if (interval[0] <= prevInterval[1]) {
                prevInterval[1] = Math.max(prevInterval[1], interval[1]);
            } else {
                mergedIntervals.add(prevInterval);
                prevInterval = interval;
            }
        }
        mergedIntervals.add(prevInterval);
        return mergedIntervals.toArray(new int[mergedIntervals.size()][]);
    }
}