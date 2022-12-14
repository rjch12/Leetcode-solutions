// Write any import statements here
package com.leetcode.facebook;

import java.util.Arrays;

public class pairSumDuplicate {

  public static void main(String[] args) {
    pairSumDuplicate psd = new pairSumDuplicate();
    // System.out.println(psd.pairSums(6, 5, new int[]{1, 2, 3, 4, 3}));
    System.out.println(psd.pairSums(6, 5, new int[] { 1, 5, 3, 3, 3 }));
  }

  public int pairSums(int k, int n, int[] arr) {
    // Write your code here
    Arrays.sort(arr);

    int pairSum = 0, len = arr.length, lptr = 0, rptr = len - 1;

    while (lptr < rptr) {
      int sum = arr[lptr] + arr[rptr];
      if (sum == k) {
        pairSum++;
        lptr++;
        rptr--;
      } else if (sum < k) {
        lptr++;
      } else if (sum > k) {
        rptr--;
      }
    }
    return pairSum;
  }
}
