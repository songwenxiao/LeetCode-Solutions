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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
       if(root==null){
           return null;
       } else if(root.val == p.val) {
           return root;
       } else if(root.val == q.val){
           return root;
       } else {
           TreeNode left = lowestCommonAncestor(root.left,p,q);
           TreeNode right = lowestCommonAncestor(root.right,p,q);
           if(left!=null&&right!=null){
               return root;
           }else {
               return left!=null?left:right;
           }
       }
       
        
    }
}