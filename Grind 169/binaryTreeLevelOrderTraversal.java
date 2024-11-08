/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    List<List<Integer>> levelTraversal = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return levelTraversal;
        }
        queue.add(root);
        queue.add(null);
        while (!queue.isEmpty() && queue.peek() != null) {
            TreeNode cur = queue.peek();
            queue.poll();
            level.add(cur.val);
            if (cur.left != null)
                queue.add(cur.left);
            if (cur.right != null)
                queue.add(cur.right);
            TreeNode front = queue.peek();
            if (front == null) {
                queue.poll();
                queue.add(null);
                levelTraversal.add(level);
                level = new ArrayList<>();
            }
        }
        if (!level.isEmpty())
            levelTraversal.add(level);
        return levelTraversal;
    }
}