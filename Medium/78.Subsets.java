public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backtracking(res, list, 0, nums);
        return res;
    }
    
    public void backtracking(List<List<Integer>> res, List<Integer> list, int pos, int[] nums) {
        if(pos==nums.length){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        
        list.add(nums[pos]);
        backtracking(res, list, pos+1, nums);
        list.remove(list.size()-1);
        backtracking(res, list, pos+1, nums);
    }

    private void doSubsets(int[] nums, List res,List subset,int start){
        if(start != nums.length){
            for(int i=start; i<nums.length; i++){
                subset.add(nums[i]);
                res.add(new ArrayList(subset));
                doSubsets(nums,res,subset,i+1);
                subset.remove(subset.get(subset.size()-1));
            }
        }
    }

}