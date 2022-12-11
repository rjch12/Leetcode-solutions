package com.leetcode.problems;

public class MinimumTimetoMakeRopeColorful_1578 {
    public static void main(String[] args) {
        MinimumTimetoMakeRopeColorful_1578 m = new MinimumTimetoMakeRopeColorful_1578();
        // System.out.println(m.minCost("aabaa", new int[] { 1, 2, 3, 4, 1 }));
        System.out.println(m.minCost("aaabbbabbbb", new int[] { 3, 5, 10, 7, 5, 3, 5, 5, 4, 8, 1 }));
    }

    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        for (int i = 1; i < colors.length(); i++) {
            if (colors.charAt(i) == colors.charAt(i - 1)) {
                minTime += Math.min(neededTime[i - 1], neededTime[i]);
                neededTime[i] = Math.max(neededTime[i - 1], neededTime[i]);
            }
        }
        return minTime;
    }
}
