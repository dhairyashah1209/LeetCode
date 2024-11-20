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
    private void rightView(TreeNode cur, List<Integer> result, int curDepth) {
        if (cur == null)
            return;
        if (curDepth == result.size())
            result.add(cur.val);
        rightView(cur.right, result, curDepth + 1);
        rightView(cur.left, result, curDepth + 1);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        rightView(root, result, 0);
        return result;
    }
}