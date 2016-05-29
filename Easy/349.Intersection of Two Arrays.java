public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> res = new HashSet<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        while(i<nums1.length&&j<nums2.length) {
            if(nums1[i]<nums2[j]) {
                i++;
            } else if(nums1[i]>nums2[j]) {
                j++;   
            } else {
                res.add(nums1[i]);  
                i++;
                j++;
            }
        }
        int[] result = new int[res.size()];
        int k = 0;
        for(int num : res){
            result[k++] = num;
        }
        return result;
    }
}