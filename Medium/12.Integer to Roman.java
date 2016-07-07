public class Solution {
    public String intToRoman(int num) {
        int[] value = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] str = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<value.length;i++){
            while(num>=value[i]){
                sb.append(str[i]);
                num = num - value[i];
            }
        }
        return sb.toString();
    }
}