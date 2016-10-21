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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Queue<TreeNode> treeQ = new LinkedList<TreeNode>();
        Queue<Integer> numQ = new LinkedList<Integer>();
        if(root == null) return res;
        treeQ.add(root); 
    	numQ.add(0);
    
    	int min = 0, max = 0;
    	while(!treeQ.isEmpty()){
    	    TreeNode node = treeQ.poll();
    	    int num = numQ.poll();
    	    if(!map.containsKey(num)) map.put(num, new ArrayList<Integer>());
		    map.get(num).add(node.val);
		    if(node.left != null) {
    			treeQ.add(node.left); 
    			numQ.add(num - 1);
    			if(num <= min) min = num - 1;
        	}
    		if(node.right != null) {
    			treeQ.add(node.right);
    			numQ.add(num + 1);
    			if(num >= max) max = num + 1;
    		}
    	}
    	for(int i = min; i <= max; i++) {
		res.add(map.get(i));
	    }

	    return res;
    }
}