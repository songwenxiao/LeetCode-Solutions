public class NumArray {
    
    int[] numArray;
    
    public NumArray(int[] nums) {
        for(int i = 1; i<nums.length;i++){
            nums[i] += nums[i-1];
        }
        this.numArray = nums;
    }

    public int sumRange(int i, int j) {
        if(i==0) return numArray[j];
        return numArray[j] - numArray[i-1];
    }
}