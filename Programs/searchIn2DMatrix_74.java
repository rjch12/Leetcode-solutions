class searchIn2DMatrix_74 {
  public static void main(String[] args) {
    searchIn2DMatrix_74 sim = new searchIn2DMatrix_74();
    int [][]mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    // int [][]mat = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
    System.out.println( sim.searchMatrix(mat, 3));
  }

  public boolean searchMatrix(int[][] matrix, int target) {
    int lowRow = 0, highRow = matrix.length - 1, col = matrix[0].length - 1;
    int midRow = ((lowRow + highRow) / 2);

    // binary search row
    while (lowRow <= highRow) {
      midRow = ((lowRow + highRow) / 2);
      if (target == matrix[midRow][col] || target == matrix[midRow][0])
        return true;
      else if (target > matrix[midRow][0] && target < matrix[midRow][col])
        break;
      else if (target < matrix[midRow][0])
        highRow = midRow - 1;
      else
        lowRow = midRow + 1;
    }

    int lowCol = 0, highCol = col;

    while (lowCol <= highCol) {
      int mid = ((lowCol + highCol) / 2);
      if (matrix[midRow][mid] == target)
        return true;
      else if (matrix[midRow][mid] > target)
        highCol = mid - 1;
      else
        lowCol = mid + 1;
    }
    return false;
  }
}
