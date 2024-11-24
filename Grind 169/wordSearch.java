class Solution {

    private boolean dfs(char[][] board, String word, boolean[][] visited, int i, int j, int wordIndex) {
        if (wordIndex == word.length())
            return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length
                || visited[i][j] || board[i][j] != word.charAt(wordIndex))
            return false;
        visited[i][j] = true;

        int[][] adjCells = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
        for (int[] adj : adjCells) {
            int newRow = i + adj[0];
            int newCol = j + adj[1];
            if (dfs(board, word, visited, newRow, newCol, wordIndex + 1))
                return true;
        }
        visited[i][j] = false;
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[m][n];
                    if (dfs(board, word, visited, i, j, 0))
                        return true;
                }
            }
        }
        return false;
    }
}