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
    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        if (isBalancedUtil(root) == -1)
            return false;
        return true;
    }

    public int isBalancedUtil(TreeNode root) {
        if (root == null)
            return 0;
        int leftHeight = isBalancedUtil(root.left);
        int rightHeight = isBalancedUtil(root.right);
        if (leftHeight == -1 || rightHeight == -1)
            return -1;
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}