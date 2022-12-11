package com.leetcode.problems;

public class ContinuousSubarraySum_523 {
    public static void main(String[] args) {
        ContinuousSubarraySum_523 cs = new ContinuousSubarraySum_523();
        System.out.println(cs.checkSubarraySum(new int[] { 23, 2, 6, 4, 7 }, 6));
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        int sum = nums[0], low = 0;
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            if (sum > 0) {
                if (sum % k == 0)
                    return true;
                else {
                    sum -= nums[low];
                    low++;
                }
            }
        }
        return false;
    }
}
