/**
 * 739. Daily Temperatures
 * https://leetcode.com/problems/daily-temperatures/description/
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i]
 * is the number of days you have to wait after the ith day to get a warmer
 * temperature. If there is no future day for which this is possible, keep
 * answer[i] == 0 instead.
 * Example 1:
 * Input: temperatures = [73,74,75,71,69,72,76,73]
 * Output: [1,1,4,2,1,1,0,0]
 * 
 */
package com.leetcode.problems;

public class DailyTemperatures_739 {
    public static void main(String[] args) {
        DailyTemperatures_739 dt = new DailyTemperatures_739();
        int[] nums = { 73, 74, 75, 71, 69, 72, 76, 73 };
        dt.dailyTemperatures(nums);
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmer = new int[temperatures.length];
        int hottest = 0;

        for(int i = temperatures.length - 1; i >= 0; i--) {
            if(temperatures[i] >= hottest) {
                warmer[i] = 0;
                hottest = temperatures[i];
            } else {
                // check neighbour
                int days = 1;
                while(temperatures[i + days] <= temperatures[i]) {
                    days += warmer[i + days];
                }
                warmer[i] = days;
            }
        }

        return warmer;
    }
}
