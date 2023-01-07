package com.leetcode.problems;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class minSubArrayWithSumk_862 {
  public static void main(String[] args) {
    minSubArrayWithSumk_862 msk = new minSubArrayWithSumk_862();
    System.out.println(msk.shortestSubarray(new int[] { 2, -1, 2 }, 3));
  }

  public int shortestSubarray(int[] nums, int k) {
    int n = nums.length;
    int[] prefix = new int[n + 1];
    for (int i = 0; i < n; i++) {
      prefix[i + 1] = prefix[i] + nums[i];
    }

    System.out.println(Arrays.toString(prefix));

    int min = Integer.MAX_VALUE;

    Deque<Integer> dq = new LinkedList<>();
    for (int i = 0; i <= n; i++) {
      while (dq.size() > 0 && prefix[i] - prefix[dq.getFirst()] >= k) {
        int idx = dq.pollFirst();
        min = Math.min(i - idx, min);
      }
      while (dq.size() > 0 && prefix[i] <= prefix[dq.getLast()]) {
        dq.pollLast();
      }
      dq.add(i);
      // System.out.println("i="+i+" dq="+dq);
    }
    return (min == Integer.MAX_VALUE) ? -1 : min;
  }
}
