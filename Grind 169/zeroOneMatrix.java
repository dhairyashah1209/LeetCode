class Solution {
    class Node {
        int row, col, steps;

        Node(int row, int col, int steps) {
            this.row = row;
            this.col = col;
            this.steps = steps;
        }
    }

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] dist = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        Queue<Node> q = new LinkedList<>();

        // Initialise Queue to start BFS with nodes with 0 values.
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                }
            }
        }

        int[] adjRow = { -1, 0, 0, 1 };
        int[] adjCol = { 0, -1, 1, 0 };

        // BFS Traversal - take FIFO from queue and update steps of adjactent nodes and
        // mark them visited.
        while (!q.isEmpty()) {
            Node node = q.poll();
            int row = node.row;
            int col = node.col;
            int steps = node.steps;

            dist[row][col] = steps;

            for (int i = 0; i < 4; i++) {
                int newRow = row + adjRow[i];
                int newCol = col + adjCol[i];

                if (newRow >= 0 && newRow < m
                        && newCol >= 0 && newCol < n
                        && !vis[newRow][newCol]) {
                    vis[newRow][newCol] = true;
                    // Add adjacent nodes and mark values as existing_steps+1.
                    q.add(new Node(newRow, newCol, steps + 1));
                }
            }
        }
        return dist;
    }
}