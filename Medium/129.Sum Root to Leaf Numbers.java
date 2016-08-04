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
    int sum;
    public int sumNumbers(TreeNode root) {
        if(root==null) return 0;
        int num = 0;
        sum = 0;
        sum(root,root.val);
        return sum;
    }
    
    public void sum(TreeNode root, int num){
        if(root.left==null&&root.right ==null){
            sum += num;
        }
        if(root.left!=null){
            sum(root.left,num*10+root.left.val);
        }
        if(root.right!=null){
            sum(root.right,num*10+root.right.val);
        }
    }
}