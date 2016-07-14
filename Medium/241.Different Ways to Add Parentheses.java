public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i<input.length();i++){
            if(input.charAt(i)=='+'||input.charAt(i)=='-'||input.charAt(i)=='*'){
            List<Integer> left = diffWaysToCompute(input.substring(0,i));
            List<Integer> right = diffWaysToCompute(input.substring(i+1));
            if(input.charAt(i)=='-'){
                for(Integer a:left){
                    for(Integer b:right){
                        result.add(a-b);
                    }
                }
            }else if(input.charAt(i)=='+'){
                for(Integer a:left){
                    for(Integer b:right){
                        result.add(a+b);
                    }
                }
            }else if(input.charAt(i)=='*'){
                for(Integer a:left){
                    for(Integer b:right){
                        result.add(a*b);
                    }
                }
            }
            }
        }
        if(result.size()==0){
            result.add(Integer.valueOf(input));
        }
        
        return result;
        
    }
}