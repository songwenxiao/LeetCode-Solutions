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
    public int countNodes(TreeNode root) {
        int count = 0;
        int h = height(root);
        while(root!=null){
            if(height(root.right)==h-1){
                count += 1<<h;
                root = root.right;
            }else{
                count += 1<<h-1;
                root = root.left;
            }
            h--;
        }
        return count;
    }
    
    public int height(TreeNode root){
        return root==null?-1:1+height(root.left);
    }
}