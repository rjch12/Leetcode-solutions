

class countSubsets {
  public static void main(String[] args) {
    countSubsets cs = new countSubsets();
    int arr[] = { 2, 3, 5, 6, 8, 10 };
    System.out.println(cs.subset(arr, 10, arr.length));
  }

  public int subset(int[] arr, int sum, int len) {
    if (sum == 0) {
      return 1;
    }
    if (len == 0)
      return 0;
    if (arr[len - 1] <= sum) {
      return subset(arr, sum - arr[len - 1], len - 1) + subset(arr, sum, len - 1);
    } else
      return subset(arr, sum, len - 1);
  }

  public int subsett(int[] arr, int sum, int len) {
    int[][] dp = new int[len + 1][sum + 1];
    for (int l = 0; l <= len; l++)
      for (int s = 0; s <= sum; s++) {
        if (l == 0)
          dp[l][s] = 0;
        else if (s == 0)
          dp[l][s] = 1;
        else if (arr[l - 1] <= s) {
          dp[l][s] = dp[l - 1][s - arr[l - 1]] + dp[l - 1][s];
        } else
          dp[l][s] = dp[l - 1][s];
      }
    return dp[len][sum];
  }
}