public class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if(numerator==0)return "0";
        if(denominator==0) return "";
        
        String ans = "";
        if((numerator<0)^(denominator<0)){
            ans += "-";
        }
        
        long num = numerator;
        long den = denominator;
        num = Math.abs(num);
        den = Math.abs(den);
        
        long res = num/den;
        long rem = (num%den)*10;
        ans += String.valueOf(res);
        
        if(rem==0)return ans;
        
        ans += ".";
        Map<Long,Integer> map = new HashMap<Long,Integer>();
        while(rem!=0){
            if(map.containsKey(rem)){
                int p = map.get(rem);
                String s1 = ans.substring(0,p);
                String s2 = ans.substring(p,ans.length());
                ans = s1 +"(" +s2 + ")";
                return ans;
            }
            
            map.put(rem,ans.length());
            res = rem / den;  
            ans += String.valueOf(res);  
            rem = (rem % den) * 10; 
        }
        return ans;
    }
}