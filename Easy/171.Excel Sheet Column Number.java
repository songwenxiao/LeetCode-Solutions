public class Solution {
    public int titleToNumber(String s) {
        char[] cs = s.toCharArray();
        int res = 0;
        int tmp = 0;
        for(int i = 0;i<cs.length;i++){
            tmp = cs[i] - 'A' + 1;
            res = res*26 + tmp;
        }
        return res;
    }
}