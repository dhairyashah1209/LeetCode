class Solution {
    class Orange {
        int row;
        int col;
        int rottingTime;

        Orange(int row, int col, int rottingTime) {
            this.row = row;
            this.col = col;
            this.rottingTime = rottingTime;
        }
    }

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<Orange> queue = new LinkedList<>();
        int freshOranges = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Orange(i, j, 0));
                }
                if (grid[i][j] == 1)
                    freshOranges++;
            }
        }
        int adjRow[] = { -1, 0, 0, 1 };
        int adjCol[] = { 0, -1, 1, 0 };
        int maxTimeTakenToRot = 0;
        int rottingOranges = 0;

        while (!queue.isEmpty()) {
            int curRow = queue.peek().row;
            int curCol = queue.peek().col;
            int curTime = queue.peek().rottingTime;
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int newRow = curRow + adjRow[i];
                int newCol = curCol + adjCol[i];

                if (newRow >= 0 && newCol >= 0 && newRow < m && newCol < n && grid[newRow][newCol] == 1) {
                    queue.add(new Orange(newRow, newCol, curTime + 1));
                    grid[newRow][newCol] = 2;
                    maxTimeTakenToRot = Math.max(maxTimeTakenToRot, curTime + 1);
                    rottingOranges++;
                }
            }
        }
        if (freshOranges != rottingOranges)
            return -1;
        return maxTimeTakenToRot;
    }
}