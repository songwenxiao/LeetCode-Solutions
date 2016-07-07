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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        List<Integer> list = new ArrayList<Integer>();
        if(root==null)return list;
        stack.push(root);
        while(root.left!=null){
            stack.push(root.left);
            root = root.left;
        }
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            list.add(node.val);
            if(node.right!=null){
                stack.push(node.right);
                node = node.right;
                while(node.left!=null){
                    stack.push(node.left);
                    node = node.left;
                }
            }
        }
        return list;
    }
}