public class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] a = new int[n];
    int k = primes.length;
    int[] p = new int[k];
    a[0] = 1;
    for (int i = 1; i < n; i++) {
        for (int j = 0; j < k; j++) {
            while (primes[j] * a[p[j]] <= a[i - 1]) {
                p[j]++;
            }
        }
        a[i] = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            a[i] = Math.min(a[i], primes[j] * a[p[j]]);
        }
    }
    return a[n - 1];
    }
}