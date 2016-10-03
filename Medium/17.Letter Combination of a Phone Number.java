public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits.length()==0){
            return res;
        }
        String[] array = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String str="";
        backtracking(res, digits, 0, str, array);
        return res;
    }
    
    public void backtracking(List<String> res, String digits, int index, String cur, String[] array){
        if(index==digits.length()){
            res.add(new String(cur));
            return;
        }
        int j = (digits.charAt(index) - '0');
        String s = array[j];
        
        for(int k = 0;k<s.length();k++){
                String st = new String(cur);
                st += s.charAt(k);
                backtracking(res, digits, index+1, st, array);
            }
            return;
    }
}