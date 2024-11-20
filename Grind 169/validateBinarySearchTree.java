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

    private boolean isValidBSTUtil(TreeNode node, long minimum, long maximum) {
        if (node == null)
            return true;
        if (node.val <= minimum || node.val >= maximum)
            return false;
        return isValidBSTUtil(node.left, minimum, node.val)
                && isValidBSTUtil(node.right, node.val, maximum);
    }

    public boolean isValidBST(TreeNode root) {
        return isValidBSTUtil(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}