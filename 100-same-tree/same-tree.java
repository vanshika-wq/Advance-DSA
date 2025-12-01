/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Both trees are empty
        if (p == null && q == null) {
            return true;
        }
        // One is empty, the other is not
        if (p == null || q == null) {
            return false;
        }
        // Check current node value and recurse for left and right subtrees
        return (p.val == q.val)
            && isSameTree(p.left, q.left)
            && isSameTree(p.right, q.right);
    }
}
