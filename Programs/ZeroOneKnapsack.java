

import java.util.Arrays;

class ZeroOneKnapsack {
  public static void main(String[] args) {
    ZeroOneKnapsack kp = new ZeroOneKnapsack();
    int val[] = { 60, 100, 120 };
    int wt[] = { 10, 20, 30 };
    int w = 50;
    int n = wt.length;
    int[][] t = new int[n + 1][w + 1];
    for (int[] arr : t) {
      Arrays.fill(arr, -1);
    }
    System.out.println(kp.knapsach2(wt, val, w, n, t));
  }

  public int knapsach_memoization(int[] wt, int[] val, int w, int n, int[][] t) {
    if (n == 0 || w == 0) {
      return 0;
    }
    if (t[n][w] != -1) {
      return t[n][w];
    } else if (wt[n - 1] <= w) {
      return t[n][w] = Math.max(val[n - 1] + knapsach_memoization(wt, val, w - wt[n - 1], n - 1, t),
      knapsach_memoization(wt, val, w, n - 1, t));
    } else {
      return t[n][w] = knapsach_memoization(wt, val, w, n - 1, t);
    }
  }

  public int knapsach2(int[] wt, int[] val, int W, int len, int[][] t) {
    int[][] dp = new int[len + 1][W + 1];

    for (int n = 0; n <= len; n++) {
      for (int w = 0; w <= W; w++) {
        if (n == 0 || w == 0) {
          dp[n][w] = 0;
        } else if (wt[n - 1] <= w) {
          dp[n][w] = Math.max(val[n - 1] + dp[n - 1][w - wt[n - 1]], dp[n - 1][w]);
        } else
          dp[n][w] = dp[n - 1][w];
      }
    }
    return dp[len][W];
  }

}
