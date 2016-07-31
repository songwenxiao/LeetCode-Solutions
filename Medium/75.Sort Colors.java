public class Solution {
    public void sortColors(int[] nums) {
        if(nums==null||nums.length==0){
            return;
        }
        int idx0 = -1;
        int idx1 = -1;
        int idx2 = -1;
        for(int i = 0;i<nums.length;i++){
            if(nums[i]==0){
                nums[++idx2] = 2;
                nums[++idx1] = 1;
                nums[++idx0] = 0;
            }else if(nums[i]==1){
                nums[++idx2] = 2;
                nums[++idx1] = 1;
            }else{
                nums[++idx2] = 2;
            }
        }
        
    }

    void sortColors(int A[], int n) {
    int j = 0, k = n-1;
    for (int i=0; i <= k; i++) {
        if (A[i] == 0)
            swap(A[i], A[j++]);
        else if (A[i] == 2)
            swap(A[i--], A[k--]);
    }
}
}