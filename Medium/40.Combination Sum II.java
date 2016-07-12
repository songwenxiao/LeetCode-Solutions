public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        int index = 0;
        
        if(candidates == null || candidates.length==0)  
        return result; 
        Arrays.sort(candidates);  
        backtrack(candidates,target,index,(ArrayList)list,(ArrayList)result);
        return result;
        
    }
    
    public void backtrack(int[] candidates, int target, int index, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> result){
        
        if(target<0)  
        return; 
        if(target==0){
            result.add(new ArrayList<Integer>(list));
            return;
        }
        
        for(int i=index;i<candidates.length;i++)  
    {  
        if(i>index && candidates[i]==candidates[i-1])  
            continue;  
        list.add(candidates[i]);  
        backtrack(candidates,target-candidates[i],i+1,list,result);  
        list.remove(list.size()-1);  
    }  
    }

}