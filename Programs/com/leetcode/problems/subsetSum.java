package com.leetcode.problems;

import java.util.Arrays;

public class subsetSum {
  public static void main(String[] args) {
    subsetSum ss = new subsetSum();
    int[] wt = { 2, 3, 7, 8, 10 };
    int[][] dp = new int[wt.length + 1][12];
    for (int[] arr : dp) {
      Arrays.fill(arr, -1);
    }
    System.out.println(ss.subsett(wt, 11, wt.length, dp) == 1 ? true : false);
  }

  public boolean subset(int[] arr, int sum) {
    boolean[][] dp = new boolean[arr.length + 1][sum + 1];
    for (int a = 0; a <= arr.length; ++a) {
      for (int s = 0; s <= sum; s++) {

        if (a == 0)
          dp[a][s] = false;
        if (s == 0)
          dp[a][s] = true;
        else if (arr[s - 1] <= sum) {
          dp[a][s] = dp[a - 1][s - 1] || dp[a - 1][s];
        } else
          dp[a][s] = dp[a - 1][s];
      }
    }
    return dp[arr.length][sum];
  }

  public int subsett(int arr[], int sum, int len, int[][] dp) {
    if (sum == 0)
      return dp[len][sum] = 1;
    if (len == 0)
      return dp[len][sum] = 0;
    if (dp[len][sum] != -1)
      return dp[len][sum];

    if (arr[len - 1] <= sum) {
      return dp[len][sum] = Math.max(subsett(arr, sum - arr[len - 1], len - 1, dp), subsett(arr, sum, len - 1, dp));
    } else
      return dp[len][sum] = subsett(arr, sum, len - 1, dp);
  }
}
