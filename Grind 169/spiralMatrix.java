class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        List<Integer> result = new ArrayList<>();

        int top = 0, left = 0, right = n - 1, bottom = m - 1;
        int cnt = 0;
        while (cnt < m * n) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
                cnt++;
            }
            if (cnt == (m * n))
                break;
            top++;
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
                cnt++;
            }
            if (cnt == (m * n))
                break;
            right--;
            for (int i = right; i >= left; i--) {
                result.add(matrix[bottom][i]);
                cnt++;
            }
            if (cnt == (m * n))
                break;
            bottom--;
            for (int i = bottom; i >= top; i--) {
                result.add(matrix[i][left]);
                cnt++;
            }
            if (cnt == (m * n))
                break;
            left++;
        }
        return result;
    }
}