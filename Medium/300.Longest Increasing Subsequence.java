//1) DP N2  https://www.youtube.com/watch?v=CE2b_-XfVDk
public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums==null||nums.length<1){
            return 0;
        }
        int[] T = new int[nums.length];
        for(int i = 0;i<T.length;i++){
            T[i] = 1;
        }
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    if(T[j]+1>T[i]){
                        T[i] = T[j]+1;
                    }
                }
            }
        }
        int longest = 0;
		for(int i=0; i < T.length; i++)
			longest = Math.max(longest, T[i]);

		return longest;
    }
}

//2) DP + Binary Search  nlogn  https://www.youtube.com/watch?v=S9oUiVYEq7E
