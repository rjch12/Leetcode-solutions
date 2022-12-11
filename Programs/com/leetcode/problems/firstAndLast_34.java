package com.leetcode.problems;

public class firstAndLast_34 {

  public static void main(String[] args) {
    firstAndLast_34 fnl = new firstAndLast_34();

    int[] a = (fnl.searchRange(new int[] { 2, 2 }, 2));
    System.out.println(a[0] + " " + a[1]);
  }

  public int[] searchRange(int[] nums, int target) {
    int n = nums.length;
    if (n == 0)
      return new int[] { -1, -1 };
    int start = 0, end = n - 1;
    int first = -1, second = -1;

    while (start <= end) {
      int mid = ((start + end) / 2);
      if (nums[mid] == target && nums[mid - 1] < target) {
        first = mid;
        break;
      } else if (nums[mid] >= target)
        end = mid - 1;
      else
        start = mid + 1;
    }
    start = 0;
    end = n - 1;
    while (start <= end) {
      int mid = ((start + end) / 2);
      if (nums[mid] == target && nums[mid + 1] > target) {
        second = mid;
        break;
      } else if (nums[mid] <= target)
        start = mid + 1;
      else
        end = mid - 1;
    }
    return new int[] { first, second };
  }
}
