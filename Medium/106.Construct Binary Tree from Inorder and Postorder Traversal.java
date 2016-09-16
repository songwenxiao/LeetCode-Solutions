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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
          TreeNode root = createTree(inorder,postorder,0,inorder.length-1,0,postorder.length-1);
        return root;
    }
    
     public TreeNode createTree(int[] inorder, int[] postorder, int inBeg, int inEnd, int posBeg, int posEnd){
        if(inBeg>inEnd){
            return null;
        }
        
        int root = postorder[posEnd];
        
        int index = 0;
        
        for(int i = inBeg;i<= inEnd;i++){
            if(inorder[i] == root)
            {
                index = i;
                break;
            }
        }
        
        int len = index - inBeg;
        TreeNode node = new TreeNode(root);
        node.left = createTree(inorder,postorder,inBeg,index-1,posBeg,posBeg+len-1);
        node.right = createTree(inorder, postorder, index+1,inEnd, posBeg+len,posEnd-1);
        
     
        
        return node;
    }

}