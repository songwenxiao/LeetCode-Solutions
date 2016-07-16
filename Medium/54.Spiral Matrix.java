public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<Integer>();
          if (matrix == null || matrix.length == 0 
              || matrix[0].length == 0) {
             return ret;   
         }
         
         int x1 = 0;
         int y1 = 0;
         
         int rows = matrix.length;
         int cols = matrix[0].length;
         
       while (rows >= 1 && cols >= 1) {
            // Record the right down corner of the matrix.
             int x2 = x1 + rows - 1;
             int y2 = y1 + cols - 1;
             
             // go through the WHOLE first line.
             for (int i = y1; i <= y2; i++) {
                 ret.add(matrix[x1][i]);
             }
             
             // go through the right column.
             for (int i = x1 + 1; i < x2; i++) {
                 ret.add(matrix[i][y2]);
             }
             
             // go through the WHOLE last row.
             if (rows > 1) {
                 for (int i = y2; i >= y1; i--) {
                     ret.add(matrix[x2][i]);
                 }    
             }
             
             // the left column.
             if (cols > 1) {
                 for (int i = x2 - 1; i > x1; i--) {
                     ret.add(matrix[i][y1]);
                 }
             }    
             
             // in one loop we deal with 2 rows and 2 cols.
                 rows -= 2;
                 cols -= 2;
                 x1++;
                 y1++;
         }
         
         return ret;
    }
}