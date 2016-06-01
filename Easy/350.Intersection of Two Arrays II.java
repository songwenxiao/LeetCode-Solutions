public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while(i<nums1.length&&j<nums2.length){
            if(nums1[i] < nums2[j]){
                i++;
            }else if(nums1[i]>nums2[j]){
                j++;
            }else {
                list.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[list.size()];
        int p = 0;
        for(int k : list){
            res[p++] = k;
        }
        return res;
    }
}