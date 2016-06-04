public class Solution {
    public int trailingZeroes(int n) {
        int res = 0;
        while(n/5!=0){
            int cur = n/5;
            res += cur;
            n = n/5;
        }
        return res;
    }
}