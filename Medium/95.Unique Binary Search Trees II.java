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
    public List<TreeNode> generateTrees1(int n) {
        if(n==0)return new ArrayList<TreeNode>();
        return genTrees(1,n);
    }
    
    public List<TreeNode> genTrees(int start, int end) {
        List<TreeNode> list = new ArrayList<TreeNode>();

        if(start>end)
        {
            list.add(null);
            return list;
        }

        if(start == end){
            list.add(new TreeNode(start));
            return list;
        }

        List<TreeNode> left,right;
        for(int i=start;i<=end;i++)
        {

            left = genTrees(start, i-1);
            right = genTrees(i+1,end);

            for(TreeNode lnode: left)
            {
                for(TreeNode rnode: right)
                {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }

        }

        return list;
    }







    TreeNode deepCopy(TreeNode root){
        if(root == null) return null;
        TreeNode tmp = new TreeNode(1);
        tmp.left = deepCopy(root.left);
        tmp.right = deepCopy(root.right);
        return tmp;
    }
    int cur = 0;
    void setValue(TreeNode root){
        if(root.left != null){
            setValue(root.left);
        }
        root.val = cur++;
        if(root.right != null){
            setValue(root.right);
        }
        
    }
    public List<TreeNode> generateTrees2(int n) {
        if(n <= 0){
            List<TreeNode> res =new ArrayList<TreeNode>();
            res.add(null);
            return res;
        }
        
        List<TreeNode>[] dp = new ArrayList [n+1];
        for(int i = 0; i < n+1; ++i){
            dp[i] =  new ArrayList<TreeNode>();
        }
        
        dp[0].add(null);
        
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j < i; ++j){
                for(int k = 0; k < dp[j].size(); ++k){
                    for(int l = 0; l < dp[i-1-j].size(); ++l){
                        TreeNode tmp = new TreeNode(1);
                        tmp.left = deepCopy(dp[j].get(k));
                        tmp.right = deepCopy(dp[i-1-j].get(l));
                        dp[i].add(tmp);
                    }
                }
            }
        }
        
        for(int i = 0; i < dp[n].size(); ++i){
            cur = 1;
            setValue(dp[n].get(i));
        }
        return dp[n];
    }
}