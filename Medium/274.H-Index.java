public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        int[] arr = new int[len+1];
        for(int i = 0;i<len;i++){
            if(citations[i]>len){
                arr[len] += 1;
            }else{
                arr[citations[i]] += 1;
            }
        }
        
        int t = 0;
        
        for(int i = len;i>= 0;i--){
            t = t+arr[i];
            if(i<=t){
                return i;
            }
        }
        return 0;
    }
}