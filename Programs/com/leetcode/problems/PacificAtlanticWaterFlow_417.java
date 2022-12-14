package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticWaterFlow_417 {
  int[][] dir = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };

  public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int r = heights.length;
    int c = heights[0].length;

    if (heights == null || r == 0 || c == 0)
      return null;

    boolean[][] pac = new boolean[r][c];
    boolean[][] atl = new boolean[r][c];

    // pac////////////////
    // //
    // //
    // //
    // //
    // ///////////////atl

    // filling in col wise - Top row touches pacific so call begins with (0, i), int
    // min and pacific
    // filling in col wise - Bottom row touches atlantic so call begins with (r-1,
    // i), int min and atlantic
    for (int i = 0; i < c; i++) {
      dfs(0, i, heights, pac, Integer.MIN_VALUE);
      dfs(r - 1, i, heights, atl, Integer.MIN_VALUE);
    }

    // filling in row wise - Left col touches pacific so call begins with (i, 0),
    // int min and pacific
    // filling in row wise - Right col touches atlantic so call begins with (i,
    // c-1), int min and atlantic
    for (int i = 0; i < r; i++) {
      dfs(i, 0, heights, pac, Integer.MIN_VALUE);
      dfs(i, c - 1, heights, atl, Integer.MIN_VALUE);
    }

    List<List<Integer>> res = new ArrayList<>();
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        if (pac[i][j] && atl[i][j]) {
          res.add(Arrays.asList(i, j));
        }
      }
    }
    return res;
  }

  public void dfs(int i, int j, int[][] heights, boolean[][] visited, int h) {
    if (i < 0 || j < 0 || i >= heights.length || j >= heights[0].length || visited[i][j] || heights[i][j] < h)
      return;

    visited[i][j] = true;

    for (int[] d : dir) {
      dfs(i + d[0], j + d[1], heights, visited, heights[i][j]);
    }
  }
}
