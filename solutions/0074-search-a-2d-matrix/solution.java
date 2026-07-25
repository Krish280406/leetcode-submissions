class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int rows = matrix.length;
        int noOfCols = matrix[0].length;
        
        int left = 0;
        int right = rows * noOfCols - 1;
        
        while (left <= right) {
            int index = left + (right - left) / 2;
            int row = index / noOfCols;
            int col = index % noOfCols;
            
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = index + 1;
            } else {
                right = index - 1;
            }
        }
        
        return false;
    }
}
