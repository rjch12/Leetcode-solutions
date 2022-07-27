

class longestIncreasingPathInAMatrix_329 {
  int maxPath = 0;

  public static void main(String[] args) {
    longestIncreasingPathInAMatrix_329 lipiam = new longestIncreasingPathInAMatrix_329();
    // lipiam.longestIncreasingPath(new int[][] { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1,
    // 1 } });
    lipiam.longestIncreasingPath(new int[][] { { 3, 4, 5 }, { 3, 2, 6 }, { 2, 2, 1 } });
    // lipiam.longestIncreasingPath(new int[][] { { 1 } });
    System.out.println(lipiam.maxPath);
  }

  public int longestIncreasingPath(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        searchPath(i, j, 1, matrix);
      }
    }
    return maxPath;
  }

  public void searchPath(int i, int j, int depth, int[][] matrix) {
    if (i < 0 || i >= matrix.length || j < 0 || j > matrix[0].length) {
      return;
    }

    if (depth > maxPath)
      maxPath = depth;

    if (i + 1 < matrix.length && matrix[i + 1][j] > matrix[i][j])
      searchPath(i + 1, j, depth + 1, matrix);
    if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j])
      searchPath(i - 1, j, depth + 1, matrix);
    if (j + 1 < matrix[0].length && matrix[i][j + 1] > matrix[i][j])
      searchPath(i, j + 1, depth + 1, matrix);
    if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j])
      searchPath(i, j - 1, depth + 1, matrix);
  }
}
