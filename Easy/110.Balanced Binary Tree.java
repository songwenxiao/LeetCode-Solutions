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
    public boolean isBalanced(TreeNode root) {
        if(root==null)return true;
        return height(root)!=-1;
    }
    
    public int height(TreeNode node){
        if(node==null) return 0;
        int lh = height(node.left);
        int rh = height(node.right);
        if(lh==-1||rh==-1)return -1;
        if(lh-rh>1||lh-rh<-1){
            return -1;
        }
        return Math.max(lh,rh)+1;
    }
}