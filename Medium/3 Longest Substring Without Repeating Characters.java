public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0)
            return 0;
        int[] map = new int[256];
        int begin = 0, end = 0, sliding = Integer.MIN_VALUE;
        while(end < s.length()){
            if(map[s.charAt(end)] == 0){
                map[s.charAt(end++)]++;
                if(end - begin > sliding)
                    sliding = end - begin;
            }else{
                map[s.charAt(begin++)]--;
            }
        }
        return sliding;
    }
}