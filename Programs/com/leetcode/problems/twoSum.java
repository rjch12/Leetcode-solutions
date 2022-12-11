package com.leetcode.problems;

import java.util.Arrays;

public class twoSum {
    public static void main(String orgs[]) {
        twoSum ts = new twoSum();
        int[] nums = { 3, 2, 4 };
        System.out.println(ts.twoSums(nums, 6));
    }

    public int[] twoSums(int[] nums, int target) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while (low < high) {
            if (nums[low] + nums[high] == target) {
                return new int[] { low, high };
            } else if (nums[low] + nums[high] > target) {
                --high;
            } else if (nums[low] + nums[high] < target) {
                ++low;
            }
        }
        return new int[] {};
    }
}
