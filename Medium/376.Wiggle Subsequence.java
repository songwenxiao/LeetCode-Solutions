public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int[] res = new int[nums.length];
        if(nums==null||nums.length==0)return 0;
        res[0] = 1;
        int i = 1;
        while(i<nums.length&&nums[0]==nums[i]){
            res[i] = res[i-1];
            i++;
        }
        if(i>=nums.length){
            return 1;
        }
        boolean isPositive;
        if(nums[i]>nums[0]){
            isPositive = true;
        }else{
            isPositive = false;
        }
        res[i] = res[i-1] + 1;
        int pre = nums[i];
        
        for(int j = i+1;j<nums.length;j++){
            if(isPositive){
                if(pre > nums[j]){
                    res[j] = res[j-1]+1;
                    isPositive = false;
                }else{
                    res[j] = res[j-1];
                }
            }else{
                if(pre < nums[j]){
                    res[j] = res[j-1]+1;
                    isPositive = true;
                }else{
                    res[j] = res[j-1];
                }
            }
            pre = nums[j];
        }
        return res[nums.length-1];
    }
}