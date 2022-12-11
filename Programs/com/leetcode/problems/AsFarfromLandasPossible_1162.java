package com.leetcode.problems;

import java.util.Queue;
import java.util.LinkedList;

public class AsFarfromLandasPossible_1162 {
  public static void main(String[] args) {
    // int[][] grid = new int[][] { { 1, 1, 1 }, { 1, 1, 1 }, { 1, 1, 1 } };
    int[][] grid = new int[][] { { 1, 0, 1 }, { 0, 0, 0 }, { 1, 0, 1 } };
    AsFarfromLandasPossible_1162 af = new AsFarfromLandasPossible_1162();
    System.out.println(af.maxDistance(grid));
  }

  public int maxDistance(int[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0)
      return -1;

    Queue<int[]> q = new LinkedList<>();
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    int[][] direction = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

    for (int i = 0; i < grid.length; ++i) {
      for (int j = 0; j < grid[0].length; ++j) {
        if (grid[i][j] == 1) {
          visited[i][j] = true;
          q.offer(new int[] { i, j });
        }
      }
    }

    int depth = -1;

    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        int newX = 0, newY = 0;
        int[] ones = q.poll();

        for (int[] dir : direction) {
          newX = ones[0] + dir[0];
          newY = ones[1] + dir[1];
          if (newX >= 0 && newX < grid.length
              && newY >= 0 && newY < grid[0].length
              && grid[newX][newY] == 0
              && !visited[newX][newY]) {
            q.offer(new int[] { newX, newY });
            visited[newX][newY] = true;
          }
        }
      }
      depth++;
    }
    return depth == 0 ? -1 : depth;
  }

}
