public class Solution {
    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k = k%len;
        
        if(len==1)return;
        if(k==0)return;
        
        reverse(nums,0,len-1-k);
        reverse(nums,len-k,len-1);
        reverse(nums,0,len-1);
        
    }
    
     public void reverse(int nums[], int begin, int end) {
        int t= 0;
        while(begin<end&&begin>=0){
            t = nums[begin];
            nums[begin] = nums[end];
            nums[end]=t;
            begin++;
            end--;
        }
    }
}