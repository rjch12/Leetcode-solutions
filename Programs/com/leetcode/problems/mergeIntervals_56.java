package com.leetcode.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class mergeIntervals_56 {
  public static void main(String[] args) {
    mergeIntervals_56 mi = new mergeIntervals_56();
    // int[][] res = (mi.merge(new int[][] { { 1, 3 }, { 2, 6 }, { 8, 10 }, { 15, 18
    // } }));
    int[][] res = (mi.merge(new int[][] { { 1, 4 } }));
    for (int[] a : res)
      for (int i : a)
        System.out.print(i + " ");
    System.out.println();

  }

  public int[][] merge(int[][] intervals) {
    Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
    List<int[]> al = new ArrayList<>();

    if (intervals.length == 1) {
      return intervals;
    }

    int start = intervals[0][0];
    int end = intervals[0][1];
    for (int i = 1; i < intervals.length; i++) {
      if (end < intervals[i][0]) {
        al.add(new int[] { start, end });
        start = intervals[i][0];
        end = intervals[i][1];
      } else {
        end = Math.max(end, intervals[i][1]);
      }
    }
    al.add(new int[] { start, end });
    return al.toArray(new int[al.size()][]);
  }
}
