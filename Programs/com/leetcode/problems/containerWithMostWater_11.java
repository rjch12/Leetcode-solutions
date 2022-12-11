package com.leetcode.problems;

public class containerWithMostWater_11 {
    public static void main(String[] args) {
        containerWithMostWater_11 cwmc = new containerWithMostWater_11();
        System.out.println(cwmc.maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
    }

    public int maxArea(int[] height) {
        int max = 0;
        int low = 0, high = height.length - 1;
        while (low < high) {
            max = Math.max(max, (Math.min(height[low], height[high]) * (high - low)));

            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return max;
    }
}
