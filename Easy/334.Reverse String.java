public class Solution {
    public String reverseString(String s) {
        if(s == null||s.length() == 0) {
            return "";
        }
        char[] cs = s.toCharArray();
        int low = 0;
        int high = cs.length - 1;
        while(low<high) {
            char tmp = cs[low];
            cs[low] =  cs[high];
            cs[high] =  tmp;
            low++;
            high--;
        }
        return new String(cs);
    }
}
