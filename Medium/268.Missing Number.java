public class Solution {
    public int missingNumber1(int[] nums) {
        int i = 0;
        while(i<nums.length){
            if(nums[i]==i||nums[i]>=nums.length){
                i++;
            }else if(nums[nums[i]]!=nums[i]){
                swap(nums,i,nums[i]);
            }
        }
        i = 0;
        while(i<nums.length&&i==nums[i]){
            i++;
        }
        return i;
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int missingNumber2(int[] nums) {
        int xor = 0, i = 0;
    for (i = 0; i < nums.length; i++) {
        xor = xor ^ i ^ nums[i];
    }

    return xor ^ i;
    }
}