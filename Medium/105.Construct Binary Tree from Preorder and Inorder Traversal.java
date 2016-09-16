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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);

    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder){
        if(preStart>=preorder.length||inStart>inEnd){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preStart]);
        int index = 0;
        for(int i = inStart;i<=inEnd;i++){
            if(inorder[i]==node.val){
                index = i;
            }
        }
        node.left = helper(preStart+1,inStart,index-1,preorder,inorder);
        node.right = helper(preStart+index-inStart+1,index+1,inEnd,preorder,inorder);
        return node;
    }
}