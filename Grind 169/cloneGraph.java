/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        Map<Node, Node> clonedGraph = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();

        queue.add(node);
        clonedGraph.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            Node clonedCur = clonedGraph.get(cur);

            for (Node neighbor : cur.neighbors) {
                if (!clonedGraph.containsKey(neighbor)) {
                    clonedGraph.put(neighbor, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                clonedCur.neighbors.add(clonedGraph.get(neighbor));
            }
        }
        return clonedGraph.get(node);
    }
}