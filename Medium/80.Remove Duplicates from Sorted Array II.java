public class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        if(len<3) return len;
        int index = 1;
        int count = 1;
        for(int i = 1; i<len;i++){
            if(nums[i]==nums[i-1]){
                if(count<2){
                    nums[index++] = nums[i];
                    count++;
                }
            }else{
                nums[index++] = nums[i];
                count = 1;
            }
        }
        return index;
    }
}