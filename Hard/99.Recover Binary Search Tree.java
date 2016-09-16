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
    TreeNode m1, m2;
    TreeNode pre;
    public void recoverTree(TreeNode root) {
        recursive(root);  
        if(m1!=null&&m2!=null) {  
            int tmp = m1.val;  
            m1.val = m2.val;  
            m2.val = tmp;  
        } 
    }
    
    public void recursive(TreeNode root){
        if(root==null)
            return;
        if(root.left!=null){
            recursive(root.left);
        }
        if(pre!=null&&root.val<pre.val){
            if(m1==null){
                m1 = pre;
                m2 = root;
            }else{
                m2 = root;
            }
        }
        pre = root;
         if(root.right!=null) {  
            recursive(root.right);  
        }  
    }
}