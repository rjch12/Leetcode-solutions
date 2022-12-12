/*
 * Leetcode Problem: 70. Climbing Stairs (https://leetcode.com/problems/climbing-stairs/)
 * You are climbing a staircase. It takes n steps to reach the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * 
 * Input: n = 3
 * Output: 3
 * Explanation: There are three ways to climb to the top.
 * 1. 1 step + 1 step + 1 step
 * 2. 1 step + 2 steps
 * 3. 2 steps + 1 step
 */
package com.leetcode.problems;

public class ClimbingStairs_70 {
    public static void main(String[] args) {
        ClimbingStairs_70 cs = new ClimbingStairs_70();
        System.out.println(cs.climbStairs(44));
    }

    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        return recur(n, 0, dp);
    }

    public int recur(int target, int curr, int[] dp) {
        if (curr > target)
            return 0;
        if (curr == target)
            return 1;

        if (dp[curr] > 0)
            return dp[curr];

        return dp[curr] = (recur(target, curr + 1, dp) + recur(target, curr + 2, dp));
    }
}
