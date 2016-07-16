public class Solution {
    private static final int NUM = 1337;
    public int superPow(int a, int[] b) {
        int ans = 1;
    //not expecting to be a part of input
    if(b==null||b.length==0)
        return 0;
    a = a%NUM;
    int len = b.length;
    for (int i = 0; i < len; i++) {
        ans = ((pow(ans,10)*pow(a,b[i]))%NUM);
    }
    return ans;
}

private int pow(int a, int b){
    if(b==1)
        return a;
    if(b==0)
        return 1;
    int x = pow(a,b/2);
    x = (x*x)%NUM;
    if((b&1)==1)
        x = (x*a)%NUM;
    return x;
}
    }
