public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int middle = (left+right)/2;
        while(left<=right){
            middle = (left+right)/2;
            if(nums[middle]==target){
                while(middle>=0&&nums[middle]==target){
                    middle--;
                }
                return middle+1;
            }else if(nums[middle]<target){
                left = middle+1;
            }else {
                right = middle-1;
            }
        }
        return right+1;
    }
}