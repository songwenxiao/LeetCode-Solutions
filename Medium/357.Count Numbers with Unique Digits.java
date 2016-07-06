public class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if (n>10) return countNumbersWithUniqueDigits(10);
        
        int count = 1; // x == 0
		long max = (long) Math.pow(10, n);

		boolean[] used = new boolean[10];

		for (int i = 1; i < 10; i++) {
			used[i] = true;
			count += helper(i, max, used);
			used[i] = false;
		}
		
		return count;
    }
    
    public int helper(long prev, long max, boolean[] used) {
        int count = 0;
        if(prev<max){
            count += 1;
        }else {
            return count;
        }
        
        for(int i = 0 ; i < 10 ; i++){
            if(!used[i]){
                long cur = 10 * prev + i;
                used[i] = true;
                count += helper(cur, max, used);
                used[i] = false;
            }
        }
        return count;
    }
}