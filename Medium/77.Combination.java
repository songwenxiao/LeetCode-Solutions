public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(k==0||n==0)   return result;
        backtracking(n,k,result,list,1);
        return result;
    }
    
    public void backtracking(int n, int k, List<List<Integer>> result, List<Integer> list, int start){
        if(k==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }else{
            for(int i = start;i<=n;i++){
                list.add(i);
                backtracking(n,k-1,result,list,i+1);
                list.remove(list.size()-1);
            }
        }
    }
}