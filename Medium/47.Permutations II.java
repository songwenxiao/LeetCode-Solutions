public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums,visited,result,new ArrayList<Integer>(), nums.length);
        return result;
    }
    
    public void backtracking (int[] nums, boolean[] visited, List<List<Integer>> result, List<Integer> list, int k){
        if(k==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(visited[i]){
                continue;
            }else{
                if(i>0&&nums[i-1]==nums[i]&&visited[i-1]){
                    return;
                }
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums,visited,result,list,k-1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }
}