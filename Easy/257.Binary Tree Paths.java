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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        if(root==null)return res;
        help(root,"",res);
        return res;
    }
    
    public void help(TreeNode node, String str, List<String> result){
        if(node.left==null&&node.right==null){
            result.add(new String(str+String.valueOf(node.val)));
            return;
        }
        if(node.left!=null){
            help(node.left,str+String.valueOf(node.val)+"->",result);
        }
        if(node.right!=null){
            help(node.right,str+String.valueOf(node.val)+"->",result);
        }
        return;
    }
}