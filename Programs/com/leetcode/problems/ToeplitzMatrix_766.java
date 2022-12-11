import java.util.*;

package com.leetcode.problems;

public class ToeplitzMatrix_766 {
    public static void main(String[] args) {
        ToeplitzMatrix_766 t = new ToeplitzMatrix_766();
        int[][] mat = new int[2][2];
        mat[0][0] = 1;
        mat[0][1] = 2;
        mat[1][0] = 2;
        mat[1][1] = 2;
        System.out.println(t.isToeplitzMatrix(mat));
    }

    public boolean isToeplitzMatrix(int[][] matrix) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (hm.containsKey(i - j)) {
                    if (matrix[i][j] != hm.get(i - j))
                        return false;
                } else
                    hm.put(i - j, matrix[i][j]);
            }
        }
        return true;
    }
}