/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        TreeNode tmp = root.left;
        root.left = invertTree(right);
        root.right = invertTree(tmp);
        return root;
    }
}