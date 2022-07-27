
class LongestCommonSubstring {
  public static void main(String[] args) {
    LongestCommonSubstring lcs = new LongestCommonSubstring();
    System.out.println(lcs.find("abcdef", "abcfef", 6, 6));
  }

  public int find(String a, String b, int len1, int len2) {
    int[][] dp = new int[len1 + 1][len2 + 1];
    int result = 0;
    for (int i = 0; i <= len1; ++i) {
      for (int j = 0; j <= len2; ++j) {
        if (i == 0 || j == 0) {
          dp[i][j] = 0;
        } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
          result = Math.max(result, dp[i][j]);
        } else
          dp[i][j] = 0;
      }
    }
    return result;
  }
}