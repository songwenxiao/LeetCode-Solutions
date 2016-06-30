public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num+1];
        result[0] = 0;
        for(int i = 1;i<=num ;i++){
            result[i] = i%2==1 ? result[i/2]+1 : result[i/2];
        }
        return result;
    }
}