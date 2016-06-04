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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null)return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        int level = 1;
        while(!queue.isEmpty()){
            List<Integer> set = new ArrayList<Integer>();
            int nextLevel = 0;
            while(level!=0){
                TreeNode cur = queue.poll();
                level--;
                set.add(cur.val);
                if(cur.left!=null){
                    queue.offer(cur.left);
                    nextLevel++;
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                    nextLevel++;
                }
            }
            level = nextLevel;
            res.add(0,set);
        }
        return res;
    }
}