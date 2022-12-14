package com.leetcode.problems;

public class MinimumFallingPathSum_931 {
    public static void main(String[] args) {
        MinimumFallingPathSum_931 fs = new MinimumFallingPathSum_931();
        int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
        System.out.println(fs.minFallingPathSum(matrix));
    }

    public int minFallingPathSum(int[][] matrix) {
        int min = Integer.MAX_VALUE, len = matrix.length;
        Integer[][] dp = new Integer[len][len];

        for (int i = 0; i < len; i++)
            min = Math.min(min, dfs(matrix, 0, i, dp));

        return min;
    }

    public int dfs(int[][] matrix, int row, int col, Integer[][] dp) {
        if (row < 0 || row >= matrix.length || col < 0 || col >= matrix.length)
            return 0;

        if (dp[row][col] != null) {
            return dp[row][col];
        }

        if (row == matrix.length - 1) {
            return dp[row][col] = matrix[row][col];
        } else {
            dp[row][col] = Math.min(dfs(matrix, row + 1, col - 1, dp), Math.min(dfs(
                    matrix, row + 1, col, dp), dfs(matrix, row + 1, col + 1, dp)));
        }
        return dp[row][col];
    }
}
