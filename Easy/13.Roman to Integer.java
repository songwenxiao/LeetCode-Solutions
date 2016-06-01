public class Solution {
    public int romanToInt(String s) {
        int res = 0;
        int sub = valueExchange(s.charAt(0));
        int cur = 0;
        for(int i = 1;i<s.length();i++) {
            cur = valueExchange(s.charAt(i));
            if(cur<sub){
                res = res + sub;
                sub = cur;
            } else if(cur > sub){
                sub = cur - sub;
            } else {
                sub = sub + cur;
            }
        }
        res = res + sub;
        return res;
    }
    
    public int valueExchange(char c){
        switch(c) {
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
}