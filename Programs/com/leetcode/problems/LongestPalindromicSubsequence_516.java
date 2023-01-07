package com.leetcode.problems;

public class LongestPalindromicSubsequence_516 {
  public static void main(String[] args) {
    LongestPalindromicSubsequence_516 LPC = new LongestPalindromicSubsequence_516();
    System.out.println(LPC.longestPalindromeSubseq("cbbd"));
  }

  public int longestPalindromeSubseq(String s) {
    int len = s.length();
    if (len == 0 || s == null) {
      return 0;
    }
    StringBuilder rev = new StringBuilder(s);
    rev.reverse();
    return (LCS(s, rev.toString(), len));
  }

  public int LCS(String s1, String s2, int l1) {
    int[][] dp = new int[l1 + 1][l1 + 1];
    for (int i = 1; i <= l1; i++) {
      for (int j = 1; j <= l1; j++) {
        if (s1.charAt(i-1) == s2.charAt(j-1)) {
          dp[i][j] = 1 + dp[i - 1][j - 1];
        } else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }
    return dp[l1][l1];

  }
}
