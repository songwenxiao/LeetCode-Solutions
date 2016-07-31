public class Solution {
    public void wiggleSort(int[] nums) {
        int median = findKthLargest(nums, (nums.length + 1) / 2);
        int n = nums.length;

        int left = 0, i = 0, right = n - 1;

        while (i <= right) {

            if (nums[newIndex(i,n)] > median) {
                swap(nums, newIndex(left++,n), newIndex(i++,n));
            }
            else if (nums[newIndex(i,n)] < median) {
                swap(nums, newIndex(right--,n), newIndex(i,n));
            }
            else {
                i++;
            }
        }


    }

    private int newIndex(int index, int n) {
        return (1 + 2*index) % (n | 1);
    }
    
    private void swap(int[] a, int i, int j){
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
    
    public int findKthLargest(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return Integer.MAX_VALUE;
        }   
        
        int len = nums.length;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(len, new Comparator<Integer>(){
            public int compare(Integer n1, Integer n2){
                return n2-n1;
            } 
        });
        for(int num : nums){
            pq.offer(num);
        }
        int[] res = new int[k];
        for(int i=0; i<k; i++){
            res[i] = pq.poll();
        }
        return res[k-1];
    }
}