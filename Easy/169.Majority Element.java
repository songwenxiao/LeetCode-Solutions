public class Solution {
    public int majorityElement(int[] nums) {
        int res = nums[0];
        int count = 1;
        for (int i = 0;i<nums.length ; i++) {
            if(nums[i] == res){
                count++;
            } else {
                if(count==1){
                    res = nums[i];
                }else {
                    count--;
                }
            }
        }
        return res;
    }
}