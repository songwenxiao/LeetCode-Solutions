public class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
        HashSet<Integer> set = new HashSet<Integer>();
        minHeap.offer(1);
        set.add(1);

        Integer uglyNumber = 1;

        for (int i=1; i<=n; ++i) {
            uglyNumber = minHeap.poll();
            if (uglyNumber <= Integer.MAX_VALUE/2 && !set.contains(uglyNumber * 2)) { 
                minHeap.offer(uglyNumber * 2);
                set.add(uglyNumber * 2);
            }
            if (uglyNumber <= Integer.MAX_VALUE/3 &&!set.contains(uglyNumber * 3)) {
                minHeap.offer(uglyNumber * 3);
                set.add(uglyNumber * 3);
            }
            if (uglyNumber <= Integer.MAX_VALUE/5 &&!set.contains(uglyNumber * 5)) {
                minHeap.offer(uglyNumber * 5);
                set.add(uglyNumber * 5);
            }
        }

        return uglyNumber.intValue();
    }
}