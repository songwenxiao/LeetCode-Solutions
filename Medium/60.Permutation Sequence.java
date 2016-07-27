public class Solution {
    public String getPermutation(int n, int k) {
        int[] data = new int[10];
        boolean visited[] = new boolean[10];
        
        data[0] = data[1] = 1;
        
        for(int i = 1;i<=n;i++){
            data[i] = data[i-1]*i;
            
        }
        String str = "";
        k--;
        for(int i = n-1;i>=0;i--){
            int cur = k/data[i];
            int j=1;
            for(;j<9;j++){
                if(visited[j]==false)
                     cur--;
                 if(cur<0)
                     break;
            }
            visited[j]=true;
             str += j;
             k=k%data[i];
        }
        return str;
    }
}