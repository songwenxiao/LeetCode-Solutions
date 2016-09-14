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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        boolean isOdd = true;
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> cur = new ArrayList<Integer>();
            while(size!=0){
                TreeNode node = queue.poll();
                size--;
                if(node.left!=null){
                    queue.offer(node.left);
                }
                if(node.right!=null){
                    queue.offer(node.right);
                }
                if(isOdd){
                    cur.add(node.val);
                }else{
                    cur.add(0,node.val);
                }
            }
            isOdd = !isOdd;
            res.add(cur);
        }
        return res;
    }
}