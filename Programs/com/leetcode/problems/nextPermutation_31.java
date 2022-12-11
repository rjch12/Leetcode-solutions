package com.leetcode.problems;

public class nextPermutation_31 {
  public static void main(String[] args) {
    nextPermutation_31 np = new nextPermutation_31();
    // int[] nums = { 1, 2, 3 };
    // int[] nums = { 3, 2, 1 };
    int[] nums = { 1, 1, 5 };
    np.nextPermutation(nums);
  }

  public void nextPermutation(int[] nums) {
    int i = nums.length - 2;

    while (i >= 0 && nums[i + 1] < nums[i]) {
      i--;
    }
    int j = nums.length - 1;
    if (i >= 0) {
      if (nums[j] < nums[i]) {
        j--;
      }
      swap(nums, i, j);
    }
    reverse(nums, i + 1);
    for (int elt : nums) {
      System.out.print(elt + " ");
      ;
    }
  }

  public void reverse(int[] nums, int low) {
    int high = nums.length - 1;
    while (low < high) {
      swap(nums, low, high);
      low++;
      high--;
    }
  }

  public void swap(int[] nums, int low, int high) {
    int temp;

    temp = nums[low];
    nums[low] = nums[high];
    nums[high] = temp;
  }
}
