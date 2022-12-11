package com.leetcode.problems;

import java.util.Arrays;

public class sumLessThanK_1099 {
  public static void main(String[] args) {
    sumLessThanK_1099 sltk = new sumLessThanK_1099();
    System.out.println((sltk.twoSumLessThanK(new int[] { 34, 23, 1, 24, 75, 33, 54, 8 }, 60)));
  }

  public int twoSumLessThanK(int[] nums, int k) {
    Arrays.sort(nums);

    int low = 0, high = nums.length - 1, sum = 0, max = Integer.MIN_VALUE;
    while (low < high) {
      sum = nums[low] + nums[high];
      if (sum < k) {
        max = Math.max(max, sum);
        low++;
      } else
        high--;
    }
    return max;
  }

}
