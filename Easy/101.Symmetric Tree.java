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
    public boolean isSymmetric(TreeNode root) {
        if(root==null)return true;
        return resolve(root.left,root.right);
    }
    
    public boolean resolve(TreeNode left, TreeNode right){
        if(left==null&&right==null)return true;
        else if(left==null||right==null){
            return false;
        }else if(left.val!=right.val){
            return false;
        }else {
            return resolve(left.left,right.right)&&resolve(left.right,right.left);
        }
    }
}