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

public int nthSuperUglyNumberHeap(int n, int[] primes) {//Heap
    int[] ugly = new int[n];

    PriorityQueue<Num> pq = new PriorityQueue<>();
    for (int i = 0; i < primes.length; i++) pq.add(new Num(primes[i], 1, primes[i]));
    ugly[0] = 1;

    for (int i = 1; i < n; i++) {
        ugly[i] = pq.peek().val;
        while (pq.peek().val == ugly[i]) {
            Num nxt = pq.poll();
            pq.add(new Num(nxt.p * ugly[nxt.idx], nxt.idx + 1, nxt.p));
        }
    }

    return ugly[n - 1];
}

private class Num implements Comparable<Num> {
    int val;
    int idx;
    int p;

    public Num(int val, int idx, int p) {
        this.val = val;
        this.idx = idx;
        this.p = p;
    }

    @Override
    public int compareTo(Num that) {
        return this.val - that.val;
    }
}