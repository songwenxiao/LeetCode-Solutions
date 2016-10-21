public class Solution {
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] product = new int[len1+len2];
        
        for(int i = len1-1;i>=0;i--){
            for(int j = len2-1;j>=0;j--){
                int index = len1-1+len2-1-i-j;
                product[index] += (num1.charAt(i)-'0')*(num2.charAt(j)-'0');//注意这三行
                product[index+1] += product[index]/10;
                product[index] = product[index]%10;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = product.length-1;i>0;i--){
             if (sb.length() == 0 && product[i] == 0)
            continue;
        sb.append(product[i]);
        }
        sb.append(product[0]);
        return sb.toString();
    }
}