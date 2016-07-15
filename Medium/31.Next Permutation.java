public class Solution {
    public void nextPermutation(int[] nums) {
        int start = nums.length - 1;
       while (start > 0 && nums[start-1] >= nums[start]) start--;
       if (start > 0) {
           int end = nums.length - 1;
           while (nums[end] <= nums[start-1]) end--;
           swap(nums, start-1, end);
       }
       //we don't need to sort, we can just reverse it
       for (int i=start; i<(start+nums.length)/2; i++) {//注意此处的交换
           swap(nums, i, nums.length-1+start-i);
       }
    }
    
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}