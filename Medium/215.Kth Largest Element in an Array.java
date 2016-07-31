public class Solution {
    //heap
    public int findKthLargest1(int[] nums, int k) {
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

    //quick sort divide and conquer
    public class Solution {
    public int findKthLargest2(int[] nums, int k) {
        if(nums==null||nums.length==0){
            return Integer.MAX_VALUE;
        }   
        int a = nums.length;
        int p = partition(nums, 0, a - 1, a - k + 1);
        return nums[p];
    }
    
    //find kth smallest number
    public int partition(int[] nums, int lo, int hi, int k){
        int i = lo, j = hi, pivot = nums[hi];
        while(i<j){
            if(nums[i++] > pivot){
                swap(nums,--i,--j);
            }
        }
        swap(nums,i,hi);
        int m = i-lo+1;
        if(m==k) return i;
        else if(m>k) return partition(nums,lo,i-1,k);
        else return partition(nums,i+1,hi,k-m);
        
    }
    
    void swap(int[] a, int i, int j) {
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }
}
}