package com.leetcode.problems;

public class trappingRainWater_42_2 {
    public static void main(String[] args) {
        trappingRainWater_42_2 tr = new trappingRainWater_42_2();
        System.out.println(tr.trap(new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 }));
    }

    public int trap(int[] height) {

        // [0,1,0,2,1,0,1,3,2,1,2,1]
        // [0,1,1,2,2,2,2,3,3,3,3,3]
        // [3,3,3,3,3,3,3,3,2,2,2,1]

        int len = height.length;
        int left[] = new int[len];
        int right[] = new int[len];

        int max = 0;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, height[i]);
            left[i] = max;
        }
        max = 0;

        for (int i = len - 1; i >= 0; i--) {
            max = Math.max(max, height[i]);
            right[i] = max;
        }

        max = 0;
        for (int i = 0; i < len; i++) {
            max = max + Math.min(right[i], left[i]) - height[i];
        }
        return max;
    }
}
