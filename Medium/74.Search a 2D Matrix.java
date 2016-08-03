public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int high = matrix.length-1;
        int low = 0;
        int mid = 0;
        if(high == -1)return false;
        
        while(low<=high){
            mid = (low+high)/2;
            if(target == matrix[mid][0])return true;
            if(target < matrix[mid][0])  high = mid-1;
            if(target > matrix[mid][0]) {
                               if(mid==matrix.length-1||matrix[mid+1][0]>target){
                    break;
                }else{
                    low =mid+1;
                }
            
            }
        }
        
        int level = mid;
        low = 1;
        high = matrix[0].length-1;
        while(low<=high){
            mid = (high+low)/2;
            if(target == matrix[level][mid])return true;
            if(target < matrix[level][mid])  high = mid-1;
            if(target > matrix[level][mid]) low = mid+1;
        }
        
        return false;
    }
}