/*
 * You are given an m x n grid grid where:
 * '.' is an empty cell.
 * '#' is a wall.
 * '@' is the starting point.
 * Lowercase letters represent keys.
 * Uppercase letters represent locks.
 * 
 * You start at the starting point and one move consists of walking one space 
 * in one of the four cardinal directions. You cannot walk outside the grid, or walk into a wall.
 * If you walk over a key, you can pick it up and you cannot walk over a lock unless you have its 
 * corresponding key.
 * 
 * For some 1 <= k <= 6, there is exactly one lowercase and one uppercase letter of the first k letters 
 * of the English alphabet in the grid. This means that there is exactly one key for each lock, and one 
 * lock for each key; and also that the letters used to represent the keys and locks were chosen in the 
 * same order as the English alphabet.
 * 
 * Return the lowest number of moves to acquire all keys. If it is impossible, return -1.
 */

package com.leetcode.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortestPathtoGetAllKeys_864 {
    public static void main(String[] args) {
        ShortestPathtoGetAllKeys_864 s = new ShortestPathtoGetAllKeys_864();
        System.out.println(s.shortestPathAllKeys(new String[] { "@.a..", "###.#", "b.A.B" }));

    }

    public int shortestPathAllKeys(String[] grid) {
        char[][] board = new char[grid.length][grid[0].length()];

        int ii = 0, jj = 0, noOfKeys = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length(); j++) {
                board[i][j] = grid[i].charAt(j);
                if (board[i][j] == '@') {
                    ii = i;
                    jj = j;
                }
                if (board[i][j] >= 'a' && board[i][j] <= 'z') {
                    noOfKeys++;
                }
            }
        }
        if (noOfKeys == 0)
            return 0;

        int[][] memo = new int[grid.length][grid[0].length()];
        boolean[][] visited = new boolean[grid.length][grid[0].length()];
        for (int arr[] : memo)
            Arrays.fill(arr, -1);
        return dfs(board, ii, jj, new HashSet<>(), noOfKeys, memo, 0, visited);
    }

    public int dfs(char[][] grid, int i, int j, Set<Character> keys, int noOfKeys, int[][] memo, int steps,
            boolean[][] visited) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] == '#' || noOfKeys == 0
                || visited[i][j])
            return Integer.MAX_VALUE;

        visited[i][j] = true;

        if (grid[i][j] >= 'A' && grid[i][j] <= 'Z' && (!keys.contains(Character.toLowerCase(grid[i][j]))))
            return Integer.MAX_VALUE;

        if (memo[i][j] != -1)
            return memo[i][j];

        if (grid[i][j] >= 'a' && grid[i][j] <= 'z') {
            keys.add(grid[i][j]);
            noOfKeys--;
            if (noOfKeys == 0)
                return steps;
        }

        steps++;
        int up = dfs(grid, i - 1, j, keys, noOfKeys, memo, steps, visited);
        int left = dfs(grid, i, j - 1, keys, noOfKeys, memo, steps, visited);
        int right = dfs(grid, i, j + 1, keys, noOfKeys, memo, steps, visited);
        int down = dfs(grid, i + 1, j, keys, noOfKeys, memo, steps, visited);

        return memo[i][j] = Math.min(up, Math.min(down, Math.min(left, right)));
    }
}
