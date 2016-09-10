public class Solution {
    public int maxSubArray(int[] A) {
        int n = A.length;
        int[] dp = new int[n];//dp[i] means the maximum subarray ending with A[i];
        dp[0] = A[0];
        int max = dp[0];
        
        for(int i = 1; i < n; i++){
            dp[i] = A[i] + (dp[i - 1] > 0 ? dp[i - 1] : 0);
            max = Math.max(max, dp[i]);
        }
        
        return max;
    }
}

//2 divide and conquer
public class Solution {
public int maxSubArray(int[] nums) {
    if(nums == null || nums.length == 0) {
        return 0;
    }
    return dfshelper(nums , 0 , nums.length-1);
}

protected int dfshelper(int[] nums , int left , int right) {
    if(left == right) {
        return nums[left];
    }
    int mid = left + (right - left) / 2;
    int leftmax = dfshelper(nums , left , mid);//   divide part
    int rightmax = dfshelper(nums , mid+1 , right); //  divide part
    int lmax = Integer.MIN_VALUE;
    int rmax = Integer.MIN_VALUE;
    int leftsum = 0;
    int rightsum = 0;
    for(int i = mid ; i >= left ; i--) { //  conquer part
        leftsum += nums[i];
        lmax = Math.max(lmax , leftsum);
    }
    for(int i = mid+1 ; i <= right ; i++) { //  conquer part
        rightsum += nums[i];
        rmax = Math.max(rmax , rightsum);
    }
    int crossmax = lmax + rmax; //  conquer part
    return Math.max(crossmax , Math.max(leftmax , rightmax));   //  combine part
 }