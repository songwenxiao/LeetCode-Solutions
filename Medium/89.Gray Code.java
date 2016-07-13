public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i<1<<n;i++){
            result.add(i^i>>1);
        }
        return result;
    }

    public List<Integer> grayCode2(int n) {
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        if(n==0)return result;
        result.add(1);
        int count = 1;
        while(count<n){
            for(int i = result.size()-1;i>=0;i--){
                result.add(result.get(i)|(1<<count));
            }
            count++;
        }
        return result;
    }
}