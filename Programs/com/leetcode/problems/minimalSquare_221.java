package com.leetcode.problems;

public class minimalSquare_221 {
    public static void main(String[] args) {
        minimalSquare_221 ms = new minimalSquare_221();
        System.out.println(ms.maximalSquare(new char[][] { { '0', '1' }, { '1', '0' } }));
    }

    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (row == 0)
            return 0;

        int largest = 0;

        int dp[][] = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]);
                    largest = Math.max(largest, dp[i][j]);
                }
            }
        }
        return largest * 2;
    }
}
