public class Solution {
    public List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[nums.length];
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
                visited[i] = true;
                list.add(nums[i]);
                backtracking(nums,visited,result,list,k-1);
                list.remove(list.size()-1);
                visited[i] = false;
            }
        }
    }

    public List<List<Integer>> permute2(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        permute(result, num, 0);
        return result;
    }

    private void permute(List<List<Integer>> result, int[] array, int start) {
        if (start >= array.length) {
            List<Integer> current = new ArrayList<Integer>();
            for (int a : array) {
                current.add(a);
            }
            result.add(current);
        } else {
            for (int i=start; i<array.length; i++) {
                swap(array, start, i);
                permute(result, array, start+1);
                swap(array, start, i);
            }
        }
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}