class Solution {

    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>(
                new Comparator<Pair>() {
                    public int compare(Pair a, Pair b) {
                        int distA = a.x * a.x + a.y * a.y;
                        int distB = b.x * b.x + b.y * b.y;
                        if (distA > distB)
                            return -1;
                        else if (distA < distB)
                            return 1;
                        return 0;
                    }
                });

        for (int point[] : points) {
            pq.add(new Pair(point[0], point[1]));
            if (pq.size() > k)
                pq.poll();
        }

        int ans[][] = new int[k][2];
        int ind = 0;
        while (!pq.isEmpty()) {
            Pair cur = pq.poll();
            ans[ind][0] = cur.x;
            ans[ind++][1] = cur.y;
        }
        return ans;
    }
}