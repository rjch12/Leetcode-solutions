/*
 * 1335. Minimum Difficulty of a Job Schedule (https://leetcode.com/problems/minimum-difficulty-of-a-job-schedule/)
 * 
 * You want to schedule a list of jobs in d days. Jobs are dependent (i.e To work on the ith job, 
 * you have to finish all the jobs j where 0 <= j < i).
 * 
 * You have to finish at least one task every day. The difficulty of a job schedule is the sum of 
 * difficulties of each day of the d days. The difficulty of a day is the maximum difficulty of a 
 * job done on that day.
 * 
 * You are given an integer array jobDifficulty and an integer d. The difficulty of the ith job is
 * jobDifficulty[i].
 * 
 * Return the minimum difficulty of a job schedule. If you cannot find a schedule for the jobs return -1.
 * (Basically divide the array in d parts such that sum of Max elts of sub arrays is min.)
 * 
 * Input: jobDifficulty = [6,5,4,3,2,1], d = 2
 * Output: 7
 * Explanation: First day you can finish the first 5 jobs, total difficulty = 6.
 * Second day you can finish the last job, total difficulty = 1.
 * The difficulty of the schedule = 6 + 1 = 7 
 */

package com.leetcode.problems;

import java.util.Arrays;

public class MinimumDifficultyofaJobSchedule_1335 {
    public static void main(String[] args) {
        MinimumDifficultyofaJobSchedule_1335 m = new MinimumDifficultyofaJobSchedule_1335();
        System.out.println(m.minDifficulty(new int[] { 6, 5, 4, 3, 2, 1 }, 0));
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        if (d > jobDifficulty.length)
            return -1;
        int dp[][] = new int[d + 1][jobDifficulty.length];
        for (int[] a : dp)
            Arrays.fill(a, -1);
        return dfs(jobDifficulty, d, dp, 0);
    }

    private int dfs(int[] jd, int d, int[][] dp, int start) {
        int max = 0;
        if (d == 1) {
            while (start < jd.length)
                max = Math.max(max, jd[start++]);
            return max;
        }
        if (dp[d][start] != -1)
            return dp[d][start];
        int res = Integer.MAX_VALUE;
        for (int i = start; i < jd.length - d + 1; i++) {
            max = Math.max(max, jd[i]);
            res = Math.min(res, max + dfs(jd, d - 1, dp, start + 1));
        }
        return dp[d][start] = res;
    }
}
