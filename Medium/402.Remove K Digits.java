public class Solution {
    public String removeKdigits(String num, int k) {
        if(k == num.length()) return "0";
        int d = num.length()-k;
        StringBuilder ans = new StringBuilder();
        int l = 0;
        for(int j = d;j>0;j--){
            int r = num.length()-j;
            int minIndex = 0;
            int min = Integer.MAX_VALUE;
            for(int jj =l;jj<=r;jj++){
                if(num.charAt(jj)-'0'<min){
                    min = num.charAt(jj)-'0';
                    minIndex = jj;
                }
            }
            l = minIndex+1;
            ans.append((num.charAt(minIndex)));
        }
        String res = ans.toString();
        int j = 0;
        while(j<res.length() && res.charAt(j) == '0'){
            j++;
        }
        if(j == res.length()) return "0";
        return res.substring(j, res.length());

    }
}