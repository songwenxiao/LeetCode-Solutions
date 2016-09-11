public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1 || matrix[0].length <1) {
            return false;
        }
        int col = matrix[0].length-1;
        int row = 0;
        while(row<=matrix.length-1&&col>=0){
            if(matrix[row][col]==target){
                return true;
            }else if(matrix[row][col]>target){
                col--;
            }else{
                row++;
            }
        }
        return false;
    }

    //2 divide and conquer
    public boolean searchMatrix(int[][] matrix, int target) {
    int m = matrix.length;
    int n = matrix[0].length;
    if(target < matrix[0][0]) return false;
    if(target > matrix[m - 1][n - 1]) return false;
    return searchMatrixHelper(matrix, target, 0, 0);
}

private static boolean searchMatrixHelper(int[][] matrix, int target, int i,
        int j) {
    int m = matrix.length;
    if(i >= m) return false;
    int n = matrix[0].length;
    
    while(matrix[i][n - 1] < target) i++;
    return searchMatrixHelper(matrix, target, i + 1, j)||searchInRow(matrix, target, i, j);
}

private static boolean searchInRow(int[][] matrix, int target, int i, int j) {
    int n = matrix[0].length;
    int start = j;
    int end = n - 1;

    while(start <= end){
        int mid = (start + end)/2;
        if(target == matrix[i][mid]) return true;
        if(target > matrix[i][mid]) start = mid + 1;
        else end = mid - 1;
    }
    return false;
}
}