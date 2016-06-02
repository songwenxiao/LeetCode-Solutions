public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<Integer>();
        int sum = 0;
        int num = n;
        while(sum!=1){
            sum = 0;
            while(num>0){
                int k = num%10;
                sum = sum + k*k;
                num = num / 10;
            }
            if(set.contains(sum)){
                return false;
            }
            set.add(sum);
            num = sum;
        }
        return true;
    }
}