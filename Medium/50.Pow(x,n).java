public class Solution {
    public double myPow(double x, int n) {
        if (n == Integer.MIN_VALUE) {
            return myPow(1 / x, Integer.MAX_VALUE) * 1 / x;
        }
        if(x == 0) return 0;
        if(n == 0) return 1;
        if(n < 0){
            x = 1 / x;
            n = -n;
        }
        double res = myPow(x, n/2);
        if(n % 2 == 0) return res*res;
        else return res*res*x;
    }
}