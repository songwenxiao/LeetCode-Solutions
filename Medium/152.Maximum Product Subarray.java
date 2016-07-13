public class Solution {
    public int maxProduct(int[] nums) {
        if(nums==null||nums.length==0)return 0;
        
        int min = nums[0];
        int max = nums[0];
        int result = nums[0];
        for(int i = 1;i<nums.length;i++){
            int maxc = max;
            max = Math.max(Math.max(nums[i],nums[i]*max),min*nums[i]);
            min = Math.min(Math.min(nums[i],nums[i]*min),maxc*nums[i]);
            result = Math.max(max,result);
        }
        return result;
    }
}