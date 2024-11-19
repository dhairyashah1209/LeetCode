class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new List[numCourses];
        int[] indegree = new int[numCourses];
        List<Integer> coursesOpted = new ArrayList<>();

        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];
            if (adj[prerequisite] == null)
                adj[prerequisite] = new ArrayList<>();
            adj[prerequisite].add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0)
                queue.add(i);
        }

        while (!queue.isEmpty()) {
            int currentCourse = queue.poll();
            coursesOpted.add(currentCourse);

            if (adj[currentCourse] != null) {
                for (int nextCourse : adj[currentCourse]) {
                    indegree[nextCourse]--;
                    if (indegree[nextCourse] == 0)
                        queue.add(nextCourse);
                }
            }
        }
        return coursesOpted.size() == numCourses;
    }
}